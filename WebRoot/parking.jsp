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
   <title>ͣ������λ��Ϣ����ϵͳ</title>
</head>
<body>
	<hr>
	<table border=1 width="100%" text-align="center">
		<tr>
			<td align="center">��λ���</td>
			<td align="center">����ʱ��</td>
			<td align="center">�뿪ʱ��</td>
			<td align="center">����β��</td>
			<td align="center">˽�˳�λ</td>
			<td align="center">�Ƿ�ռ��</td>
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
				out.println("<td>" + "��δ����" + "</td>");
				out.println("<td>" + "��δ����" + "</td>");
				out.println("<td>" + "��δ����" + "</td>");
				out.println("<td>" + "��δ����" + "</td>");
				out.println("<td>" + rst.getString("status") + "</td>");
				out.println("</tr>");
			}
			//�ر����ӣ��ͷ���Դ
			rst.close();
			stmt.close();
			con.close();
		%>
	</table>
</body>
</html>
