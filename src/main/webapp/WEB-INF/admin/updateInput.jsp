<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.productInfo" %>
    <%@ page import="java.util.List" %>
 	<% String Line = (String) request.getAttribute("line"); %>
    <% List<productInfo> ShohinList = (List<productInfo>) session.getAttribute("ShohinList");
    %>
    <% int line = Integer.parseInt(Line); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style2.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>変更情報入力</title>

	</head>
	<body>
        <header><a href="/Shop/Main"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">
            <div class="box">
            <span class="sample1d">変更情報入力</span>
            </div>
			<nav class="p">
			<% productInfo Shohin = ShohinList.get(line); %>
                変更する商品<div class="colorO">「<%= Shohin.getProductName() %>」</div><br>

                <br><br>


      			<form  action="/Shop/Servlet" method="post">
                <table border="1">
                                <tr>
                    <th>商品コード：</th>
                    <td><div class="colorO"> <%= Shohin.getProductCode() %></div></td>
                </tr>
                <tr>
                    <th>商品名：</th>
                    <td><textarea id="textarea" name="productName" style="width:100%;" cols="50" rows="1"spellcheck="true" placeholder="50文字以内でお願いします"><%= Shohin.getProductName() %></textarea></td>
                </tr>
                <tr>
                    <th>カテゴリー：</th>
                    <td>
                       <div class="colorO"> <%= Shohin.getCateCode() %></div>
                    </td>

                </tr>
                    <tr>
                    <th>サイズ：</th>
                    <td>
                       <div class="colorO"> <%= Shohin.getSize() %></div>
                    </td>

                </tr>
                    <tr>
                    <th>商品詳細：</th>
                        <td>
                            <textarea id="textarea2" name="productDetails"style="width:100%;" cols="100" rows="10" maxlength="200"spellcheck="true" placeholder="200文字以内でお願いします"><%= Shohin.getProductDetails() %></textarea>
                        </td>
                    </tr>
                <tr>
                    <th>価格：</th>
                    <td><input type="number" name="price" value="<%= Shohin.getPrice() %>" class="left" max="99999999" min="100">

                    </td>


                </tr>

                <tr>
                    <th>在庫数：</th>
                    <td><input type="number" name="stock" value="<%= Shohin.getStock() %>" class="left" max="999" min="1"></td>
                </tr>
                </table><br>

				登録中の画像ファイル<br><br>
                    <img src="images/images.jpg" width="100px" alt="サンプル" title="サンプル">
                    <img src="images/images.jpg" width="100px" alt="サンプル2" title="サンプル2">
                    <img src="images/images.jpg" width="100px" alt="サンプル3" title="サンプル3"><br><br>



                    <a class="main" href="/Shop/Servlet?action=update">キャンセル</a>　　
                    <input type="submit" class="button2" onclick="location.href='updateEnd.html'"value="更新">
                    <input type="hidden" name="action" value="updateEnd">
                    <input type="hidden" name="productCode" value="<%= Shohin.getProductCode() %>">
            		</form>
            </nav>
		</div>

	</body>
</html>
