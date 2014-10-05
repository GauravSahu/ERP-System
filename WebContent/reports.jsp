<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>: Reports :</title>

<!--SLIDEDECK-->
<script src="jquery-1.2.1.pack.js" type="text/javascript"></script>
	<script src="jquery-easing.1.2.pack.js" type="text/javascript"></script>
	<script src="jquery-easing-compatibility.1.2.pack.js" type="text/javascript"></script>
<script src="coda-slider.1.1.1.pack.js" type="text/javascript"></script>
    
    <style type="text/css">
		
		* { margin: 0; padding: 0 }
		
		p { text-align: justify; margin: 15px 0 }
		
		p, ul { font-size: 13px; line-height: 1.4em } 
		
		p a, li a { color: #39c; text-decoration: none }
		
		p.intro { border-bottom: 1px solid #ccc; margin-bottom: 20px; padding: 20px 0 30px 0; text-align: center; width: 100% }
		
		p#cross-links { text-align: center; font-family:Verdana, Arial, Helvetica, sans-serif;}
		
		p#cross-links { border-bottom: 1px solid #ccc; margin-bottom: 30px; padding-bottom: 30px }
		
		noscript p, noscript ol { color: #a00; font-size: 13px; line-height: 1.4em; text-align: left }
		noscript a { color: #a00; text-decoration: underline }
		noscript ol { margin-left: 25px; }
		
		a:focus { outline:none }
		
		img { border: 0 }
		
		h3 { font-family:Verdana; font-size:18px; border-bottom: 1px solid silver; margin-bottom: 5px; padding-bottom: 3px; text-align: left }
	
			.stripViewer .panelContainer .panel ul {
			text-align: left;
			margin: 0 10px 0 30px;
		}
		
		.slider-wrap { 
			margin: 20px 20px;
			position: relative;
			width: 980px;;
		}

		
		.csw {width: 980px; height: 460px; background: #fff; overflow: scroll}
		.csw .loading {margin: 200px 0 300px 0; text-align: center}

		.stripViewer { 
			position: relative;
			overflow: hidden; 
			border: 2px solid #603914; 
			margin: auto;
			width: 980px; 
			height: 360px;
			clear: both;
			background: #fff;
		}
		
		.stripViewer .panelContainer {
			position: relative;
			left: 0; top: 0;
			width: 980px;
			list-style-type: none;
			
		}
		
		.stripViewer .panelContainer .panel { 
			float:left;
			height: 460px;
			position: relative;
			width: 980px;
			
		}
		
		.stripViewer .panelContainer .panel .wrapper { 
			padding: 10px;
		}
		
		.stripNav { 
			margin: auto;
		}
		
		.stripNav ul { 
			list-style: none;
		}
		
		.stripNav ul li {
			float: left;
			margin-right: 2px; 
		}
		
		.stripNav a { /* The nav links */
			font-size: 11px;
			font-weight: bold;
			text-align: center;
			line-height: 32px;
			background: #603914;
			color: #fff;
			text-decoration: none;
			display: block;
			padding: 0 15px;
			font-family:Verdana, Arial, Helvetica, sans-serif;
		}
		
		.stripNav li.tab1 a { background: #603914 }
		.stripNav li.tab2 a { background: #603914 }
		.stripNav li.tab3 a { background: #603914 }
		.stripNav li.tab4 a { background: #603914 }
		.stripNav li.tab5 a { background: #603914 }
		
		.stripNav li a:hover {
			background: #333;
		}
		
		.stripNav li a.current {
			background: #000;
			color: #fff;
		}
		
		.stripNavL, .stripNavR { /* The left and right arrows */
			position: absolute;
			top: 230px;
			text-indent: -9000em;
		}
		
		.stripNavL a, .stripNavR a {
			display: block;
			height: 40px;
			width: 40px;
		}
		
		.stripNavL {
			left: 0;
		}
		
		.stripNavR {
			right: 0;
		}
		
	
		
	</style>
	
	
	<script type="text/javascript">
		jQuery(window).bind("load", function() {
			jQuery("div#slider1").codaSlider()
			
		});
	</script>
<!--SLIDEDECK-->
<link href="css/reports_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="main">

<div id="header">
<div id="icons">

<a href="Logout.do"><img src="images/Reports_logout.png" alt="logout" border="0" class="logout" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="admhome.jsp"><img src="images/Reports_home.png" alt="Home" border="0" class="home"  /></a></div>

<div id="reports">

</div>

</div><!--header-->


<div id="content">


	<div class="slider-wrap">
	<div id="slider1" >
		<div class="panelContainer">
		
			<div class="panel" title="Payroll">
				<div class="wrapper">
					<h3>Payroll</h3>
					
					
					<p>Sed eu ligula eget eros vulputate tincidunt. Etiam sapien urna, auctor a, viverra sit amet, convallis a, enim. Nullam ut nulla. Nam laoreet massa aliquet tortor. Mauris in quam ut dui bibendum malesuada. Nulla vel erat. Pellentesque metus risus, aliquet eget, eleifend in, ultrices vitae, nisi. Vivamus non nulla. Praesent ac lacus. Donec augue turpis, convallis sed, lacinia et, vestibulum nec, lacus. Suspendisse feugiat semper nunc. Donec nisl elit, varius sed, sodales volutpat, commodo in, elit. Proin ornare hendrerit lectus. Sed non dolor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis suscipit. Mauris egestas tincidunt lectus. Phasellus sed quam et velit laoreet pretium. Nunc metus.</p>
					<p><a href="#5" class="cross-link" title="Go to Panel 5">&#171; Previous</a> | <a href="#2" class="cross-link" title="Go to Panel 2">Next &#187;</a></p>
				</div>
			</div>
			<div class="panel" title="Inventory">
				<div class="wrapper">
					<h3>Inventory</h3>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Vivamus porta tortor sed metus. Nam pretium. Sed tempor. Integer ullamcorper, odio quis porttitor sagittis, nisl erat tincidunt massa, eu eleifend eros nibh sollicitudin est. Nulla dignissim. Mauris sollicitudin, arcu id sagittis placerat, tellus mauris egestas felis, eget interdum mi nibh vel lorem. Aliquam egestas hendrerit massa. Suspendisse sed nunc et lacus feugiat hendrerit. Nam cursus euismod augue. Aenean vehicula nisl eu quam luctus adipiscing. Nunc consequat justo pretium orci. Mauris hendrerit fermentum massa. Aenean consectetuer est ut arcu. Aliquam nisl massa, blandit at, accumsan sed, porta vel, metus. Duis fringilla quam ut eros.</p>
					
					<p><a href="#1" class="cross-link" title="Go to Panel 1">&#171; Previous</a> | <a href="#3" class="cross-link" title="Go to Panel 3">Next &#187;</a></p>
				</div>
			</div>		
			<div class="panel" title="Accounting">
				<div class="wrapper">
					<h3>Accounting</h3>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Vivamus porta tortor sed metus. Nam pretium. Sed tempor. Integer ullamcorper, odio quis porttitor sagittis, nisl erat tincidunt massa, eu eleifend eros nibh sollicitudin est. Nulla dignissim. Mauris sollicitudin, arcu id sagittis placerat, tellus mauris egestas felis, eget interdum mi nibh vel lorem. Aliquam egestas hendrerit massa. Suspendisse sed nunc et lacus feugiat hendrerit. Nam cursus euismod augue. Aenean vehicula nisl eu quam luctus adipiscing. Nunc consequat justo pretium orci. Mauris hendrerit fermentum massa. Aenean consectetuer est ut arcu. Aliquam nisl massa, blandit at, accumsan sed, porta vel, metus. Duis fringilla quam ut eros.</p>
					
					<p><a href="#2" class="cross-link" title="Go to Panel 2">&#171; Previous</a> | <a href="#4" class="cross-link" title="Go to Panel 4">Next &#187;</a></p>
				</div>
			</div>
			<div class="panel" title="Sales">
				<div class="wrapper">
					<h3>Sales</h3>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Vivamus porta tortor sed metus. Nam pretium. Sed tempor. Integer ullamcorper, odio quis porttitor sagittis, nisl erat tincidunt massa, eu eleifend eros nibh sollicitudin est. Nulla dignissim. Mauris sollicitudin, arcu id sagittis placerat, tellus mauris egestas felis, eget interdum mi nibh vel lorem. Aliquam egestas hendrerit massa. Suspendisse sed nunc et lacus feugiat hendrerit. Nam cursus euismod augue. Aenean vehicula nisl eu quam luctus adipiscing. Nunc consequat justo pretium orci. Mauris hendrerit fermentum massa. Aenean consectetuer est ut arcu. Aliquam nisl massa, blandit at, accumsan sed, porta vel, metus. Duis fringilla quam ut eros.</p>
					
					<p><a href="#3" class="cross-link" title="Go to Panel 3">&#171; Previous</a> | <a href="#5" class="cross-link" title="Go to Panel 5">Next &#187;</a></p>
				</div>
			</div>
			<div class="panel" title="MasterData">
				<div class="wrapper">
					<h3>MasterData</h3>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Vivamus porta tortor sed metus. Nam pretium. Sed tempor. Integer ullamcorper, odio quis porttitor sagittis, nisl erat tincidunt massa, eu eleifend eros nibh sollicitudin est. Nulla dignissim. Mauris sollicitudin, arcu id sagittis placerat, tellus mauris egestas felis, eget interdum mi nibh vel lorem. Aliquam egestas hendrerit massa. Suspendisse sed nunc et lacus feugiat hendrerit. Nam cursus euismod augue. Aenean vehicula nisl eu quam luctus adipiscing. Nunc consequat justo pretium orci. Mauris hendrerit fermentum massa. Aenean consectetuer est ut arcu. Aliquam nisl massa, blandit at, accumsan sed, porta vel, metus. Duis fringilla quam ut eros.</p>
					
					<p><a href="#4" class="cross-link" title="Go to Panel 4">&#171; Previous</a> | <a href="#1" class="cross-link" title="Go to Panel 1">Next &#187;</a></p>
				</div>
			</div>
			
		</div><!-- .panelContainer -->
	</div><!-- #slider1 -->
</div><!-- .slider-wrap -->


   
</div>


</div><!--content-->

</div><!--main-->
<div style="clear:both"></div>
<div id="footer">
<p>Copyright © 2013 Itech solutions. All rights reserved.</p>
</div><!--footer-->

</body>
</html>