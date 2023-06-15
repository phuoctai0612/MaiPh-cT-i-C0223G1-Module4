<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
</h1>
<br/>
<form action="/calculator" method="post">
    <input type="text" placeholder="Nhập số xiền USD" name="usd" pattern="[0-9]{1,}" title="Nhập đúng định dạng số"
           required>
    <input type="text" placeholder="Nhập tỉ giá" name="tiGia" pattern="[0-9]{1,}" title="Nhập đúng định dạng số"
           required>
    <button type="submit">Tính tiền</button>
</form>
<div style="padding-top: 30px">
    <input type="text" placeholder="Số VNĐ nhận được" value="${usd}" readonly>
</div>
</body>
</html>