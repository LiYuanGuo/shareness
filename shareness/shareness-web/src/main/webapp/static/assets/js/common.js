
/*
* Funciton: 各个页面均要是用的共有函数
* Author:tanmao
* Date:2015.04.27
*
* depends:
*        jQuery.js
*
* CopyRight:591syd.com
*
*
*/

/**
*常量，全局使用
*
*/
var const_sydCouponRest = "syd-coupon-rest";

//添加cookie
//不设定过期时间，浏览器关闭时cookie自动消失
function addCookie(objName,objValue,objHours){
    var str = objName + "=" + escape(objValue);

    if(objHours > 0){
        var date = new Date();
        var ms = objHours*3600*1000;
        date.setTime(date.getTime() + ms);
        str += "; expires=" + date.toGMTString()+";path=/";
   }
   document.cookie = str;
}
 
  
//两个参数，一个是cookie的名子，一个是值
//此 cookie 将被保存 30 天
function setCookie30Days(name,value)
{
  var Days = 30; //此 cookie 将被保存 30 天
  var exp = new Date();    //new Date("December 31, 9998");
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
}

function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
    if(arr=document.cookie.match(reg))
		return unescape(arr[2]);
    else
    	return null;
}

function delCookie(name)//删除cookie
{
  var exp = new Date();
  exp.setTime(-1);
  var cval=getCookie(name);
  if(cval!= undefined) 
  	document.cookie= name + "=''"+";expires="+exp.toGMTString()+";path=/";

  return cval;
}

/*删除指定路径下的cookie*/
function delCookie(name,path)//删除cookie
{
  var exp = new Date();
  exp.setTime(-1);
  var cval=getCookie(name);
  if(cval!= undefined) 
    document.cookie= name + "=''"+";expires="+exp.toGMTString()+"; path=" + path;

  return cval;
}


//获取主机地址
function getHostPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	return curWwwPath.substring(0,pos);
}

//获取当前项目地址
function getRootPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return (localhostPaht+projectName);
}

//对Date的扩展，将 Date 转化为指定格式的String 
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) 
{ //author: meizz 
  var o = { 
    "M+" : this.getMonth()+1,                 //月份 
    "d+" : this.getDate(),                    //日 
    "h+" : this.getHours(),                   //小时 
    "m+" : this.getMinutes(),                 //分 
    "s+" : this.getSeconds(),                 //秒 
    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
    "S"  : this.getMilliseconds()             //毫秒 
  }; 
  if(/(y+)/.test(fmt)) 
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  for(var k in o) 
    if(new RegExp("("+ k +")").test(fmt)) 
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
  return fmt; 
}

//解析url 获取指定参数
function getParameter(param)
{
  var query = window.location.search; //获取URL地址中？后的所有字符  
  var iLen = param.length; //获取你的参数名称长度  
  var iStart = query.indexOf(param); //获取你该参数名称的其实索引  
  if (iStart == - 1) //-1为没有该参数  
  return '';
  iStart += iLen + 1;
  var iEnd = query.indexOf('&', iStart); //获取第二个参数的其实索引  
  if (iEnd == - 1) //只有一个参数  
  return query.substring(iStart); //获取单个参数的参数值  
  return query.substring(iStart, iEnd); //获取第二个参数的值  
}
