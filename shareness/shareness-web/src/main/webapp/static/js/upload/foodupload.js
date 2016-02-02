$(function(){
	//获取上传图片的token
	get_token_ajax();
	//上传图片到七牛
	 $('#uploadBtn').click(function () {
    $('#logo_pd_bar').show();
    $('#logo_pd_bar_1').html('上传中.....');
    $('#logo_pd_bar_1').width('0%');
    $('#CardidToUpdate').ajaxSubmit({
      url: 'http://upload.qiniu.com/',
      type: 'post',
      async: false,
      semantic: false,
      success: function (data) {
        console.log(data);
        if (data.key!=null) {
          $('#image').attr('src', 'http://7xqmgd.com1.z0.glb.clouddn.com/' + data.key+"-share.338.191");
          $('#image').attr('data-rel', 'http://7xqmgd.com1.z0.glb.clouddn.com/' + data.key);
          $('#logo_pd_bar_1').width('100%');
          $('#logo_pd_bar_1').height('20px');
          $('#logo_pd_bar_1').html('上传完成');
          $('#logo_pd_bar').removeClass('am-progress-striped');
          $('.am-gallery').pureview(); 
        };
      },
    });
   });
	
	 //提交景点信息
	 $("#subButton").click(function(){
		var name=$("#name").val();
		var briefContent=$("#briefContent").val();
		var detailContent=$("#detailContent").val();
		var ticket=$("#ticket").val();
		var address=$("#address").val();
		var route=$("#route").val();
		var traffic=$("#traffic").val();
		var tip=$("#tip").val();
		var image=$("#image").attr("src");
		var consumption=$("#consumption").val();
		if(name==""){
			alert("美食名称不能为空")
			return false;
		}
		if(briefContent==""){
			alert("美食简介不能为空!");
			return false;
		}
		if(detailContent==""){
			alert("美食详细介绍不能为空!");
			return false;
		}
		if(address==""){
			alert("美食地址不能为空!");
			return false;
		}
		if(route==""){
			alert("路线不能为空!");
			return false;
		}
		if(image==""){
			alert("请上传美食图片!");
			return false;
		}
		
		var food={};
		food["name"]=name;
		food["image"]=image;
		food["briefContent"]=briefContent;
		food["detailContent"]=detailContent;
		food["ticket"]=ticket;
		food["address"]=address;
		food["route"]=route;
		food["traffic"]=traffic;
		food["consumption"]=consumption;
		food["tip"]=tip;
		var foodStr=JSON.stringify(food);
		 $.ajax({
			type: 'post',
		    url: 'addFood',
		    data: {"foodStr":foodStr},
		    cache: false,
		    async: false,
		    dataType: 'json',
		    success: function (data) {
		    	if(data.status==1){
		    		alert(data.msg);
		    		location.href=location.href;
		    	}else{
		    		alert(data.msg);
		    	}
		    }
		 });
	 });
	 
})

function get_token_ajax()
{
  $.ajax({
    type: 'post',
    url: '../qiniu/getToken',
    data: '',
    cache: false,
    async: true,
    dataType: 'json',
    error: function (data) {
      console.log('取文件上传参数出错！');
    },
    success: function (data) {
      if (data.uptoken !== '') {
        $('input').each(function () {
          $('input#token').val(data.uptoken);
        });
      } else {
        console.log(data);
      }
    }
  });
};