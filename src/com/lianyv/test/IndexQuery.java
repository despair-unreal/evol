package com.lianyv.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qjm.jdbc.MysqlUtil;

/**
 * Servlet implementation class IndexQuery
 */
@WebServlet("/IndexQuery")
public class IndexQuery extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		MysqlUtil mu = new MysqlUtil("evol", "root", "root");
		HttpSession session=request.getSession();
		Object obj = session.getAttribute("identity");
		int identity = 404;
		if(obj != null)
			identity = (Integer)session.getAttribute("identity");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<meta charset=\"utf-8\">\r\n" + 
				"		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"		<title>恋与制作人官�?</title>\r\n" + 
				"		<link rel=\"icon\" href=\"favicon.ico\">\r\n" + 
				"		<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\">\r\n" + 
				"		<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/webCss/index.css\" />\r\n" + 
				"		<script type=\"text/javascript\" src=\"./js/jquery-3.3.1.js\"></script>\r\n" + 
				"		<script src=\"./js/bootstrap.min.js\"></script>\r\n" + 
				"		<script type=\"text/javascript\" src=\"js/index.js\"></script>\r\n" + 
				"\r\n" + 
				"		<!-- 编辑器所�?css -->\r\n" + 
				"		<link rel=\"stylesheet\" type=\"text/css\" href=\"css/font-awesome.min.css\">\r\n" + 
				"		<link href=\"css/froala_editor.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"		<div id=\"loading\">\r\n" + 
				"			<img src=\"img/load.gif\">\r\n" + 
				"		</div>\r\n" + 
				"		<div id=\"onloadcontent\" class=\"container-fluid\">\r\n" + 
				"			<div id=\"myBtn\" onclick=\"topFunction()\"></div>" +
				"			<nav>\r\n" + 
				"				<div class=\"container-fluid\">\r\n" + 
				"					<div class=\"row row-no-gutters\">\r\n" + 
				"						<div id=\"logo\" class=\"col-md-2 col-md-offset-1 text-center\">\r\n" + 
				"							<a><img src=\"./img/logo.png\"></a>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col-md-7\">\r\n" + 
				"							<!-- style=\"background-color: #000000;\" -->\r\n" + 
				"							<ul class=\"list-unstyled\">\r\n" + 
				"								<div class=\"col-md-2 text-center\">\r\n" + 
				"									<li>\r\n" + 
				"										<div class=\"active\">\r\n" + 
				"											<span>首页</span>\r\n" + 
				"											<span>Top</span>\r\n" + 
				"										</div>\r\n" + 
				"									</li>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-md-2 text-center\">\r\n" + 
				"									<li class=\"\">\r\n" + 
				"										<div>\r\n" + 
				"											<span>新闻公告</span>\r\n" + 
				"											<span>News</span>\r\n" + 
				"										</div>\r\n" + 
				"									</li>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-md-2 text-center\">\r\n" + 
				"									<li class=\"\">\r\n" + 
				"										<div>\r\n" + 
				"											<span>故事背景</span>\r\n" + 
				"											<span>Story</span>\r\n" + 
				"										</div>\r\n" + 
				"									</li>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-md-2 text-center\">\r\n" + 
				"									<li class=\"\">\r\n" + 
				"										<div>\r\n" + 
				"											<span>角色介绍</span>\r\n" + 
				"											<span>Character</span>\r\n" + 
				"										</div>\r\n" + 
				"									</li>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-md-2 text-center\">\r\n" + 
				"									<!-- onclick=\"window.open('https://evol.papegames.cn/gallery');\" -->\r\n" + 
				"									<li class=\"\">\r\n" + 
				"										<div>\r\n" + 
				"											<span>视听�?</span>\r\n" + 
				"											<span>Gallery</span>\r\n" + 
				"										</div>\r\n" + 
				"									</li>\r\n" + 
				"								</div>\r\n" + 
				"								<div class=\"col-md-2 text-center\">\r\n" + 
				"									<li class=\"\" onclick=\"window.open('https://tongren.papegames.cn/');\">\r\n" + 
				"										<div>\r\n" + 
				"											<span>同人专区</span>\r\n" + 
				"											<span>Artwork</span>\r\n" + 
				"										</div>\r\n" + 
				"									</li>\r\n" + 
				"								</div>\r\n" + 
				"							</ul>\r\n" + 
				"						</div>\r\n" + 
				"						<div id=\"music\" class=\"col-md-2 text-center\">\r\n" + 
				"							<img src=\"img/musicNone.png\">\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"clearfix\"></div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</nav>\r\n" + 
				"			<div class=\"container-fluid content\">\r\n" + 
				"				<video id=\"indexBg\" autoplay muted loop>\r\n" + 
				"					<source src=\"img/倾色浮影_横版.mp4\" type=\"video/mp4\">\r\n" + 
				"				</video>\r\n" + 
				"				<div id=\"downWrap\" class=\"container\">\r\n" + 
				"					<div id=\"download\" class=\"row row-no-gutters\">\r\n" + 
				"						<div class=\"col-md-4\">\r\n" + 
				"							<div class=\"col-md-6\">\r\n" + 
				"								<img src=\"img/downloadQRcode.png\" />\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"col-md-3 text-center\">\r\n" + 
				"								�?<br />�?<br />�?<br />�?<br />�?<br />�?<br />戏\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"col-md-3\">\r\n" + 
				"								<div id=\"line\"></div>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div class=\"col-md-8\">\r\n" + 
				"							<div class=\"col-md-6\">\r\n" + 
				"								<a href=\"https://20210322.onelink.me/fkaq/5a6cca0b\"><img src=\"img/downloadAndroid.png\"></a>\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"col-md-6 text-right\">\r\n" + 
				"								<a target=\"_blank\" href=\"https://go.onelink.me/app/d0ad8ea4\"><img src=\"img/downloadIOS.png\"></a>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"				<aside>\r\n" + 
				"					<div id=\"asideButton\"></div>\r\n" + 
				"					<div class=\"asideMsg\">\r\n" + 
				"						<img src=\"img/wx.png\">\r\n" + 
				"						<p>官方微信</p>\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"wx\"></div>\r\n" + 
				"					<div class=\"line2\"></div>\r\n" + 
				"					<div class=\"asideMsg\">\r\n" + 
				"						<img src=\"img/wb.png\" onclick=\"window.open('https://weibo.com/u/3248438592');\">\r\n" + 
				"						<p>官方微博</p>\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"line2\"></div>\r\n" + 
				"					<div class=\"asideMsg\">\r\n" + 
				"						<img src=\"img/qq.png\">\r\n" + 
				"						<p>官方Q�?</p>\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"qq\"></div>\r\n" + 
				"					<div class=\"line2\"></div>\r\n" + "");
	if(obj == null)	{
		out.println("					<div class=\"asideMsg\" onclick=\"window.open('login.html');\">\r\n" + 
				"						<img src=\"img/login.png\">\r\n" + 
				"						<p>登录/注册</p>\r\n" + 
				"					</div>\r\n" + "");
	}else {
		out.println("					<div class=\"asideMsg\" onclick=\"window.open('DestroySession');\">\r\n" + 
				"						<img src=\"img/login.png\">\r\n" + 
				"						<p>�?出登�?</p>\r\n" + 
				"					</div>\r\n" + "");
	}
	out.println("				</aside>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"container-fluid content\">\r\n" + 
				"				<div class=\"story_title\">\r\n" + 
				"					<img src=\"img/news_title.png\">\r\n" + 
				"				</div>\r\n" + 
				"				<div id=\"news-bg\">\r\n" + 
				"					<div id=\"news_detail\" style=\"display: none;\" >\r\n" + "");
	out.println("					</div>\r\n" + 
				"					<table id=\"newsTable\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"						<colgroup>\r\n" + 
				"							<col style=\"width: 13%;\" />\r\n" + 
				"							<col style=\"width: 66%;\" />\r\n" + 
				"							<col style=\"width: 21%;\" />\r\n" + 
				"						</colgroup>\r\n" + 
				"						<tbody>\r\n" + 
				"							<tr>\r\n" + 
				"								<td colspan=\"2\"></td>\r\n" + 
				"								<td align=\"center\" valign=\"middle\" style=\"font-weight: 300;padding-top: 30px;\">\r\n" + "");
	if(identity == 0) {
		out.println("									<a href=\"NewsQuery\" target=\"_blank\" class=\"edit\">编辑</a>\r\n" + "");
	}	
	out.println("								</td>\r\n" + 
				"							</tr>");
		String newsListSql = "select * from newsList order by newsDate desc;";
		List<String[]> newsList = mu.querySQL(newsListSql);
		for(int i=0;i<newsList.size();i++) {
			out.println("<tr>\r\n" + 
					"								<td><span>"+newsList.get(i)[1]+"</span></td>\r\n" + 
					"								<td><input type=\"hidden\" name=\"newsListId\" value=\""+newsList.get(i)[0]+"\" /><a onclick=\"gotoDetail(this)\" target=\"_blank\">"+newsList.get(i)[2]+"</a></td>\r\n" + 
					"								<td>"+newsList.get(i)[3]+"</td>\r\n" + 
					"							</tr>");
		}
		out.println("<tr>\r\n" + 
				"								<td><a id=\"pre\">上一�?</a></td>\r\n" + 
				"								<td align=\"center\" id=\"num\">1</td>\r\n" + 
				"								<td><a id=\"next\">下一�?</a></td>\r\n" + 
				"							</tr>\r\n" + 
				"						</tbody>\r\n" + 
				"\r\n" + 
				"					</table>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"container-fluid content\">\r\n" + 
				"				<div id=\"story-world-bg\">\r\n" + 
				"					<img src=\"img/story-world.png\">\r\n" + 
				"					<img src=\"img/story-world-moon.png\">\r\n" + 
				"					<div class=\"word-txt\"></div>\r\n" + 
				"					<div class=\"word-txt-bg\"></div>\r\n" + 
				"					<div class=\"cir\"></div>\r\n" + 
				"					<div class=\"cir\"></div>\r\n" + 
				"					<div class=\"cir\"></div>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"story_title\">\r\n" + 
				"					<img src=\"img/story_title.png\">\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"story-tabs\">\r\n" + 
				"					<div id=\"story-tabs-a\"></div>\r\n" + 
				"					<div id=\"story-tabs-b\"></div>\r\n" + 
				"					<ul id=\"story-tabs-b-ul\" class=\"list-unstyled\">\r\n" + 
				"						<li class=\"focus\"><span></span><span class=\"liActive1\"></span></li>\r\n" + 
				"						<li><span></span><span></span></li>\r\n" + 
				"						<li><span></span><span></span></li>\r\n" + 
				"						<li><span></span><span></span></li>\r\n" + 
				"					</ul>\r\n" + 
				"				</div>\r\n" + 
				"				<div id=\"rose\">\r\n" + 
				"					<img src=\"img/玫瑰.png\">\r\n" + 
				"				</div>\r\n" + 
				"				<div id=\"bg-cir\">\r\n" + 
				"					<img src=\"img/图层1.png\">\r\n" + 
				"					<img src=\"img/图层2.png\">\r\n" + 
				"				</div>\r\n" + 
				"				<a href=\"https://evol.papegames.cn/secondary/index.html#/\" target=\"_blank\">\r\n" + 
				"					<div id=\"story-secondary\"></div>\r\n" + 
				"				</a>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"container-fluid content\">\r\n" + 
				"				<div id=\"roleBg\">\r\n" + 
				"					<div class=\"story_title\">\r\n" + 
				"						<img src=\"img/character_title.png\">\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"lihui\"></div>\r\n" + 
				"					<div id=\"lihuiRole\"></div>\r\n" + 
				"					<div id=\"roleDetail\"></div>\r\n" + 
				"					<div id=\"cg\">\r\n" + 
				"						<img title=\"点击图片查看人物档案\" src=\"img/CG_xm.jpg\">\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"roleMsg\">\r\n" + 
				"						<img src=\"img/xm_details.png\" title=\"点击图片关闭人物档案\">\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"role\">\r\n" + 
				"						<img class=\"roleImg\" alt=\"xm\" src=\"img/xm.png\">\r\n" + 
				"						<img class=\"roleImg\" alt=\"bq\" src=\"img/bq.png\">\r\n" + 
				"						<img class=\"roleImg\" alt=\"zql\" src=\"img/zql.png\">\r\n" + 
				"						<img class=\"roleImg\" alt=\"lzy\" src=\"img/lzy.png\">\r\n" + 
				"						<img class=\"roleImg\" alt=\"lx\" src=\"img/lx.png\">\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"roleLine\">\r\n" + 
				"						<img src=\"img/line.png\">\r\n" + 
				"						<img src=\"img/line.png\">\r\n" + 
				"						<img src=\"img/line.png\">\r\n" + 
				"						<img src=\"img/line.png\">\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"container-fluid content\">\r\n" + 
				"				<div id=\"resource\">\r\n" + 
				"					<div id=\"gallery_show\">\r\n" + 
				"");
				
	String showVideoSql = "select * from showVideo order by videoDate desc;";
	List<String[]> showVideo = mu.querySQL(showVideoSql);
	out.println("						<img src=\""+showVideo.get(0)[1]+"\">\r\n" + 
				"						<div class=\"bottom_text\">\r\n" + 
				"							"+showVideo.get(0)[3]+"\r\n" + 
				"						</div>\r\n" + 
				"						<img class=\"gallery_play\" src=\"img/gallery-first-play.png\">\r\n" + 
				"						<video id=\"gallery_show_video\" controls=\"controls\">\r\n" + 
				"							<source src=\""+showVideo.get(0)[2]+"\" type=\"video/mp4\">\r\n" +
				"						</video>\r\n" + 
				"					</div>\r\n" + 
				"					<div id=\"gallery_list\">\r\n" + 
				"						<div id=\"gallery_list_tabs\">\r\n" + 
				"							<div class=\"gallery_list_tabs_change gallery_list_tabs_active\">\r\n" + 
				"								宣传视频\r\n" + 
				"								<img src=\"img/gallary_tabs_active.png\">\r\n" + 
				"							</div>\r\n" + 
				"							<div class=\"gallery_list_tabs_change\">\r\n" + 
				"								羁绊展示\r\n" + 
				"								<img src=\"img/gallary_tabs_active.png\" style=\"display: none;\">\r\n" + 
				"							</div>\r\n" + 
				"							<div id=\"gallery_list_tabs_sort\">\r\n" + 
				"								<div id=\"gallery_list_tabs_sort_a\">\r\n" + 
				"									按时间\r\n" + 
				"								</div>\r\n" + 
				"								<div id=\"gallery_list_tabs_sort_b\">\r\n" + 
				"									换一换\r\n" + 
				"								</div>\r\n" + "");
	if(identity == 0) {
		out.println("							<div class=\"dropdown\">\r\n" + 
				"								  <button class=\"btn btn-default dropdown-toggle\" type=\"button\" id=\"dropdownMenu1\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"true\">\r\n" + 
				"								    新增\r\n" + 
				"								    <span class=\"caret\"></span>\r\n" + 
				"								  </button>\r\n" + 
				"								  <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu1\">\r\n" + 
				"								    <li><a target=\"_blank\" href=\"AddVideo\">宣传视频</a></li>\r\n" + 
				"								    <li role=\"separator\" class=\"divider\"></li>\r\n" + 
				"								    <li><a target=\"_blank\" href=\"AddCard\">羁绊展示</a></li>\r\n" + 
				"								  </ul>\r\n" + 
				"								</div>\r\n" + "");
	}
	
				
	out.println("							</div>\r\n" + 
				"						</div>\r\n" + 
				"						<div id=\"gallery_list_main\">\r\n" + 
				"							<div id=\"gallery_list_main_video\">");
		
		for(int i=0;i<showVideo.size();i++) {
			out.println("<div class=\"gallery_list_content\">\r\n" + 
					"									<img data-Id=\""+showVideo.get(i)[0]+"\" alt=\""+showVideo.get(i)[2]+"\" src=\""+showVideo.get(i)[1]+"\">\r\n" + 
					"									<div class=\"bottom_text\">\r\n" + 
					"										"+showVideo.get(i)[3]+"\r\n" + 
					"									</div>\r\n" + 
					"									<img class=\"gallery_play\" src=\"img/gallery-first-play.png\">\r\n" + 
					"								</div>");
		}
		
		out.println("<div style=\"clear: both;\"></div>\r\n" + 
				"							</div>\r\n" + 
				"							<div id=\"gallery_list_main_photo\">");
		String showCardSql = "select * from showCard order by cardDate desc;";
		List<String[]> showCard = mu.querySQL(showCardSql);
		for(int i=0;i<showCard.size();i++) {
			out.println("<div class=\"gallery_list_content\">\r\n" + 
					"									<img data-Id=\""+showCard.get(i)[0]+"\" data-cardType=\""+showCard.get(i)[4]+"\" alt=\""+showCard.get(i)[2]+"\" src=\""+showCard.get(i)[1]+"\">\r\n" + 
					"									<div class=\"bottom_text\">\r\n" + 
					"										"+showCard.get(i)[3]+"\r\n" + 
					"									</div>\r\n" + 
					"								</div>");
		}
	out.println("<div style=\"clear: both;\"></div>\r\n" + 
				"							</div>\r\n" + 
				"							<div id=\"gallery_list_detail\">\r\n" + 
				"								<div id=\"gallery_list_detail_video\">\r\n" + 
				"									<video controls=\"controls\">\r\n" + 
				"										<source src=\"\" type=\"video/mp4\">\r\n" + 
				"									</video>\r\n" + 
				"									<div class=\"videoHref\">\r\n" + "");
	if(identity == 0) {
		out.println("									<a class=\"newsContentEdit videoEdit\" target=\"_blank\">[编辑]</a>\r\n" + 
				"										&nbsp;&nbsp;\r\n" + 
				"										<a class=\"newsContentEdit videoDelete\" target=\"_blank\">[删除]</a>\r\n" + "");
	}
	out.println("									</div>\r\n" + 
				"								</div>\r\n" + 
				"								<div id=\"gallery_list_detail_photo\">\r\n" + 
				"									<img src=\"\" >\r\n" +
				"									<img src=\"img/loadingPhoto.gif\" width=\"32px\" style=\"display: none;\" >" +
				"									<div class=\"photoHref\" id=\"\">\r\n" + "");
	if(identity == 0) {
		out.println("									<a class=\"newsContentEdit photoEdit\" target=\"_blank\">[编辑]</a>\r\n" + 
				"										&nbsp;&nbsp;\r\n" + 
				"										<a class=\"newsContentEdit photoDelete\" target=\"_blank\">[删除]</a>\r\n" + "");
	}			
	out.println("									</div>\r\n" + 
				"								</div>\r\n" + 
				"								<div id=\"gallery_list_detail_close\">\r\n" + 
				"									<img src=\"img/close.png\">\r\n" + 
				"								</div>\r\n" + 
				"							</div>\r\n" + 
				"						</div>\r\n" + 
				"					</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"			<footer>\r\n" + 
				"				<img src=\"img/footer.jpg\" />\r\n" + 
				"				<div id=\"copyright\" align=\"center\">\r\n" + 
				"					<span>著作权人：芜湖叠纸网络科�?有限公司&nbsp;皖ICP�?16013764�?-3&nbsp;皖网文（2016�?6818-121�? 文网游备�? [2017] M-RPG 1512 �? 著作登记号：2017SR468901</span><br />\r\n" + 
				"					<span>出版服务单位：北京中清龙图网络技术有限公司新广出审[2017]8847�? ISBN 978-7-498-01805-2</span><br />\r\n" + 
				"					<span>COPYRIGHT © 2013-2017 WUHU NIKKI CO., Ltd. ALL RIGHTS RESERVED.</span>\r\n" + 
				"				</div>\r\n" + 
				"			</footer>\r\n" + 
				"		</div>\r\n" + 
				"	</body>\r\n" + 
				"</html>\r\n" + 
				"");
		out.println("");
		
	}
}
