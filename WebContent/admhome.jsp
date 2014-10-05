<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="javax.imageio.ImageWriter"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="org.apache.commons.io.FileUtils"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.Image"%>
<%@page import="javax.imageio.stream.ImageOutputStream"%>
<%@page import="org.apache.commons.io.IOUtils"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iERP- Home</title>
<link href="css/main_css.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
function timedRefresh(timeoutPeriod) {
	setTimeout("location.reload(true);",timeoutPeriod);
}
function edite()
{
	alert("testing");
}

window.history.forward();
function noBack() { window.history.forward(); }
</script>

<body onload="noBack();"  onpageshow="if (event.persisted) noBack();" onunload="">

<!--<body onload="JavaScript:timedRefresh(5000);">-->
<%
			Object ob1 = (Object) session.getAttribute("logo").toString();
			if (ob1 != null) {
		%>  <%
 	}
 %>
 
<%
	String connectionURL = "jdbc:mysql://localhost:3306/ierp?user=root&password=root";
	Connection con = null;
	try {
		//PrintWriter pw  = response.getWriter();
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		//pw.println("hi");
		con = DriverManager
				.getConnection(connectionURL, "root", "root");
		Statement st1 = con.createStatement();
		ResultSet rs1 = st1
				.executeQuery("select companylogo from companymaster where companyid="+ob1);
		String imgLen = "";
		if (rs1.next()) {
			imgLen = rs1.getString(1);
			System.out.println("imglen" + imgLen.length());
		}
		rs1 = st1.executeQuery("select companylogo from companymaster where companyid="+ob1);
		System.out.println(ob1);
		if (rs1.next()) {
			int len = imgLen.length();
			byte[] rb = new byte[len];
			InputStream readImg = rs1.getBinaryStream(1);
			System.out.println(readImg);
			int index = readImg.read(rb, 0, len);
			System.out.println("index " + index);
			
			
			st1.close();
			FileOutputStream stream=new FileOutputStream(new File("G:\\iERP_PROJECT\\iERP\\WebContent\\images\\test.jpg"));
			stream.write(rb,0,len);  
			stream.flush();
			stream.close();

		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		out.println(e);
		System.out.println(e);
	}
%>

<div id="main" align="center"><!--main div starts from here-->
<div id="header1">

<div id="header_logo">


<img alt="" src="<%=request.getContextPath()%>/images/test.jpg" width="145px" height="65px">

</div>
<!-- header_logo -->
<div id="header_menus1"> <a href="Logout.do"
	style="text-decoration: none;"><img src="images/logout2.png"
	border="0" /></a></div>
</div>
<div id="content_about"><!--content from here-->
<div id="content_user">

<table width="1010" height="45" style="margin-top: 10px;">

	<tr height="15px">
		<td colspan="6"></td>
	</tr>
	
	<tr>
 <html:form action="Login.do?action=home1" method="post" > 
	<td width="208" height="39" class="text4">SCode :&nbsp;
		  <input type="text" value="" name="scode" id="scode" style="width:50px; height:15px; background-color:#d1b4dc;">&nbsp;
		  <input type="submit" value="" name="submit"  onclick="edite()" style="background:url(images/ok.png); background-repeat:no-repeat; cursor:pointer; height:27px; width:27px; border:none;" ></td>   
</html:form>	   
	  
		<td width="400" height="39" class="text4">Date & Time :<%=new java.util.Date()%></td>

		<td width="400" class="text4"></td>

		<td width="80" class="text4">User :</td>
		<td width="46" class="text4">
		<%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %>
 
 	
		</td>
	
		<td width="60">&nbsp;</td>
	</tr>
	
</table>


</div>
<div id="content_user2">

<div id="content_user3">
<table width="175" height="332">
	<tr>
		<td height="56">
		<p class="text5">USER MENU</p>
		<hr color="#6474b4" />
		</td>
	</tr>
	<tr>
		<td height="28"></td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table></div>
<div id="content_user4">
<table width="580" height="476" align="center">


    <tr>
		<td height="65" colspan="3"><p class="text5"> MAIN MENU</p><hr color="#6474b4" /></td>
	</tr>
	
	<tr>
		<td  align="center"><a href="inventory.jsp"><img
			src="images/Inventory1.png" border="0" /></a></td>
		<td  align="center"><a href="payroll.jsp"><img
			src="images/Payroll.png" border="0" /></a></td>
		<td  align="center"><a href="account.jsp"><img
			src="images/Accounting.png" border="0" /></a></td>
			
	</tr>

	
	<tr>

	<td align="center"><a href="settings.jsp"><img
			src="images/Settting1.png" border="0" /></a></td>
		<td  align="center"><a href="sales.jsp"><img
			src="images/Sales1.png" border="0" /></a></td>
		<td  align="center"><a href="reports.jsp"><img
			src="images/Report1.png" border="0" /></a></td>
	</tr>
	<tr >
		<td></td>
		<% if(session.getAttribute("masterData")!=null){
long access= (Long) session.getAttribute("masterData");
if(access!=3){
	
System.out.println("Access in jsp "+access);
%>
		<td align="center"><a href="masterdata.jsp"><img
			src="images/masterdata.png" border="0" /></a></td>
		<td></td>
		<%}} %>
	</tr>
</table>
</div>
<div id="content_user5">
<table width="185" height="332">
	<tr>
		<td height="56">
		<p class="text5">QUICK LINKS</p>
		<hr color="#6474b4" />
		</td>
	</tr>
	<tr>
		<td height="28"></td>
	</tr>
	<tr>
		<td></td>
	</tr>
</table>
</div>


</div>
<!--content till here--></div>


<div id="footer">
<div id="menus_copyright">Copyrights&copy; 2013, Itech solutions, All Rights
Reserved.</div>
<div id="menus_footer">
<table>
	<tr>

		<td width="29"><a href="#"><img src="images/ierp_twt.PNG"
			border="0" /></a></td>

		<td width="29"><a href="#"><img src="images/ierp_fb.PNG"
			border="0" /></a></td>

		<td width="29"><a href="#"><img src="images/ierp_u.PNG"
			border="0" /></a></td>
	</tr>

</table>
</div>
</div>
<!--main div starts from here--></div>
</body>
</html>