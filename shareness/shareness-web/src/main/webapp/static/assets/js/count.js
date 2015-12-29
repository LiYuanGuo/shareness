$(function(){
	var equipment=detectOS();
	var visitTime=new Date();//.Format("yyyy-MM-dd HH:mm:ss")
	var path=window.location.href;
	var url="visit/save";
	/*if(path.indexOf("homepage")>0){
		url="visit/save";
	}else if(path.indexOf("seeQuestionnaire")>0||path.indexOf("591syd")>0){
		url="visit/save";
	}else{
		url="./visit/save";
	}*/
	
	window.onbeforeunload = onbeforeunload_handler;  
    function onbeforeunload_handler(){  
    	/*var pathStr=path.substring(8,path.length());
    	var sum=0;
    	var i=0;
    	for(i=0;i<pathStr.length;i++){
    		if(pathStr.charAt(i)=="/"){
    			sum=sum+1;
    		}
    	}
    	var url="/visit/save";
    	for(i=0;i<sum;i++){
    		url="."+url;
    	}*/
    	
        var leaveTime=new Date();
        var visitNum={};
        visitNum["equipment"]=equipment;
        visitNum["visitTime"]=visitTime;
        visitNum["path"]=path;
        visitNum["leaveTime"]=leaveTime;
        var visitNumStr=JSON.stringify(visitNum);
        $.ajax({
        	type:"post",
        	async:false,
        	url:url,
        	data:{"visitNumStr":visitNumStr},
        	success:function(){
        		
        	}
        });
       /* $.post("visit/save",{"visitNumStr":visitNumStr},function(){
        	
        });*/
      /* return warning;*/
    }
	/*function onunload_handler(){
	    var warning="谢谢光临";
	    var leaveTime=new Date();
        var visitNum={};
        visitNum["equipment"]=equipment;
        visitNum["visitTime"]=visitTime;
        visitNum["path"]=path;
        visitNum["leaveTime"]=leaveTime;
        var visitNumStr=JSON.stringify(visitNum);
        $.post("visit/save",{"visitNumStr":visitNumStr},function(){
        	
        });
	    alert(warning);
	    }*/
	
	
});


//获取访问设备
function detectOS() { 
var sUserAgent = navigator.userAgent; 

var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows"); 
var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel"); 
if (isMac) return "Mac"; 
var isUnix = (navigator.platform == "X11") && !isWin && !isMac; 
if (isUnix) return "Unix"; 
var isLinux = (String(navigator.platform).indexOf("Linux") > -1); 

var bIsAndroid = sUserAgent.toLowerCase().match(/android/i) == "android";
if (isLinux) {
if(bIsAndroid) return "Android";
else return "Linux"; 
}
if (isWin) { 
var isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1; 
if (isWin2K) return "Win2000"; 
var isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || 
sUserAgent.indexOf("Windows XP") > -1; 
if (isWinXP) return "WinXP"; 
var isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1; 
if (isWin2003) return "Win2003"; 
var isWinVista= sUserAgent.indexOf("Windows NT 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1; 
if (isWinVista) return "WinVista"; 
var isWin7 = sUserAgent.indexOf("Windows NT 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1; 
if (isWin7) return "Win7"; 
} 
return "other"; 
} 
