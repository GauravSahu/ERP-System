<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
       <%@ page import="java.sql.*"%>
   <%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hi
<%
String connectionURL="jdbc:mysql://localhost:3306/ierp?user=root&password=root";
Connection  con = null;
try
{
	PrintWriter pw  = response.getWriter();
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	//pw.println("hi");
	con = DriverManager.getConnection(connectionURL,"root","root");
	Statement st1 = con.createStatement();
	ResultSet rs1 = st1.executeQuery("select companylogo from companymaster where companyid='3'");
	String imgLen = "";
	if(rs1.next())
	{
		imgLen=rs1.getString(1);
		System.out.println("imglen"+imgLen.length());
	}
	rs1 = st1.executeQuery("select companylogo from companymaster where companyid='3'");
	if(rs1.next())
	{
		int len = imgLen.length();
		byte [] rb = new byte[len];
		InputStream readImg = rs1.getBinaryStream(1);
		System.out.println(readImg);
		int index = readImg.read(rb,0,len);
		System.out.println("index "+index);
		
		st1.close();
		response.reset();
	
	    
	    response.getOutputStream().write(rb,0,len);
	    response.getOutputStream().flush();
	}
}
catch (IllegalStateException e)
{
	// TODO: handle exception
	e.printStackTrace();
	out.println(e);
	System.out.println(e);
}
%>
</body>
</html>