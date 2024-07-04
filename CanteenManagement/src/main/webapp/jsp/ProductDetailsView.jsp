<%@page import="in.co.canteen.mg.Controller.ProductdetailsCtl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.canteen.mg.Controller.ProductTypeCtl"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>
<%@page import="in.co.canteen.mg.Utility.HTMLUtility"%>
<%@page import="in.co.canteen.mg.Utility.DataUtility"%>
<%@page import="in.co.canteen.mg.Controller.CMSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
	<%
		List producttypelist = (List) request.getAttribute("productTypeName");
	    List companylist = (List) request.getAttribute("companyName");
	%>
	<br>
	<div class="container mt-5"
		style="position: relative; min-height: 58vh">
		<div class="row">
			<div class="col-2"></div>
			<div class="col-8">
				<form action="<%=CMSView.PRODUCT_DETAILS_CTL%>" method="post" enctype="multipart/form-data">


					<h2>Add Product</h2>
					<hr>
					<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
					<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
					<jsp:useBean id="bean" scope="request"
						class="in.co.canteen.mg.Bean.ProductDetailsBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>">
					<div class="container">

	<div class="col-md-12">
							<label for="inputAddress" class="form-label">Product Name</label>
							<input type="text" class="form-control" id="inputAddress"
								name="productName" placeholder="Enter here..." value="">
						</div>
						<font color="red"><%=ServletUtility.getErrorMessage("productName", request)%></font>


                   <!-- Type -->
						<div class="col-md-12">
							<label for="inputAddress" class="form-label col-md-12">Prodcut Type:</label> <select name="type" class="form-control">
								<%=HTMLUtility.getList("type", String.valueOf(bean.getTypeid()), producttypelist)%>
								<font color="red"><%=ServletUtility.getErrorMessage("type", request)%></font>
							</select>
						</div>
						<!-- Type End -->


						<div class="col-md-12">
							<label for="inputAddress" class="form-label col-md-12">Product Company:</label> <select name="company" class="form-control">
								<%=HTMLUtility.getList("company", String.valueOf(bean.getCompanyid()), companylist)%>
								<font color="red"><%=ServletUtility.getErrorMessage("company", request)%></font>
							</select>
						</div>
						

						<div class="col-md-12">
							<label for="inputAddress" class="form-label">Product Price</label>
							<input type="number" class="form-control" id="inputAddress"
								name="price" placeholder="Enter here..." value="">
						</div>
						<font color="red"><%=ServletUtility.getErrorMessage("price", request)%></font>
						
							<div class="col-md-12">
						<label for="exampleFormControlInput1" class="form-label">
							Image:</label> <br><input type="file" id="exampleFormControlInput1" class="form-control" required="required"
							name="image" value="<%=DataUtility.getStringData(bean.getImage())%>">
					</div>

<br>
						<input type="submit" class="btn btn-primary" name="operation"
							style="margin-left: 300px;" value="<%=ProductdetailsCtl.OP_SUBMIT%>">
					</div>
				</form>
			</div>
		</div>
	</div>


	<div style="margin-top: 2%;">
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>