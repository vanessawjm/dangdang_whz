<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
<style type="text/css">
td {
	padding-top: 8px;
}

#file_upload1 {
	display: none;
}

#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/back/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(function(){ 
	$("#ff").validate({
		//填写验证规则
		rules:{
			"book.name":"required",				
			"book.pageNum":"required",	
			"book.price":"required",				
			"book.dprice":"required",				
			"book.wordNum":"required",				
			"book.pressDate":"required",				
			"book.stock":"required",				
			"book.author":"required",				
			"book.press":"required",
			"book.isbn":"required",				
			"book.edition":"required",				
			"book.pack":"required",				
			"book.paper":"required",				
			"book.sizes":"required",				
			"book.impression":"required",				
			"book.printDate":"required",	
			"book.editorRecommend":"required",	
			"book.contentAbstract":"required",	
			"book.authorAbstract":"required",	
			"book.director":"required",	
			"book.mediaCommentary":"required",	
		},
		//不通过时提示信息
		messages:{
			"book.name":"*不能为空",				
			"book.pageNum":"*不能为空",		
			"book.price":"*不能为空",						
			"book.dprice":"*不能为空",						
			"book.wordNum":"*不能为空",						
			"book.pressDate":"*不能为空",						
			"book.stock":"*不能为空",						
			"book.author":"*不能为空",						
			"book.press":"*不能为空",		
			"book.isbn":"*不能为空",					
			"book.edition":"*不能为空",						
			"book.pack":"*不能为空",					
			"book.paper":"*不能为空",						
			"book.sizes":"*不能为空",						
			"book.impression":"*不能为空",						
			"book.printDate":"*不能为空",	
			"book.editorRecommend":"*不能为空",
			"book.contentAbstract":"*不能为空",
			"book.authorAbstract":"*不能为空",	
			"book.director":"*不能为空",
			"book.mediaCommentary":"*不能为空",	
		}			
	});
});			
</script>
<!-- 提示信息添加样式 -->
<style>
	label.error{
		color:red;
	}
</style>	   
</head>
<body
	style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">添加图书</div>
	<hr />
	<div align="center">
		<form id="ff" action="${pageContext.request.contextPath}/book/addBook" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="book.name"
						class="el-input__inner"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="book.pageNum"
						class="el-input__inner"></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="book.categoryId" class="el-select__inner inner2">
							<c:forEach items="${list}" var="category">
								<option value="${category.id }">${category.name }</option>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="book.wordNum" class="el-input__inner"></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="book.price" class="el-input__inner"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<span id="uploadtip">添加图书封面</span> 
							<img id="uploadimg" src="" alt="" width="118px" height="143px" />
						</label> 
						<input type="file" name="cover" class="" id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="book.dprice"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="book.stock"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="book.author"
						class="el-input__inner"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner"
							name="book.editorRecommend"></textarea></td>
				</tr>
				
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="book.press"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="book.pressDate"
						class="el-input__inner"></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner"
							name="book.contentAbstract"></textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="book.edition"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="book.printDate"
						class="el-input__inner"></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner"
							name="book.authorAbstract"></textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="book.impression"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="book.isbn"
						class="el-input__inner"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner"
							name="book.director"></textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="book.sizes"
						class="el-input__inner"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="book.paper"
						class="el-input__inner"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner"
							name="book.mediaCommentary"></textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="book.pack"
						class="el-input__inner"></td>
					<td></td>
				</tr>
			</table>
			<input type="submit" class="button btn-p" value="提交"/>&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>
