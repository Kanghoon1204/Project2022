<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO"%>
<%@ page import="com.example.bean.MessageVO" %>
<%@ page import="com.example.common.FileUpload" %>

<%
	request.setCharacterEncoding("utf-8");
	BoardDAO boardDAO = new BoardDAO();
	FileUpload upload = new FileUpload();
	MessageVO u = upload.uploadMessage(request);
	int i = boardDAO.insertMessage(u);
	String msg = "댓글이 작성되었습니다.";
	if(i == 0) msg = "[에러] 데이터 추가 실패 ";
%>


<script>
	alert('<%=msg%>');
	history.back();
</script>