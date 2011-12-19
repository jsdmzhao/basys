/*
 * filename: common.js 一些共有的JS组件或者属性
 * 
 */

/** 文档区域高度 */
document_height = Ext.getDoc().getHeight();

/**
 * 通过结构化的JSON对象返回，FORM提交用的对象
 * */
function buildSubmitParam(subpa, para, prefix) {

	for (key in para) {
		if (typeof para[key] == "object") {
			if (prefix)
				prefix = prefix + key + '.';
			else
				prefix = key + '.';
			subpa = buildSubmitParam(subpa, para[key], prefix);
			prefix = null;
		} else {
			if (prefix == null)
				subpa[key] = para[key];
			else
				subpa[prefix + key] = para[key];
		}
	}
	return subpa;
}
