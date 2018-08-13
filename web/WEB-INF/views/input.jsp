<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 黄杰
  Date: 2018/7/31
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Input</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
    <c:if test="${employee.id==null}">
        LastName: <form:input path="lastName"/>
    </c:if>
<c:if test="${employee.id!=null}">
    <form:hidden path="id"/>
    <input type="hidden" name="_method" value="PUT"/>
</c:if>

    <br>
    Email: <form:input path="email"/>
    <br>
    <%
        Map<String,String> genders=new HashMap<>();
        genders.put("1","Male");
        genders.put("0","Female");
        request.setAttribute("genders",genders);
    %>
    Gender: <form:radiobuttons path="gender" items="${genders}"/>
    <br>
    Birth: <form:input path="birth"/>
    <br>
    Department: <form:select path="department.id"
                             items="${departments}" itemLabel="departmentName" itemValue="id"/>
    <INPUT TYPE="submit" VALUE="submit">
</form:form>
</body>
</html>
