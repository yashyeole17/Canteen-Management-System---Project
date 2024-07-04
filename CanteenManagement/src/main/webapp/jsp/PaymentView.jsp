<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
</head>
<body style="background-color: #f0f1f2">
	<%@ include file="Header.jsp"%>
	<div class="container-fluid"
		style="position: relative; min-height: 70vh">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4 mt-4">
				<div class="card mt-4">
					<div class="card-body px-5 mt-4">
						<div class="container text-center mt-3 mb-4">

							<h5 style="color: green;" class="text-center">
								<i class="fa fa-check-square fa-5x"></i>
							</h5>
							<h2>Thank You</h2>
							<h3>Your Payment SuccessFully Done</h3>
							<a href="<%=CMSView.ORDER_CTL%>" class="btn btn-primary mt-3">Home</a>
							<a href="<%=CMSView.PAYMENT_LIST_CTL%>" class="btn btn-danger mt-3">View Order</a>


						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="Footer.jsp"%>

</body>
</html>