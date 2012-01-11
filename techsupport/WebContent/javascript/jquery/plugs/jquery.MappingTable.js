(function($) {
	$.fn.loadData = function(store, tableConfigs, options) {
		var opts = $.extend({}, $.fn.loadData.defaults, options); 
		
		var mode = opts.mode || 'table';
		var entityclass = opts.entityclass || store.id;
		
		if (store.getCount() == 0)
			return this;
		if (mode == 'table') {
			return loadToTable(this, tableConfigs, store.getAt(0), entityclass);
		} else if (mode == 'row') {
			return loadToRow(this, tableConfigs, store, entityclass);
		} else {
			return loadToCell(this, tableConfigs, store, entityclass);
		}
		
		function loadToTable(obj, tableConfigs, record, entityclass) {
			return obj.each(function(){
				//var btime = new Date();

				//检查当前要装载对象至表格的映射配置是否存在
				var table = $(this);			
				var tableid = table.attr('id');
				var key = 'table.' + entityclass + '.' + tableid;
				if (!tableConfigs[key])
					return;

				var tableConfig = tableConfigs[key];

				//设置表格对应实体对象的ID值
				var id = record.get('id');
				table.attr('entityid', id);
				
				//根据映射配置，遍历配置中各个属性对应的单元格，从record中查找属性值，写入单元格中
				for (property in tableConfig.propertys) {
					var tdConfig = tableConfig.propertys[property];
					if (record.data[property])
						$.setTableCellVal(tdConfig.td, record.data[property], tdConfig, optionItemConfig);
				}

				//清除表格中各个单元格的修改标志
				table.find('td[modify]').removeAttr('modify');
			
				if (opts.callback)
					opts.callback(table);
				
				//var etime = new Date();
				//var iii = etime - btime;
				//alert('execute start time: ' + btime + ', end time: ' + etime + ', total using time: ' + iii + ' milliseconds');
			});
		}
		
		function loadToRow(obj, tableConfigs, store, entityclass) {
			return obj.each(function(){
				//var btime = new Date();
				
				//检查当前要装载对象至行的映射配置是否存在				
				var table = $(this);
				var tableid = table.attr('id');
				var key = 'row.' + entityclass + '.' + tableid;
				
				if (!tableConfigs[key])
					return;

				//查找模板行，作为生成的行数据要插入的行位置
				var trs = table.find('tr[entityclass="' + entityclass + '"]');
				var trInsertAfter = trs[0];
				var trTemplate = $(trs[0]);

				//获取行的分组配置信息，并清除掉配置信息中先前执行本函数时生成的临时数据
				var rowConfig = tableConfigs[key];
				var groupConfigs = rowConfig.groupConfigs;
				
				for (var ind = 0; ind < groupConfigs.length; ind++) {
				
					if (groupConfigs[ind]['preKey'])
					    groupConfigs[ind].preKey="";
					    // 非jquery对象不支持remove
						//groupConfigs[ind].remove('preKey');

					if (groupConfigs[ind]['preTds'])
					    groupConfigs[ind].preTds=""
					    // 非jquery对象不支持remove
						//groupConfigs[ind].remove('preTds');
				}
				
				//初始化单元格状态表
				var cellStateTable = rowConfig.cellStateTable;

				//循环store中的记录，并根据记录生成行数据，插入到表格中
				var count = store.getCount();
				for (var row = 0; row < count; row++) {
					var record = store.getAt(row);
					//从行模板克隆一行
					var tr = rowConfig.trTemplate.clone(true);
					//设置行对应实体对象的ID值
					var id = record.get('id');
					tr.attr('entityid', id);

					tr.attr('hashcode', generateMixed(16));
					
					//初始化当前行的单元格状态表
					cellStateTable[row] = {
						tr: tr
					};
					
					cellStateTable[row].cellStates = [];
					
					var cellStates = cellStateTable[row].cellStates;

					var tdConfigs = rowConfig.tdConfigs;
					
					//设置行上各个单元格数据
					fillRowData(record.data, tdConfigs, tr, cellStates);

					var removeTds = [];

					//根据分组配置信息，检查各个分组中指定分组的单元格的值与上一行的值是否相同，如果相同，则让分组单元格与上一行单元格合并（删除本单元格，并设置上一行对应单元格的rowSpan加1）
					tds = tr.find('td');
					for (var j = 0; j < groupConfigs.length; j++) {
						var groupConfig = groupConfigs[j];
						var k, length = groupConfig.groupTdIndexs.length;

						//合并分组单元格的值，组成一个大字符串
						var groupKey = '';
						for (k = 0; k < length; k++) {
							var col = groupConfig.groupTdIndexs[k];
							
							//有的单元格已经和其他列合并，不存在了，所以只对存在的单元格进行组字符串
							var mytds = tr.find('td[index=' + col + ']');
							if (mytds.length > 0)
								groupKey += $.getTableCellVal($(mytds[0])) + '.';
						}
						
						//比较组成字符串的值是否与上一行分组单元格的值相同
						if (groupConfig.preKey && groupKey == groupConfig.preKey) {		//如果相同，则分组的单元格需要与上一行对应单元格合并
							//遍历每个需要合并行的单元格
							for (k = 0; k < length; k++) {
								var col = groupConfig.groupTdIndexs[k];
								
								if (cellStateTable[row].cellStates[col].rowSpan == 1) { //如果本单元格还未被合并过，则设置rowSpan属性为0，并且放到删除的单元格数组中等待删除
									cellStateTable[row].cellStates[col].rowSpan = 0;
									
									if (cellStateTable[row].cellStates[col].colSpan > 0) {
										//有可能由于列合并，指定列不是实际要处理的列，所以通过遍历搜索index属性，找到实际要处理的列
										var c = 0;
										while ($(tds[c]).attr('index') != col)
											c++;
											
										removeTds[removeTds.length] = $(tds[c]);
									}
								} else { //如果本单元格已经被删除，则检查影响单元格被删除的组行号是否和当前组行号相同，相同的话就忽略，不处理该行
									var f = false;
									for (var m = j - 1; m >= 0; m--) {
										if (groupConfigs[m].preRow == groupConfig.preRow) {
											f = true;
											break;
										}
									}	
									
									if (f)
										continue;
								}
								
								//修改组行的单元格，设置单元格的rowSpan属性加1
								if (cellStateTable[groupConfig.preRow].cellStates[col].rowSpan > 0) {
									cellStateTable[groupConfig.preRow].cellStates[col].rowSpan += 1;
									
									var colSpan = cellStateTable[groupConfig.preRow].cellStates[col].colSpan;
									if (colSpan > 0) {
										//有可能由于列合并，指定列不是实际要处理的列，所以通过遍历搜索index属性，找到实际要处理的列
										var c = 0;
										while ($(groupConfig.preTds[c]).attr('index') != col)
											c++;
										
										$(groupConfig.preTds[c]).attr('rowSpan', cellStateTable[groupConfig.preRow].cellStates[col].rowSpan);
									}
								}
							}
						} else {	//如果不相同，或者是第一行，则把当前分组单元格值组成的大字符串以及当前单元格数组存入临时数据中，供下一行作比较
							groupConfig.preKey = groupKey;
							groupConfig.preTds = tds;
							groupConfig.preRow = row;
						}
					}
			
					//删除因为合并空行而需要删除的单元格
					for (var i = 0; i < removeTds.length; i++)
						removeTds[i].remove();

					//把生成的行数据插入到表格中的上一个插入位置，并改变插入位置为当前插入行位置
					tr.insertAfter(trInsertAfter);
					trInsertAfter = tr;
			
					if (opts.callback)
						opts.callback(tr);
				}

				//从表格中删除模板行
				trTemplate.remove();
				
				//var etime = new Date();
				//var iii = etime - btime;
				//alert('execute start time: ' + btime + ', end time: ' + etime + ', total using time: ' + iii + ' milliseconds');
			});
		}
		
		function loadToCell(store, tableConfigs, entityclass) {
		}
	}; 
	
	$.fn.loadData.defaults = { 
	}; 
	
	$.fn.addRow = function(initVal, tableConfigs, options) {
		var opts = $.extend({}, $.fn.addRow.defaults, options); 
		
		var entityclass = opts.entityclass;
		if (!entityclass)
			return this;

		var trAdd;
		this.each(function(){
			//var btime = new Date();
			
			//检查当前要装载对象至行的映射配置是否存在				
			var table = $(this);
			var tableid = table.attr('id');
			var key = 'row.' + entityclass + '.' + tableid;
			if (!tableConfigs[key])
				return;
			
			var rowConfig = tableConfigs[key];
			var cellStateTable = rowConfig.cellStateTable;

			var trInsertAfter, trTemplate = null;
			if (rowConfig.cellStateTable.length > 0) {
				trInsertAfter = rowConfig.cellStateTable[rowConfig.cellStateTable.length - 1].tr[0];
			} else {
				var trs = table.find('tr[entityclass="' + entityclass + '"]');
				trInsertAfter = trs[trs.length - 1];
				
				trTemplate = $(trInsertAfter);
			}

			//从行模板克隆一行
			trAdd = rowConfig.trTemplate.clone(true);
			//设置行对应实体对象的ID值
			trAdd.attr('entityid', 0);

			trAdd.attr('hashcode', generateMixed(16));

			var row = rowConfig.cellStateTable.length;
			
			//初始化当前行的单元格状态表
			rowConfig.cellStateTable[row] = {
				tr: trAdd,
				cellStates: []
			};
			
			var cellStates = rowConfig.cellStateTable[rowConfig.cellStateTable.length - 1].cellStates;

			var tdConfigs = rowConfig.tdConfigs;
					
			//设置行上各个单元格数据
			fillRowData(initVal, tdConfigs, trAdd, cellStates);

			var removeTds = [];

			tds = trAdd.find('td');
			
			var preRows = [];
			
			//根据分组配置信息，检查各个分组中指定分组的单元格的值与上一行的值是否相同，如果相同，则让分组单元格与上一行单元格合并（删除本单元格，并设置上一行对应单元格的rowSpan加1）
			var groupConfigs = rowConfig.groupConfigs;
			for (var j = 0; j < groupConfigs.length; j++) {
				var groupConfig = groupConfigs[j];

				//合并分组单元格的值，组成一个大字符串
				var groupKey = '';
				for (var k = 0; k < groupConfig.groupTdIndexs.length; k++) {
					var col = groupConfig.groupTdIndexs[k];
					
					//有的单元格已经和其他列合并，不存在了，所以只对存在的单元格进行组字符串
					var mytds = trAdd.find('td[index=' + col + ']');
					if (mytds.length > 0)
						groupKey += $.getTableCellVal($(mytds[0])) + '.';
				}
				
				var preRow;
				for (preRow = row - 1; preRow >= 0; preRow--) {
					var preKey = '';

					//获取该行的组key值
					for (var k = 0; k < groupConfig.groupTdIndexs.length; k++) {
						var c = groupConfig.groupTdIndexs[k];
						var r = preRow;

						//如果该单元格被上面的行合并了，则继续往上找，找到合并该单元格的行，取该行的单元格数据
						while(rowConfig.cellStateTable[r].cellStates[c].rowSpan == 0)
							r--;
						
						//有的单元格已经和其他列合并，不存在了，所以只对存在的单元格进行组字符串
						var mytds = rowConfig.cellStateTable[r].tr.find('td[index=' + c + ']');
						if (mytds.length > 0)
							preKey += $.getTableCellVal($(mytds[0])) + '.';
					}
					
					if (preKey != groupKey)
						break;
				}
				
				preRows[preRows.length] = ++preRow;
				
				if (row - preRow == 0)
					continue;
				
				var preTds = rowConfig.cellStateTable[preRow].tr.find('td');
				
				//遍历每个需要合并行的单元格
				for (var k = 0; k < groupConfig.groupTdIndexs.length; k++) {
					var col = groupConfig.groupTdIndexs[k];
					
					if (cellStateTable[row].cellStates[col].rowSpan == 1) { //如果本单元格还未被合并过，则设置rowSpan属性为0，并且放到删除的单元格数组中等待删除
						cellStateTable[row].cellStates[col].rowSpan = 0;
						
						if (cellStateTable[row].cellStates[col].colSpan > 0) {
							//有可能由于列合并，指定列不是实际要处理的列，所以通过遍历搜索index属性，找到实际要处理的列
							var c = 0;
							while ($(tds[c]).attr('index') != col)
								c++;
							
							removeTds[removeTds.length] = $(tds[c]);
						}
					} else { //如果本单元格已经被删除，则检查影响单元格被删除的组行号是否和当前组行号相同，相同的话就忽略，不处理该行
						var f = false;
						for (var m = j - 1; m >= 0; m--) {
							if (preRows[m] == preRow) {
								f = true;
								break;
							}
						}	
						
						if (f)
							continue;
					}
					
					//修改组行的单元格，设置单元格的rowSpan属性加1
					if (cellStateTable[preRow].cellStates[col].rowSpan > 0) {
						cellStateTable[preRow].cellStates[col].rowSpan += 1;
						
						if (cellStateTable[preRow].cellStates[col].colSpan > 0) {
							//有可能由于列合并，指定列不是实际要处理的列，所以通过遍历搜索index属性，找到实际要处理的列
							var c = 0;
							while ($(preTds[c]).attr('index') != col)
								c++;
							
							$(preTds[c]).attr('rowSpan', cellStateTable[preRow].cellStates[col].rowSpan);
						}
						
						//var msg = '<br>currcol:' + col + ' currrow:' + row + ' torow:' + preRow + ' group:' + groupConfig.groupId;
						//msg += ' groupKey:' + groupKey;
						//msg += ' rowSpan:' + cellStateTable[preRow].cellStates[col].rowSpan;
						//$('#msg').html($('#msg').html() + msg);
					}
				}
			}
	
			//删除因为合并空行而需要删除的单元格
			for (var i = 0; i < removeTds.length; i++)
				removeTds[i].remove();

			//把生成的行数据插入到表格中的上一个插入位置，并改变插入位置为当前插入行位置
			trAdd.insertAfter(trInsertAfter);

			//从表格中删除模板行
			if (trTemplate != null)
				trTemplate.remove();
			
			if (opts.callback)
				opts.callback(trAdd);
				
			//var etime = new Date();
			//var iii = etime - btime;
			//alert('execute start time: ' + btime + ', end time: ' + etime + ', total using time: ' + iii + ' milliseconds');
		});
		
		return trAdd;
	};
	
	$.fn.addRow.defaults = { 
	};
	
	$.fn.removeRow = function(removeTr, tableConfigs, options) {
		removeTr = $(removeTr);
		while(removeTr.attr('nodeName').toUpperCase() != 'TR') {
			removeTr = removeTr.parent();
			
			if (typeof(removeTr) == 'undefined')
				return;
		}
	
		var opts = $.extend({}, $.fn.removeRow.defaults, options); 
		
		var entityclass = opts.entityclass;
		if (!entityclass)
			return this;

		return this.each(function(){
		
			//var btime = new Date();
			
			//检查当前要装载对象至行的映射配置是否存在				
			var table = $(this);
			var tableid = table.attr('id');
			var key = 'row.' + entityclass + '.' + tableid;
			if (!tableConfigs[key])
				return;
			
			var rowConfig = tableConfigs[key];
			var cellStateTable = rowConfig.cellStateTable;

			//搜索要删除行对应的行号
			for (var row = 0; row < cellStateTable.length; row++) {
				if (cellStateTable[row].tr.attr('hashcode') == removeTr.attr('hashcode'))
					break;
			}

			//如果没找到，说明要删除行不在表格中
			if (row == cellStateTable.length)
				return;

			//遍历要删除行的所有单元格，处理单元格跨行的情况
			var cellStates = cellStateTable[row].cellStates;
			for (var col = 0; col < cellStates.length; col++) {
				var cellState = cellStates[col];
				
				//如果当前单元格和被合并到本行其他列别的单元格中，忽略本单元格的处理
				if (cellState.colSpan == 0)
					continue;
					
				if (cellState.rowSpan == 0) {	//如果单元格被合并其他行的单元格中
					var r;
					
					//找到被合并单元格的行号
					for (r = row - 1; r >= 0; r--) {
						if (cellStateTable[r].cellStates[col].rowSpan > 0)
							break;
					}
					
					//让该行的对应单元格的rowSpan减1
					cellStateTable[r].cellStates[col].rowSpan -= 1;
					
					//并修改单元格的rowSpan属性
					var mytds = rowConfig.cellStateTable[r].tr.find('td[index=' + col + ']');
					$(mytds[0]).attr('rowSpan', cellStateTable[r].cellStates[col].rowSpan);
				} else if (cellState.rowSpan > 1) {	//如果单元格合并了其他行的单元格
					//修改本行的下一行对应的单元格
					var r = row + 1;
					
					//设置新单元格的rowSpan减1
					cellStateTable[r].cellStates[col].rowSpan = cellStateTable[row].cellStates[col].rowSpan - 1;
					
					//找到本行单元格，并复制一份，设置单元格的rowSpan属性
					var mytds = rowConfig.cellStateTable[row].tr.find('td[index=' + col + ']');
					var td = $(mytds[0]).clone(true);
					td.attr('rowSpan', cellStateTable[r].cellStates[col].rowSpan);
					
					//搜索下一行中新单元格的插入位置
					var tds = rowConfig.cellStateTable[r].tr.find('td');
					var tdInsertBefore;
					for (var c = 0; c < tds.length; c++) {
						tdInsertBefore = $(tds[c]);
						
						if (tdInsertBefore.attr('index') > col)
							break;
					}
					
					//把修改了rowSpan属性的新单元格插入下一行中
					td.insertBefore(tdInsertBefore);
				}
			}
			
			if (cellStateTable.length == 1) {	//如果仅剩一行时，则这行删除后应该从模板行中复制一行，插入到表格中
				//从行模板克隆一行
				var trtemplate = rowConfig.trTemplate.clone(true);
				trtemplate.insertBefore(cellStateTable[row].tr);
			}
				
			//删除单元格状态表中删除行的状态信息，并删除行
			cellStateTable[row].tr.remove();
			cellStateTable.splice(row, 1);
			
			if (opts.callback)
				opts.callback(removeTr);
		});
	};
	
	$.fn.removeRow.defaults = { 
	}; 

	$.fn.saveData = function(options) {
		var opts = $.extend({}, $.fn.saveData.defaults, options); 
		
//		var saveTask = new Ext.util.DelayedTask(handleSave, this, [opts]);
//		saveTask.delay(100);
//		
//		function handleSave(opts) {
			var mode = opts.mode || 'table';
			var entityclass = opts.entityclass;
			var saveUrl = opts.url;
			var onlyModify = opts.onlyModify || false;
			
			if (mode == 'table') {
				return saveTable(this, entityclass, saveUrl, onlyModify);
			} else if (mode == 'row') {
				return saveRow(this, entityclass, saveUrl, onlyModify);
			} else {
				return saveCell(this, entityclass, saveUrl, onlyModify);
			}
//		}
		
		function saveTable(obj, entityclass, saveUrl, onlyModify) {
			return obj.each(function(){
				var table = $(this);			
				
				var ec = table.attr('entityclass');
				if (typeof(ec) == 'undefined' || ec != entityclass)
					return;
					
				var id = table.attr('entityid');
				if (typeof(id) == 'undefined')
					id = 0;

				var data = {};
				data['id'] = id;
				
				var isModify = false;

				var trs = table.find('tr');
				for (var i = 0; i < trs.length; i++) {
					var tr = $(trs[i]);
					if (typeof(tr.attr('entityclass')) != 'undefined' && tr.attr('entityclass') != entityclass)
						continue;
					
					var tds = tr.find('td[property]');
					for (var j = 0; j < tds.length; j++) {
						var td = $(tds[j]);
						if (typeof(td.attr('entityclass')) != 'undefined' && td.attr('entityclass') != entityclass)
							continue;
						
						var property = td.attr('property');
						data[property] = $.getTableCellVal(td);
						
						if (typeof(td.attr('modify')) != 'undefined')
							isModify = true;
					}
				}
				
				if (onlyModify && !isModify)
					return;
					
				$.ajax({
					type: "POST",
					url: saveUrl,
					data: data,
					success: opts.callback,
					options: opts, 
					dataType: 'json'
				});
			});
		}
		
		function saveRow(obj, entityclass, saveUrl, onlyModify) {
			return obj.each(function(){
				var trs = $(this).find('tr[entityclass="' + entityclass + '"]');
				if (trs.length == 0)
					return;
					
				var data = {};
				
				for (var i = 0; i < trs.length; i++) {
					var tr = $(trs[i]);
					
					var id = tr.attr('entityid');
					if (typeof(id) == 'undefined')
						id = 0;
	
					data['id'] = id;
					
					var isModify = false;
					
					var tds = tr.find('td[property]');
					for (var j = 0; j < tds.length; j++) {
						var td = $(tds[j]);
						if (typeof(td.attr('entityclass')) != 'undefined' && td.attr('entityclass') != entityclass)
							continue;
						
						var property = td.attr('property');
						data[property] =  $.getTableCellVal(td);
						
						if (typeof(td.attr('modify')) != 'undefined')
							isModify = true;
					}
				
					if (onlyModify && !isModify)
						continue;
					
					$.ajax({
						type: "POST",
						url: saveUrl,
						data: data,
						success: opts.callback,
						options: opts, 
						dataType: 'json'
					});
				}
			});
		}
	};
	
	$.fn.saveData.defaults = { 
		callback: function(data, textStatus) {
			if (data.success) {
				if (this.options.success)
					this.options.success(data);
			} else {
				if (this.options.failure)
					this.options.failure(data);
			}
		},
		success: function(data) {
			//alert('save success!');
		},
		failure: function(data) {
			//alert('save failure!');
		}
	}; 
	
	function fillRowData(fillData, tdConfigs, tr, cellStates) {
		//遍历单元格配置信息，设置行的单元格数据信息
		var tds = tr.find('td');
		var removeTds = [];

		//初始化行上每个单元格的rowSpan属性和colSpan属性为1
		for (var col = 0; col < tdConfigs.length; col++) {
			cellStates[col] = {
				rowSpan: 1, 
				colSpan: 1
			};
		}
		
		for (var col = 0; col < tdConfigs.length; col++) {
			var td = $(tds[col]);
			td.attr('index', col);
			
			//如果本单元格没有映射的属性，则不处理，忽略
			var tdConfig = tdConfigs[col];
			if (!tdConfig['property'])
				continue;

			var property = tdConfig['property'];

			//读取本单元属性对应的值
			var val = null;
			if (fillData[property])
				val = fillData[property];
		
			// 对"0"特殊处理,否则val为null
            if(typeof(fillData[property])=="number" && fillData[property]==0){
               val = "0";
            }
            
			if ((val == null || val == '') && tdConfig['mergeblank']) {	//如果单元格要设置的文本为空，并且本单元格设置了合并空行属性
				//往前找是否有可以合并的单元格（不是第一个单元格、或者单元格的colSpan不是为0的）
				var j = -1;
				if (col > 0) {
					j = col - 1;
					while (j >= 0 && cellStates[j].colSpan == 0)
						j--;
				}
				
				//如果找到可以合并的单元格，则让单元格的colSpan加1，并修改单元格的colSpan属性，否则设置紧邻后一个单元格的colSpan加1
				if (j >= 0) {
					cellStates[j].colSpan += 1;
					
					$(tds[j]).attr('colSpan', cellStates[j].colSpan);
				} else
					cellStates[col + 1].colSpan = cellStates[col].colSpan + 1;
				
				//本单元格的colSpan属性为0，并且放到删除的单元格数组中等待删除
				cellStates[col].colSpan = 0;
				removeTds[removeTds.length] = td;
			} else {	//如果单元格要设置的文本不为空、或者单元格未设置合并空行属性
				$.setTableCellVal(td, val, tdConfig, optionItemConfig);
				
				//如果检查本单元格的colSpan大于1（前面单元格因为合并空行影响了本单元格的colSpan属性），则修改单元格的colSpan属性
				if (cellStates[col].colSpan > 1)
					td.attr('colSpan', cellStates[col].colSpan);
			}
		}

		//删除因为合并空行而需要删除的单元格
		for (var i = 0; i < removeTds.length; i++)
			removeTds[i].remove();
	}

	var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	function generateMixed(n) {
		var res = '';

		for(var i = 0; i < n ; i ++) {
			var id = Math.ceil(Math.random()*35);
			res += chars[id];
		}

		return res;
	} 
})(jQuery);