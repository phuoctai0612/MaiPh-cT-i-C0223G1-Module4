<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
</h1>
<br/>
<form action="/calculator" method="get">
<input type="number" placeholder="Nhập số xiền USD" name="usd">
    <input type="number" placeholder="Nhập tỉ giá" name="tigia">
<button type="submit">Tính tiền</button>
</form>
<div style="padding-top: 30px">
<input type="text" placeholder="Số VNĐ nhận được" value="${usd}" readonly>
</div>
</body>
</html>