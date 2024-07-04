<%@page import="java.util.Iterator"%>
<%@page import="in.co.canteen.mg.Bean.PaymentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<%UserBean user = (UserBean)session.getAttribute("user");%>
	
	<br>
	<div class="container mt-2"
		style="position: relative; min-height: 72vh">
		<h2 align="center">Payment List</h2>
		<br>
		<form action="<%=CMSView.PAYMENT_LIST_CTL%>" method="post">
			<br>
			<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
			<h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>

			<table class="table table-striped table-dark">
				<tr>
					<th scope="col">Order No</th>
					<th scope="col">Product Name</th>
					<th scope="col">User Name</th>
					<th scope="col">Price</th>
				</tr>
				<%PaymentBean bean = new PaymentBean(); %>
				<%
					int index = 1;
					List list = ServletUtility.getList(request);
					Iterator it = list.iterator();
					while (it.hasNext()) {
						 bean = (PaymentBean) it.next();
				%>
				<tr>
					<td><%=bean.getOrderID()%></td>
					<td><%=bean.getProductname()%></td>
					<td><%=bean.getUsername()%></td>
					<td>&#8377; <%=bean.getTotalprice()%></td>
				</tr>
				<%
					}
				%>
				<%-- <%if(user.getRoleId()==1){ %>
				
				<%}else{%>
				
				<tr><td style="border-bottom-width: 0px;"></td><td style="border-bottom-width: 0px;"></td><td style="border-bottom-width: 0px;"></td>
				<td><b class= 'font-weight-bold btn btn-outline-primary mt-1'>Total Price : &#8377;<%=bean.getTotalCharge()%></b></td></tr>
<%} %> --%>
				</tbody>
			</table>


		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>