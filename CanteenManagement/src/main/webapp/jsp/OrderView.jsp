<%@page import="in.co.canteen.mg.Bean.ProductDetailsBean"%>
<%@page import="in.co.canteen.mg.Bean.CartBean"%>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
<%UserBean user = (UserBean)session.getAttribute("user");%>

	<div class="container-fluid mt-2" style="position: relative; min-height: 72vh">
	<br>
	
	<h2 align="center">Product List</h2>
	<form action="<%=CMSView.PRODUCT_TYPE_LISTCTL%>" method="post">
<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
<div class="row mt-2 mx-2 mb-4">

			<%
						int index = 1;
						List list = ServletUtility.getList(request);
						Iterator it = list.iterator();
						while (it.hasNext()) {
					    ProductDetailsBean bean = (ProductDetailsBean) it.next();
					%>
					
					
					
						<div class="col-md-3 mt-4">
						<div class="text-center">
							<div class="card" style="width: 23rem;">
							  <img class="card-img-top" src="/CanteenManagement/image?id=<%=bean.getId()%>" style="height: 300px;" width="350px;" alt="Card image cap">
								<div class="card-body">
								    <h5 class="card-title text-primary">Product Name:<%=bean.getProductName()%></h5>
								    <p class="card-text"><h5>Type Name :<%=bean.getTypeName()%></h5></p>
								    <h5 class="card-title">Company Name :<%=bean.getComapnyName()%></h5>
								    <p class="card-text"><h5>Price : &#8377; <%=bean.getPrice()%></h5></p>
								    
							
								    <%if(user == null) {%>
								    <a href="<%=CMSView.REGISTRATION_CTL%>" class="btn btn-primary">Add To Cart</a>
								    <%}else{ %>
								    <a href="<%=CMSView.CART_CTL%>?typeName=<%=bean.getTypeName()%>&companyName=<%=bean.getComapnyName()%>&productName=<%=bean.getProductName()%>&price=<%=bean.getPrice()%>" class="btn btn-primary">Add Cart</a>
                                      <%} %>
                                      </div>
								</div>
							</div>
						</div>
					
			<%
			}
		%>
						</div>
	</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>