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
    <link rel="stylesheet" href="css/register2.css">
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
            <h1>決済画面</h1>
            <p class="select">決済方法を選択してください</p>
            <div class="pay-select">
                <form method="post" action="">
                    <div class="visa">
                        <input type="radio" name="q1" value="visa" class="visa-name"> Visa<br>
                    </div>
                    <div class="visa-detail">
                        <p>
                            <label for="uid">カード名義人:</label>
                            <input type="text" name="userid" id="uid" placeholder="YAMADA TARO" />
                        </p>
                        <p>
                            <label for="num">カード番号:</label>
                            <input type="text" name="text" id="text" placeholder="1234567899" />
                        </p>
                        <p>
                            <label for="date">有効期限:</label>
                            <input type="text" name="date" id="date" placeholder="20230512" />
                        </p>
                    </div>
                    <div class="conbini">
                        <input type="radio" name="q1" value="conbini"> コンビニ決済<br>
                    </div>
                    <div class="daibiki">
                        <input type="radio" name="q1" value="daibiki" > 代金引換<br>
                    </div>
                </form>
            </div>
            <form method="post" action="/Shop/Main?action=confirm">
            	<h1 class="delivery">配送オプション</h1>
        	    <p class="delivery-select">ご希望の配送日を選択してください</p>
    	       	 <input type="date" name="delivery_date" value="today" required="required" min="today"><strong> 必須</strong>
	            <p class="delivery-date">ご希望の配送先を入力してください</p>
                	<select name="address1" class="pref-name" required="required">
	                    <option value="" selected>都道府県</option>
	                    <option value="北海道">北海道</option>
	                    <option value="青森県">青森県</option>
	                    <option value="岩手県">岩手県</option>
	                    <option value="宮城県">宮城県</option>
	                    <option value="秋田県">秋田県</option>
	                    <option value="山形県">山形県</option>
	                    <option value="福島県">福島県</option>
	                    <option value="茨城県">茨城県</option>
	                    <option value="栃木県">栃木県</option>
	                    <option value="群馬県">群馬県</option>
	                    <option value="埼玉県">埼玉県</option>
	                    <option value="千葉県">千葉県</option>
	                    <option value="東京都">東京都</option>
	                    <option value="神奈川県">神奈川県</option>
	                    <option value="新潟県">新潟県</option>
	                    <option value="富山県">富山県</option>
	                    <option value="石川県">石川県</option>
	                    <option value="福井県">福井県</option>
	                    <option value="山梨県">山梨県</option>
	                    <option value="長野県">長野県</option>
	                    <option value="岐阜県">岐阜県</option>
	                    <option value="静岡県">静岡県</option>
	                    <option value="愛知県">愛知県</option>
	                    <option value="三重県">三重県</option>
	                    <option value="滋賀県">滋賀県</option>
	                    <option value="京都府">京都府</option>
	                    <option value="大阪府">大阪府</option>
	                    <option value="兵庫県">兵庫県</option>
	                    <option value="奈良県">奈良県</option>
	                    <option value="和歌山県">和歌山県</option>
	                    <option value="鳥取県">鳥取県</option>
	                    <option value="島根県">島根県</option>
	                    <option value="岡山県">岡山県</option>
	                    <option value="広島県">広島県</option>
	                    <option value="山口県">山口県</option>
	                    <option value="徳島県">徳島県</option>
	                    <option value="香川県">香川県</option>
	                    <option value="愛媛県">愛媛県</option>
	                    <option value="高知県">高知県</option>
	                    <option value="福岡県">福岡県</option>
	                    <option value="佐賀県">佐賀県</option>
	                    <option value="長崎県">長崎県</option>
	                    <option value="熊本県">熊本県</option>
	                    <option value="大分県">大分県</option>
	                    <option value="宮崎県">宮崎県</option>
	                    <option value="鹿児島県">鹿児島県</option>
	                    <option value="沖縄県">沖縄県</option>
	                </select>
	            <%if(account == null) { %>
	            	<p>
	                    <label class="addres">市町村区</label><br>
	                    	<input type="text" name="address2" class="addres-input" required="required"><br>
	                    <label class="addres">番地</label><br>
	                    	<input type="text" name="address3" class="addres-input" required="required">
                	</p>
	            <% } else { %>
                <p>
                    <label class="addres">市町村区</label><br>
                    	<input type="text" name="address2" class="addres-input" value="<%=account.getAddress2() %>" required="required"><br>
                    <label class="addres">番地</label><br>
                    	<input type="text" name="address3" class="addres-input" value="<%=account.getAddress3() %>" required="required"><br>
                    <label class="addres-name addres">建物名・号室</label><br>
                    	<input type="text" name="address4" class="addres-input" value="<%=account.getAddress4() %>">
                </p>
                <p>
                </p>
                <% } %>
                <input class="submit" type="submit" value="登録">
                <input type="reset" value="リセット">
            </form>


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