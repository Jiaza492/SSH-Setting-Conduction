<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lift.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" rel="stylesheet" href="<%=path%>/css/style.css" />


  </head>
  
  <script type="text/javascript">
 function checktarget(id){

	 
	 if(${login==null}){
			document.getElementById(id).target = "_top";
		}else{
		    document.getElementById(id).target = "mainFrame";
			
		}
}
  </script>
 <body class="frame-bd">
 
 <ul class="left-menu">
    
	<li><a href="doListBill.action" id="listBill" onclick="checktarget('listBill');"><img src="<%=path%>/images/btn_bill.gif" /></a></li>
	<c:if test="${login.authentity eq '02'}"><li><a href="doListSupplier.action" id="listSupplier" onclick="checktarget('listSupplier');"><img src="<%=path%>/images/btn_suppliers.gif" /></a></li></c:if>
	<li><a href="doListUser.action" id="listUser" onclick="checktarget('listUser');"><img src="<%=path%>/images/btn_users.gif" /></a></li>
	<li><a href="doLogOut.action" target="_top"><img src="<%=path%>/images/btn_exit.gif" /></a></li>

 </ul>
 

</body>

</html>
