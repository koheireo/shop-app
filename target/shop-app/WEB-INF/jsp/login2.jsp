<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String errorMsg=(String)request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ログインページ</h1>
<% if (errorMsg != null) { %>
	<p><%=errorMsg %></p>
<% } %>
<form action="/Shop/Main" method="post">
	<p>ユーザーID：<input type="text" name="id"></p>
	<p>パスワード：<input type="password" name="pass"></p>
	<input type="submit" value="ログイン">
</form>
<p><a href="/Shop/Main?action=new">新規登録</a></p>
</body>
</html>