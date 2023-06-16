<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculation" method="post">
    <fieldset>
        <legend>Tính toán</legend>
        <input type="text" placeholder="Nhập giá trị" name="param1">
        <select name="calculations">
            <option value="">Phép tính</option>
            <option value="+">Cộng</option>
            <option value="-">Trừ</option>
            <option value="*">Nhân</option>
            <option value="/">Chia</option>
        </select>
        <input type="text" placeholder="Nhập giá trị" name="param2">
        <button type="submit">Tính</button>
    </fieldset>
</form>
${result}
</body>
</html>