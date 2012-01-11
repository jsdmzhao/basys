/*
jquery.combobox
version 0.1.2.3 alpha

ahura mazda
copyright 2007
jquery.sanchezsalvador.com
*/
jQuery.fn.combobox = function(options)
{
	// Setting class
	var settings =
	{	
		comboboxContainerClass: null,
		comboboxValueContainerClass: null,
		comboboxValueContentClass: null,
		comboboxDropDownButtonClass: null,
		comboboxDropDownClass: null,
		comboboxDropDownItemClass: null,
		comboboxDropDownItemHoverClass: null,
		comboboxDropDownGroupItemHeaderClass: null,
		comboboxDropDownGroupItemContainerClass: null,
		animationType: "slide"
	};
	if (options)
	{
		jQuery.extend(settings, options);
	}
	
	//#region public events
//	this.onChange =
//		function()
//		{
//			//Intentionally left empty
//		alert("dddd");
//		};
	//this.onChange = this.attr("onChange");
	//this.onClick = this.attr("onClick");
	//#endregion public events
	
	return this.each(
		function()
		{
		
			//#region 'private' variables
			
			// This class can operate of N elements depending on how ComboBox is called
			// for example jQuery('select').combobox() could return multiple Selects.
			// This variable should always be a Select JQuery element.
			// TODO: Check if select control is used
var _originalElementJQuery = jQuery(this);
			var _containerJQuery = null;
			var _containerDefaultStyle = "border-left: solid 1px #7f9db9;border-top: solid 1px #7f9db9; background:#fff; height:14px;border-right: solid 1px #7f9db9;border-bottom: solid 1px #7f9db9;"; //输入边框样式
			var _containerEnforcedStyle = "padding:1;";//下拉图片与输入边框的空隙
			var _dropDownListJQuery = null;
			var _dropDownListEnforcedStyle = "list-style-type:none;padding-top:0;margin:1px;";//下拉框的样式/实线
			var _dropDownListDefaultStyle = "cursor:default;padding:0px;background:#fff;border-right:solid 1px #000;border-bottom:solid 1px #000;border-left:solid 1px #000;border-top:solid 1px #000;overflow:auto";//下拉框的样式
			var _dropDownListItemEnforcedStyle = "display:block;";
			var _dropDownListItemDefaultStyle = "cursor:default;padding-left:2px;font-weight:normal;font-style:normal;";
			var _dropDownListGroupItemContainerEnforcedStyle = "list-style-type:none;";
			var _dropDownListGroupItemContainerDefaultStyle = "padding-left:10px;margin-left:0;";
			var _dropDownListGroupItemHeaderEnforcedStyle = "";
			var _dropDownListGroupItemHeaderDefaultStyle = "font-style:italic;font-weight:bold;";			
			var _valueDisplayContainerJQuery = null;
			var _valueDisplayContainerEnforcedStyle = "position:static;overflow:hidden;";
			var _valueDisplayJQuery = null;
			var _valueDisplayEnforcedStyle = "float:left;position:static;cursor:default;overflow:hidden;";
			var _dropDownButtonJQuery = null;
			var _dropDownButtonDefaultStyle = "width:17px;height:14px;color:#4d6185;font-family: 幼圆;font-size: 10px;cursor: default;text-align: center;";
			var _dropDownButtonEnforcedStyle = "background-repeat:no-repeat;float:right;position:static;";
			var _dropDownButtonDefaultUnselectedStyle = "padding-left:0px;width:13px;height:14px;background:#c1d2fb;border:0px;";//图片样式
			var _dropDownButtonDefaultSelectedStyle = "color:#4d6185;width:12px;height:14px;background:#cae2fd;border:#95ade5;";//鼠标点击时图片的样式
			var _dropDownButtonDefaultCharacter = "&#9660;";
			var _lastItemSelectedJQuery = null;
			var _lastValue = null;
			var _downdownListPositionIsInverted = false;
			var _maximumItemLength = 0;
			var _dropDownListOffset = null;
			
			//#endregion 'private' variables
			
			//#region 'private' methods
			
			///<summary>
			/// Function extension to String.
			///	Replaces the placeholder tags '{0}...{n}' with the parameters based on ordinal position of the parameters
			///	Example: String.format("The quick {0} fox {2} over the lazy {1}.", "brown", "Dog", "jumps");
			///	Output:	The quick brown fox jumps over the lazy Dog.
			///</summary>
			String.format =
				function()
				{
					var currentString = null;
					if (arguments.length != 0)
					{
						currentString = arguments[0];
						for (var argumentIndex = 1; argumentIndex < arguments.length; argumentIndex++)
						{
							var modifiedString = new RegExp('\\{' + (argumentIndex - 1) + '\\}','gm');
							currentString = currentString.replace(modifiedString, arguments[argumentIndex]);
						}
					}
					
					return currentString;
				};

			///<summary>
			///	Sets the width of an element taking into consideration any borders and padding.
			///	Works exactly like Internet Explorers Box Model, where the padding and border is considered
			//	part of the width. For the purposes of this control, it is require in certain circumstances.
			///	Example:
			///	 <div id="container" style="width: 150px; border:solid 2px #000"></div>
			///		jQuery('#container').width(); // 150px
			///		jQuery('#container').outerWidth(); // 154px (2px border on the left and right)
			///		setInnerWidth(jQuery('#container'), 120);
			///		jQuery('#container').width(); // 116px
			///		jQuery('#container').outerWidth(); // 120px (2px border on the left and right)
			///</summary>				
			function setInnerWidth(elementJQuery, width)
			{
				var differenceWidth = (elementJQuery.outerWidth() - elementJQuery.width());
				
				elementJQuery.width(width - differenceWidth);
			}
			
			///<summary>
			///	Sets the height of an element taking into consideration any borders and padding.
			///	Works exactly like Internet Explorers Box Model, where the padding and border is considered
			//	part of the height. For the purposes of this control, it is require in certain circumstances.			
			///</summary>				
			function setInnerHeight(elementJQuery, height)
			{
				var differenceheight = (elementJQuery.outerHeight() - elementJQuery.height());
				
				elementJQuery.height(height - differenceheight);
			}
			
			///<summary>
			/// Builds the elements that make up the always visible portion of the control.
			///	The equivalent of a Textbox-type element.
			/// Also creates the DropDownButton
			///</summary>
			function buildValueDisplay()
			{
				// A container for the Display Value and DropDownButton. A container is required as the child elements
				// are floated
				var valueDisplayContainerHTML = "";
				if (settings.comboboxValueContainerClass)
				{
					valueDisplayContainerHTML = String.format("<div class='{0}' style='{1}'></div>", settings.comboboxValueContainerClass, _valueDisplayContainerEnforcedStyle);
				}
				else
				{
					valueDisplayContainerHTML = String.format("<div style='{0}'></div>", _valueDisplayContainerEnforcedStyle);
				}
				
				// Create the equivalent of the select 'textbox' where the current selected value is shown
				var valueDisplayHTML = "";
				if (settings.comboboxValueContentClass)
				{
					valueDisplayHTML = String.format("<div class='{0}' style='{1}'></div>", settings.comboboxValueContentClass, _valueDisplayEnforcedStyle);
				}
				else
				{
					valueDisplayHTML = String.format("<div style='{0}'></div>", _valueDisplayEnforcedStyle);
				}
				
				var dropdownButtonHTML = "";
				if (settings.comboboxDropDownButtonClass)
				{
					dropdownButtonHTML = String.format("<div class='{1}' style='{0}'></div>",_dropDownButtonEnforcedStyle, settings.comboboxDropDownButtonClass);
				}
				else
				{
					dropdownButtonHTML = String.format("<div style='{0}'><img src='images/sebg.gif'style='border:0'></div>", (_dropDownButtonEnforcedStyle + _dropDownButtonDefaultStyle), _dropDownButtonDefaultCharacter);
				}
				
				_valueDisplayJQuery = jQuery(valueDisplayHTML);
				_dropDownButtonJQuery = jQuery(dropdownButtonHTML);
				_valueDisplayContainerJQuery = jQuery(valueDisplayContainerHTML);
				
				_valueDisplayContainerJQuery.appendTo(_containerJQuery);
				_valueDisplayJQuery.appendTo(_valueDisplayContainerJQuery);
				_dropDownButtonJQuery.appendTo(_valueDisplayContainerJQuery);
			
				setDropDownButtonState(0);
			}
			
			///<summary>
			///	Build a drop down list element populating it will values, text, styles and class
			///	depending on the source value type. The source value (childJQuery) can be an option or
			///	and optgroup element.
			///</summary>
			function buildDropDownItem(childJQuery)
			{
				var dataItemHTML = "";
				var dataItemClass = null;
				var dataItemText = "";
				var dataItemValue = null;
				var dataItemStyle = "";
				var dataItemType = "option";
				
				if (childJQuery.is('option'))
				{
					dataItemText = childJQuery.text();
					dataItemValue = childJQuery.val();
					
					if (settings.comboboxDropDownItemClass)
					{
						dataItemClass = settings.comboboxDropDownItemClass;
						dataItemStyle = _dropDownListItemEnforcedStyle;
					}
					else
					{
						dataItemStyle = (_dropDownListItemEnforcedStyle + _dropDownListItemDefaultStyle);
					}
					
					if (dataItemClass)
					{						
						dataItemHTML = String.format("<li style='{0}' class='{1}'>{2}</li>", dataItemStyle, dataItemClass, dataItemText);
					}
					else
					{
						dataItemHTML = String.format("<li style='{0}'>{1}</li>", dataItemStyle, dataItemText);
					}
					
				}
				else
				{
					dataItemText = childJQuery.attr('label');
					dataItemValue = childJQuery.attr('class');
					dataItemType = "optgroup";
					
					if (settings.comboboxDropDownGroupItemHeaderClass)
					{
						dataItemClass = settings.comboboxDropDownGroupItemHeaderClass;
						dataItemStyle = _dropDownListGroupItemHeaderEnforcedStyle;
					}
					else
					{
						dataItemStyle = (_dropDownListGroupItemHeaderEnforcedStyle + _dropDownListGroupItemHeaderDefaultStyle);
					}
					
					if (dataItemClass)
					{						
						dataItemHTML = String.format("<li><span style='{0}' class='{1}'>{2}</span></li>", dataItemStyle, dataItemClass, dataItemText);
					}
					else
					{
						dataItemHTML = String.format("<li><span style='{0}'>{1}</span></li>", dataItemStyle, dataItemText);
					}
				}
				
				var dataItemJQuery = jQuery(dataItemHTML);
				
				// The element's style is set to inline for the calculation of the true width
				// The element is then reset to its enforced style (display:block) later
				dataItemJQuery.css("display", "inline");
				// Store the value with the DOMElement which is persisted with the Browser
				dataItemJQuery[0].dataValue = dataItemValue;
				dataItemJQuery[0].dataType = dataItemType;
				dataItemJQuery[0].title = dataItemText;
				
				return dataItemJQuery;
			}
			
			///<summary>
			///	Recusively build the drop down list elements based on the options and optgroups contained
			///	with the original Select element
			///</summary>
			function recursivelyBuildList(parentJQuery, childrenOptionsJQuery)
			{
				childrenOptionsJQuery.each(
					function()
					{
						var childJQuery = jQuery(this);
						var builtDropDownItemJQuery = buildDropDownItem(childJQuery);
						parentJQuery.append(builtDropDownItemJQuery);
						
						// Calculate the true width of the item taking into consideration the offset from the left-edge
						// of the drop-down list.
						// Get the left offset of the DropDown list container and subtract that from the builtDropDownItemJQuery left offset
						//	to get the distance the builtDropDownItemJQuery is from its container
						var offsetLeft = builtDropDownItemJQuery.offset().left;
						
						offsetLeft -= _dropDownListOffset.left;
						
						if (offsetLeft < 0)
						{
							offsetLeft = 0;
						}
						
						var width = (offsetLeft + builtDropDownItemJQuery.outerWidth());
						if (width > _maximumItemLength)
						{
							_maximumItemLength = width;
						}
						
						// Set the enforced style of display:block after the width has been calculated.
						applyMultipleStyles(builtDropDownItemJQuery, _dropDownListItemEnforcedStyle);
						
						if (childJQuery.is('optgroup'))
						{
							var dataGroupItemHTML = "";
							if (settings.comboboxDropDownGroupItemContainerClass)
							{
								dataGroupItemHTML = String.format("<ul style='{0}' class='{1}'></ul>", _dropDownListGroupItemContainerEnforcedStyle, settings.comboboxDropDownGroupItemContainerClass);
							}
							else
							{
								dataGroupItemHTML = String.format("<ul style='{0}'></ul>", (_dropDownListGroupItemContainerEnforcedStyle + _dropDownListGroupItemContainerDefaultStyle));
							}
							
							var dataGroupItemJQuery = jQuery(dataGroupItemHTML);
							builtDropDownItemJQuery.append(dataGroupItemJQuery);
							
							// If not an option, then the child of a Select must be an optgroup element
							recursivelyBuildList(dataGroupItemJQuery, childJQuery.children());
						}
					});
			}
	
			///<summary>
			/// Creates an unordered list of values from the original Select control
			///</summary>
			function buildDropDownList()
			{
				var originalElementChildrenJQuery = _originalElementJQuery.children();
				_lastItemSelectedJQuery = null;
				_lastValue = null;

				// If the Drop Down List container already exists, recreate only the items,
				// else create the container and the items as well.
				if (_dropDownListJQuery)
				{
					// Clear out any existing children elements
					_dropDownListJQuery.empty();
				}
				else
				{
					var dropDownHTML = "";
					if (settings.comboboxDropDownClass)
					{
						dropDownHTML += String.format("<ul class='{0} scrollbarface' style='{1};overflow-y:auto;overflow-x:hidden'></ul>", settings.comboboxDropDownClass, _dropDownListEnforcedStyle);
					}
					else
					{
						dropDownHTML += String.format("<ul class='scrollbarface' style='{0};overflow-y:auto;overflow-x:hidden'></ul>", (_dropDownListEnforcedStyle + _dropDownListDefaultStyle));
					}
					_dropDownListJQuery = jQuery(dropDownHTML);
					// Create the equivalent of the drop down list where the all the values are shown
					//_dropDownListJQuery.css("position","absolute");
					_dropDownListJQuery.appendTo(_containerJQuery);
					// Enable the Drop Down List to be able to receive focus and key events
					_dropDownListJQuery.attr("tabIndex", 0);
				}
				// Create the internal list of values if they exist
				if (originalElementChildrenJQuery.length > 0)
				{
					_maximumItemLength = 0;
					_dropDownListOffset = _dropDownListJQuery.offset();
					settingWidth = _originalElementJQuery.width();
						
					_dropDownListJQuery.width(settingWidth);
					
					var listHeigth = originalElementChildrenJQuery.length*16;
					if(listHeigth>200)listHeigth=200;
					
					_dropDownListJQuery.css("height",listHeigth);
					recursivelyBuildList(_dropDownListJQuery, originalElementChildrenJQuery);
				}
				
			}
			
			///<summary>
			/// Applies CSS styling from a string that contains multiple style settings
			///	Example: "background-color:#fff;color:#0f0;border:solid 1px #00f;"
			///</summary>			
			function applyMultipleStyles(elementJQuery, multipleCSSStyles)
			{
				var stylePairArray = multipleCSSStyles.split(";");
				if (stylePairArray.length > 0)
				{
					for (var stylePairArrayIndex = 0; stylePairArrayIndex < stylePairArray.length; stylePairArrayIndex++)
					{
						var stylePair = stylePairArray[stylePairArrayIndex];
						var splitStylePair = stylePair.split(":");
						
						elementJQuery.css(splitStylePair[0], splitStylePair[1]);
					}
				}
			}
			
			///<summary>
			///	Changes the image of the drop down button based on the state
			///	Normal = 0
			///	Pressed = 1
			///</summary>
			function setDropDownButtonState(state)
			{
				if (settings.comboboxDropDownButtonClass)
				{
					var width = _dropDownButtonJQuery.width();
					var offset = state * width;
					var background_positionCSS = String.format("-{0}px 0px", offset);
					_dropDownButtonJQuery.css("background-position", background_positionCSS);
				}
				else
				{
					var style = _dropDownButtonDefaultUnselectedStyle;
					
					if (state == 1)
					{
						style = _dropDownButtonDefaultSelectedStyle;
					}
					
					applyMultipleStyles(_dropDownButtonJQuery, style);
				}
			}
			
			///<summary>
			///	Adjust the width of the DropDown list based on the widest item or the set width (options), whichever
			///	is larger.
			///</summary>
			function updateDropDownListWidth()
			{
				//Drop down list element
				var dropdownListWidth = _containerJQuery.outerWidth();

				if (dropdownListWidth < _maximumItemLength)
				{
					dropdownListWidth = _maximumItemLength;
				}
				_dropDownListJQuery.width(dropdownListWidth);
			}
			
			///<summary>
			/// Repositions the display value based on height of the element.
			///	Note: the height will only have meaning if the display value element has text
			///</summary>
			function positionDisplayValue()
			{
				var displayValueHeight = _valueDisplayJQuery.outerHeight();
				var displayContainerHeight = _valueDisplayContainerJQuery.height();
				var difference = ((displayContainerHeight - displayValueHeight) / 2);
				
				if (difference < 0)
				{
					difference = 0;
				}
				//TODO: add other alignments for the user, such as left, top, middle, bottom, etc
				_valueDisplayJQuery.css("top", difference);
			}
			
			///<summary>
			///	Applies custom layout position and sizing to the controls
			///</summary>
			function applyLayout()
			{
				_containerJQuery.width(_originalElementJQuery.width());
				// Removes any units and retrieves only the value of width
				var controlWidth = _containerJQuery.width();
				setInnerWidth(_valueDisplayContainerJQuery, controlWidth);

				var displayValueWidth = (_valueDisplayContainerJQuery.width() - _dropDownButtonJQuery.outerWidth());
				setInnerWidth(_valueDisplayJQuery, displayValueWidth);
				var dropDownButtonHeight = _dropDownButtonJQuery.outerHeight();
				setInnerHeight(_valueDisplayContainerJQuery, dropDownButtonHeight);

				_dropDownListJQuery.css("position", "absolute");
				_dropDownListJQuery.css("z-index", "20000");
				
				updateDropDownListWidth();

				// Position the drop down list correctly, taking the main display control border into consideration
				var currentLeftPosition = _dropDownListJQuery.offset().left;
				var leftPosition = (currentLeftPosition - (_containerJQuery.outerWidth() - _containerJQuery.width()));
				_dropDownListJQuery.css("left", leftPosition + 1);
				_dropDownListJQuery.hide();
			}

			///<summary>
			/// Bind all items to mouse events except for UL elements
			/// and LI elements that are option group labels
			///</summary>			
			function bindItemEvents()
			{
				jQuery("*", _dropDownListJQuery).not("ul").not("span").not("[@dataType='optgroup']").each(
					function()
					{
						var itemJQuery = jQuery(this);
						itemJQuery.click(
							function(clickEvent)
							{
								// Stops the click event propagating to the Container and the Container.onClick firing
								clickEvent.stopPropagation();
								
								container_onItemClick(itemJQuery);
							});
						
						itemJQuery.mouseover(
							function()
							{
								container_onItemMouseOver(itemJQuery);
							});
							
						itemJQuery.mouseout(
							function()
							{
								container_onItemMouseOut(itemJQuery);
							});
					});			
			}

			///<summary>
			///		Bind the dropdown list control blur event to a function
			///</summary>
			function bindBlurEvent()
			{
				_dropDownListJQuery.blur(
					function(blurEvent)
					{
						blurEvent.stopPropagation();
						
						dropDownListJQuery_onBlur();
					});
			}
			
			///<summary>
			///	Bind the click event of the container to a function
			///</summary>
			function bindContainerClickEvent()
			{	
				_containerJQuery.click(
					function(clickEvent)
					{
						container_onClick();
					});
			}

			///<summary>
			///	Remove the binding of a custom function from the container's click event
			///</summary>
			function unbindContainerClickEvent()
			{
				_containerJQuery.unbind("click");
			}
						
			///<summary>
			///		Bind this control to the events to custom functions
			///</summary>
			function bindEvents()
			{
				_containerJQuery.keydown(
					function(keyEvent)
					{
						keyEvent.preventDefault();container_onKeyDown(keyEvent)
					});
				bindContainerClickEvent();
					
				bindBlurEvent();
					
				bindItemEvents();
			}
						
			///<summary>
			///		Sets the value both internally and visually to the user
			///</summary>
			function setDisplayValue()
			{
				var valueHasChanged = false;
				var originalElement = _originalElementJQuery[0];
				
				if (originalElement.length > 0)
				{
					var selectedText = originalElement[originalElement.selectedIndex].text;
					_valueDisplayJQuery.text(selectedText);
					_valueDisplayJQuery.attr("title", selectedText);
					_originalElementJQuery.attr("title",selectedText);
					// Reposition the display value based on height of the element after the text has changed
					positionDisplayValue();
					
					if (_lastValue!=null)
					{
						if (_lastValue != _originalElementJQuery.val())
						{
							valueHasChanged = true;
						}
					}

					//alert(_originalElementJQuery.val());
					_lastValue = _originalElementJQuery.val();
					//  If the selected value has changed since the last click, fire the onChange event
					if (valueHasChanged)
					{
						_originalElementJQuery.trigger("change");

					}
					
					// If _lastItemSelectedJQuery has been set, remove the highlight from it, before setting it to the current
					// value
					if (_lastItemSelectedJQuery)
					{
						toggleItemHighlight(_lastItemSelectedJQuery, false);
					}
					
					// Find the DropDown Item Element that corresponds to the current value in the Select element
					_lastItemSelectedJQuery = jQuery("li[@dataValue='" + _lastValue + "']", _dropDownListJQuery);
					
					toggleItemHighlight(_lastItemSelectedJQuery, true);
				}
			}
			
			///<summary>
			///	Highlights/Unhighlights a specific option.
			///	If a class is not set, then the background and foreground colours are inverted
			///</summary>
			function toggleItemHighlight(elementJQuery, isHighlighted)
			{
				if (elementJQuery)
				{
					if (settings.comboboxDropDownItemHoverClass)
					{
						if (isHighlighted)
						{
							elementJQuery.addClass(settings.comboboxDropDownItemHoverClass);
						}
						else
						{
							elementJQuery.removeClass(settings.comboboxDropDownItemHoverClass);
						}
					}
					else
					{
						if (isHighlighted)
						{
							elementJQuery.css("background", "#316ac5");
							elementJQuery.css("color", "#fff");
						}
						else
						{
							elementJQuery.css("background", "");
							elementJQuery.css("color", "");
						}
					}
				}
			}

			///<summary>
			///	Builds the Outermost control and swaps out the original Select element.
			///	The Select element then becomes an hidden control within.
			///</summary>
			function buildContainer()
			{
				var containerHTML = "";
				if($("#div_"+_originalElementJQuery.attr("id")).attr("id")!=null){
					jQuery("#div_"+_originalElementJQuery.attr("id")).remove();
				}
				
				if (settings.comboboxContainerClass)
				{
					containerHTML = String.format("<div class='{0}' id='div_"+_originalElementJQuery.attr("id")+"' style='{1}'></div>", settings.comboboxContainerClass, _containerEnforcedStyle);
				}
				else
				{
					containerHTML = String.format("<div style='{0}' id='div_"+_originalElementJQuery.attr("id")+"' style='{1}'></div>", _containerDefaultStyle, _containerEnforcedStyle);
				}
				_containerJQuery = jQuery(containerHTML).click(function(){
					var selectValue = _originalElementJQuery.val();
					_originalElementJQuery.trigger("click");
					_originalElementJQuery.val(selectValue);
				});
				//_containerJQuery.css("position","absolute");
				_originalElementJQuery.before(_containerJQuery);
				//_containerJQuery.append(_originalElementJQuery);
//				_originalElementJQuery.parents().each(function(){
//					isFixed |= $(this).css('position') == 'fixed';
//				});
				_originalElementJQuery.hide();
				// Allow the custom jquery.combobox be able to receive focus and key events
				_containerJQuery.attr("tabIndex", 9999);
			}
			
			///<summary>
			///	Converts an existing Select element to a JQuery.combobox.
			///	The Select element is kept and updated accordingly, but visually is represented
			///	by other richer HTML elements
			///</summary>
			function initialiseControl()
			{
				buildContainer();
				
				buildValueDisplay();
				
				buildDropDownList();
				
				applyLayout();
			
				var onlyAttr = _originalElementJQuery.attr("readonly");

				if(!onlyAttr || onlyAttr=="false"){
					bindEvents();
				}
				
				setDisplayValue();
				//alert(_containerJQuery.html());
			}
			
			///<summary>
			///	Focus must be set to the DropDown list element only after it has shown.
			///	This is due to IE executing the Blur event before the list has immediately shown
			///</summary>
			function setDropDownListFocus()
			{
				_dropDownListJQuery.focus();
			}

			///<summary>
			///	Focus set to the Combobox Container
			///</summary>
			function setAndBindContainerFocus()
			{
				_containerJQuery.focus();
				bindContainerClickEvent();
			}
			
			///<summary>
			///	Slides up the DropDownlist when it is to be placed above the CB
			///</summary>
			function slideUp(newTop)
			{
				_dropDownListJQuery.animate(
					{
						height: "toggle",
						top: newTop
					},
					"fast",
					setDropDownListFocus);
			}
			
			///<summary>
			///	Slides closed the DropDownlist when it is placed above the CB.
			///	Binds the CB Container click event after the DDL is hidden to avoid a bug in IE
			///	where the click event fires re-opening the DDL.
			///</summary>
			function slideDown(newTop)
			{
				_dropDownListJQuery.animate(
					{
						height: "toggle",
						top: newTop
					},
					"fast",
					setAndBindContainerFocus);
			}
			
			///<summary>
			///	Get the proposed top position of the drop down list container.
			///	Also sets whether the drop down list is inverted. Inverted means that the
			///	list is shown above the container as opposed to the normal position of below the combobox 
			///	container
			///</summary>
			function getDropDownListTop()
			{	
				var comboboxTop = _containerJQuery.position().top;
				var dropdownListHeight = _dropDownListJQuery.outerHeight();
				var comboboxBottom = (comboboxTop + _containerJQuery.outerHeight());
				var windowScrollTop = jQuery(window).scrollTop();
				var windowHeight = jQuery(window).height();	
				var availableSpaceBelow = (windowHeight - (comboboxBottom - windowScrollTop));
				var dropdownListTop;

				// Set values to display dropdown list below combobox as default				
				dropdownListTop = comboboxBottom;
				_downdownListPositionIsInverted = false;

				// Check if there is enough space below to display the full height of the drop down list
				if (availableSpaceBelow < dropdownListHeight)
				{
					// There is no available space below the combobox to display the dropdown list
					// Check if there is available space above. If not, then display below as default
					if ((comboboxTop - windowScrollTop)> dropdownListHeight)
					{
						// There is space above
						dropdownListTop = (comboboxTop - dropdownListHeight);
						_downdownListPositionIsInverted = true;
					}
				}
				
				return dropdownListTop;
			}
			
			function getDropDownListLeft()
			{
				var comboboxTop = _containerJQuery.position().top;
				var dropdownListHeight = _dropDownListJQuery.outerHeight();
				var comboboxBottom = (comboboxTop + _containerJQuery.outerHeight());
				var windowScrollTop = jQuery(window).scrollTop();
				var windowHeight = jQuery(window).height();	
				var availableSpaceBelow = (windowHeight - (comboboxBottom - windowScrollTop));
				var dropdownListTop;

				// Set values to display dropdown list below combobox as default				
				dropdownListTop = comboboxBottom;
				_downdownListPositionIsInverted = false;

				// Check if there is enough space below to display the full height of the drop down list
				if (availableSpaceBelow < dropdownListHeight)
				{
					// There is no available space below the combobox to display the dropdown list
					// Check if there is available space above. If not, then display below as default
					if ((comboboxTop - windowScrollTop)> dropdownListHeight)
					{
						// There is space above
						dropdownListTop = (comboboxTop - dropdownListHeight);
						_downdownListPositionIsInverted = true;
					}
				}
				
				return dropdownListTop;
			}
			
			///<summary>
			///	Hides/Shows the list of values.
			///	The method of display or hiding is specified as settings.animationType.
			///	This method also changes the button state
			///</summary>					
			function toggleDropDownList(isShown)
			{
				if (isShown)
				{
					if (_dropDownListJQuery.is(":hidden"))
					{
						// Remove the click event from the container because when the dropdown list is shown
						// and the container is clicked, the dropdownlist blur event is fired which hides the control
						// and the container click is fired after which will show the list again (error);
						unbindContainerClickEvent();
						
						// When the DropDown list is shown, highlist the current value in the list
						toggleItemHighlight(_lastItemSelectedJQuery, true);
		
						setDropDownButtonState(1);
						var dropdownListTop = getDropDownListTop();
						_dropDownListJQuery.css("top", dropdownListTop);
						_dropDownListJQuery.css("left", _containerJQuery.position().left-3);
						switch (settings.animationType)
						{
							case "slide":
								if (_downdownListPositionIsInverted)
								{
									var comboboxTop = _containerJQuery.position().top;
									var containerHeight = _containerJQuery.outerHeight();

									_dropDownListJQuery.css("top", (comboboxTop - containerHeight));

									slideUp(dropdownListTop);
								}
								else
								{
									_dropDownListJQuery.slideDown("fast", setDropDownListFocus);
								}
								break;
								
							case "fade":
								_dropDownListJQuery.fadeIn("fast", setDropDownListFocus);
								break;
								
							default:
								_dropDownListJQuery.show();
								setDropDownListFocus();
						}
					}
				}
				else
				{
					if (_dropDownListJQuery.is(":visible"))
					{
						setDropDownButtonState(0);
						
						switch (settings.animationType)
						{
							case "slide":
								if (_downdownListPositionIsInverted)
								{
									comboboxTop = _containerJQuery.position().top;
									dropdownListHeight = _dropDownListJQuery.height();

									slideDown(comboboxTop - _containerJQuery.outerHeight());
								}
								else
								{
									_dropDownListJQuery.slideUp("fast", setAndBindContainerFocus)
								}
								break;
								
							case "fade":
								_dropDownListJQuery.fadeOut("fast", setAndBindContainerFocus);
								break;
								
							default:
								_dropDownListJQuery.hide();
								setAndBindContainerFocus();
						}
					}
				}
			}

			///<summary>
			///	Selects a value from the list of options from the original Select options.
			///	Does not use JQuery Selectors ':last' and ':first' because they take optgroup elements into
			///	account.
			///</summary>					
			function selectValue(subSelector)
			{
				var originalElement = _originalElementJQuery[0];
				var currentIndex = originalElement.selectedIndex;
				var newIndex = -1;
				// {select}.length returns the array size of the options. Does not count optgroup elements
				var optionCountZeroBased = originalElement.length - 1;
				
				switch (subSelector)
				{
					case ":next":
						newIndex = currentIndex + 1;
						if (newIndex > optionCountZeroBased)
						{
							newIndex = optionCountZeroBased;
						}
						break;
					
					case ":previous":
						newIndex = currentIndex - 1;
						if (newIndex < 0)
						{
							newIndex = 0;
						}

						break;
						
					case ":first":
						newIndex = 0;
						
						break;
						
					case ":last":
						newIndex = optionCountZeroBased;
						
						break;
				}

				originalElement.selectedIndex = newIndex;
				setDisplayValue();
			}
			
			///<summary>
			///	Returns true if the DropDownList visible on screen, else false
			///</summary>
			function isDropDownVisible()
			{
				return _dropDownListJQuery.is(":visible");
			}
			
			//#endregion 'private' functions
			
			//#region public methods
			
			///<summary>
			///	Updates the combobox with the current selected item.
			///	This function is called if the original Select element selection has been changed
			///</summary>
			_originalElementJQuery.combobox.updateSelection = 
				function()
				{
					setDisplayValue();
				};
				
				_originalElementJQuery.combobox.setVal = 
					function(selValue){
					jQuery("*", _dropDownListJQuery).not("ul").not("span").not("[@dataType='optgroup']").each(
							function()
							{
								var itemJQuery = jQuery(this);
								//container_onItemClick(itemJQuery);
								alert(itemJQuery.text());
							});
					};
				
			///<summary>
			///	The Drop Down List Container will already have been created.
			///	This function recreates the items and binds the events to them.
			///	Thereafter, the current selection is set.
			///</summary>
			_originalElementJQuery.combobox.update =
				function()
				{
					buildDropDownList();
					updateDropDownListWidth();
					bindItemEvents();
					setDisplayValue();
				};
			
			//#endregion public methods
			
			//#region private events
			
			function container_onClick()
			{
				if (_dropDownListJQuery.is(":hidden"))
				{
					toggleDropDownList(true);
				}
				else
				{
					toggleDropDownList(false);
				}
			}
			
			function dropDownListJQuery_onBlur()
			{
				if (_dropDownListJQuery.is(":visible"))
				{
					toggleDropDownList(false);
				}
			}
			
			function container_onItemClick(itemJQuery)
			{
				_originalElementJQuery.val(itemJQuery[0].dataValue);
				
				setDisplayValue();
				
				toggleDropDownList(false);
			}
			
			function container_onItemMouseOver(itemJQuery)
			{
				// An item may be selected from the previous selection and will require
				// to be set to normal.
				// TODO: find a better method of matching _lastItemSelectedJQuery to itemJQuery and optimising the removal
				// of the class, instead of removing it consistently
				toggleItemHighlight(_lastItemSelectedJQuery, false);
				
				toggleItemHighlight(itemJQuery, true);
			}
			
			function container_onItemMouseOut(itemJQuery)
			{
				toggleItemHighlight(itemJQuery, false);
			}
			
			function container_onKeyDown(keyEvent)
			{
				switch (keyEvent.which)
				{
					case 33:
						//Page Up
					case 36:
						//Home
						selectValue(":first");
						break;
					
					case 34:
						//Page Down
					case 35:
						//End
						selectValue(":last");
						break;

					case 37:
						//Left
						selectValue(":previous");
						break;
						
					case 38:
						//Up
						if (keyEvent.altKey)
						{
							// alt-up
							// If DDL is hidden, then it is shown and vice-versa
							toggleDropDownList(!(isDropDownVisible()));
						}
						else
						{
							selectValue(":previous");
						}
						break;

					case 39:
						//Right
						selectValue(":next");
						break;
						
					case 40:
						//Down
						if (keyEvent.altKey)
						{
							// alt-down
							// If DDL is hidden, then it is shown and vice-versa
							toggleDropDownList(!(isDropDownVisible()));
						}
						else
						{
							selectValue(":next");
						}
						break;
						
					case 27:
					case 13:
						// Escape
						toggleDropDownList(false);
						break;

					case 9:
						// Tab
						//TODO: Support alt-tab
						//TODO: Does not truly leave the Combobox if the DropDown is visible
						_dropDownListJQuery.blur();
						
						// This is required in Internet Explorer as the blur() order is different
						$(window)[0].focus();
						
						break;
				}
				
				keyEvent.cancelBubble = true;
			}
			
			//#endregion private events
			
			initialiseControl();
		});
}

jQuery.fn.selectBox = function(options){
	var sourceSelect = jQuery(this);
	var selData;
	var params = {
			url:"sysadmin/querySelDict_dict_item.action",
			state:"",
			code:null,
			order:0,
			clear:"0",
			query:"",
			isDispalyControl:true,
			width: "148px"
			//selValue:"",
			//selText:""
	};

	if (options)
	{
		jQuery.extend(params, options);
		
	}
	sourceSelect.width(params.width);
	if(params.isDispalyControl){
		sourceSelect.hide();
		sourceSelect.combobox(params);
	}else
		sourceSelect.before("<div style='display:none' id='dispalyControl_"+sourceSelect.attr("id")+"'></div>");
	
	if(params.clear=="1"){
		var roptions=sourceSelect.find("option").length;
		  var delid=0;
		  for (var a=0;a<roptions;a++){
			  if (sourceSelect.find("option").eq(a).val()!=''){
			  	sourceSelect.get(0).options.remove(delid);
			  }else
				delid=1;  
		  }
		  if(params.isDispalyControl)
			  sourceSelect.combobox(params);
			else
				sourceSelect.before("<div style='display:none' id='dispalyControl_"+sourceSelect.attr("id")+"'></div>");
	}else{
	
		if(params.code!=undefined && params.code!=null && params.code!=""){
			selData = {dict_code:params.code,query_simplepin:params.query,orderBySib_order:params.order};
		}else{
			selData = {dataxml:sXML};
		}
		if(params.state==undefined || params.state==null || params.state==""){
			$.ajax({
				  type: "POST",
				  url: params.url,
				  async: false,
				  data: selData,
				  dataType:"json",
				  success: function(result){
					  var roptions=sourceSelect.find("option").length;
					  var delid=0;
					  for (var a=0;a<roptions;a++){
						  if (sourceSelect.find("option").eq(a).val()!=''){
						  	sourceSelect.get(0).options.remove(delid);
						  }else
							delid=1;  
					  }
					  var itemLength = result.ldata.length;
					for(var i=0;i<itemLength;i++){
						sourceSelect.get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));
						sourceSelect.find("option:last").attr("item",result.ldata[i].item_id);
					}
					if(params.isDispalyControl)
						sourceSelect.combobox(params);
					else
						sourceSelect.before("<div style='display:none' id='dispalyControl_"+sourceSelect.attr("id")+"'></div>");
				  }
				});
		}else{
			if(params.isDispalyControl)
				sourceSelect.combobox(params);
			else
				sourceSelect.before("<div style='display:none' id='dispalyControl_"+sourceSelect.attr("id")+"'></div>");
		}
	}
		
}

jQuery.fn.setValue = function(selValue,selWidth){
	var sourceSelect = jQuery(this);
	sourceSelect.val(selValue);
	if($("#dispalyControl_"+sourceSelect.attr("id")).length==0)
		sourceSelect.combobox({width:selWidth});
}

jQuery.fn.setText = function(selText,selWidth){
	var sourceSelect = jQuery(this);
	sourceSelect.attr("text",selText);
	sourceSelect.find("option").each(function(){
		if($(this).text()==selText){
			sourceSelect.val($(this).val());
		}
	});
	if($("#dispalyControl_"+sourceSelect.attr("id")).length==0)
		sourceSelect.combobox({width:selWidth});
}

jQuery.fn.setAttr = function(attrName,attrValue){
	var sourceSelect = jQuery(this);
	sourceSelect.attr(attrName,attrValue);
	if($("#dispalyControl_"+sourceSelect.attr("id")).length==0)
		sourceSelect.combobox();
}

jQuery.fn.selectBoxhylb = function(options){
	var sourceSelect = jQuery(this);
	sourceSelect.hide();
	var selData;
	var params = {
			url:"sysadmin/querySelDicthylb_dict_item.action",
			state:"",
			code:null,
			order:0,
			query:"",
			width: "148px"
			//selValue:"",
			//selText:""
	};
	if (options)
	{
		jQuery.extend(params, options);
	}
	
	sourceSelect.width(params.width);
	if(params.code!=undefined && params.code!=null && params.code!=""){
		selData = {dict_code:params.code,query_simplepin:params.query,orderBySib_order:params.order};
	}else{
		selData = {dataxml:sXML};
	}
	if(params.state==undefined || params.state==null || params.state==""){
		$.ajax({
			  type: "POST",
			  url: params.url,
			  async: false,
			  data: selData,
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
				  var roptions=sourceSelect.find("option").length;
				  var delid=0;
				  for (var a=0;a<roptions;a++){
					  if (sourceSelect.find("option").eq(a).val()!=''){
					  	sourceSelect.get(0).options.remove(delid);
					  }else
						delid=1;  
				  }
				  var itemLength = result.ldata.length;
				  var optionHtml = '';
				for(var i=0;i<itemLength;i++){
					optionHtml += '<option value="'+result.ldata[i].fact_value+'">'+result.ldata[i].display_name+'</option>';
					
				}
				if(optionHtml!='')
					sourceSelect.append(jQuery(optionHtml));
				sourceSelect.combobox(params);
			  }
			});
	}else{
		sourceSelect.combobox(params);
	}
	if(sourceSelect.find("option").length<=1){
	    sourceSelect.setAttr("readonly",true);
	}	
}

jQuery.fn.selectBoxDel = function(options){
	var sourceSelect = jQuery(this);
	sourceSelect.hide();
	var selData;
	var params = {
			url:"sysadmin/querySelDictDel_dict_item.action",
			state:"",
			code:null,
			order:0,
			clear:"0",
			delvalue:"0",
			query:"",
			width: "148px"
			//selValue:"",
			//selText:""
	};
	
	if (options)
	{
		jQuery.extend(params, options);
		
	}
	sourceSelect.width(params.width);
	if(params.clear=="1"){
	   sourceSelect.empty(); ///clear as "1" empty select
	   //sourceSelect.append("<option></option>");
	   sourceSelect.get(0).options.add(new Option("",""));
	   sourceSelect.combobox(params);
	   
	}else{
	
		if(params.code!=undefined && params.code!=null && params.code!=""){
			selData = {dict_code:params.code,query_simplepin:params.query,orderBySib_order:params.order,delvalue:params.delvalue};
		}else{
			selData = {dataxml:sXML};
		}
		if(params.state==undefined || params.state==null || params.state==""){
			$.ajax({
				  type: "POST",
				  url: params.url,
				  async: false,
				  data: selData,
				  dataType:"json",
				  timeout:100,
				  success: function(result){
					  var roptions=sourceSelect.find("option").length;
					  var delid=0;
					  for (var a=0;a<roptions;a++){
						  if (sourceSelect.find("option").eq(a).val()!=''){
						  	sourceSelect.get(0).options.remove(delid);
						  }else
							delid=1;  
					  }
					  var itemLength = result.ldata.length;
					for(var i=0;i<itemLength;i++){
						sourceSelect.get(0).options.add(new Option(result.ldata[i].display_name,result.ldata[i].fact_value));
						sourceSelect.find("option:last").attr("item",result.ldata[i].item_id);
					}
					sourceSelect.combobox(params);
				  }
				});
		}else{
			sourceSelect.combobox(params);
		}
	}
		
}

jQuery.fn.selectBoxinhylb = function(options){
	var sourceSelect = jQuery(this);
	sourceSelect.hide();
	var selData;
	var params = {
			url:"sysadmin/querySelDictinhylb_dict_item.action",
			state:"",
			code:null,
			order:0,
			query:"",
			width: "148px"
			//selValue:"",
			//selText:""
	};
	if (options)
	{
		jQuery.extend(params, options);
	}
	
	sourceSelect.width(params.width);
	if(params.code!=undefined && params.code!=null && params.code!=""){
		selData = {dict_code:params.code,query_simplepin:params.query,orderBySib_order:params.order};
	}else{
		selData = {dataxml:sXML};
	}
	if(params.state==undefined || params.state==null || params.state==""){
		$.ajax({
			  type: "POST",
			  url: params.url,
			  async: false,
			  data: selData,
			  dataType:"json",
			  timeout:1000,
			  success: function(result){
				  var roptions=sourceSelect.find("option").length;
				  var delid=0;
				  for (var a=0;a<roptions;a++){
					  if (sourceSelect.find("option").eq(a).val()!=''){
					  	sourceSelect.get(0).options.remove(delid);
					  }else
						delid=1;  
				  }
				  var itemLength = result.ldata.length;
				for(var i=0;i<itemLength;i++){
					if(result.ldata[i].display_name!="")
					sourceSelect.get(0).options.add(new Option(result.ldata[i].display_name,"'"+result.ldata[i].fact_value+"'"));		
					else
					sourceSelect.get(0).options.add(new Option(result.ldata[i].display_name,"'"+result.ldata[i].fact_value+"' "));		
				}
				sourceSelect.combobox(params);
			  }
			});
	}else{
		sourceSelect.combobox(params);
	}
	if(sourceSelect.find("option").length<=1){
	    sourceSelect.setAttr("readonly",true);
	}	
}