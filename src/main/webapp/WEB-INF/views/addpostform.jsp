<%@ page language="java" contentType="text/html; charset=UTF-8"
         isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<legend><h1>게시글 작성</h1></legend>
<fieldset>
<form action="addpost" method="post" enctype="multipart/form-data">
    <table>
<tr><td>Photo:</td><td><input type="file" name="photo"/></td></tr>

<tr><td>Category:</td>
        <td><select name = "category">
            <option value = "질문">질문</option>
            <option value = "요리 자랑">요리 자랑</option>
            <option value = "맛집">맛집</option>
        </select></td></tr>

<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
<tr><td>Writer:</td><td><input type="text" name="writer"/><label>익명:</label>
    <input type= "radio"  name ="anonymous"  value = "true" checked> 익명 <input type="radio" name ="anonymous" value = "false" > 아니요</td></tr>

<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
<tr><td><a href="posts">뒤로 가기</a></td><td align="right"><input type="submit" value="Add Post"/></td></tr>
</table>
</form>
</fieldset>

</body>
</html>