<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品削除</title>
		<link rel="stylesheet" href="css/style2.css" >

	</head>
	<body>
        <header><a href="index.html"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">

            <div class="box">
            <span class="sample1d">商品削除</span>
            </div>
			<nav class="p">
            削除する商品を選択してください

            <form action="/Shop/Servlet" method="post">

                <table  border="1" >
                    <tr>
                        <th>登録日</th>
                        <th><u>商品一覧</u></th>
                        <th>カテゴリー</th>
                        <th>サイズ</th>
                        <th>価格</th>
                        <th>在庫</th>
                        <th> </th>

                    </tr>

                    <tr>
                        <td>2021/09/08</td>
                        <td>スニーカー</td>
                        <td>レディース・靴</td>
                        <td>27</td>
                        <td>5.500円</td>
                        <td>20</td>
                        <td><input type="submit" value="削除"></td><br>
                    </tr>

                    <tr>
                        <td>2021/09/08</td>
                        <td>ダウンジャケット</td>
                        <td>トップス</td>
                        <td>L</td>
                        <td>10.000円</td>
                        <td>30</td>
                    <td><input type="submit" onclick="location.href='deleteChoice.html'" value="削除"></td><br>

                    <tr>
                        <td>2021/09/08</td>
                        <td>カーディガン</td>
                        <td>トップス</td>
                        <td>M</td>
                        <td>4.400円</td>
                        <td>15</td>
                        <td><input type="submit" value="削除"></td><br>
                    </tr>

                    <tr>
                        <td>2021/09/08</td>
                        <td>シャツ</td>
                        <td>インナー</td>
                        <td>XL</td>
                        <td>2.500円</td>
                        <td>20</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                    <tr>
                        <td>2021/09/08</td>
                        <td>ワンピース</td>
                        <td>その他</td>
                        <td>S</td>
                        <td>9.200円</td>
                        <td>20</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                    <tr>
                        <td>2021/09/08</td>
                        <td>ブルゾン</td>
                        <td>トップス</td>
                        <td>M</td>
                        <td>12.300円</td>
                        <td>30</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                    <tr>
                        <td>2021/09/08</td>
                        <td>シャツ</td>
                        <td>インナー</td>
                        <td>L</td>
                        <td>1.500円</td>
                        <td>30</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                    <tr>
                        <td>2021/09/08</td>
                        <td>パーカー</td>
                        <td>インナー</td>
                        <td>S</td>
                        <td>6.000円</td>
                        <td>36</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                    <tr>
                        <td>2021/09/08</td>
                        <td>ポンチョ</td>
                        <td>その他</td>
                        <td>M</td>
                        <td>7.500円</td>
                        <td>10</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                    <tr>
                        <td>2021/09/08</td>
                        <td>スウェット</td>
                        <td>トップス</td>
                        <td>XXL</td>
                        <td>3.600円</td>
                        <td>50</td>
                        <td><input type="submit" value="削除"></td>
                    </tr>
                </table><br>
                <input type="hidden" name="action" value="updateEnd">
                </form>


                <ul class="example">
                <li>1</li>
                <li><a href="/page/2/">2</a></li>
                <li><a href="/page/3/">3</a></li>
                <li><a href="/page/4/">4</a></li>
                <li><a href="/page/5/">5</a></li>
                <li><a href="/page/6/">6</a></li>
                <li><a href="/page/7/">7</a></li>
                <li><a href="/page/8/">8</a></li>
                <li><a href="/page/9/">9</a></li>
                <li><a href="/page/10/">10</a></li>
                <li><a href="/page/2/" rel="next">次へ</li>
                </ul>

			<a href="/Shop/Servlet?action=mente">メニューへ戻る</a>
			</nav>
		</div>
	</body>
</html>