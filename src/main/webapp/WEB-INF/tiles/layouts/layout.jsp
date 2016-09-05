<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@   page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<tiles:insertAttribute name="head"/>
</head>
<body>
        <div><tiles:insertAttribute name="header" /></div>
        <div style="float:left;padding:1px;width:15%;"><tiles:insertAttribute name="menu" /></div>
        <div style="float:left;padding:10px;width:80%;border-left:1px solid blue;">
        <tiles:insertAttribute name="body" /></div>
        <div style="clear:both"><tiles:insertAttribute name="footer" /></div>

</body>
</html>