<%@ page session="false" isErrorPage="true"%>

<html>
<head>
<title>ERROR 404</title>
</head>
<body>
<h1>ERROR 404: File Not Found</h1>
<code>${requestScope["javax.servlet.error.exception"]}</code>

<!--
Unless this text is here, if your page is less than 513 bytes, Internet Explorer will display it's "Friendly HTTP Error Message",
and your custom error will never be displayed.  This text is just used as filler.
This is a useless buffer to fill the page to 513 bytes to avoid display of Friendly Error Pages in Internet Explorer
This is a useless buffer to fill the page to 513 bytes to avoid display of Friendly Error Pages in Internet Explorer
This is a useless buffer to fill the page to 513 bytes to avoid display of Friendly Error Pages in Internet Explorer
-->

</body>
</html>