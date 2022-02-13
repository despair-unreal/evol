$(window).on('load', function() {
	$("#loading").fadeOut();
});
$(document).ready(function() {
	$("#onloadcontent").show();

	//加载图
	var loadingTop = ($(window).height() - $("#loading img").height()) / 2;
	var loadingLeft = ($(window).width() - $("#loading img").width()) / 2;
	$("#loading img").css("margin-left", loadingLeft);
	$("#loading img").css("margin-top", loadingTop);

	//设置导航栏各部分高度，跟logo等高  垂直居中
	var musicTag = "<audio autoplay='true' id='musicPlay' src='img/倾色浮影.mp3' loop ></audio>";
	$("body").after("<style type='text/css'>nav ul li .active:after{bottom: -15px;}</style>");
	$("#music img").click(function() {
		if ($("#music audio").length > 0) {
			$(this).prop("src", "img/musicNone.png");
			$("#music audio").remove();
		} else {
			$(this).prop("src", "img/musicPlay.png");
			$("#music").append(musicTag);
		}
	});

	//$("nav ul>div:eq(1)").trigger('click'); 

	//导航栏选中
	$("nav ul>div").click(function() {
		//切换内容页
		var clickIndex = $("nav ul>div").index(this);
		//修改样式
		let clickReturn = ()=>{
			$("nav ul li>div").removeClass("active");
			$(this).children().children().addClass("active");
			$(".content").hide();
			$(".content:eq(" + clickIndex + ")").show();

			if (clickIndex != 0) {
				$("nav").css("background-color", 'rgba(255,255,255,0.96)');
				$("nav li>div").css("color", "#96959D");
				$(this).children().children().css("color", "#7B9CE3");
			} else{
				$("nav").css("background-color", 'rgba(0,0,0,0.5)');
				$("nav li>div").css("color", "#ebebeb");
				$(this).children().children().css("color", "#7B9CE3");
			}
		}
		if (clickIndex != 5){
			clickReturn();
			clickIndex == 0;
			clickReturn();
		}
		$("#story-world-bg img:eq(1)").stop();

		

		if (clickIndex != 2) {
			$("#newsTable").show();
			$("#news_detail").hide();
			$("footer").css("top", $(".content:eq(1)").height() - $("#logo").height());
			$("#onloadcontent").height($(".content:eq(1)").height() + $("footer").height());
		}

		if (clickIndex == 2) {
			moonMove();
		} else {
			$("#story-world-bg img:eq(1)").css({
				"left": 0,
				"top": moonTopBefore
			});
		}
		if (clickIndex != 3) {
			$(".roleImg").css("filter", "brightness(70%)");
			$(".roleImg").removeClass("focus");
			var roleImgRight = 56.925;
			$(".roleImg:not(:last-child)").css("margin-right", roleImgRight);
			var roleLineImgRight = roleImgRight + $(".roleImg").width() - $("#roleLine img").width();
			$("#roleLine img").css("margin-right", roleLineImgRight);
			var roleLeft = ($(window).width() - $("#role").width()) / 2;
			$("#role").css("margin-left", roleLeft);
			var roleLineLeft = roleLeft - $("#roleLine img").width() / 2 + $(".roleImg").width() +
				roleImgRight / 2;
			$("#roleLine").css("left", roleLineLeft);
			$("#roleDetail").hide();
			$("#cg").css("opacity", 0);
			$("#cg").hide();
			$("#lihui").css("opacity", 0);
			$("#lihuiRole").css("opacity", 0);
		}
		$("#onloadcontent").height($(".content:eq(" + clickIndex + ")").height() + $("footer")
			.height());
		$("footer").css("top", $(".content:eq(" + clickIndex + ")").height() - $("#logo").height());
		
	});

	//首页 下载框部位高度调整 居中
	$("#line").height($("#download").height());

	//侧边栏
	//console.log(73.53/$(window).width()); 
	$(".asideMsg img").height(73.53 * 0.5);
	$(".asideMsg img").width($(".asideMsg img").height());
	$(".asideMsg").width($("aside").width());
	var asideMsgImgLeft = ($(".asideMsg").width() - $(".asideMsg img").width()) / 2;
	$(".asideMsg img").css("margin-left", asideMsgImgLeft + 3);
	$("#asideButton").height($(".asideMsg").height() * 0.67);
	$("#asideButton").width($("#asideButton").height() * 0.5);
	$("#asideButton").css("border-radius", $("#asideButton").width() + "px 0 0 " + $("#asideButton").width() +
		"px");
	$("aside").css("top", $("#logo").height() * 2 + 10);
	$("#asideButton").css("right", $("aside").width());
	var asideButtonTop = ($("aside").height() - $("#asideButton").height()) / 2;
	$("#asideButton").css("top", asideButtonTop);
	$(".line2").width($("aside").width());
	//按钮缩回
	$("#asideButton").click(function() {
		if ($("aside").css("right") == "0px") {
			$("aside").animate({
				right: -$("aside").width()
			}, 800);
			$("#asideButton").css("background-image", "url('img/asideBtn1.png')");
			$("#asideButton").css("background-position", "center center");
		} else {
			$("aside").animate({
				right: 0
			}, 800);
			$("#asideButton").css("background-image", "url('img/asideBtn2.png')");
			$("#asideButton").css("background-position", "center right");
		}
	});
	$(".asideMsg:eq(0)").hover(function() {
		$("#wx").show();
	}, function() {
		$("#wx").hide();
	});
	$(".asideMsg:eq(2)").hover(function() {
		$("#qq").show();
	}, function() {
		$("#qq").hide();
	});

	//故事背景 中间文字图片 居中
	var textBottomWindow = ($(window).height() - $("#story-world-bg img:eq(0)").height() - $("#logo")
		.height()) / 4;
	var moonTopBefore = -$("#story-world-bg img:eq(0)").height() + textBottomWindow + ($(
			"#story-world-bg img:eq(0)").height() /
		2);

	function moonMove() {
		$("#story-world-bg img:eq(1)").animate({
			left: 430.9,
			top: -656.2
		}, 4500);
	}

	//放光圆圈
	//计算比例alert(652/830)
	var cirHeight = 515.4727710843374;
	var cirTop = 189.682;
	var cirLeft = 501.264;

	//名词解释
	var boxShadow = "0px 0px 120px #a5a8ec"; //#bb2c3d
	function cirAnimate(index) {
		setTimeout(function() {
			$(".cir:eq(" + index + ")").addClass("cirBoxShadow");
			$(".cir:eq(" + index + ")").css("box-shadow", boxShadow);
		}, 200)
		$(".cir:eq(" + index + ")").animate({
			width: $(".cir:eq(" + index + ")").width() * 2.5,
			height: $(".cir:eq(" + index + ")").height() * 2.5,
			top: cirTop - $(".cir:eq(" + index + ")").height() * 1.5 * 0.5,
			left: cirLeft - $(".cir:eq(" + index + ")").width() * 1.5 * 0.5,
			opacity: 0
		}, 5000, function() {
			$(".cir:eq(" + index + ")").removeClass("cirBoxShadow");
			$(this).height(cirHeight);
			$(this).width(cirHeight);
			$(this).css("top", cirTop);
			$(this).css("left", cirLeft);
			$(this).css("box-shadow", "none");
			$(this).css("opacity", 1);
			cirAnimate(index);
		});
	}
	setTimeout(cirAnimate(0), 0);
	setTimeout(function() {
		cirAnimate(1);
	}, 2000);
	setTimeout(function() {
		cirAnimate(2);
	}, 6000);

	//标题 
	//比例 alert(76.69/$(window).width())
	var storyTitleHeight = 0.05052042160737813 * $(window).width();
	$(".story_title img").css("height", storyTitleHeight);
	var storyTitleTop = $("#logo").height();
	$(".story_title").css("top", storyTitleTop + 10);
	//比例 alert(205.562/$(window).width())
	var storyTitleLeft = 0.13541633728590252 * $(window).width();
	$(".story_title").css("left", storyTitleLeft);
	//alert(23.7188/$(window).width())
	var storyTitleBottom = 0.01562503293807642 * $(window).width();

	//闪光圈
	function bgCir(index) {
		$("#bg-cir img:eq(" + index + ")").animate({
				opacity: 1
			}, 1500,
			function() {
				$(this).animate({
					opacity: 0
				}, 1500);
				bgCir(index);
			});
	}
	setTimeout(bgCir(0), 0);
	setTimeout(function() {
		bgCir(1);
	}, 500);


	$("#story-secondary").height(130.45);
	$("#story-secondary").width(130.45);
	var storySecondaryTop = $(window).height() - $("#story-secondary").height() / 2;
	$("#story-secondary").css("top", storySecondaryTop);

	$("#story-secondary").css("right", 0.391304347826087 * storySecondaryTop);


	var storyTabsSize = 100.4;
	$(".story-tabs div").height(storyTabsSize);
	$(".story-tabs div").width(storyTabsSize);

	var bBlueBackgroundSize = "70.86614173228346% 46.45669291338582%";
	var aBlueBackgroundSize = "53.54330708661418% 46.45669291338582%";
	$("#story-tabs-a").css("background-size", aBlueBackgroundSize);
	$("#story-tabs-b").css("background-size", bBlueBackgroundSize);
	//alert(31.625/$(window).width()) 0.020833333333333332
	$("#story-tabs-a").css("margin-bottom", 31.625);
	var storyTitleBottom = 23.718800000000005;
	var storyTabsTop = storyTitleTop + 10 + storyTitleHeight + storyTitleBottom;
	$(".story-tabs").css("top", storyTabsTop);
	//alert(273.9565/$(window).width()) 0.18047200263504612
	$(".story-tabs").css("left", 273.9565);

	//点击选项卡
	var bRedBackgroundSize = "76.37795275590551% 53.54330708661418%";
	var aRedBackgroundSize = "59.05511811023622% 53.54330708661418%";
	$("#story-tabs-b").click(function() {
		$("#story-world-bg img:eq(1)").stop();
		$(".word-txt-bg").show();
		$(".word-txt").animate({
			opacity: 1
		}, 500);
		$(this).css("background-image", "url(img/story-tabs-b-red.png)");

		$(this).css("background-size", bRedBackgroundSize);
		$(this).css("border", "1px solid #fff");
		$(this).css("box-shadow", "0 0 13px 0 #f03535, inset 0 0 13px 0 #f03535");
		$("#story-tabs-a").css("background-image", "url(img/story-tabs-a-red.png)");
		$("#story-tabs-a").css("border", "none");
		$("#story-tabs-a").css("box-shadow", "none");

		$("#story-tabs-a").css("background-size", aRedBackgroundSize);
		$(".cir").css("box-shadow", "0 0 240px #bb2c3d");
		boxShadow = "0 0 240px #bb2c3d";
		$("#story-world-bg img:eq(1)").css({
			"left": 0,
			"top": moonTopBefore
		});
		$("#story-world-bg img:eq(1)").hide();
		$("#story-world-bg img:eq(0)").animate({
			opacity: 0
		}, 500);
		$("#rose").show();
		$("#rose img").addClass("roseAnimation");

		$("#story-tabs-b-ul").show();
		$("#story-tabs-b-ul").css("margin-left", -$("#story-tabs-b-ul").width() / 3.5);
		$("#story-tabs-b-ul li").hover(function() {
			if ($(this).index() == 0 || $(this).index() == 1) {
				$("#story-tabs-b-ul li:eq(" + $(this).index() + ") span:nth-child(2)").addClass(
					"liActive1");
			}
			if ($(this).index() == 2 || $(this).index() == 3) {
				$("#story-tabs-b-ul li:eq(" + $(this).index() + ") span:nth-child(2)").addClass(
					"liActive2");
			}
		}, function() {
			if (!$(this).hasClass("focus")) {
				if ($(this).index() == 0 || $(this).index() == 1) {
					$("#story-tabs-b-ul li:eq(" + $(this).index() + ") span:nth-child(2)")
						.removeClass();
				}
				if ($(this).index() == 2 || $(this).index() == 3) {
					$("#story-tabs-b-ul li:eq(" + $(this).index() + ") span:nth-child(2)")
						.removeClass();
				}
			}
		});
		$("#story-tabs-b-ul li").click(function() {
			$("#story-tabs-b-ul li span:nth-child(2)").removeClass();
			$("#story-tabs-b-ul li").removeClass();
			$(this).addClass("focus");
			$(".word-txt").css("opacity", 0);
			if ($(this).index() == 0 || $(this).index() == 1) {
				$("#story-tabs-b-ul li:eq(" + $(this).index() + ") span:nth-child(2)").addClass(
					"liActive1");
			}
			if ($(this).index() == 2 || $(this).index() == 3) {
				$("#story-tabs-b-ul li:eq(" + $(this).index() + ") span:nth-child(2)").addClass(
					"liActive2");
			}
			if ($(this).index() == 0) {
				$(".word-txt").stop();
				$(".word-txt").css("background-image", "url('img/story-words-txt-red.png')");
				$(".word-txt").css("background-size", "79.53846153846154% 35.23076923076923%");
			} else if ($(this).index() == 1) {
				$(".word-txt").stop();
				$(".word-txt").css("background-image", "url('img/story-words-txt-evol.png')");
				$(".word-txt").css("background-size", "290.1624px auto");
			} else if ($(this).index() == 2) {
				$(".word-txt").stop();
				$(".word-txt").css("background-image", "url('img/story-words-txt-black.png')");
				$(".word-txt").css("background-size", "309.9283px auto");
			} else {
				$(".word-txt").stop();
				$(".word-txt").css("background-image", "url('img/story-words-txt-queen.png')");
				$(".word-txt").css("background-size", "392.1541px auto");
			}
			$(".word-txt").animate({
				opacity: 1
			}, 600);
		});
	});
	$("#story-tabs-a").click(function() {
		$(".word-txt-bg").hide();
		$(this).css("background-image", "url(img/story-tabs-a-blue.png)");
		//alert(0.97/1.27) 0.7637795275590551
		$(this).css("background-size", aBlueBackgroundSize);
		$(this).css("border", "1px solid #fff");
		$(this).css("box-shadow", "0 0 8px 0 #8a90ff, inset 0 0 8px 0 #8a90ff");
		$("#story-tabs-b").css("background-image", "url(img/story-tabs-b-blue.png)");
		$("#story-tabs-b").css("border", "none");
		$("#story-tabs-b").css("box-shadow", "none");
		//alert(0.75/1.27) 0.5905511811023622
		$("#story-tabs-b").css("background-size", bBlueBackgroundSize);
		$(".cir").css("box-shadow", "0px 0px 120px #a5a8ec");
		boxShadow = "0px 0px 120px #a5a8ec";
		$("#story-world-bg img:eq(1)").show();
		moonMove();
		$("#story-world-bg img:eq(0)").animate({
			opacity: 1
		}, 500);
		$(".word-txt").animate({
			opacity: 0
		}, 500);
		$("#rose").hide();
		$("#rose img").removeClass("roseAnimation");
		$("#story-tabs-b-ul").hide();
	});

	//新闻
	var newsTableTop = storyTitleTop + storyTitleHeight + storyTitleBottom;
	$("#newsTable").width(600);
	$("#newsTable").height(620);
	$("#newsTable").css("margin-top", newsTableTop);
	$("#newsTable tr:first-child").height(0.11664953601870173 * $("#newsTable").height() + 5);
	$("#newsTable tr:last-child").height(0.11664953601870173 * $("#newsTable").height() - 2);

	//角色
	$("#role").height(660.95);
	var roleTop = storyTitleTop + 10 + 23.7188 + $(".story_title").height();
	$("#role").css("margin-top", roleTop);
	//console.log(63.25/$(window).width()); 0.041666666666666664
	$("#role").css("margin-bottom", 63.25);
	//console.log(131.24/$(window).width()); 0.08645586297760212 
	//console.log(640.4/$(window).width()); 0.42187088274044793
	$(".roleImg").width(131.24);
	//console.log(20.5562/$(window).width()); 0.013541633728590251
	$(".roleImg:nth-child(odd)").css("margin-top", 20.5562);
	//console.log(56.925/$(window).width()); 0.0375
	var roleImgRight = 56.925;
	$(".roleImg:not(:last-child)").css("margin-right", roleImgRight);
	$("#role").width(883.89);
	var roleLeft = ($(window).width() - $("#role").width()) / 2;
	$("#role").css("margin-left", roleLeft);
	//console.log(10.28/$(window).width()); 0.006772068511198945
	//console.log(645.15/$(window).width()); 0.425
	$("#roleLine img").width(10.28);
	//$("#roleLine img").height(0.425 * $(window).width());
	var roleLineImgRight = roleImgRight + $(".roleImg").width() - $("#roleLine img").width();
	$("#roleLine img").css("margin-right", roleLineImgRight);
	var roleLineLeft = roleLeft - $("#roleLine img").width() / 2 + $(".roleImg").width() + roleImgRight / 2;
	$("#roleLine").css("left", roleLineLeft);
	$("#roleLine").css("top", roleTop - 20.5562);
	$("#roleBg").height(roleTop + $("#role").height() + 63.25);
	$("#lihui").width(632.5);
	$("#lihui").height($("#roleBg").height() - $("#logo").height());
	$("#lihui").css("top", $("#logo").height());
	$("#lihuiRole").width($("#lihui").width());
	$("#lihuiRole").height($("#lihui").height());
	$("#lihuiRole").css("top", $("#logo").height());
	var lihuiRoleHeight = $("#lihuiRole").height() - $(".story_title").height() - 10;
	$("#lihuiRole").css("background-size", "auto " + lihuiRoleHeight + "px");
	$("#roleDetail").height(185);
	$("#roleDetail").width(18.18);
	$("#roleDetail").css("top", $("#roleBg").height() - lihuiRoleHeight);
	$("#roleDetail").css("left", 632.5 - 120);
	$("#roleMsg img").css("margin-top", ($(window).height() - $("#roleMsg img").height()) / 2)
	$("#lihui").css("opacity", 0);
	$("#lihuiRole").css("opacity", 0);
	$("#roleDetail").hide();
	$("#roleMsg").hide();
	$("#roleMsg img").click(function() {
		$("#roleMsg").fadeOut();
		$("#roleMsg img").fadeOut();
		$("#roleMsg").css("background", "rgba(0,0,0,0)");
	});

	$(".roleImg").hover(function() {
		$(this).css("filter", "brightness(100%)");
		$(this).css("transform", "translateY(5px)");
	}, function() {
		if ($(this).hasClass("focus")) {
			$(this).css("filter", "brightness(100%)");
			$(this).css("transform", "translateY(-5px)");
		} else {
			$(this).css("filter", "brightness(70%)");
			$(this).css("transform", "translateY(-5px)");
		}
	});
	var roleAlt;
	$(".roleImg").click(function() {
		$(".roleImg").removeClass("focus");
		$(".roleImg").css("filter", "brightness(70%)");
		$(this).css("filter", "brightness(100%)");
		$(this).addClass("focus");

		//立绘
		roleImgRight = 17.3937;
		roleLeft = $("#lihui").width() - 10;
		roleLineImgRight = roleImgRight + $(".roleImg").width() - $("#roleLine img").width();
		roleLineLeft = roleLeft - ($("#roleLine img").width()) / 2 + $(".roleImg").width() +
			roleImgRight / 2;
		lihuiRoleUrl = "url('img/lihui_" + $(this).prop("alt") + ".png')";
		$("#lihuiRole").css("background-image", lihuiRoleUrl);
		$(".roleImg:not(:last-child)").animate({
			marginRight: roleImgRight
		}, 100);
		$("#roleLine img").animate({
			marginRight: roleLineImgRight
		}, 100);
		$("#roleLine").animate({
			left: roleLineLeft
		}, 500);
		$("#role").animate({
			marginLeft: roleLeft
		}, 500);
		$("#roleDetail").show();
		$("#lihui").css("opacity", 1);
		$("#lihuiRole").css("opacity", 1);

		roleAlt = $(this).prop("alt");
	});

	//点击详情
	$("#roleDetail").click(function() {
		var cgUrl = "img/CG_" + roleAlt + ".jpg";
		$("#cg img").prop("src", cgUrl);
		$("#cg").show();
		$("#cg img").width($(window).width());
		$("#roleBg").height($("#cg img").height());
		$("#cg").css("opacity", 1);
		$("footer").css("top", $("#cg").height() - $("#logo").height());
	});

	$("#cg img").click(function() {
		$("#roleMsg").css("background", "rgba(0,0,0,.75)");
		$("#roleMsg").show();

		$("#roleMsg img").prop("src", "img/" + roleAlt + "_details.png");
		$("#roleMsg img").fadeIn(500);
		$("#roleMsg").css("opacity", 1);
	});

	//视听站
	$("#gallery_show .gallery_play").click(function() {
		$("#gallery_show_video").show();
		$("#gallery_show_video").trigger('play');
	});
	var gallery_list_tabs = $(".gallery_list_tabs_change");
	gallery_list_tabs.click(function() {
		var gallery_list_tabs_index = gallery_list_tabs.index(this);
		gallery_list_tabs.removeClass("gallery_list_tabs_active");
		$(".gallery_list_tabs_change img").hide();
		$(this).addClass("gallery_list_tabs_active");
		$(this).find("img").show();
		if (gallery_list_tabs_index == 0) {
			$("#gallery_list_main_video").show();
			$("#gallery_list_main_photo").hide();
		} else {
			$("#gallery_list_main_video").hide();
			$("#gallery_list_main_photo").show();
		}
		var newContentHeight = $(this).parent().parent().parent().parent().height();
		$("footer").css("top", newContentHeight - $("#logo").height());
		$("#onloadcontent").height(newContentHeight + $("footer").height());
	});
	var gallery_list_detail_close = $("#gallery_list_detail_close");
	gallery_list_detail_close.click(function() {
		$("#gallery_list_detail_video video").prop("currentTime", 0);
		$("#gallery_list_detail_video video").trigger('pause');
		$("#gallery_list_detail").hide();
	})
	var gallery_list_content = $(".gallery_list_content");
	gallery_list_content.click(function() {
		var gallery_list_content_src = $(this).find("img:eq(0)").prop("alt");
		if ($(this).parent().prop("id") == "gallery_list_main_video") {
			$(".videoEdit").attr("data-Id", $(this).find("img:eq(0)").attr("data-Id"));
			$("#gallery_list_detail").show();
			$("#gallery_list_detail_photo").hide();
			$("#gallery_list_detail_video").show();
			$("#gallery_list_detail_video video").prop("src", gallery_list_content_src);
			$("#gallery_list_detail_video video").trigger('play');
			gallery_list_detail_close.css("right", "calc(50% - 562.22px)");
		} else {
			$(".photoEdit").attr("data-Id", $(this).find("img:eq(0)").attr("data-Id"));
			$("#gallery_list_detail").show();
			$("#gallery_list_detail_photo").show();
			$("#gallery_list_detail_photo img:eq(1)").show();
			$("#gallery_list_detail_photo img:eq(0)").hide();
			$("#gallery_list_detail_photo img:eq(0)").prop("src", gallery_list_content_src);
			var gallery_list_content_type = $(this).find("img:eq(0)").attr("data-cardType");
			if (gallery_list_content_type == "手机壁纸") {
				$("#gallery_list_detail_photo img:eq(0)").width(355.78);
				gallery_list_detail_close.css("right", "calc(50% - 177.89px)");
				$(".photoHref").css("left", "calc(50% - 177.89px)");
			} else {
				$("#gallery_list_detail_photo img:eq(0)").width(1124.44);
				gallery_list_detail_close.css("right", "calc(50% - 562.22px)");
				$(".photoHref").css("left", "calc(50% - 562.22px)");
			}
			$("#gallery_list_detail_photo img:eq(0)").on('load', function(){
					$("#gallery_list_detail_photo img:eq(1)").hide();
					$("#gallery_list_detail_photo img:eq(0)").show();
				});
			$("#gallery_list_detail_video").hide();
		}
	});

	$(".videoEdit").click(function() {
		var id = $(this).attr("data-Id");
		window.location.href = "VideoUpdatePage?id=" + id;
	});
	$(".photoEdit").click(function() {
		var id = $(this).attr("data-Id");
		window.location.href = "CardUpdatePage?id=" + id;
	});
	$(".videoDelete").click(function() {
		if (confirm("确认删除？")) {
			var id = $(this).prev().attr("data-Id");
			window.location.href = "VideoDelete?id=" + id;
		}
	});
	$(".photoDelete").click(function() {
		if (confirm("确认删除？")) {
			var id = $(this).prev().attr("data-Id");
			window.location.href = "CardDelete?id=" + id;
		}
	});

	//初次加载显示内容页
	$(".content").hide();
	$(".content:eq(0)").show();

});
window.onload = function() {
	tableChange();
};

function gotoDetail(obj) {
	$("#newsTable").hide();
	$("#news_detail").show();
	$("footer").css("opacity", "0");

	var newsListId = obj.previousElementSibling.value;
	$("#news_detail").load("NewsDetailQuery", "newsListId=" + newsListId, function() {
		if ($("#news_content img").length != 0) {
			$("#news_content img").on('load', function() {
				var newsDetailContent = obj.parentNode.parentNode.parentNode.parentNode.parentNode
					.parentNode.clientHeight;
				$("#onloadcontent").height($(".content:eq(1)").height() + $("footer").height());
				$("footer").css("opacity", "1");
				$("footer").css("top", newsDetailContent - $("#logo").height());
			});
		} else {
			var newsDetailContent = obj.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode
				.clientHeight;
			$("#onloadcontent").height($(".content:eq(1)").height() + $("footer").height());
			$("footer").css("top", newsDetailContent - $("#logo").height());
			$("footer").css("opacity", "1");
		}
		//$("#news-bg").height($("#news_detail").height());
		//$(".content:eq(1)").height(170.409 + $("#news-bg").height());
	});
}
window.onscroll = function() {scrollFunction()};
 
function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("myBtn").style.opacity = "1";
    } else {
        document.getElementById("myBtn").style.opacity = "0";
    }
}
 
// 点击按钮，返回顶部
function topFunction() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
function tableChange() {
	var nextNews = document.getElementById('next');
	var preNews = document.getElementById('pre');
	var newsTable = document.getElementById('newsTable');
	var TableTr = newsTable.children[1].children;
	var num = document.getElementById('num');
	var page = (TableTr.length - 2) / 8;
	if (page % 1 != 0) {
		page = Math.ceil(page);
		var insertRowNum = (page * 8) - (TableTr.length - 2);
		for (let i = 0; i < insertRowNum; i++) {
			var trNodeNew = newsTable.insertRow(TableTr.length - 1);
			for (let i = 0; i < 3; i++) {
				trNodeNew.insertCell(i);
				trNodeNew.cells[i].innerHTML = '&nbsp;';
			}
		}
	}
	for (let t = 1; t < TableTr.length - 1; t++) {
		if (t > 8)
			TableTr[t].style.display = 'none';
	}
	var pageIndex = 1;
	preNews.onclick = function() {
		if (pageIndex != 1) {
			pageIndex -= 1;
			num.innerHTML = pageIndex;
			showTr(pageIndex);
		}
	};
	nextNews.onclick = function() {
		if (pageIndex != page) {
			pageIndex += 1;
			num.innerHTML = pageIndex;
			showTr(pageIndex);
		}
	};

	function showTr(pageIndex) {
		var rowNumEnd = pageIndex * 8 + 1;
		var rowNumBegin = (pageIndex - 1) * 8 + 1;
		for (let t = 1; t < TableTr.length - 1; t++)
			TableTr[t].style.display = 'none';
		for (let t = rowNumBegin; t < rowNumEnd; t++)
			TableTr[t].style.display = 'table-row';
	}
}

var imgReady = (function () {
	var list = [], intervalId = null,
	// 用来执行队列
	tick = function () {
		var i = 0;
		for (; i < list.length; i++) {
			list[i].end ? list.splice(i--, 1) : list[i]();
		};
		!list.length && stop();
	},
	// 停止所有定时器队列
	stop = function () {
		clearInterval(intervalId);
		intervalId = null;
	};
	return function (url, ready, load, error) {
		var onready, width, height, newWidth, newHeight,
		img = new Image();
		img.src = url;
		// 如果图片被缓存，则直接返回缓存数据
		if (img.complete) {
			ready.call(img);
			load && load.call(img);
			return;
		};
		width = img.width;
		height = img.height;
		// 加载错误后的事件
		img.onerror = function () {
			error && error.call(img);
			onready.end = true;
			img = img.onload = img.onerror = null;
		};
		// 图片尺寸就绪
		onready = function () {
			newWidth = img.width;
			newHeight = img.height;
			if (newWidth !== width || newHeight !== height || newWidth * newHeight > 1024) {
				ready.call(img);
				onready.end = true;
			};
		};
		onready();
		// 完全加载完毕的事件
		img.onload = function () {
			// onload在定时器时间差范围内可能比onready快
			// 这里进行检查并保证onready优先执行
			!onready.end && onready();
			load && load.call(img);
			// IE gif动画会循环执行onload，置空onload即可
			img = img.onload = img.onerror = null;
		};
		// 加入队列中定期执行
		if (!onready.end) {
			list.push(onready);
			// 无论何时只允许出现一个定时器，减少浏览器性能损耗
			if (intervalId === null) intervalId = setInterval(tick, 40);
		};
	};
})();