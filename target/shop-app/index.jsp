<%@page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Account account = (Account) session.getAttribute("account");
List<Product> list = (List<Product>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="utf-8">
<title>ショッピングサイト</title>
<meta name="description" content="サイトキャプションを入力">
<meta name="keywords" content="サイトキーワードを,で区切って入力">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/index4.css">
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
		<div class="category">

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

	<div class="item-wrapper">
		<div class="popular-category">
			<h2>人気のカテゴリー</h2>
			<a class="category-name">メンズ・トップス</a> <a class="category-name">メンズ・ボトムス</a> <a
				class="category-name">レディース・トップス</a> <a class="category-name">レディース・ボトムス</a>
		</div>

		<%if(list==null) {%>
		<div class="back">
			<a href="/Shop/Main" class="back">ホームへ</a>
		</div>
		<%}else { %>
			<!-- javascriptのテスト -->
			<div class="container">
				<div class="top">
					<div class="title">
						<h3>おすすめ商品</h3>
					</div>

					<div class="more">
						<a href="/Shop/Main?action=more"> もっと見る<svg width="16" height="16"
								fill="#0095ee" fill-rule="evenodd" viewBox="0 0 24 24"
								aria-hidden="true" class="style_right__2qI2e">
	                            <path
									d="M9,19a.7.7,0,0,1-.49-.2.69.69,0,0,1,0-1l5.62-5.63a.28.28,0,0,0,.09-.21.27.27,0,0,0-.09-.2L8.6,6.19a.7.7,0,1,1,1-1l5.58,5.58A1.71,1.71,0,0,1,15.66,12a1.73,1.73,0,0,1-.49,1.2L9.54,18.8A.74.74,0,0,1,9,19Z">
	                            </path>
	                        </svg>
						</a>
					</div>
				</div>
			</div>
			<div class="items">
				<%for(Product p:list){ %>
					<div class="item">
						<a href="/Shop/Main?id=<%=p.getCode() %>">
							<img src="upload/<%=p.getImages_pass() %>" height="350px" width="300px">
							<p><%=p.getName() %></p>
							<p><%=p.getPrice() + "円" %></p>
						</a>
					</div>
				<% } %>
			</div>

			<div class="container">
				<div class="top">
					<div class="title">
						<h3>新着商品</h3>
					</div>

					<div class="more">
						<a href="/Shop/Main?action=more"> もっと見る<svg width="16" height="16"
								fill="#0095ee" fill-rule="evenodd" viewBox="0 0 24 24"
								aria-hidden="true" class="style_right__2qI2e">
	                            <path
									d="M9,19a.7.7,0,0,1-.49-.2.69.69,0,0,1,0-1l5.62-5.63a.28.28,0,0,0,.09-.21.27.27,0,0,0-.09-.2L8.6,6.19a.7.7,0,1,1,1-1l5.58,5.58A1.71,1.71,0,0,1,15.66,12a1.73,1.73,0,0,1-.49,1.2L9.54,18.8A.74.74,0,0,1,9,19Z">
	                            </path>
	                        </svg>
						</a>
					</div>
				</div>
			</div>

			<div class="items">
			<%for(Product p:list){ %>
				<div class="item">
					<a href="/Shop/Main?id=<%=p.getCode() %>">
						<img src="upload/<%=p.getImages_pass() %>" height="350px" width="300px">
						<p><%=p.getName() %></p>
						<p><%=p.getPrice() + "円" %></p>
					</a>
				</div>
			<% } %>
			</div>

			<div class="back">
				<p id="page-top">
					<a href="/Shop/Main">Page Top</a>
				</p>
			</div>
		</div>
		<%} %>

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