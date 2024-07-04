<%@page import="in.co.canteen.mg.Controller.LoginCtl"%>
<%@page import="in.co.canteen.mg.Controller.CMSView"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>
<%@page import="in.co.canteen.mg.Utility.DataUtility"%>
<%@page import="in.co.canteen.mg.Controller.CMSView"%>
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
<div class="container"
		style="position: relative; min-height: 84vh">


		
		<form action="<%=CMSView.LOGIN_CTL%>" method="post">

			<div class="row">
				<div class="col-3"></div>
				<div class="col-6" style="margin-top: 150px;">


					<jsp:useBean id="bean" scope="request"
						class="in.co.canteen.mg.Bean.UserBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>"> 
<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
		<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>
		
<p class="h4 mb-4 text-center" style="background-color: graytext;">Sign in</p>
<label class="form-label">Email Id</label>
					<input type="email" id="defaultLoginFormEmail"
						class="form-control mb-4" name="email" placeholder="Enetr E-mail"
						value="<%=DataUtility.getStringData(bean.getEmail())%>">
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("email", request)%></div>

<label class="form-label">Password</label> 
					<input type="password" id="defaultLoginFormPassword"
						class="form-control mb-4" name="password"
						placeholder="Enter Password"
						value="<%=DataUtility.getStringData(bean.getPassword())%>">
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("password", request)%></div>


					<div class="container mt-2 text-center">
					<input type="submit" class="btn btn-primary" name="operation"
						value="<%=LoginCtl.OP_SINGIN%>">
</div>
		


		</div>

			</div>
			<div class="col-3"></div>
		</form>
	<br>
	</div>
<%@ include file="Footer.jsp" %>
</body>
</html>