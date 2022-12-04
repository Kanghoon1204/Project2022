<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO,java.util.*"%>
<%@ page import="com.example.bean.MessageVO" %>
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
  background-color: #006bb3;
  color: white;
}
</style>
</head>
<body>
<% BoardDAO boardDAO = new BoardDAO();
	String sid = request.getParameter("id");
	int id = Integer.parseInt(sid);
	BoardVO u = boardDAO.getBoard(id);
	MessageVO k = boardDAO.getMessage(id);
	request.setAttribute("vo",u);
	request.setAttribute("ko",k);
	String file = u.getPhoto();

	List<MessageVO> list = boardDAO.getMessageList(id);
	request.setAttribute("list",list);

%>
<fieldset>
<legent><h1>제목 : ${vo.getTitle()}</h1></legent>
</fieldset><br>
<fieldset>
<h3>작성자 : ${vo.getAnonymous() ? '익명' : vo.getWriter() }</h3>
</fieldset><br>
<fieldset>
	내용 : ${vo.getContent()}<br>
</fieldset><br>
<fieldset>
	첨부사진
<table id="edit">
	<tr>
	<td><c:if test="${vo.getPhoto() ne ''}"><br/>
	<img src ="${pageContext.request.contextPath}/upload/${vo.getPhoto()}" class ="photo" width="500"> </c:if></td>
	</tr>
</table>
</fieldset><br>
<br>

</fieldset><br>
<fieldset>
	<form action="addMessagepost" method="post" enctype="multipart/form-data">
		<input type="hidden" name="cnt_message" value="<%=u.getSeq() %>">
		<table>
	<tr><td>댓글 : </td><td><input type="text" name="content_message"/></td></tr>
		<td align="right"><input type="submit" value="등록"/></td>
		</table>
	</form>
</fieldset><br>

<fieldset>
	No. ${vo.getSeq()}번 [${vo.getTitle()}] 제목의 댓글<br>
	<table id="list">
	<c:forEach items="${list}" var="t">
		<tr>
			<td>[익명]</td>
			<td>댓글 내용: ${t.getContent_message()}</td>
			<td>${t.getRegdate_message()}</td>
		</tr>
	</c:forEach>
	</table>

</fieldset><br>

<button type ="button" onclick="history.back()">뒤로 가기</button>
<button type ="button" onclick="location.href='editform?id=${vo.getSeq()}'">수정 하기</button>
</body>
</html>