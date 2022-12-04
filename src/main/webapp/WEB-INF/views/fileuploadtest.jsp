<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 isELIgnored="false"
		 pageEncoding="UTF-8"%>

<%
	String filename = "";
	int sizeLimit = 15 * 1024 * 1024;

	String realPath = request.getServletContext().getRealPath("upload");
	File dir = new File(realPath);
	if (!dir.exists()) dir.mkdir();

	MultipartRequest multipartRequest = null;
	multipartRequest = new MultipartRequest(request,realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
	filename = multipartRequest.getFilesystemName("photo");
%>
<img src = "${pageContext.request.contextPath}/upload/<%=filename%>">