$(function(){
	$("#yijian").click(function(){
		var oldPerson_1=$("#text-75").text();
		var oldPerson_2=$("#text-76").text();
		var person_1=$("#xiaoming").val();
		var person_2=$("#xiaohong").val();
		
		for(var i=1;i<=77;i++){
			var textString=$("#text-"+i).text();
			if(textString.indexOf(oldPerson_1)>0){
				textString=textString.replace(oldPerson_1,person_1);
			}
			if(textString.indexOf(oldPerson_2)>0){
				textString=textString.replace(oldPerson_2,person_2);
			}
			$("#text-"+i).text(textString);
		}
		});
});