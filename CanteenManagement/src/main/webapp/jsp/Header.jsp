<%@page import="in.co.canteen.mg.Model.CartModel"%>
<%@page import="java.util.List"%>
<%@page import="in.co.canteen.mg.Controller.LoginCtl"%>
<%@page import="in.co.canteen.mg.Bean.UserBean"%>
<%@page import="in.co.canteen.mg.Controller.CMSView"%>
<%@page import="in.co.canteen.mg.Utility.ServletUtility"%>


<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<title>Hello, world!</title>
</head>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>
	<%
		boolean userLoggedIn = userBean != null;

		String welcomeMsg = "Hello, ";

		if (userLoggedIn) {
			String role = (String) session.getAttribute("role");
			welcomeMsg += "(" + userBean.getUserName() + ")";
		} else {
			welcomeMsg += "Guest";
		}
	%>

	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container">
			<a class="navbar-brand text-white" href="<%=CMSView.WELCOME_CTL%>"><b
				class="text-white">Canteen Management System</b></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">


					<%
						if (userBean != null) {
					%>

					<%
						if (userBean.getRoleId() == 1) {
					%>
					<div class="dropdown">
						<a class="btn btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
							aria-expanded="false"> Products Type </a>

						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item"
								href="<%=CMSView.PRODUCT_TYPE_CTL%>">ADD</a></li>
							<li><a class="dropdown-item"
								href="<%=CMSView.PRODUCT_TYPE_LISTCTL%>">List</a></li>
						</ul>
					</div>&nbsp;

					<div class="dropdown">
						<a class="btn btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
							aria-expanded="false"> Products Company </a>

						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item"
								href="<%=CMSView.PRODUCT_COMPANY_CTL%>">ADD</a></li>
							<li><a class="dropdown-item"
								href="<%=CMSView.PRODUCT_COMPANY_LISTCTL%>">List</a></li>
						</ul>
					</div>&nbsp;

					<div class="dropdown">
						<a class="btn btn-secondary dropdown-toggle" href="#"
							role="button" id="dropdownMenuLink" data-bs-toggle="dropdown"
							aria-expanded="false">Products</a>

						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item"
								href="<%=CMSView.PRODUCT_DETAILS_CTL%>">ADD</a></li>
							<li><a class="dropdown-item"
								href="<%=CMSView.PRODUCT_DETAILS_LIST_CTL%>">List</a></li>
						</ul>
					</div>

					<li class="nav-item"><a class="nav-link text-white" href="<%=CMSView.PAYMENT_LIST_CTL%>">payment
							history</a></li>

					<li class="nav-item"><a class="nav-link text-white"
						href="<%=CMSView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>">Logout</a>
					</li>

					<li class="nav-item"><a class="nav-link text-white"><%=welcomeMsg%></a></li>

					<%
						} else if (userBean.getRoleId() == 2) {
					%>


					<li class="nav-item"><a class="nav-link text-white"
						href="<%=CMSView.ORDER_CTL%>">Product List</a></li>

					<li class="nav-item"><a class="nav-link text-white"><%=welcomeMsg%></a></li>

					<li class="nav-item"><a class="nav-link text-white"
						href="<%=CMSView.LOGIN_CTL%>?operation=<%=LoginCtl.OP_LOGOUT%>">Logout</a></li>


					<%
					                	CartModel model = new CartModel();
										List list = model.cartlist(userBean.getId());
									
					%>

					<li class="nav-item active"><a class="nav-link"
						href="<%=CMSView.CART_LIST_CTL%>"><i class='fas fa-cart-plus'
							style='font-size: 30px; color: blue'></i><span
							class="ml-1 cart-items text-white" style="margin-top: -20px;">(<%=list.size()%>)
						</span> </a></li>


					<li class="nav-item"><a class="nav-link text-white" href="<%=CMSView.PAYMENT_LIST_CTL%>">payment
							history</a></li>

					<%
						}
					%>

					<%
						} else {
					%>



					<li class="nav-item"><a class="nav-link text-white"
						href="<%=CMSView.ORDER_CTL%>">Product List</a></li>


					<li class="nav-item"><a class="nav-link text-white"
						href="<%=CMSView.LOGIN_CTL%>">Login</a></li>

					<li class="nav-item"><a class="nav-link text-white"
						href="<%=CMSView.REGISTRATION_CTL%>">Registration</a></li>
						
						<li class="nav-item"><a class="nav-link text-white"><%=welcomeMsg%></a></li>


				</ul>
			</div>
		</div>
		<%
			}
		%>
	</nav>



</body>
</html>