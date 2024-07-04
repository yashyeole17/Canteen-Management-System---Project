<%@page import="in.co.canteen.mg.Bean.ProductCompanyBean"%>
<%@page import="in.co.canteen.mg.Bean.ProductsTypeBean"%>
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
	<br>
	<div class="container mt-2" style="position: relative; min-height: 72vh">
	<h2 align="center">Product Company List</h2>
	<br>

	
	<form action="<%=CMSView.PRODUCT_COMPANY_LISTCTL%>" method="post">

		<br>
<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
	<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>

		<table class="table table-striped table-dark">
			<tr >
				
				<th scope="col">Product Comapny Name</th>
				<th scope="col">Action</th>
			</tr>
			<%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
					ProductCompanyBean bean = (ProductCompanyBean) it.next();
			%>
			<tr>
				<td><%=bean.getCompanyName()%></td>
				
				<td><a class="btn btn-success"
					href="<%=CMSView.PRODUCT_COMPANY_CTL%>?id=<%=bean.getId()%>">Edit</a>
			    <a class="btn btn-danger" href="<%=CMSView.PRODUCT_COMPANY_LISTCTL%>?id=<%=bean.getId()%>">Delete</a></td>	
			</tr>
			<%
			}
		%>
		
			</tbody>
		</table>

		
	</form>
	</div>
<%@include file="Footer.jsp"%>
</body>
</html>