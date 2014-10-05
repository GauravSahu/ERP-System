<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/TLD/struts-html.tld"	prefix="html"%>
<%@ taglib uri="/WEB-INF/TLD/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/TLD/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iERP- Home</title>
<link href="css/main_css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="default/default.css" type="text/css" media="screen" />
 <link rel="stylesheet" href="nivo-slider.css" type="text/css" media="screen" />
<link rel="stylesheet" href="jquery.nivo.slider.js" type="text/css" media="screen" />
<script type="text/javascript" src="scripts/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="jquery.nivo.slider.pack.js"></script>
<script type="text/javascript">
    $(window).load(function() {
        $('#slider').nivoSlider();
    });
    window.history.forward();  
    function noBack() { window.history.forward(); }
    </script>
</head>
<body onload="noBack();"  onpageshow="if (event.persisted) noBack();" onunload="">
<div id="main" align="center">
 <!--main div starts from here-->
 <div id="header">
  <div id="header_logo"></div>
 <div id="header_menus">
 <table width="322px" height="30px">
 <br/>
 <br/>
 <tr>
 <td width="102"><a href="#" style="text-decoration:none;"><img src="images/iERP_menu_01.png" border="0" /></a></td>

 <td width="104"><a href="http://www.itechsolutions.in/" style="text-decoration:none;"><img src="images/iERP_menu_02.png" border="0" /></a></td>

 <td width="178"><a href="contact.html" style="text-decoration:none;"><img src="images/iERP_menu_03.png" border="0" /></a></td>

 </tr>
 </table></div>
 </div>
 <div id="content">
 <!--content from here-->
 <div id="content_banner1">
 <!--animation from here-->
 <div id="banner">
    <table cellpadding="0" cellspacing="0" width="695" height="350" style="margin-top:10px;">
    <tr>
	<td width="683" valign="top"><div class="slider-wrapper theme-default">
            <div class="ribbon"></div>
            <div id="slider" class="nivoSlider">
                
                <img src="images/banner_05.jpg"  alt=""/>
                <img src="images/banner_06.jpg"  alt=""/>
                 <img src="images/banner_07.jpg"  alt=""/>
                  <img src="images/banner_08.jpg"  alt=""/>
                   <img src="images/banner_09.jpg"  alt=""/>
                 <img src="images/banner_10.jpg"  alt=""/>
            </div>           
        </div></td></tr>
        </table>        
</div>
 <!--animation till here-->
 </div>
  <div id="content_text">
   <div id="content_text1">
   <div id="content_text01"></div>
   <table style="margin:0px 20px 0px 20px;">
   <tr>
    <td class="text">
     ERP's best hope for demonstrating value is as a sort of battering ram for improving the way your company
     takes a customer order and processes it into an invoice and revenue-otherwise known as the order
     fulfillment process. That is why ERP is often referred to as back-office software. It doesn't handle the up-front
     selling process (although most ERP vendors have developed CRM software or acquired pure-play CRM providers that can do this).
  </td>
  </tr>
   <tr>
   <td class="text1"><a href="#" style="text-decoration:none;"><strong><font color="#0b9dc4">read more...</font></strong></a></td>
   </tr>
   </table>
   </div>
    <div id="content_text2">
    <div id="content_text02">
    </div>
    <html:form action="Login.do?action=login" method="post" > 
    <table style="margin:10px 0px 0px 30px;">
    <tr>
  <td colspan="3" ><div align="right" class="style4">
	<logic:present name="loginfailure">
		<span class="style4"><font size="-1" color="red">
		<bean:write name="loginfailure"/></font></span>
	</logic:present></div>
	<logic:present name="success">
		<span class="style4"><font size="-1" color="red">
		<bean:write name="success"/></font></span>
	</logic:present></div>
  </td>
</tr>
    <tr height="30px">
    <td width="62" class="text3">USER NAME</td>
    <td width="6"  class="text">:</td>
    <td width="167"><input name="username" type="text" width="150" maxlength="20"/></td>
    </tr>
    <tr height="30px">
     <td class="text3">PASSWORD</td>
    <td  class="text">:</td>
    <td width="167"><input name="password" type="password" width="150" /></td>
    </tr>
    <tr>
    <td></td>
    <td></td>
    <td>
    <input type="submit" value="submit" style="background:url(images/iERP_login_submit.png)" ></input>
    <input type="reset" value="Reset" style="background:url(images/iERP_login_reset.PNG")"></input>
    <!-- <a href="main_menu.html"><img src="images/iERP_login_submit.png" border="0"/></a>
    <a href="#"><img src="images/iERP_login_reset.PNG" border="0"/></a> --></td>
    </tr>
    <tr height="20px">
    <td></td>
    <td></td>
    </tr>
    <tr height="20px">
    <td></td>
    <td></td>
      <td><p class="style2"><a href="ForgotPassword1.do">Forgot your password?</a></p></td>
    </tr>
    </table>
</html:form>
    </div>
  </div> 
<!--content till here-->
 </div>
  <div id="footer"><div id="menus_copyright">Copyright © 2013 Itech Solutions. All rights Reserved.</div>
  <div id="menus_footer">
  <table>
  <tr>
 <td width="29"><a href="https://www.twitter.com"><img src="images/ierp_twt.PNG" border="0" /></a></td>
  <td width="29"><a href="https://www.facebook.com"><img src="images/ierp_fb.PNG" border="0" /></a></td>
   <td width="29"><a href="http://www.youtube.com"><img src="images/ierp_u.PNG" border="0" /></a></td>
   </tr>
  </table>
  </div></div>
 <!--main div starts from here-->
</div>
</body>
</html>