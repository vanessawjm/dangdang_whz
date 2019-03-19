<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${news }" var="book">
		<div class="second_d_wai">
			<div class="img">
				<a href="${pageContext.request.contextPath }/book/selectOne?id=${book.id}" target='_blank'>
					<img class="book-cover" style="width:80px;height:103px;" src="${pageContext.request.contextPath }/back/img/${book.cover}" /> 
				</a>
			</div>
			<div class="shuming">
				<a href="${pageContext.request.contextPath }/book/selectOne?id=${book.id}" target="_blank">${book.name }</a><a href="#" target="_blank"></a>
			</div>
			<div class="price">
				定价：￥${book.price }
			</div>
			<div class="price">
			
				当当价：￥${book.dprice }
			</div>
			<div class="price">
				销量：${book.sale }
			</div>
		</div>
		<div class="book_c_xy_long"></div>
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>