<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.productInfo" %>
    <% productInfo p = (productInfo) request.getAttribute("productinfo2"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style2.css">
		<title>変更完了</title>

	</head>
	<body>
        <header><a href="/Shop/Main"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">
            <div class="box">
            <span class="sample1d">変更完了</span>
            </div>

			<nav class="p">
				以下の情報に変更しました<br><br>

            <table  border="1">
                    <tr>

                        <th>商品名:</th>
                        <td><%= p.getProductName() %></td>
                    </tr>

                    <tr>
                        <th>商品詳細:</th>
                        <td> <%= p.getProductDetails() %>
                        </td>
                    <tr>

                        <th>価格:</th>
                        <td><%= p.getPrice() %></td>
                    </tr>
                    <tr>

                    <th>在庫数：</th>
                    <td><%= p.getStock() %></td>
                </tr>
            </table><br>


                <a href="/Shop/Servlet?action=mente">メニューへ戻る</a>　　
				<a class="main" href="/Shop/Servlet?action=update">続けて変更する</a>
			</nav>
		</div>

	</body>
</html>