<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath }/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script>
			$(function(){
				$(".book-cover").mouseover(function(e){
					//1.获取图片大小
					var width = this.width;
					var height = this.height;
					
					//2.获取鼠标的当前位置
					var x = e.pageX + 10;
					var y = e.pageY + 10;
					
					//3.创建一个div
					var div = $("<div id='bigImg'/>").css({
							"position":"absolute",
							"width":width * 2,
							"height":height * 2,
							"top":y,
							"left":x,
							"display":"none",
							});
					//4.创建一个img
					var img = $("<img/>").attr({"src":this.src}).css({"width":width * 2,"height":height * 2});
					//5.将img放到div当中
					div.append(img);
					//6.将div放入到body中
					$("body").append(div);
					//7.将img展示出来
					div.show(1000);
				}).mousemove(function(e){
					//获取鼠标当前的位置
					var x = e.pageX + 10;
					var y = e.pageY + 10;
					//改变div的位置
					$("#bigImg").css({"top":y,"left":x});
				}).mouseout(function(){
					$("#bigImg").remove();
				});
			});
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath }/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href="${pageContext.request.contextPath }/book/main">当当图书</a> &gt;&gt;
			<font style='color: #cc3300'><strong>${category.name}</strong> </font>
			<c:forEach items="${category.seconds}" var="second">
				<c:if test="${second.id eq sid }">
					&gt;&gt; <font style='color: #cc3300'><strong>${second.name}</strong> </font>
				</c:if>
			</c:forEach>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath }/book/second?fid=${category.id}">
											&middot;<span <c:if test="${sid==null}">style="color: #cc3300;"</c:if> >全部&nbsp</span>
										</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<c:forEach items="${category.seconds}" var="second">
								<li>
									<div>
										<div class=second_fenlei>
											&middot;
										</div>
										<div class=second_fenlei3>
											<a href="${pageContext.request.contextPath }/book/second?fid=${category.id}&sid=${second.id}">
												<span <c:if test="${second.id eq sid }">style="color: #cc3300;"</c:if>>${second.name }</span>
											</a>
										</div>
									</div>
								</li>
								<div class="clear"></div>
							</c:forEach>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="#">
									<img src='${pageContext.request.contextPath }/front/images/page_up.gif' /> 
								</a>
							</div>
	
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath }/front/images/page_up_gray.gif' />
							</div>
				
							<div class='list_r_title_text3b'>
								第1页/共5页
							</div>
							
							<div class='list_r_title_text3a'>
								<a name=link_page_next href="#">
									<img src='${pageContext.request.contextPath }/front/images/page_down.gif' /> 
								</a>
							</div>
			
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath }/front/images/page_down_gray.gif' />
							</div>

							<!--分页导航结束-->
						</div>
					</div>
					
					<div class="list_r_line"></div>
					<!--商品条目开始-->
						
					<c:forEach items="${list }" var="book">
						<div class="list_r_list">
							<span class="list_r_list_book">
								<a name="link_prd_img" href='${pageContext.request.contextPath }/book/selectOne?id=${book.id}'>
									<img class="book-cover" style="width:70px;height: 103px;" src="${pageContext.request.contextPath }/back/img/${book.cover}" /> 
								</a> 
							</span>
							<h2>
								<a name="link_prd_name" href='${pageContext.request.contextPath }/book/selectOne?id=${book.id}'>${book.name }</a>
							</h2>
							<h3></h3>
							<h4 class="list_r_list_h4">
								作 者:${book.author}
							</h4>
							<h4>
								出版社：${book.press }
							</h4>
							<h4>
								出版时间：<fmt:formatDate value="${book.pressDate }" pattern="yyyy-MM-dd" />
							</h4>
							<h4>
								销量：${book.sale}
							</h4>
							<h5>
								${book.contentAbstract }
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥${book.price }</span>
								<span class="red">￥${book.dprice }</span>
								节省：￥${book.price - book.dprice }
							</h6>
							<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath }/cart/addCart?id=${book.id}"> 
									<img src='${pageContext.request.contextPath }/front/images/buttom_goumai.gif' />
								</a>
							</span>
						</div>
						<div class="clear"></div>
					</c:forEach>
					
					<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
