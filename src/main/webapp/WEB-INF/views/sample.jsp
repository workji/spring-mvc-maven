<%--
  Created by IntelliJ IDEA.
  User: jxm
  Date: 2019/09/22
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
    <title><spring:message code="test.title"/></title>
</head>
<body>
<p>${receiveMsg}</p>
<p>Locale : ${locale}</p>
</body>
</html>
