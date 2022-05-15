<%@ page import="com.Item"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/item.js"></script>
</head>
<body>
	<div class = "container">
		<div class = "row">
				<div class = "col-6">
					<h1>Power Usage Report Management</h1>
	
	<form id="formPower" name="formPower" method="post" action="power.jsp">
		 Report ID:
		 <input id="reportID" name="reportID" type="text"
 						class="form-control form-control-sm">
 						
		<br> Usage:
		<input id="usage" name="usage" type="text"
 						class="form-control form-control-sm">
 						
		<br> Power Cuts:
		<input id="powerCuts" name="powerCuts" type="text"
 						class="form-control form-control-sm">
 						
 						
		<br> Weather:
		<input id="weather" name="weather" type="text"
						 class="form-control form-control-sm">
						 
		<br>
		<input id="btnSave" name="btnSave" type="button" value="Save"
						 class="btn btn-primary">
						 
		<input type="hidden" id="hidreportIDSave" name="hidreportIDSave" value="">
	</form>
	
	<br/>
	<!-- Show output -->

	<div id= "alertSuccess" class="alert alert-success"></div>
 	<div id = "alertError" class="alert alert-danger"></div>
	
	<br>
	<div id ="divPowerGrid">
		<%
			 Item powerObj = new Power(); 
	 		 out.print(powerObj.readPower()); 
		%>
    </div>

   </div> 
  </div>
  </div>
  


</body>
</html> 