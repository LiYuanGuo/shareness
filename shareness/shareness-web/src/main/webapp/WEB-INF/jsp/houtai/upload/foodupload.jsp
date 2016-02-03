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
<meta charset="UTF-8">
<title>foodupload</title>
<link rel="stylesheet" href="../static/assets/css/amazeui.min.css">

<script src="../static/assets/js/jquery.min.js"></script>
<script src="../static/assets/js/amazeui.min.js"></script>
<script src="../static/assets/js/common.js"></script>
<script src="../static/assets/js/jquery.form.js"></script> 
<script src="../static/js/upload/foodupload.js"></script> 
</head>
<body>
	<div class="admin-content">
  <input type="hidden" value="auditing_edit.html" id="filename">
  <div class="am-cf am-padding">
    <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">美食信息</strong> / <small>美食展示</small></div>
  </div>
  <div class="am-g am-cf am-padding" id="edit-confirm">
  <ul class="am-gallery" data-am-gallery="{pureview: 1}">
    <div class="am-form am-u-sm-12">
        <fieldset>
          <input type="hidden" id="id" value="">
          <div class="am-g am-form-group ">
            <label for="r_name" class="am-u-sm-4 am-u-md-2 am-text-center">美食名称：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
              <input type="text" class="am-input-sm" id="name" placeholder="美食名称"  data-foolish-msg="最少四个字符!" required >
            </div>
          </div>
          <div class="am-g am-margin-top am-form-group">
            <label for="alias" class="am-u-sm-4 am-u-md-2 am-text-center">美食简介：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
              <textarea rows="3" cols="30" class="am-input-sm" id="briefContent" placeholder="美食简介" ></textarea>
            </div>
          </div>
          
          <div class="am-g am-margin-top am-form-group">
            <label for="address" class="am-u-sm-4 am-u-md-2 am-text-center">美食详细简绍：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
          
              <textarea rows="4" cols="30" class="am-input-sm" id="detailContent" placeholder="美食详细简绍"></textarea>
            </div>
          </div>
          
          <div class="am-g am-margin-top am-form-group">
            <label for="address" class="am-u-sm-4 am-u-md-2 am-text-center">消费情况：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
              <input type="text" class="am-input-sm" id="consumption" placeholder="消费情况">
            </div>
          </div>
          <div class="am-g am-margin-top am-form-group">
            <label for="address" class="am-u-sm-4 am-u-md-2 am-text-center">美食地址：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
              <input type="text" class="am-input-sm" id="address" placeholder="美食地址">
            </div>
          </div>
          <div class="am-g am-margin-top am-form-group">
            <label for="type_name" class="am-u-sm-4 am-u-md-2 am-text-center">交通方式：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
              <select class="am-input-sm" id="traffic">
              	<option value="1">自驾游</option>
              	<option value="2">公交</option>
              	<option value="3">汽车</option>
              </select>
            </div>
          </div>
          <div class="am-g am-margin-top am-form-group">
            <label for="phone" class="am-u-sm-4 am-u-md-2 am-text-center">路线：</label>
            <div class="am-u-sm-8  am-u-md-8 am-u-end">
              <textarea rows="3" cols="30" class="am-input-sm" id="route" placeholder="路线"></textarea>
            </div>
          </div>
        
          <div class="am-g am-margin-top am-form-group am-form-icon am-form-feedback">
            <label for="business_hours" class="am-u-sm-4 am-u-md-2 am-text-center">提示：</label>
            <div class="am-u-sm-8 am-u-md-8 am-u-end">
              <textarea rows="3" cols="30" class="am-input-sm" id="tip" placeholder="提示"></textarea>
            </div>
          </div>
            
          <div class="am-g am-margin-top am-form-group">
            <label for="license" class="am-u-sm-4 am-u-md-2 am-text-center">美食图片：</label>
            <div class="am-u-sm-8 am-u-md-2 am-list-thumb">
            <img src="" id="image" data-rel style="width:85px;" alt="logo"/>
            </div>
            <div class="am-u-sm-8  am-u-md-2" style="float:left;">
              <form method="post" action="" enctype="multipart/form-data" id="CardidToUpdate">
              <div class="am-form-group am-form-file">
                <input name="token" id="token" type="hidden" value="">
                <input name="file" id="syd-logo" type="file" />
                <input name="x:field" type="hidden" value="shareness-logo">
                <input name="x:up_id" id="up_id" type="hidden" value="">
                <button type="button" id="uploadBtn"  class="am-btn am-btn-sm am-btn-default" style="width:100%">
                <i class="am-icon-cloud-upload"></i> 点击上传图片</button>
                <div id="logo_pd_bar" class="am-text-sm  am-progress-striped am-progress-sm am-active" >
                  <div class="am-progress-bar am-progress-bar-secondary" id="logo_pd_bar_1" style="width: 0%;"></div>
                </div>
              </div>
              </form>
            </div>
          </div>
  		</fieldset>
          <div class="am-margin">
            <div class="am-g am-margin-top am-form-group">
              <div class="am-u-sm-6 am-u-md-5 am-u-end am-text-center" >
                <button type="button" class="am-btn am-btn-primary am-btn-xs"  id="subButton">提交保存</button>
              </div>
            </div>            
          </div>
    </div>
  </ul>
  </div>
</div>
	
</body>
</html>