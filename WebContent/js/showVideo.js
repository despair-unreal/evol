$(document).ready(function(){
	$("#videoShow").click(function(){
		//var path = $("#videoShow").prev().val();
		$("#tdShow").show();
		$("#tdShow table tr:eq(0) td:eq(0)").show();
		$("#tdShow table tr:eq(1) td:eq(0)").show();
		if($("#tdShow table tr:eq(0) td").length<1){
			$("#tdShow video").removeClass("maxWidth");
			$("#tdShow img").removeClass("maxWidth");
		}
	});
	
	$(".cardShow").click(function(){
		$("#tdShow").show();
		if($(".cardShow").length==1){
			var path = $(".cardShow").prev().val();
			$("#tdShow img:eq(1)").show();
			$("#tdShow img:eq(0)").prop("src",path);
			$("#tdShow img:eq(0)").on('load', function(){
				$("#tdShow img:eq(1)").hide();
				$("#tdShow img:eq(0)").show();
			});
			$("#tdShow table tr:eq(0) td:eq(1)").show();
			$("#tdShow table tr:eq(1) td:eq(1)").show();
		}else{
			if($(".cardShow").index(this)!=1){
				var path = $(this).prev().val();
				$("#tdShow .imgshow").eq(0).next().show();
				$("#tdShow .imgshow").eq(0).prop("src",path);
				$("#tdShow .imgshow").eq(0).on('load', function(){
					$("#tdShow .imgshow").eq(0).next().hide();
					$("#tdShow .imgshow").eq(0).show();
				});
				$("#tdShow table tr:eq(0) td:eq(0)").show();
				$("#tdShow table tr:eq(1) td:eq(0)").show();
			}else{
				var path = $(this).prev().val();
				$("#tdShow .imgshow").eq(1).next().show();
				$("#tdShow .imgshow").eq(1).prop("src",path);
				$("#tdShow .imgshow").eq(1).on('load', function(){
					$("#tdShow .imgshow").eq(1).next().hide();
					$("#tdShow .imgshow").eq(1).show();
				});
				$("#tdShow table tr:eq(0) td:eq(1)").show();
				$("#tdShow table tr:eq(1) td:eq(1)").show();
			}
		}
	});
	$("#tdShow video").addClass("maxWidth");
	$("#tdShow img").addClass("maxWidth");
});
function showVideo(){
	var path = document.getElementById("videoShow").previousElementSibling.value;
	document.getElementById("showVideo").src=path;
	document.getElementById("showVideo").play();
}