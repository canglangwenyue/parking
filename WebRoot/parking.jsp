<%@ page language="java" import="java.sql.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">
   <title>停车场车位信息检索系统</title>
</head>
<body>
	<hr>
	<table border=1 width="100%" text-align="center">
		<tr>
			<td align="center">车位编号</td>
			<td align="center">进入时间</td>
			<td align="center">离开时间</td>
			<td align="center">汽车尾号</td>
			<td align="center">私人车位</td>
			<td align="center">是否占用</td>
		</tr>
		<%
		
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			Connection con = java.sql.DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1/parking", "root", "bjx719519");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from parkData;");
			while (rst.next()) {
				out.println("<tr>");
				out.println("<td>" + rst.getString("address") + "</td>");
				out.println("<td>" + "暂未开放" + "</td>");
				out.println("<td>" + "暂未开放" + "</td>");
				out.println("<td>" + "暂未开放" + "</td>");
				out.println("<td>" + "暂未开放" + "</td>");
				out.println("<td>" + rst.getString("status") + "</td>");
				out.println("</tr>");
			}
			//关闭连接，释放资源
			rst.close();
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>
