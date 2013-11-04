<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Hello World</title>
</head>
<body>

<h1>Session Hijacking Example</h1>

<form method="post" action="hijack" >
	<input type="text" name="message" value="öäö" />
	<input type="submit"/>
</form>


<p><a href="hijack">View</a></p>
</body>
</html>