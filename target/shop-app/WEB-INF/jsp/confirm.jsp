<%@page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Account account = (Account) session.getAttribute("account");
	productInfo product = (productInfo)session.getAttribute("product");
	Address address = (Address)session.getAttribute("address");
	String quantity = (String)session.getAttribute("quantity");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="utf-8">
    <title>注文確定画面</title>
    <meta name="description" content="サイトキャプションを入力">
    <meta name="keywords" content="サイトキーワードを,で区切って入力">
    <link rel="stylesheet" href="css/confirmed2.css">
    <script src="sample.js"></script>
</head>

<body>
    <!----- ヘッダー ----->
    <header>
        <a href="/Shop/Main"><img src="logo/logo.png" class="logo"></a>
        <div class="header-top">
            <!-- キーワード検索 -->
			<form action="/Shop/Main?action=keyword" method="post">
				<input type="search" name="keyword" placeholder="何かお探しですか？"
					class="keyword">
				 <button class="search_button">
					<svg aria-hidden="true" width="16" height="16" viewBox="0 0 16 16"
						class="sc-brqgnP sc-cQFLBn ZnRMu">
                        <path fill="currentColor" fill-rule="nonzero"
							d="M11.435 10.063h-.723l-.256-.247a5.92 5.92 0 0 0 1.437-3.87 5.946 5.946 0 1 0-5.947 5.947 5.92 5.92 0 0 0 3.87-1.437l.247.256v.723L14.637 16 16 14.637l-4.565-4.574zm-5.489 0A4.111 4.111 0 0 1 1.83 5.946 4.111 4.111 0 0 1 5.946 1.83a4.111 4.111 0 0 1 4.117 4.116 4.111 4.111 0 0 1-4.117 4.117z">
                        </path>
                    </svg>
				</button>
			</form>
        </div>

        <!-- ハンバーガー -->
        <% if(account != null) { %>
		<div id="wrapper">
			<p class="btn-gnavi">
				<span></span> <span></span> <span></span>
			</p>
			<nav id="global-navi">
				<ul class="menu">
					<li><a href="account.html">ユーザー情報変更</a></li>
					<li><a href="/Shop/Main?cart=<%=account.getId()%>">カート内を見る</a></li>
					<li><a href="purchasehistory.html">購入履歴</a></li>
					<li><a href="/Shop/Main?action=logout">ログアウト</a></li>
				</ul>
			</nav>
		</div>
		<% } else { %>
		<div id ="wrapper">
			<p>
				<a class="login" href="/Shop/Main?action=login">ログインする</a>
			</p>
		</div>
		<% } %>
    </header>
    <!----- ヘッダー END ----->

    <!----- メインコンテンツ ----->
    <section class="item">
        <div class="detail">
            <h1>注文確定画面</h1>
            <p class="select">以下の内容で注文を確定しますか？</p>
	           <div class="button">
	            	<form action="/Shop/Main?action=complete" method="post">
	            		<input type="hidden" name="id" value=<%=account.getId() %>>
	            		<input type="hidden" name="delivery_date" value=<%=address.getDelivery_date() %>>
	            		<input type="hidden" name="address1" value=<%=address.getAddress1() %>>
	            		<input type="hidden" name="address2" value=<%=address.getAddress2() %>>
	            		<input type="hidden" name="address3" value=<%=address.getAddress3() %>>
	            		<input type="hidden" name="address4" value=<%=address.getAddress4() %>>
	            		<input type="hidden" name="product_code" value=<%=product.getProductCode() %>>
	            		<input type="hidden" name="product_price" value=<%=product.getPrice() %>>
	            		<input type="hidden" name="quantity" value=<%=quantity %>>
	            		<input type="submit" value="注文を確定する" class="item-buy-button">
	            	</form>
	            </div>

            <div class="price">
                <span class="price-total">ご請求額</span>
                <span class="item-price">￥<%=product.getPrice() * Integer.parseInt(quantity)%></span>
                <span class="item-tax">(税込)</span>
                <span class="item-shipping">送料込み</span>
            </div>

            <div class="address">
                <p class="title">お届け先住所</p>
                <div class="address-detail">
                    <p>お届け先：<%=address.getAddress1() %></p>
                    <p>お届け先：<%=address.getAddress2() %></p>
                    <p>お届け先：<%=address.getAddress3() %></p>
                    <p>お届け先：<%=address.getAddress4() %></p>
                    <p>お届け日：<%=address.getDelivery_date() %></p>
                </div>
            </div>

            <div class="address">
                <p class="title">商品の詳細</p>
                <div class="item-detail">
                    <p><%=product.getProductName() %></p>
                    <p><%=product.getProductDetails() %></p>
                    <p><%=quantity %>個</p>
                    <p>商品単価:\<%=product.getPrice() %></p>
                    <p><img src="upload/<%=product.getImagesPass() %>" height="350px" width="300px"></p>
                </div>
            </div>

            <div class="button">
            	<form action="/Shop/Main?action=complete" method="post">
            		<input type="hidden" name="id" value=<%=account.getId() %>>
            		<input type="hidden" name="delivery_date" value=<%=address.getDelivery_date() %>>
            		<input type="hidden" name="address1" value=<%=address.getAddress1() %>>
            		<input type="hidden" name="address2" value=<%=address.getAddress2() %>>
            		<input type="hidden" name="address3" value=<%=address.getAddress3() %>>
            		<input type="hidden" name="address4" value=<%=address.getAddress4() %>>
            		<input type="hidden" name="product_code" value=<%=product.getProductCode() %>>
            		<input type="hidden" name="product_price" value=<%=product.getPrice() %>>
            		<input type="hidden" name="quantity" value=<%=quantity %>>
            		<input type="submit" value="注文を確定する" class="item-buy-button">
            	</form>
            </div>
        </div>
        <div class="back">
            <a href="/Shop/Main" class="back">ホームへ</a>
        </div>
    </section>
    <!----- メインコンテンツ END ----->

    <!----- フッター ----->
    <footer>
        <p>ありがとうございました</p>
    </footer>
    <!----- フッター END ----->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/index.js"></script>
</body>

</html>