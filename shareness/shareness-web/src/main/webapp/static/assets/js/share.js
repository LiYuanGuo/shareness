
//分享js
function shareInfo(shareType){
	var shareId=getCookie("userid");
	var code=getRnd(5);
	var path=location.href;
	var lastShareId;
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
			lastShareId=paramArray[i].split("=")[1];
		}
	}
	param=param.substring(1,param.length);
	//原始地址
	var oldUrl=pathArray[0]+"?"+param;
	//新的要分享出去的地址
	var newUrl=oldUrl+"&"+"shareId="+shareId+"&code="+code;
	
	//userid不为空才保存到数据库
	if(shareId!=null&&shareId!=lastShareId){
		var share={};
		share["shareId"]=shareId;
		share["code"]=code;
	    share["path"]=oldUrl;
	    var shareTime=new Date();
	    share["shareTime"]=shareTime;
	    share["destination"]=shareType;
	    share["lastShareId"]=lastShareId;
	    var shareStr=JSON.stringify(share);
		 $.ajax({
	     	type:"post",
	     	async:false,
	     	url:"share/save",
	     	data:{"shareStr":shareStr},
	     	success:function(){
	     		
	     	}
	     });
	}
	
	if(shareType==1){
		//qq分享
		//1动态加载各类分享的js代码 同步加载
		AjaxPage( "scrA", "http://connect.qq.com/widget/loader/loader.js" );
		//2封装分享的内容
		var p = {
				url:newUrl, /*获取URL，可加上来自分享到QQ标识，方便统计*/
				/*desc:content, *//*分享理由(风格应模拟用户对话),支持多分享语随机展现（使用|分隔）*/
				title:title, /*分享标题(可选)*/
				summary:content, /*分享摘要(可选)*/
				pics:imgs[0], /*分享图片(可选)*/
				flash: '', /*视频地址(可选)*/
				site:'分享自 @随意点', /*分享来源(可选) 如：QQ分享*/
				style:'202',
				width:32,
				height:32
				};
				var s = [];
				for(var i in p){
				s.push(i + '=' + encodeURIComponent(p[i]||''));
				}
				window.open("http://connect.qq.com/widget/shareqq/index.html?"+s.join('&'));
				
	}else if(shareType==2){
		//腾讯微博分享
		var p = {
				url:newUrl, 
				title:'['+title+']'+content, 
				pics:imgs[0], 
				site:'分享自 @随意点', 
				};
				var s = [];
				for(var i in p){
				s.push(i + '=' + encodeURIComponent(p[i]||''));
				}
				window.open("http://share.v.t.qq.com/index.php?c=share&a=index&"+s.join('&'));
	}else if(shareType==3){
		//新浪微博分享
		var param = {
			    url:newUrl ,
			    appkey:'3772474479',
			    title:'['+title+']'+content,
			    pic:imgs[0],
			    ralateUid:'5462259235',
			    rnd:new Date().valueOf()
			  }
			  var temp = [];
			  for( var p in param ){
			    temp.push(p + '=' + encodeURIComponent( param[p] || '' ) )
			  }
			  window.open("http://v.t.sina.com.cn/share/share.php?"+temp.join('&'));
	}else if(shareType==4){
		//qq空间分享
		//1动态加载各类分享的js代码 同步加载
		AjaxPage( "scrA", "http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" );
		//2封装分享的内容
		var p = {
				url:newUrl,
				showcount:'1',/*是否显示分享总数,显示：'1'，不显示：'0' */
				desc:'',/*默认分享理由(可选)*/
				summary:content,/*分享摘要(可选)*/
				title:title,/*分享标题(可选)*/
				site:'分享自 @随意点',/*分享来源 如：腾讯网(可选)*/
				pics:imgs[0], /*分享图片的路径(可选)*/
				/*style:'203',
				width:98,
				height:22*/
				};
				var s = [];
				for(var i in p){
				s.push(i + '=' + encodeURIComponent(p[i]||''));
				}
				window.open("http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?"+s.join('&'));
	}
	
	
}

//动态加载js的三个相关方法

function GetHttpRequest() 

{ 

    if ( window.XMLHttpRequest ) // Gecko 

        return new XMLHttpRequest() ; 

    else if ( window.ActiveXObject ) // IE 

        return new ActiveXObject("MsXml2.XmlHttp") ; 

} 


function AjaxPage(sId, url){ 

    var oXmlHttp = GetHttpRequest() ; 



    oXmlHttp.OnReadyStateChange = function()  

    { 

        if ( oXmlHttp.readyState == 4 ) 

        { 

            if ( oXmlHttp.status == 200 || oXmlHttp.status == 304 ) 

            { 

                IncludeJS( sId, url, oXmlHttp.responseText ); 

            } 

            else 

            { 

                alert( 'XML request error: ' + oXmlHttp.statusText + ' (' + oXmlHttp.status + ')' ) ; 

            } 

        } 

    } 



    oXmlHttp.open('GET', url, true); 

    oXmlHttp.send(null); 

} 



function IncludeJS(sId, fileUrl, source) 

{ 

    if ( ( source != null ) && ( !document.getElementById( sId ) ) ){ 

        var oHead = document.getElementsByTagName('HEAD').item(0); 

        var oScript = document.createElement( "script" ); 



        oScript.language = "javascript"; 

        oScript.type = "text/javascript"; 

        oScript.id = sId; 

        oScript.defer = true; 

        oScript.text = source; 



        oHead.appendChild( oScript ); 

    } 

} 

//获取指定位数的随机数
function getRnd(v) {
    var s = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"];
    var r = "";
    for (var i = 0; i < v; i++) {
        r += s[parseInt(61 * Math.random())];
    }
    return r;
}
