<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<c:set var="req" value="${pageContext.request}" />
<base href="${fn:replace(req.requestURL, req.requestURI, req.contextPath)}/" />
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="root" value="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}" />
<c:set var="base" value="${fn:substring(root, 6, fn:length(root))}" />
<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
<link rel="stylesheet" href="${baseURL}/resources/assets/bootstrap-3.3.4/css/bootstrap.min.css">