
	function WriteOffline(PlaceName,PlaceID){
		document.getElementById('ctlICCard').ConnJava=content_connJava;
		document.getElementById('ctlICCard').DeviceType=content_deviceType;//河南设备
		document.getElementById('ctlICCard').WriteOffline(PlaceName,PlaceID,content_urls,content_yzdz);
		
	}
	//字典下载更新方法
	function dictUpdate(url){
		document.getElementById('DictUpdate').ConnJava=2;
		document.getElementById('DictUpdate').DictUpdate(content_urls+content_yzdz_org);
	}