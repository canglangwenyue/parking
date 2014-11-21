<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>停车场车位信息检索系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  <frameset rows="23%,*,25" cols="*" framespacing="0" frameborder="no" border="0">
	<frame src="top.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame">
	<frame src="parking.jsp" name="mainFrame" id="mainFrame">
 </frameset>
  <noframes>
  	<body>
	</body>
</noframes>
</html>
