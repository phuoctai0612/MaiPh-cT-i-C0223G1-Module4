<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/19/2023
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="emailinbox" action="edit" method="post">
    <p>Languages: </p> <span><form:select path="languages" items="${languagesArray}"/></span>
    <br>
    pageSizes:
    <span>Show</span>
    <form:select path="pageSize" items="${pagesizeArray}"/>
    <span> emails per page</span>
    <br>
    Spam filter: </th>
    <form:checkbox path="spamsFilter"/>
    <span> Enable spams filter</span>
    <br>
    Signature:
    <form:textarea path="signature"/>
    <br>
    <form:hidden path="id"/>
    <button type="submit">Edit</button>
</form:form>
</body>
</html>
