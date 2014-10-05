<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Previlege Page</title>
<link href="css/settings_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/homecalender.js"></script>
</head>
<body onload="goforit()" >
<div id="wraper">
<div id="header">
<div id="header1">

<a href="Logout.do"><img src="images/setting_logout.png" alt="logout" border="0" /></a>&nbsp;<a href="admhome.jsp"><img src="images/setting_home.png" alt="Home" border="0"  /></a>
</div><!--header1-->

<table width="1000" align="center" cellpadding="0" cellspacing="0" class="para">

<tr>
<td width="255" height="80"></td>
<td width="402"></td>
<td width="341"></td>
</tr>
<tr>
<td align="left" style="padding-left:20px;"> Welcome <%
			Object ob = (Object) session.getAttribute("username").toString();
			if (ob != null) {
		%> <%=ob%> <%
 	}
 %></td>
<td align="center"><img src="images/previlegecontrol.png"/></td>
<td align="right"><%=new java.util.Date()%></td>
</tr>
</table>



</div><!--header-->

<div id="content">

<logic:present name="msg">
<fieldset><legend><strong></strong></legend>
      <table border="0" width="100%" class="para">
				  <tr>
					<td align="left" ><font color="red"><bean:write name="msg"/></font></td>
				  </tr>
				  </table>
				  </fieldset>
				  </logic:present>
<fieldset ><legend><strong>Previlege Control</strong></legend>
				
              		 	<form action="<%=request.getContextPath()%>/previlege.do?action=save" method="post">
	                	<table class="para1" border="0" cellpadding="2" cellspacing="2" width="100%" style="table-layout: fixed;" align="center">
							<tr class="tdheader">
	                			<th width="13%"></th>
	                			<th width="11%">ADMIN</th>
	                			
	                			
	                		</tr>
	                		<logic:notEmpty name="previlegeList">
	                	<%
	                	String[] Names={"MASTER DATA","PAYROLL"};
	                
	                	int name_len=Names.length;
	                	for(int i=0;i<name_len;i++)
	                	{
	                	%>
						 
	                		<tr class="tdContent2">
	                		  <td align="left" style="color: black;"><font color="black"><%="&nbsp;"+Names[i]+ "&nbsp;&nbsp;&nbsp;"%></font></td>
	                			<logic:iterate id="list" name="previlegeList">
	                		 <bean:define id="fid"><bean:write name="list" property="functionId"/></bean:define>
	                			   <%int j=Integer.parseInt(fid);
	                			  // System.out.println(fid);
	                			   if(j==(i+1)){
	                			   %>
	                			     <logic:equal name="list" property="roleId" value="1">
	                			     <bean:define id="acess"><bean:write name="list" property="access"/></bean:define>
	                			   
	                			       <td align="center">
	                			       
	     	                	       <select name="admin" class="para1">
	                			         <%if(acess.equals("1")) {%><option value="1" selected="selected" >Read/Write</option><option value="2">Read Only</option> <option value="3">No Access</option>
	                			          <%} else if(acess.equals("2")) {%><option value="1" >Read/Write</option><option value="2" selected="selected">Read Only</option> <option value="3">No Access</option>
	                			          <%}else {%><option value="1">Read/Write</option><option value="2">Read Only</option> <option value="3" selected="selected">No Access</option>
	                			          <%} %>
	                			         </select>
	                			       </td>
	                			      </logic:equal>
	                			   
	                			
	                			     
	                			     
	                			      
	                		<%} %>
	                		</logic:iterate>
	                	   </tr>
	                	   
	                	  <%} %>
	                	
	                	</logic:notEmpty> 
	                	    <tr></tr><tr></tr>
	                		<tr>
	                		<td colspan="6" align="center"><input type="submit" name="btn" value="Save Changes" /></td>
	              			</tr>
	                			
	                	</table>
	                	</form>
	                	
	                	
	                	<logic:present name="previlegeList">
	                  <logic:empty name="previlegeList">
                		  <label> <font color="white">No Previlege is added yet.</font></label>
                	  </logic:empty>
                	  </logic:present>
                	
                </fieldset>
                </centre>
                <%for(int i=0;i<20;i++) {%>
      		<tr>
        		<td>
        			&nbsp;
        		</td>
      		</tr>
      		<% }%>  
      		</div>
   </div><!--content-->
</div><!--wraper-->

    <div style="clear:both;"> </div>

<div id="footer">
<p>Copyright © 2013 itech solutions. All rights reserved.</p>
</div><!--footer-->  		   		
      		
  </body>
  </html:html>    		
