<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO"%>
<%@ page import="com.example.common.FileUpload" %>
<%@ page import="com.example.bean.BoardVO" %>

<%
	request.setCharacterEncoding("utf-8");
	BoardDAO boardDAO = new BoardDAO();
	FileUpload upload = new FileUpload();
	BoardVO u = upload.editPhoto(request);
	int i = boardDAO.updateBoard(u);
	response.sendRedirect("posts");

%>