<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/include/head.jsp" %>
    <title>Main Page</title>
</head>
<body>
<div class="container">
    ${conference.name}
</div>
</body>
</html>
