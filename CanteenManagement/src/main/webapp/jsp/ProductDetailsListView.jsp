<%@page import="in.co.canteen.mg.Bean.ProductDetailsBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.canteen.mg.Controller.ProductTypeCtl"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>
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
		UserBean userBean2 = (UserBean) session.getAttribute("user");
	%>
	<br>
	<div class="container">
		<h1>All Product List</h1>
		<div class="row">
			<div class="col-12">


				<form action="<%=CMSView.PRODUCT_DETAILS_LIST_CTL%>" method="post">

					<br>
					<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
					<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
					<%
						int index = 1;
						List list = ServletUtility.getList(request);
						Iterator it = list.iterator();
						while (it.hasNext()) {
							ProductDetailsBean bean = (ProductDetailsBean) it.next();
					%>
					<div class="card mt-3">

						<div class="text-center">
							<img class="m-4"
								src="/CanteenManagement/image?id=<%=bean.getId()%>"
								style="height: 400px;" width="400px;">
						</div>
						<div class="card-body px-5">
							<h5 class="card-title text-center">
								Product Name :<%=bean.getProductName()%></h5>
							<p class="text-center">
								<b class="text-primary">Company Name :<%=bean.getComapnyName()%></b>
							</p>
							<p class="text-center">
								<b class="text-primary">Type Name :<%=bean.getTypeName()%></b>
							</p>
							<h4 class="card-text text-center">
								Price :   &#8377;  <%=bean.getPrice()%></h4>
							<div class="container text-center mt-2">

								<%
									if (userBean2 == null) {
								%>

								<a
									href="<%=CMSView.ORDER_CTL%>?id=<%=bean.getId()%>&price=<%=bean.getPrice()%>&productName=<%=bean.getProductName()%>"
									class="btn btn-success">Order</a>

								<%
									} else {
								%>
								<a
									href="<%=CMSView.PRODUCT_DETAILS_LIST_CTL%>?id=<%=bean.getId()%>"
									class="btn btn-danger">Delete</a>
								<%
									}
								%>
							</div>
						</div>
					</div>

					<%
						}
					%>



				</form>
			</div>
		</div>

	</div>
	<br>
	<%@include file="Footer.jsp"%>

</body>
</html>