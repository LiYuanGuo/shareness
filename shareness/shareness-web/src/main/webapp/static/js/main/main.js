$(function(){
	//初始化主页头部画廊数据
	var page=$("#page").val();
	var html="";
	$.ajax({
		type:'post',
		url:'main/initMain',
		cache:false,
		async:false,
		dataType:'json',
		success:function(datas){
			$.each(datas,function(k,v){
				html +='<li class="headImage"><input type="hidden" id="enjoyId" value="'+v.id+'"><img src="'+v.image+'">';
				html +='<div class="am-slider-desc">'+v.briefContent+'</div></li>';
			});
			
		}
	});
	$("#head_slider").html(html);
	
	$("#head_slider").delegate("li","click",function(){
		var enjoyId=$(this).find("input").val();
		location.href="main/detail?enjoyId="+enjoyId;
	});
	
	//初始化景点数据
	html="";
	$.ajax({
		type:'post',
		url:'site/topSite',
		cache:false,
		async:false,
		dataType:'json',
		success:function(datas){
			$.each(datas,function(k,v){
				html +='<li><div class="am-gallery-item"><a href="main/detail?enjoyId='+v.id+'" class=""><img src="'+v.image+'"alt="'+v.briefContent+'" />';
				html +='<h3 class="am-gallery-title">'+v.briefContent+'</h3><div class="am-gallery-desc">阅读量1000</div>';
				html +='</a></div></li>';
			});
			
		}
		
	})
	$("#sites").html(html);
	
	//控制翻页
	window.onscroll = function ()
	  {
	    if (Math.abs(document.body.clientHeight - document.documentElement.clientHeight) <= (document.documentElement.scrollTop || document.body.scrollTop))
	    {
	        select_query($('#page').val());
	    }
	  }
	
});

//下拉刷新数据
function select_query(page){
  if(page == -1) {
	  return;
  }else{
    $('#page').val(parseInt($('#page').val()) + 1);
    
    $.post(host,{},function(d){
    	data = eval('(' + d + ')');
		 if (data.coupons!=undefined) {
			 oppendRestaurantHmtl(data.coupons);
	         $('#list_news').show();
	      }
          if (data.status==-1) {
            //没有新数据
            $('#page_div').hide();
            $('#pagen').val('-1');
            alertMsg('','全都被你看光了，看看其他的吧...');
          }
	});
    
  }
}