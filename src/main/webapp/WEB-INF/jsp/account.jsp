<%@page import="java.util.*,model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Account account = (Account) session.getAttribute("account");
%>
<!DOCTYPE html>
<html lang="ja">

<head>
    <meta charset="utf-8">
    <title>ショッピングサイト</title>
    <meta name="description" content="サイトキャプションを入力">
    <meta name="keywords" content="サイトキーワードを,で区切って入力">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/account.css">
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
    <main>
        <div class="item-wrapper">
            <div class="popular-category">
                <h2>ユーザー情報変更画面</h2>
                <a class="category-name" href="/Shop/Main?action=account">ユーザー情報変更</a>
                <a class="category-name" href="/Shop/Main?cart=<%=account.getId()%>">カート内を見る</a>
                <a class="category-name" href="/Shop/Main?purchasehistory=<%=account.getId()%>">購入履歴</a>
                <a class="category-name" href="/Shop/Main?action=logout">ログアウト</a>
            </div>
        </div>

        <!-- プロフィール -->
        <div class="item-wrapper detail">
            <div class="popular-category  profile">
                <h1>プロフィール</h1>
                <form action="/Shop/Main?action=account_update" method="post">
	                <div class="info">
	                    <label>ユーザーID</label><br>
	                    <input type="text" name="user_id" class="info-text" value=<%=account.getId() %> required="required">
	                </div>
	                <div class="info">
	                    <label>メールアドレス</label><br>
	                    <input type="text" name="email" class="info-text" value=<%=account.getEmail()%> required="required">
	                </div>
	                <div class="info">
	                    <label>電話番号</label><br>
	                    <input type="number" name="telnum" class="info-text" value=<%=account.getTelnum()%> required="required">
	                </div>
	                <div class="info">
	                    <label>都道府県</label><br>
	                    <input type="text" name="address1" class="info-text" value=<%=account.getAddress1()%> required="required">
	                </div>
	                <div class="info">
	                    <label>市区町村</label><br>
	                    <input type="text" name="address2" class="info-text" value=<%=account.getAddress2() %> required="required">
	                </div>
	                <div class="info">
	                    <label>番地</label><br>
	                    <input type="text" name="address3" class="info-text" value=<%=account.getAddress3() %> required="required">
	                </div>
	                <div class="info">
	                    <label>建物名</label><br>
	                    <input type="text" name="address4" class="info-text" value=<%=account.getAddress4() %>>
	                </div>
	                <p class="update-p">
	                	<button type="submit" class="update">更新</button>
	                </p>
                </form>
            </div>
            <div class="back">
                <a href="/Shop/Main">ホームへ</a>
            </div>
        </div>
    </main>

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