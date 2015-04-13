<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />

  </head>
  
  <body>
    <div id="header">
	<div class="title"></div>
	<div class="welcome">欢迎您：<c:if test="${login.authentity eq '02'}">管理员  </c:if><c:if test="${login.authentity eq '01'}">用户 </c:if>${login.userName}</div>
</div>
  </body>
</html>
