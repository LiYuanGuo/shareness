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
		var playMode=$("#playMode").val();
		var tip=$("#tip").val();
		var shisu=$("#shisu").val();
		var image=$("#image").attr("src");
		if(name==""){
			alert("景点名称不能为空")
			return false;
		}
		if(briefContent==""){
			alert("景点简介不能为空!");
			return false;
		}
		if(detailContent==""){
			alert("景点详细介绍不能为空!");
			return false;
		}
		if(address==""){
			alert("景点地址不能为空!");
			return false;
		}
		if(route==""){
			alert("景点路线不能为空!");
			return false;
		}
		if(image==""){
			alert("请上传景点图片!");
			return false;
		}
		
		var site={};
		site["name"]=name;
		site["image"]=image;
		site["briefContent"]=briefContent;
		site["detailContent"]=detailContent;
		site["ticket"]=ticket;
		site["address"]=address;
		site["route"]=route;
		site["traffic"]=traffic;
		site["playMode"]=playMode;
		site["shisu"]=shisu;
		site["tip"]=tip;
		var siteStr=JSON.stringify(site);
		 $.ajax({
			type: 'post',
		    url: 'addSite',
		    data: {"siteStr":siteStr},
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