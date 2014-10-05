
<div id="header">

<div id="header1">
<div id="logo"><img src="images/logo.png" alt="logo" /></div>
<!-- logo ends -->

<div id="button"><a href="Login.do?action=login1"><img
src="images/home.png" title="Home" /></a> 
	<a href="Logout.do"><img src="images/logout.png" title="Logout" /></a></div>
<!--button--></div>
<!-- header1 --></div>
<!-- header -->

<table>

	<tr>
		<td>
		<%
	  try{
	  Object ob=(Object)session.getAttribute("username").toString();
      if(ob!=null){%>
		<div class="datetime" style="text-align: left; margin-left: 30px;"><label><strong>
		Welcome <%=ob %> <%}
      }catch(NullPointerException e){
      RequestDispatcher rd = request.getRequestDispatcher("sessionexpired.jsp");
      rd.forward(request, response);
      }%>
		</strong></label>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label><strong><span id="clock"></span></strong></label></div>
		</td>
	</tr>
</table>