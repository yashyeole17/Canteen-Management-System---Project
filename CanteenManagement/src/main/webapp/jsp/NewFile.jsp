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
<style>
.card{
display: block;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br>
	<div class="container mt-2" style="position: relative; min-height: 72vh">
	<h2 align="center">Product Type List</h2>
	<br>

	
	<form action="<%=CMSView.PRODUCT_TYPE_LISTCTL%>" method="post">

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
					
					
					<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="/CanteenManagement/image?id=<%=bean.getId()%>" style="height: 200px;" width="300px;" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title"><%=bean.getProductName()%></h5>
    <p class="card-text"><%=bean.getTypeName()%></p>
    <h5 class="card-title"><%=bean.getComapnyName()%></h5>
        <p class="card-text">%=bean.getPrice()%>></p>
    <a href="#" class="btn btn-primary">Add Cart</a>
  </div>
</div>
					
					
					
				
			<%
			}
		%>
		
			
	</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>