
//处理加分
$(function(){
	var shareId;
	var code;
	var path=location.href;
	//获取原始地址
	var pathArray=[];
	pathArray=path.split("?");
	var paramArray=[];
	paramArray=pathArray[1].split("&");
	var param="";
	for(var i=0;i<paramArray.length;i++){
		if(-1==paramArray[i].indexOf("shareId")&&-1==paramArray[i].indexOf("code")){
			param=param+"&"+paramArray[i];
		}
		if(-1!=paramArray[i].indexOf("shareId")){
			shareId=paramArray[i].split("=")[1];
		}
		if(-1!=paramArray[i].indexOf("code")){
			code=paramArray[i].split("=")[1];
		}
		
	}
	param=param.substring(1,param.length);
	//原始地址
	var oldUrl=pathArray[0]+"?"+param;
	//加分
	if(shareId!=null){
		//把shareid写到cookie
		addCookie("shareId",shareId,24);
		var share={};
		share["shareId"]=shareId;
		share["code"]=code;
	    share["path"]=oldUrl;
	    var shareStr=JSON.stringify(share);
		 $.ajax({
	     	type:"post",
	     	async:false,
	     	url:"share/addIntegral",
	     	data:{"shareStr":shareStr},
	     	success:function(){
	     		
	     	}
	     });
	}
	
});
