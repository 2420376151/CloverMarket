$(function() {
	// ////开始
	var flag=0;
	$(".go").click(function() {
		if(flag==0){
			flag=1;
			$.ajax({
				type : "post",
				url : "go",
				success : function(data) {
					//data:{"list":[{},{},{},{}]}
					var arr=data.list;
					var str="";
					var info=$(".info");
					for(var i=0;i<arr.length;i++){
						str+=arr[i].pid+" "+arr[i].pname+" "+arr[i].detail+" "+arr[i].price+"<br/>"
					}
					info.html(str);

				}
			});
		}else if(flag==1){
			flag=0;
			$(".info").html(" ");
		}
		

		// /////click
	});

	// /////结束/////
});