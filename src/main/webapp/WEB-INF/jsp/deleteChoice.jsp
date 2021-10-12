<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品削除確認</title>
		<link rel="stylesheet"  href="css/style2.css" >

	</head>
	<body>
        <header><a href="index.html"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">
            <div class="box">
            <span class="sample1d">商品削除確認</span>
            </div>
			<nav class="p">
				「シャツ」「M」を削除しますか？<br><br>
				<input type="submit"class="button2" onclick="location.href='deleteEnd.html'" value="はい">　
				<a href="delete.html"class="button2">いいえ</a>
			</nav>
		</div>
	</body>
</html>