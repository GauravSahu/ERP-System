<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.sql.*"%>
<%@page import="com.itech.iERP.utils.ConnectionUtil"%>
<%@page import="com.itech.iERP.forms.LoginForm;" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Documents</title>
<link href="css/MasterData_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">        
window.history.forward();
function noBack() { window.history.forward(); }

function update123() 
{  
	 var file1=document.getElementById("txtFile").value;
	 var x = document.getElementById('userid').options[document.getElementById('userid').selectedIndex].value;
	 alert(x);
	 var y = document.getElementById('filetype').options[document.getElementById('filetype').selectedIndex].value;
	 alert(y);
   
	// if(x==-1){
		 //alert("Please select user name!");
		//return false;
	//}
	 
	 if(file1.length==""){
		 alert("Please select a file!");
		return false;
	}
	
	
	 
	 document.forms[0].action= "/iERP/Jsp/multiaudioprocess.jsp?userid="+x+"&filetype="+y;
	 //document.forms[0].action= "/Hayagriva/jsp/multiaudioprocess.jsp?userid="+x;
	 document.forms[0].submit();
	
}

window.history.forward();
function noBack() { window.history.forward(); }


</script>
<script type="text/javascript">
 
 function invoke(abc)
 {
 
  if(abc==1) document.addphotoform.action="addphotoupload.jsp";
  if(abc==2) {
	  document.addphotoform.action="addphoto.jsp";
	}
	 }
 function validate(){
	 var file1=document.getElementById("txtFile").value;
	 var file2=document.getElementById().value;

	 if(file2.length==""){
		 alert("Please select user name");
		return false;
	}
	 
	 if(file1.length==""){
		 alert("Please select a file");
		return false;
	}  
	  	
 	document.addphotoform.eventDesc.value=document.addphotoform.eventDesc.value.replace(/&/g, "&amp;").replace(/>/g, "&gt;").replace(/</g, "&lt;").replace(/"/g, "&quot;").replace(/'/g,"&acute;");
    checkenter();
    return true;
    
}
 
function checkenter(){
	String.prototype.trim = function() {
	    return this.replace(/^\s+|\s+$/g,"");
	};
	var input=document.addphotoform.photoCaption.value.trim();
	var output=document.addphotoform.photoCaption.value;
    output="";
    var k=input.length;
    for (var i = 0; i < k; i++){	
		if (input.charCodeAt(i) == 10){
		      output +="<BR/>";
		}else{			
		      output += input.charAt(i);
			}
		}
	document.addphotoform.photoCaption.value=output;
}
function replacesp1(){	
	document.addphotoform.eventHeader.value=document.addphotoform.eventHeader.value.replace(/&/g, "&amp;").replace(/>/g, "&gt;").replace(/</g, "&lt;").replace(/"/g, "&quot;");
	return true;
}
function addRowInnerHTML(tblId){
	var tblBody = document.getElementById(tblId).tBodies[0];
		var newRow = tblBody.insertRow(-1);
		var newCell0 = newRow.insertCell(0);
		newCell0.innerHTML = '<input  name="photoghaph1" type="file" id="txtFile2" size="55">';
		var newCell1 = newRow.insertCell(1);
		var tblBody = document.getElementById(tblId).tBodies[0];
		var j=tblBody.rows.length;
	}
function deleteAllRows(tblId){
		var tblBody = document.getElementById(tblId).tBodies[0];
		var i=tblBody.rows.length-1;
		tblBody.deleteRow(i);
		return i;			
}

function fetch(){
	if(document.addphotoform.userid.options[document.addphotoform.userid.selectedIndex]){
	   document.addphotoform.action="Login.do?action=list";	  
	   document.addphotoform.submit();
	}
	else
	 alert("User list empty");			
 }

function checkInput(ob) {
	  var invalidChars = /[^0-9]/gi
	  if(invalidChars.test(ob.value)) {
	            ob.value = ob.value.replace(invalidChars,"");
	      }
	}
</script>
<style type="text/css">
<!--
.style1 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}
.style2 {
	color: #FFFFFF;
	font-size: 12px; 
	font-family: Verdana, Arial, Helvetica, sans-serif;
	line-height:20px;
}
-->
</style>
</head>
<body onload="goforit(),dateDiaplay()" onpageshow="if (event.persisted) noBack();" onunload="">

<div id="header">

	<div id="logo">
    
    </div><!--logo-->
    <div id="search">
   <a href="Logout.do"><img src="images/MasterData_logout.png" alt="logout" border="0" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/MasterData_home.png" alt="Home" border="0"  /></a>
   
    </div>
</div><!--header-->
<div id="content_admin">
<br/>

<h2 align="center">Files Uploading</h2>	
<%long compid = 0; %>
 <form  method="post"  name="addphotoform" id="addphotoform" enctype="multipart/form-data" onsubmit="var x = document.getElementById('userid').options[document.getElementById('userid').selectedIndex].value" action="<%=request.getContextPath() %>/jsp/multiaudioprocess.jsp?userid="+"+x+" >
   <center>
   
   
   
  <!-- <tr>
				<td width="50%" align="left">Select Username:</td>
				<td width="50%" align="left" colspan="2"><select property="userid" onchange="fetch()">
					<option value="-1">--Select username--</option>
					<options  collection="userDetail" property="userid"	labelProperty="username" />
				</select></td>
	</tr><tr></tr><tr></tr>	--> 		
   
   </table>
   
   <table border="1" rules="all" class="para1">
         <%  
         session = request.getSession();
 		compid = ((LoginForm)session.getAttribute("userDetail")).getCompid();
         System.out.println("company id in jsp "+compid);
         %>
      <tr>
	       <td align="right" class="para1"><b>Username :</b></td>
		   <td> <select  name="userid" id="userid">
          <%
          Connection con = null;
          PreparedStatement preStat = null;
          ResultSet rs = null;
          	try{
	          con = ConnectionUtil.getMySqlConnection();
	          String query = "select userid, username from usermaster where COMPANYID = '"+compid+"' ";
	          System.out.println("compid in session "+compid);
	          preStat = con.prepareStatement(query);
			  rs = preStat.executeQuery();%>
			  <option value="-1">--Select username--</option>
			  <% 
	          while(rs.next()){	        	  
	          %>	
	          
	          <option value="<%= rs.getLong(1) %>"><%= rs.getString(2)%></option>	          
	          <% 
	          System.out.println("check value "+rs.getLong(1));
       	  	  }
	          
	        } catch(Exception e){
	        	e.printStackTrace();
	        }finally{
	        	preStat.close();
	            rs.close();
	            con.close();
	        }
	        
       	  %>
          </select></td></tr> 
	   
	         <tr>
	       <td align="right" class="para1"><b>Document Type :</b></td>
		   <td> 
		   <select  name="filetype" id="filetype">
            <option value="Personal">Personal Details</option>
            <option value="Qualification">Qualification Related Certificates</option>
            <option value="Experience">Experience Letters</option>
            <option value="Research">Research Publications</option>
             <option value="Books">Research Books</option>
            <option value="Projects">Research Projects</option>
            <option value="Outcomes">Projects Outcomes</option>
            <option value="Guidance">Research Guidance</option>
            <option value="Courses">Training Courses</option>
            <option value="Seminars">Conference-Seminars</option>
            <option value="Invitations">Invitations</option>
            <option value="Memberships">Memberships</option>
          </select>
          </td></tr> 
	      	   	  	   	         	       	   
		<tr>
	    	<td align="right"><b><label>*File </label></b></td>
	       	<td>
	       		<p>
	       			<input type="button" value="Add" onclick="addRowInnerHTML('tblInnerHTML');" />
		   			<input type="button" value="Delete" onclick="return deleteAllRows('tblInnerHTML');" />
		   		</p>
		   		<p><input  name="photoghaph1" type="file" id="txtFile" size="55"></p>
		   		<table id="tblInnerHTML">
		   			<tbody>
		   			</tbody>
		  		</table>
		  		<!--<input  name="photoghaph1" type="file" id="photoghaph1" size="55">-->
			</td>
		</tr>
		
		 
					 
	   
	   	<tr>
			<td align="center">
			<a href="#" onclick="return update123();" style="text-decoration:none;"><input type="submit" name="Submit" value="Submit" onclick="return validate();"/></a>
			<input type="reset" name="Reset" value="Reset" onclick="invoke(2)" />
			</td>
		</tr>
	</table>
	</center>
	</form>
	
	<div style="height:70px;"></div>
	</div>
<div id="itech">
Design and Developed by <a href="http://www.itechsolutions.in">Itech solutions </a>
</div><!--itech-->

</body>
</html>