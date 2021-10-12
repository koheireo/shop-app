<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style2.css">
		<title>商品メンテナンスメニュー</title>


	</head>
	<body>
        <header><a href="/Shop/Main"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">

            <div class="box">
            <span class="sample1d">商品メンテナンスメニュー</span>
            </div>
        <br>
			<nav class="p">
                <a href="/Shop/Servlet?action=entry" class="button">商品登録</a>
                <br><br>
                <a href="/Shop/Servlet?action=update" class="button">商品情報変更</a>
                <br><br>
                <a href="/Shop/Servlet?action=delete" class="button">商品削除</a>
                <br><br><br>
                <a href="">ログアウト</a>
			</nav>
		</div>
	</body>
</html>
