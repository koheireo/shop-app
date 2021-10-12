<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
		<h2 style="text-align:center">登録データ入力画面</h2>
		<hr style="height:3; background-color:#0000ff" />
		<br>
		登録する情報を入力してください
		<form action="/Shop/Main?action=new" method="post">
			<table style="margin:0 auto">
				<tr>
					<td style="width:60">ID</td>
					<td><input type=text size="30" name="user_id"></input></td>
				</tr>
				<tr>
					<td style="width:70">パスワード</td>
					<td><input type=password size="30" name="pass"></input></td>
				</tr>
				<tr>
					<td style="width:70">氏</td>
					<td><input type=text size="30" name="name1"></input></td>
				</tr>
				<tr>
					<td style="width:70">名</td>
					<td><input type=text size="30" name="name2"></input></td>
				</tr>
				<tr>
					<td style="width:70">メール</td>
					<td><input type=text size="30" name="email"></input></td>
				</tr>
				<tr>
					<td style="width:70">郵便番号</td>
					<td><input type=text size="30" name="postnum"></input></td>
				</tr>
				<tr>
					<td style="width:70">住所1</td>
					<td><input type=text size="30" name="address1"></input></td>
				</tr>
				<tr>
					<td style="width:70">住所2</td>
					<td><input type=text size="30" name="address2"></input></td>
				</tr>
				<tr>
					<td style="width:70">住所3</td>
					<td><input type=text size="30" name="address3"></input></td>
				</tr>
				<tr>
					<td style="width:70">電話番号</td>
					<td><input type=text size="30" name="tellnum"></input></td>
				</tr>
				<tr>
					<td colspan=2 style="text-align:center">
						<input type="hidden" name="admin" value="false">
						<input type="submit" value="登録">
					</td>
				</tr>
			</table>
		</form>
		<div class="back">
                <a href="/Shop/Main">ホームへ</a>
        </div>
	</div>
</body>
</html>