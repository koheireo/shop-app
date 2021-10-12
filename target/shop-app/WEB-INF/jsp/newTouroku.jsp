<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録画面</title>
	<link rel="stylesheet" href="css/style.css">
</head>
	<header><h2>新規登録_画面(ユーザ登録用ページ)</h2></header>
<body>
	<form action="/Shop/Login***" method="post" class="Form0">
		<div class="List0">
			<ul class="Koumoku0">
				<li><label for="userid">ユーザID</label></li>
				<li><label for="pass">パスワード</label></li>
				<li><label for="name0">氏</label><br>
					<label for="name1">名</label></li>
				<li><label for="mailadd">メールアドレス</label></li>
				<li><label for="postnum">郵便番号(ハイフン無し)</label></li>
				<li><label for="address0">住所(県)</label><br>
					<label for="address1">(市区町村)</label><br>
					<label for="address2">(番地)</label></li>
				<li><label for="telnum">電話番号等連絡先(ハイフン無し)</label></li>
			</ul>

			<div class="Touroku0">
				<input type="text" size id="userid" name="UserId" maxlength placeholder=""><br>
				<input type="password" id="pass" name="Pass" min placeholder=""><br>
				<input type="text" id="name0" name="Name0" placeholder=""><br>
				<input type="text" id="name1" name="Name1" placeholder=""><br>
				<input type="email" id="mailadd" name="MailAdd" placeholder=""><br>
				<input type="text" id="postnum" name="PostNum" placeholder=""><br>
				<input type="text" id="address0" name="Address0" placeholder=""><br>
				<input type="text" id="address1" name="Address1" placeholder=""><br>
				<input type="text" id="address2" name="Address2" placeholder=""><br>
				<input type="tel" id="telnum" name="TelNum" placeholder="">
			</div>

		</div>

			<div class="Kettei0">
				<input type="submit" value="登録">
				<input type="submit" value="リセット">
				<a href="/Shop/login.jsp" >ログイン画面へ</a>
			</div>
	</form>
</body>
</html>