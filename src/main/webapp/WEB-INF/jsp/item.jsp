<%@page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Account account = (Account) session.getAttribute("account");
productInfo product = (productInfo) session.getAttribute("product");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="utf-8">
<title>ショッピングサイト</title>
<meta name="description" content="サイトキャプションを入力">
<meta name="keywords" content="サイトキーワードを,で区切って入力">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/item4.css">
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
					<li><a href="/Shop/Main?action=account">ユーザー情報変更</a></li>
					<li><a href="/Shop/Main?cart=<%=account.getId()%>">カート内を見る</a></li>
					<li><a href="/Shop/Main?purchasehistory=<%=account.getId()%>">購入履歴</a></li>
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
			<div class="title">
				<h1><%=product.getProductName()%></h1>
				<p><%=product.getProductDetails()%></p>
			</div>
			<div class="flex">
				<div class="image">
					<img src="upload/<%=product.getImagesPass()%>" height="350px"
						width="300px">
				</div>
				<div class="item-detail">
					<table>
						<tr>
							<th>カテゴリー</th>
							<td><%=product.getCateCode()%></td>
						</tr>
						<tr>
							<th>サイズ</th>
							<td><%=product.getSize()%></td>
						</tr>
						<tr>
							<th>登録日</th>
							<td><%=product.getEntryDate()%></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="price">
				<span class="item-price">\<%=product.getPrice()%></span> <span
					class="item-tax">(税込)</span> <span class="item-shipping">送料込み</span>
			</div>

			<div class="purchase">
				<%
				if (account == null) {
				%>
				<form action="/Shop/Main?action=regi2" method="post">
					<p>
						<input type="submit" value="レジに進む" class="item-buy-button">
					</p>
				</form>
				<%
				} else {
				%>
				<div class="favorite">
					<p>
						<form action="/Shop/Main?action=cart" method="post">
							<input type="hidden" name="user_id" value=<%=account.getId() %>>
							<input type="hidden" name="product_code" value=<%=product.getProductCode()%>>
							<input type="hidden" name="product_images_pass" value=<%=product.getImagesPass() %>>
							<input type="submit" value="カートに追加する" class=""><img src="logo/cart_hoso.svg"
							width="25px" height="25px" class="cart">
						</form>
					</p>
				</div>
				<p style="padding-top: 20px">個数を選択してください</p>
				<form action="/Shop/Main?action=regi" method="post">
					<select class="num" name="quantity" required="required">
						<option value="1" selected>1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
					</select>
					<p>
						<input type="submit" value="レジに進む" class="item-buy-button">
					</p>
				</form>
				<%
				}
				%>
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