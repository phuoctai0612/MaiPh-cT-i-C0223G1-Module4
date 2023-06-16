<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/getSpice" method="post">
    <label>
        <input value="Lettuce" name="spice" type="checkbox">Lettuce
    </label>
    <label>
        <input value="Tomato" name="spice" type="checkbox">Tomato
    </label>
    <label>
        <input value="Mustard" name="spice" type="checkbox">Mustard
    </label>
    <label>
        <input value="Sprouts" name="spice" type="checkbox">Sprouts
    </label>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Save</button>
        </div>
    </div>
</form>
<c:if test="${listSpice!=null}">
    Số gia vị bạn lựa cho Sandwich là: <span>${listSpice} </span>
</c:if>
<c:if test="${message!=null}">
    <p style="color: red">${message} </p>
</c:if>
</body>
</html>