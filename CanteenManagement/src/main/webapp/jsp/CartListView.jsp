<%@page import="in.co.canteen.mg.Bean.CartBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>
<%@page import="in.co.canteen.mg.Controller.PaymentCtl"%>
<%@page import="in.co.canteen.mg.Controller.CartListCtl"%>
<%@page import="javax.servlet.http.HttpSession"%>
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
	<div class="container mt-2"
		style="position: relative; min-height: 68vh">
<%UserBean user = (UserBean)session.getAttribute("user");%>
	<form action="<%=CMSView.PAYMENT_CTL%>" method="post">
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-7">
				<div class="card">
				
				<%String msg = (String)session.getAttribute("msg");
				if(msg != null){ %>
				
				<h5 style="color: red;" class="text-center"><%=msg%></h5>
				<%
				}
				session.removeAttribute("msg");
				%>
				
				<h5 style="color: red;" class="text-center"><%=ServletUtility.getErrorMessage(request)%></h5>
	           <h5 style="color: green;" class="text-center"><%=ServletUtility.getSuccessMessage(request)%></h5>
				
					<div class="card-body">
						<h4 class="text-center mb-5">Your selected Item</h4>
						<div class="cart-body">
						<table class="table table-striped table-dark">
		     <thead class = 'table-light'>
		     <tr>
		      <th>Product Name </th>
		      <th>Type Name</th>
		      <th>Company Name</th>
		      <th>Price</th>
		      <th>Action </th>
		       
		     </tr>
		     </thead>
		      <%CartBean bean = new CartBean();%>
		     <%
				int index = 1;
				List list = ServletUtility.getList(request);
				Iterator it = list.iterator();
				while (it.hasNext()) {
			     bean = (CartBean) it.next();
			%>
		     	<tr>
			     <td><%=bean.getProductName()%></td>
			     <td><%=bean.getTypeName()%></td>
			     <td><%=bean.getCompanyName()%></td>
			     <td>&#8377; <%=bean.getPrice()%></td>
			     <td><a class='btn btn-danger btn-sm' href="<%=CMSView.CART_LIST_CTL%>?id=<%=bean.getId()%>">Remove</a></td>
			</tr>
			<%} %>
			
		 <tr><input type="hidden" name="totalprice" value="<%=bean.getTotal_price()%>"></tr>
	<tr>
	<td></td><td></td><td></td>
	<td  class= 'font-weight-bold btn btn-outline-warning mt-4 mb-3' style="border-bottom-width: 0px;">Total Price : &#8377; <%=bean.getTotal_price()%></td><td></td>
	</tr>
		
		</table>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-5">
				<div class="card mb-4">
					<div class="card-body">
						<h4 class="text-center">Payment Details For Product</h4>
							<input type="hidden" name="id" value="<%=user.getId()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input name="email" required="required"
									type="email" class="form-control" id="exampleInputEmail1" value="<%=user.getEmail()%>"
									readonly="readonly" aria-describedby="emailHelp" placeholder="Enter email">
							</div>

							<div class="form-group">
								<label for="name">Your Name</label> <input type="text" value="<%=user.getUserName()%>" required="required"
									readonly="readonly" class="form-control" name="userName" placeholder="Enter name">
							</div>
							
							<div class="form-group">
								<label for="name">Your Account No</label> <input type="text" required="required"
									class="form-control" name="accountNo" placeholder="Enter Account Name">
							</div>
							
								<div class="form-group">
								<label for="name">Your Bank Name</label> <input type="text" required="required"
									class="form-control" name="bankname" placeholder="Enter Bank Name">
							</div>
							
								<div class="form-group">
								<label for="name">Your Card No</label> <input type="text" required="required"
									class="form-control" name="cardNo" placeholder="Enter Card No">
							</div>


							<div class="container text-center mt-2">
								  <input type="submit" class="btn btn-outline-success border-0" name="operation"
						value="<%=PaymentCtl.OP_PAYMENT_NOW%>">
							
							<a href="<%=CMSView.ORDER_CTL%>" class="btn btn-outline-primary border-0">Continue</a>	
							</div>



						
					</div>
					
				</div>

			</div>
			
		</div>
	</div>
</form>
</div>
	<%@include file="Footer.jsp"%>

</body>
</html>