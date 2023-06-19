<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show List Email</title>
</head>
<body>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Languages</th>
        <th>Page sizes</th>
        <th>Spams filter</th>
        <th>Signature</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${stringMap}" var="stringMap" varStatus="loop">
    <tr>
            <td><c:out value="${loop.count}" /></td>
            <td><c:out value="${stringMap.languages}"/></td>
            <td><c:out value="${stringMap.pageSize}"/></td>
            <c:if test="${stringMap.spamsFilter==false}">
                <td><c:out value="not spam"/></td>
            </c:if>
            <c:if test="${stringMap.spamsFilter==true}">
                <td><c:out value="spam"/></td>
            </c:if>
           <td><c:out value="${stringMap.signature}"/></td>
        <form action="showFormEdit" method="post">
            <input type="hidden" value="${stringMap.id}" name="id">
           <td><button type="submit">Edit</button></td>
        </form>
    </tr>
    </c:forEach>
</table>
</body>
</html>