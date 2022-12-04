<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>
<style>
#list {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
#list td, #list th {
  border: 1px solid #ddd;
  padding: 8px;
  text-align:center;
}
#list tr:nth-child(even){background-color: #f2f2f2;}
#list tr:hover {background-color: #ddd;}
#list th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #212528;
  color: white;
}
</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='deletepost?id=' + id;
	}
</script>
</head>
<body>
<h1>요리게시판</h1>
<%
	BoardDAO boardDAO = new BoardDAO();
	List<BoardVO> list = boardDAO.getBoardList();
	request.setAttribute("list",list);
%>
<table id="list" width="90%">
<tr>
	<th>게시글 번호</th>
	<th>카테고리</th>
	<th>제목</th>
	<th>작성자</th>
	<th>등록 날짜</th>
	<th>수정 날짜</th>
	<th>게시글 보기</th>
	<th>삭제</th>

</tr>
<c:forEach items="${list}" var="u">
	<tr>
		<td>${u.getSeq()}</td>
		<td>${u.getCategory()}</td>
		<td>${u.getTitle()}</td>
		<td>${u.getAnonymous() ? '익명' : u.getWriter() } </td>
		<td>${u.getRegdate()}</td>
		<td>${u.getModify()}</td>
		<td><a href="view?id=${u.getSeq()}">View</a></td>
		<td><a href="javascript:delete_ok('${u.getSeq()}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><a href="addpostform">게시글 작성하기</a>

</body>
</html>