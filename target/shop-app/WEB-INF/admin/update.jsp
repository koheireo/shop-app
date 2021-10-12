<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.productInfo" %>
    <%@ page import="java.util.List" %>
    <%@ page import="model.pagi" %>
    <% List<productInfo> ShohinList = (List<productInfo>) session.getAttribute("ShohinList");
    %>
    <% pagi pagi=(pagi)request.getAttribute("pagi"); %>

	</script>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style2.css">
		<title>商品情報変更</title>
        <dic class="head">
        </dic>

	</head>
	<body>

        <header><a href="index.html"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">
            <div class="box">
            <span class="sample1d">商品情報変更</span>
            </div>
			<nav class="p">
				変更する商品を選択してください<br>

				<form action="/Shop/Servlet" method="post">

				<table  border="1" >
                    <tr>
                        <th>登録日</th>
                        <th><u>商品一覧</u></th>
                        <th class="cate">カテゴリー</th>
                        <th>サイズ</th>
                        <th>価格</th>
                        <th>在庫</th>
                        <th> </th>

                    </tr>
                    <%  %>
                    <% for(int i=0; i < 20 ; i++){ %>
                    <% 	if  ( ShohinList.size() <= i) break; %>
                    <% 	productInfo Shohin = ShohinList.get(i);
                    %>
                    <tr>
                        <td><center><%= Shohin.getEntryDate() %></center></td>
                        <td><%= Shohin.getProductName() %></td>
                        <td><%= Shohin.getCateCode() %></td>
                        <td><center><%= Shohin.getSize() %></center></td>
                        <!-- <td><%= Shohin.getProductDetails() %></td> -->
                        <td><right><%= Shohin.getPrice() %>円</right></td>
                      	<td><%= Shohin.getStock() %></td>
                        <td><center><input type="button" value="変更" onClick="OnLinkClick(<%= i %>)"></center></td>
       		           	 </tr>
                    <% } %>

                </table><br>
                <input type="hidden" name="action" value="updateInput">
                </form>
                <script type="text/javascript">
					function OnLinkClick(i) {
						//alert('JavaScriptのアラート');
					location.href = "/Shop/Servlet?action=updateInput&line="+i;
					}
				</script>

                <ul class="example">
                <li><a href="/Shop/Servlet?action=1">1</a></li>
                <li><a href="/Shop/Servlet?action=2">2</a></li>
                <li><a href="/Shop/Servlet?action=3">3</a></li>
                <li><a href="/Shop/Servlet?action=4">4</a></li>
                <li><a href="/Shop/Servlet?action=5">5</a></li>
                <li><a href="/Shop/Servlet?action=6">6</a></li>
                <li><a href="/Shop/Servlet?action=7">7</a></li>
                <li><a href="/Shop/Servlet?action=8">8</a></li>
                <li><a href="/Shop/Servlet?action=9">9</a></li>
                <li><a href="/Shop/Servlet?action=10">10</a></li>
                <li><a href="/Shop/Servlet?action=m" rel="next">次へ</a></li>
                </ul>

                <br>
				<a href="/Shop/Servlet?action=mente">メニューへ戻る</a>
            </nav>
		</div>
	</body>
</html>