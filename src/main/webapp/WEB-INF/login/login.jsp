<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
	<link rel="stylesheet" href="/Shop/css/style.css">
</head>
	<header><h2>ログイン画面</h2></header></div>
<body>
	<div class="Login">
		<p>ユーザ名とパスワードを入力してください。</p>
			<form action="/Shop/Login" method="post">
				ユーザーID:
					<input type="text" name="USERID" class="Userid" maxlength="27"><br>
				パスワード:
					<input type="password" name="PASS" class="Pass" maxlength="27"><br>
				<div class="Fontp">パスワードを忘れた場合は<a href="/Shop/Login***">こちら</a></div>
				<input type="submit" value="ログイン">
			</form>
			<p><a href="/Shop/Main?action=new">新規登録</a></p>
	</div>
</body>
</html>