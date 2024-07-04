<%@page import="in.co.canteen.mg.Controller.ProductCompanyCtl"%>
<%@page import="in.co.canteen.mg.Controller.ProductTypeCtl"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>
<%@page import="in.co.canteen.mg.Utility.HTMLUtility"%>
<%@page import="in.co.canteen.mg.Utility.DataUtility"%>
<%@page import="java.util.List"%>

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
	<%@ include file="Header.jsp"%>
<%-- <%
			List productlist =(List)request.getAttribute("productName");
		%>  --%>
	<div class="container" style="position: relative; min-height: 84vh">



		<form action="<%=CMSView.PRODUCT_COMPANY_CTL%>" method="post">

			<div class="row">
				<div class="col-3"></div>
				<div class="col-6" style="margin-top: 150px;">


					<jsp:useBean id="bean" scope="request"
						class="in.co.canteen.mg.Bean.ProductCompanyBean" />

					<input type="hidden" name="id" value="<%=bean.getId()%>">
					<h6 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h6>
					<h6 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h6>

					<%
						if (bean.getId() > 0) {
					%>
					<p class="h4 mb-4 text-center" style="background-color: black;">
						<b class="text-white">Update Product Company</b>
					</p>
					<%
						} else {
					%>
					<p class="h4 mb-4 text-center" style="background-color: black;">
						<b class="text-white">Add Product Company</b>
					</p>
					<%
						}
					%>

					<%-- <label for="inputAddress" class="form-label">Product Type Name:</label><select
						name="productname" class="form-control">
						<%=HTMLUtility.getList("productName", String.valueOf(bean.getProducttypeid()), productlist)%>
						<font color="red"><%=ServletUtility.getErrorMessage("productname", request)%></font>
					</select> --%>
					
					 <label class="form-label">Product Company Name</label> <input
						type="text" class="form-control mb-4" name="companyName"
						placeholder="Enetr Product Company Name"
						value="<%=DataUtility.getStringData(bean.getCompanyName())%>">
					<div class="form-text" style="color: red"><%=ServletUtility.getErrorMessage("companyName", request)%></div>
					
					<%
						if (bean.getId() > 0) {
					%>

					<div class="container mt-2 text-center">
						<input type="submit" class="btn btn-primary" name="operation"
							value="<%=ProductCompanyCtl.OP_UPDATE%>">
						<%
							} else {
						%>

						<div class="container mt-2 text-center">
							<input type="submit" class="btn btn-primary" name="operation"
								value="<%=ProductCompanyCtl.OP_SUBMIT%>">
							<%
								}
							%>

						</div>



					</div>
				</div>
			</div>
			<div class="col-3"></div>
		</form>
		<br>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>