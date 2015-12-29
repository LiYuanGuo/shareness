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
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="stylesheet" href="static/assets/css/amazeui.min.css">
<link rel="stylesheet" href="static/css/main/main.css">

<script src="static/assets/js/jquery.min.js"></script>
<script src="static/assets/js/amazeui.min.js"></script>
<script src="static/assets/js/common.js"></script>
<script src="static/js/main/main.js"></script>
</head>
<body>
	<input type="hidden" id="page" value="1">
	<header data-am-widget="header" class="am-header am-header-default">
	<div class="am-header-left am-header-nav"></div>
	<h1 class="am-header-title">shareness</h1>
	<!-- <div class="am-header-right am-header-nav">
		<ul class="am-nav am-nav-tabs">
			<li class="am-dropdown" data-am-dropdown><a
				class="am-dropdown-toggle" data-am-dropdown-toggle
				href="javascript:;"> <span class="am-icon-bars"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a href="#">
							<div class="am-g">
								<div class="am-u-sm-4 am-panel-title">
									<span class="am-icon-user"> </span>
								</div>
								<div class="am-u-sm-8 am-panel-title" id="my">个人中心</div>
							</div>
					</a></li>

				</ul></li>
		</ul>
	</div> --> </header>
	<div data-am-widget="slider" class="am-slider am-slider-c2"
		data-am-slider='{"directionNav":false}'>
		<ul class="am-slides" id="head_slider">
			<li><img src="http://s.amazeui.org/media/i/demos/bing-1.jpg">
				<div class="am-slider-desc">远方 有一个地方 那里种有我们的梦想</div></li>
			<li><img src="http://s.amazeui.org/media/i/demos/bing-2.jpg">
				<div class="am-slider-desc">某天 也许会相遇 相遇在这个好地方</div></li>
			<li><img src="http://s.amazeui.org/media/i/demos/bing-3.jpg">
				<div class="am-slider-desc">不要太担心 只因为我相信 终会走过这条遥远的道路</div></li>
			<li><img src="http://s.amazeui.org/media/i/demos/bing-4.jpg">
				<div class="am-slider-desc">OH PARA PARADISE 是否那么重要 你是否那么地遥远</div></li>
		</ul>
	</div>

	<div>
		<ul data-am-widget="gallery"
			class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-imgbordered"
			data-am-gallery="{  }">
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-1.jpg"
						alt="远方 有一个地方 那里种有我们的梦想" />
						<h3 class="am-gallery-title">远方 有一个地方 那里种有我们的梦想</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-2.jpg"
						alt="某天 也许会相遇 相遇在这个好地方" />
						<h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-3.jpg"
						alt="不要太担心 只因为我相信" />
						<h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-4.jpg"
						alt="终会走过这条遥远的道路" />
						<h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
		</ul>
		<ul data-am-widget="gallery"
			class="am-gallery am-avg-sm-2 am-avg-md-3 am-avg-lg-4 am-gallery-imgbordered"
			data-am-gallery="{  }">
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-1.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-1.jpg"
						alt="远方 有一个地方 那里种有我们的梦想" />
						<h3 class="am-gallery-title">远方 有一个地方 那里种有我们的梦想</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-2.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-2.jpg"
						alt="某天 也许会相遇 相遇在这个好地方" />
						<h3 class="am-gallery-title">某天 也许会相遇 相遇在这个好地方</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-3.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-3.jpg"
						alt="不要太担心 只因为我相信" />
						<h3 class="am-gallery-title">不要太担心 只因为我相信</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
			<li>
				<div class="am-gallery-item">
					<a href="http://s.amazeui.org/media/i/demos/bing-4.jpg" class="">
						<img src="http://s.amazeui.org/media/i/demos/bing-4.jpg"
						alt="终会走过这条遥远的道路" />
						<h3 class="am-gallery-title">终会走过这条遥远的道路</h3>
						<div class="am-gallery-desc">2375-09-26</div>
					</a>
				</div>
			</li>
		</ul>
	</div>

	<!-- 下拉滑动加载 -->
	<div class="see-more" id="page_div" style="background-color: #fff">

		<a id="page" style="margin-left: 32%;"><span
			class="am-icon-refresh"></span>滑动查看更多优惠券信息</a>
		<!-- <div id="loading" style="text-align:center; display:none;">
   			 <img src="../resource/images/loading.gif" style="width:20px; height:20px;">
    		<a>正在网上努力蹦跑,马上就好...</a>
    		</div> -->
	</div>

	<!-- 弹框 -->
	<div id="alert" class="am-modal am-modal-alert" tabindex="-1">
		<div class="am-modal-dialog">
			<div class="am-modal-hd" id="alert-title"></div>
			<div class="am-modal-bd" id="alert-msg">Hello world！</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn">确定</span>
			</div>
		</div>
	</div>
</body>
</html>