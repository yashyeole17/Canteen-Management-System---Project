<%@page import="in.co.canteen.mg.Controller.RegistrationCtl"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp"%>


<div class="container-fluid" 	style="position: relative; min-height: 70vh">
<div class="row mt-5">

<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>

<div class="col-md-4 offset-md-4">
<h3 class="text-center my-3">Sign up Here</h3>

<form action="<%=CMSView.REGISTRATION_CTL%>" method="post">
<div class="card">

<div class="card-body px-5">

<div class="form-group">
    <label>User Name</label>
    <input type="text" class="form-control" placeholder="Enter UserName" name="userName">
  </div>


<div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="exampleInputEmail1"  aria-describedby="emailHelp" placeholder="Enter email"  name="email">
  </div>
  
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password"  aria-describedby="password" placeholder="Enter Password"  name="password">
  </div>
  
  <div class="container text-center mt-4">
  <input type="submit" class="btn btn-outline-success" name="operation"
						value="<%=RegistrationCtl.OP_SUBMIT%>">
  </div>
  

</div>

</div>

</form>
</div>

</div>


</div>

<%@ include file="Footer.jsp" %>
</body>
</html>