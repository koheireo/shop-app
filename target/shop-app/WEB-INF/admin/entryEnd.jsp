<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.productInfo" %>
    <% productInfo p = (productInfo) request.getAttribute("productinfo");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style2.css">
		<title>登録完了</title>


	</head>
	<body>
        <header><a href="/Shop/Main"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">
            <div class="box">
            <span class="sample1d">登録完了</span>
            </div>
			<nav class="p">
				以下の商品を登録しました<br><br>
                <table  border="1">
                    <tr>
                        <th>商品名：</th>
                        <td><%= p.getProductName() %></td>
                    </tr>
                    <tr>
                        <th>カテゴリ：</th>
                        <td><%= p.getCateCode() %></td>
                    </tr>
                    <tr>
                        <th>サイズ：</th>
                        <td><%= p.getSize() %></td>
                    </tr>
                    <tr>
                        <th>商品詳細：</th>
                        <td><%= p.getProductDetails() %></td>
                    </tr>
                    <tr>
                        <th>価格：</th>
                        <td><%= p.getPrice() %>円</td>
                    </tr>
                    <tr>
                        <th>在庫数：</th>
                        <td><%= p.getStock() %></td>
                    </tr>

                </table><br>
                画像ファイル<br><br>
                <img src="upload/<%= p.getImagesPass() %>" width="100px" alt="商品画像" title="商品画像">
                <img src="upload/<%= p.getImagesPass2() %>" width="100px" alt="商品画像2" title="商品画像2">
                <img src="upload/<%= p.getImagesPass3() %>" width="100px" alt="商品画像3" title="商品画像3"><br><br>
				<a href="/Shop/Servlet?action=mente">メニューへ戻る</a> 　　
                <a href="/Shop/Servlet?action=entry">続けて登録する</a>
			</nav>
		</div>
	</body>
</html>