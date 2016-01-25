<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>shareness-detail</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="static/assets/css/amazeui.min.css">
<link rel="stylesheet" href="static/css/site/siteDetail.css">
<script src="static/assets/js/jquery.min.js"></script>
<script src="static/assets/js/amazeui.min.js"></script>
<script src="static/assets/js/common.js"></script>
<script type="text/javascript">
	var siteId='${siteId}';
</script>
<script src="static/js/site/site.js"></script>
</head>
<body>
	<div class="content">
      <img class="imageClass" id="img" >
      <p id="name"></p>
      <p><strong>介绍:</strong><span id="detailContent"></span></p>
      <p ><strong>门票:</strong><span id="ticket"></span></p>
      <p ><strong>地址:</strong><span id="address"></span></p>
      <p ><strong>自驾线路:</strong><span id="route"></span></p>
      <p ><strong>游玩方式:</strong><span id="playMode"></span></p>
      <p ><strong>提示:</strong><span id="tip"></span></p>
      <p ><strong>食宿问题:</strong><span id="shisu"></span></p>
    </div>
</body>
</html>