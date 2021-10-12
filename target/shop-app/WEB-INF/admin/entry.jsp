<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style2.css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>商品登録</title>
		<!-- <link rel="stylesheet"  href="css/style.css" > -->

	</head>
	<body>
        <header><a href="/Shop/Main"><img class="headLink" src="images/logo.jpg" alt="Shop"></a>
        </header>
		<div class="inner">
            <div class="box">
            <span class="sample1d">商品登録</span>
            </div>
			<nav class="p">
				登録する商品情報を入力してください<br><br>

                <form  action="/Shop/Servlet" method="post" enctype="multipart/form-data">

                <table border="1">
                <tr>
                    <th>商品名：</th>
                    <td><textarea id="textarea" name="productName" style="width:100%;" cols="50" maxlength="50" rows="1"spellcheck="true" placeholder="50文字以内でお願いします"></textarea></td>
                </tr>
                <tr>
                    <th>カテゴリー：</th>
                    <td>

                        <select name="cateCode" class="left">
                            <option value="">（カテゴリーを選択してください）</option>
                            <option value="1">メンズ・トップス</option>
                            <option value="2">メンズ・ボトムス</option>
                            <option value="3">メンズ・インナー</option>
                            <option value="4">メンズ・靴</option>
                            <option value="5">メンズ・その他</option>
                            <option value="6">レディース・トップス  </option>
                            <option value="7">レディース・ボトムス</option>
                            <option value="8">レディース・インナー</option>
                            <option value="9">レディース・靴</option>
                            <option value="10">レディース・その他</option>
                            <option value="11">キッズ・トップス  </option>
                            <option value="12">キッズ・ボトムス</option>
                            <option value="13">キッズ・インナー</option>
                            <option value="14">キッズ・靴</option>
                            <option value="15">キッズ・その他</option>



                            </select>
                    </td>

                </tr>
                    <tr>
                    <th>サイズ：</th>
                    <td>

                        <select name="size"class="left">
                        <option value="">（サイズの選択）</option>

                        　<optgroup label="・服のサイズ">

                            <option value="70cm">70cm</option>
                            <option value="80cm">80cm</option>
                            <option value="90cm">90cm</option>
                            <option value="100cm">100cm</option>
                            <option value="110cm">110cm</option>
                            <option value="120cm">120cm</option>
                            <option value="130cm">130cm</option>
                            <option value="140cm">140cm</option>
                            <option value="150cm">150cm</option>
                            <option value="S">S</option>
                            <option value="M">M</option>
                            <option value="L">L</option>
                            <option value="XL">XL</option>
                            <option value="XXL">XXL</option>
                           </optgroup>

						 <optgroup label="・靴のサイズ">

                            <option value="11.5cm">11,5cm</option>
                            <option value="12cm">12cm</option>
                            <option value="12.5cm">12,5cm</option>
                            <option value="13cm">13cm</option>
                            <option value="13.5cm">13,5cm</option>
                            <option value="14cm">14cm</option>
                            <option value="14.5cm">14,5cm</option>
                            <option value="15cm">15cm</option>
                            <option value="15.5cm">15,5cm</option>
                            <option value="16cm">16cm</option>
                            <option value="16.5cm">16,5cm</option>
                            <option value="17cm">17cm</option>
                            <option value="17.5cm">17,5cm</option>
                            <option value="18cm">18cm</option>
                            <option value="18.5cm">18,5cm</option>
                            <option value="19cm">19cm</option>
                            <option value="19.5cm">19,5cm</option>
                            <option value="20cm">20cm</option>
                            <option value="20.5cm">20,5cm</option>
                            <option value="21cm">21cm</option>
                            <option value="21.5cm">21,5cm</option>
                            <option value="22cm">22cm</option>
                            <option value="22.5cm">22,5cm</option>
                            <option value="23cm">23cm</option>
                            <option value="23.5cm">23,5cm</option>
                            <option value="24cm">24cm</option>
                            <option value="24.5cm">24,5cm</option>
                            <option value="25cm">25cm</option>
                            <option value="25.5cm">25,5cm</option>
                            <option value="26cm">26cm</option>
                            <option value="26.5cm">26,5cm</option>
                            <option value="27cm">27cm</option>
                            <option value="27.5cm">27,5cm</option>
                            <option value="28cm">28cm</option>
                            <option value="28.5cm">28,5cm</option>
                            <option value="29cm">29cm</option>
                            <option value="29.5cm">29,5cm</option>
                            <option value="30cm">30cm</option>
                           </optgroup>
                        </select>
                    </td>

                </tr>
                    <tr>
                    <th>商品詳細</th>
                        <td>
                            <textarea id="textarea2" name="productDetails" style="width:100%;" cols="100" rows="10" maxlength="200"spellcheck="true" placeholder="200文字以内でお願いします"></textarea>
                        </td>
                    </tr>
                <tr>
                    <th>価格：</th>
                    <td><input type="number" name="price" class="left" max="99999999" min="100" placeholder="円">

                    </td>


                </tr>

                <tr>
                    <th>在庫数：</th>
                    <td><input type="number" name="stock" class="left" max="999" min="1"></td>
                </tr>
                </table><br>

				商品画像<br>
				(利用できる画像：jpeg/png)<br>
                     <input type="file" name="imagesPass" accept="image/jpeg,image/png" onchange="previewImage(this);"><br>
                     <input type="file" name="imagesPass2" accept="image/jpeg,image/png" onchange="previewImage(this);"><br>
                     <input type="file" name="imagesPass3" accept="image/jpeg,image/png" onchange="previewImage(this);"><br>

				<p>
				Preview:<br>
				<img id="preview" src="data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw==" style="max-width:150px;">
				</p>

				<script>
				function previewImage(obj)
				{
					var fileReader = new FileReader();
					fileReader.onload = (function() {
						document.getElementById('preview').src = fileReader.result;
					});
					fileReader.readAsDataURL(obj.files[0]);
				}
				</script>

                <ul id="uplist">
                </ul>
                <a href="/Shop/Servlet?action=mente">メニューへ戻る</a>

                <input type="submit"class="button2" value="登録">
                <input type="hidden" name="action" value="entryEnd">
            	</form>
            </nav>
		</div>

	</body>
</html>