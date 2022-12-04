<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false"
    pageEncoding="UTF-8"%>
 <%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>수정 하기</h1>
<fieldset>
<form action="editpost" method="post" enctype="multipart/form-data">
<input type="hidden" name="seq" value="<%=u.getSeq() %>">
<table>
<tr><td>Photo:</td><td><input type="file" name="photo" />
	"<%= u.getPhoto()%>"
	<c:if test="${u.getPhoto() ne ''}"><br/> <img src="${pageContext.request.contextPath}/upload/<%= u.getPhoto()%>" class ="photo" width="200"></c:if></td></tr>

	<tr><td>Category:</td>
		<td><select name = "category">
			<option value = "질문">질문</option>
			<option value = "요리 자랑">요리 자랑</option>
			<option value = "맛집">맛집</option>
		</select></td></tr>

	<tr><td>Title:</td><td><input type="text" name="title" value="<%= u.getTitle()%>"/></td></tr>
	<tr><td>Writer:</td><td><input type="text" name="writer" value="<%= u.getWriter()%>"/><label>익명:</label>
		<input type= "radio"  name ="anonymous"  value = "true" checked> 익명 <input type="radio" name ="anonymous" value = "false" > 아니요</td></tr>
<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"><%= u.getContent()%></textarea></td></tr>
<input type="button" value="취소" onclick="history.back()"/></td></tr>
<tr><td colspan="2"><input type="submit" value="파일 수정"/>

</table>
</form></fieldset>

</body>
</html>