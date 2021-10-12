<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
<%
	List<Product> list=(List<Product>)request.getAttribute("list");
	String msg=(String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container{
padding-top:20px;
padding-bottom:60px;
}
td>img{
width:200px;
}
input.form-control,
.alert{{
	width:500px;
}
table.table{
	width:70%;
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<a href="/Shop/Main" class="btn btn-outline-info btn-sm float-right">公開ページを見る</a><br><br>
<% if(msg != null){ %>
<div class="alert alert-success" role="alert">
<%=msg %>
</div>
<%} %>
<form class="mt-3" action="/Shop/Admin" method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="category_code">カテゴリーコード</label><br>
<select name="category_code" required="required">
  <option value="1">メンズ・トップス</option>
  <option value="2">メンズ・ボトムス</option>
  <option value="3">メンズ・インナー</option>
  <option value="4">レディース・トップス</option>
  <option value="5">レディース・ボトムス</option>
  <option value="6">レディース・インナー</option>
</select>
</div>
<div class="form-group">
<label for="name">商品名</label>
<input type="text" name="name" id="name" class="form-control" placeholder="商品名を入力" required>
</div>
<div class="form-group">
<label for="size">サイズ</label>
<input type="radio" name="size" value="S" required="required"/>S
<input type="radio" name="size" value="M" />M
<input type="radio" name="size" value="L" />L
</div>
<div class="form-group">
<label for="price">価格</label>
<input type="number" name="price" id="price" class="form-control" step="10" placeholder="価格を入力" required>
</div>
<div class="form-group">
<label for="stock">在庫数</label>
<input type="number" name="stock" id="stock" class="form-control" step="10" placeholder="在庫数を入力" required>
<div class="form-group">
<label for="details">詳細</label>
<input type="text" name="details" id="details" class="form-control" placeholder="詳細を入力" required>
</div>
</div>
<div class="form-group">
<label for="images_pass">商品画像</label>
<input type="file" name="images_pass" class="form-control" id="images_pass">
</div>
<button type="submit" class="btn btn-primary">登録</button>
</form>
<% if(list != null && list.size()>0){ %>
<table class="table table-bordered mt-5">
<%for(Product d:list){ %>
<tr>
<td><img src="/Shop/upload/<%=d.getImages_pass()%>" ></td>
<td><%=d.getCode() %></td>
<td><%=d.getName() %></td>
<td><%=d.getPrice() %></td>
<td>
<a href="/Shop/AdminUpdate?id=<%=d.getCode() %>">更新</a>
</td>
<td>
<a href="/Shop/AdminDelete?id=<%=d.getCode() %>" onclick="return confirm('削除してよろしいですか？')">削除</a>
</td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>