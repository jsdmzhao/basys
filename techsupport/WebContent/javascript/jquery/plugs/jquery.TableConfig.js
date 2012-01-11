(function($) {
	$.parseConfig = function(objs, options) {
		var opts = $.extend({}, $.parseConfig.defaults, options); 
		
		var tableConfigs = {};
		
		objs.each(function() {
			var table = $(this);
			var id = table.attr('id');

			var entityclass, key;
			if (typeof(table.attr('entityclass')) != 'undefined') {
				entityclass = table.attr('entityclass');
				key = 'table.' + entityclass + '.' + id;

				tableConfigs[key] = {
					mode: 'table',
					entityclass: entityclass,
					tableid: id,
					propertys: {}
				};
			}
				
			var trs = table.find('tr');
			for (var i = 0; i < trs.length; i++) {
				var tr = $(trs[i]);

				if (typeof(tr.attr('entityclass')) != 'undefined' && tr.attr('entityclass') != entityclass) {
					tr = tr.clone(true);

					if (typeof(tr.attr('entityid')) != 'undefined')
						tr.removeAttr('entityid');

					var ec = tr.attr('entityclass');
					var k = 'row.' + ec + '.' + id;

					tableConfigs[k] = {
						mode: 'row',
						entityclass: ec,
						tableid: id,
						trTemplate: tr,
						groupConfigs: [],
						tdConfigs: [],
						cellStateTable: []
					};

					var groupConfigs = tableConfigs[k].groupConfigs;

					var tds_groupid = tr.find('td');
					for (var i = 0; i < tds_groupid.length; i++) {
						var groupids = $(tds_groupid[i]).attr('groupid');
						if (typeof(groupids) == 'undefined')
							continue;
						
						groupids = groupids.trim().split(' ');
						
						for (var j = 0; j < groupids.length; j++) {
							var groupid = groupids[j].trim();

							for (var pos = 0; pos < groupConfigs.length; pos++) {
								if (groupid == groupConfigs[pos].groupId)
									break;
							}

							if (!groupConfigs[pos])
								groupConfigs[pos] = {};
							
							groupConfigs[pos].groupId = groupid;

							if (!groupConfigs[pos].groupTdIndexs)
								groupConfigs[pos].groupTdIndexs = [];

							groupConfigs[pos].groupTdIndexs[groupConfigs[pos].groupTdIndexs.length] = i;
						}
					}

					var tdConfigs = tableConfigs[k].tdConfigs;

					var tds = tr.find('td');
					for (var j = 0; j < tds.length; j++) {
						var td = $(tds[j]);

						tdConfigs[j] = {};

						var property = td.attr('property');
						if (typeof(property) != 'undefined')
							tdConfigs[j].property = property;
						
						var groupid = td.attr('groupid');
						if (typeof(groupid) != 'undefined')
							tdConfigs[j].groupid = groupid;

						var mergeblank = td.attr('mergeblank');
						if (typeof(mergeblank) != 'undefined')
							tdConfigs[j].mergeblank = mergeblank;

						var store = td.attr('store');
						if (typeof(store) != 'undefined') {
							tdConfigs[j].store = store;
							
							var valuefield = td.attr('valuefield');
							if (typeof(valuefield) != 'undefined')
								tdConfigs[j].valuefield = valuefield;
							else
								tdConfigs[j].valuefield = 1;
	
							var displayfield = td.attr('displayfield');
							if (typeof(displayfield) != 'undefined')
								tdConfigs[j].displayfield = displayfield;
							else
								tdConfigs[j].displayfield = 2;
						}
					}
				} else {
					var tds = tr.find('td[property]');

					for (var j = 0; j < tds.length; j++) {
						var td = $(tds[j]);

						if (typeof(td.attr('entityclass')) != 'undefined' && td.attr('entityclass') != entityclass) {
							var ec = td.attr('entityclass');
							var k = 'cell.' + ec + '.' + id;
							var p = td.attr('property');

							tableConfigs[k] = {
								mode: 'cell',
								entityclass: ec,
								tableid: id,
								propertys: {}
							};

							tableConfigs[k].propertys[p] = {
								td: td
							};
							
							var tdConfig = tableConfigs[k].propertys[p];

							var store = td.attr('store');
							if (typeof(store) != 'undefined') {
								tdConfig.store = store;
								
								var valuefield = td.attr('valuefield');
								if (typeof(valuefield) != 'undefined')
									tdConfig.valuefield = valuefield;
								else
									tdConfig.valuefield = 0;
		
								var displayfield = td.attr('displayfield');
								if (typeof(displayfield) != 'undefined')
									tdConfig.displayfield = displayfield;
								else
									tdConfig.displayfield = 1;
							}
						} else {
							var property = td.attr('property');

							tableConfigs[key].propertys[property] = td;
						}
					}
				}
			}
		});

		return tableConfigs;
	};
	
	$.parseConfig.defaults = { 
	}; 
	
	$.setTableCellVal = function (td, val, tdConfig, storeConfig) {
		if (tdConfig.store) {
			td.attr('storeValue', val);
			
			var store = storeConfig[tdConfig.store];
			if (store) {
				for (var i = 0; i < store.length; i++) {
					var record = store[i];
					
					if (record[tdConfig.valuefield] == val) {
						    td.html(record[tdConfig.displayfield]);
						return;
					}
				}
			}
		}
		td.html(val);
	}
	
	$.setTableCellVal1 = function (td, storeValue, displayValue) {
		if (typeof(displayValue) == 'undefined') {
			td.html(storeValue);
		} else {
			td.attr('storeValue', storeValue);
			td.html(displayValue);
		}
	}
	
	$.getTableCellVal = function (td) {
		var val = td.attr('storeValue');
		if (typeof(val) == 'undefined')
			val = td.html();
			
		return val;
	}
})(jQuery);