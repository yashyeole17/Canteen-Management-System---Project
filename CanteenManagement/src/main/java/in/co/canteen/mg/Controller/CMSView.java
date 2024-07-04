package in.co.canteen.mg.Controller;

public interface CMSView {
	
	public String APP_CONTEXT = "/CanteenManagement";
	public String PAGE_FOLDER = "/jsp";
	
	//Controller------------------------------
		public String WELCOME_CTL = APP_CONTEXT + "/welcome";
		public String REGISTRATION_CTL = APP_CONTEXT + "/registration";
		public String LOGIN_CTL = APP_CONTEXT + "/login";
		public String PRODUCT_TYPE_CTL  = APP_CONTEXT + "/productType";
		public String PRODUCT_TYPE_LISTCTL  = APP_CONTEXT + "/productTypeList";
		public String PRODUCT_COMPANY_CTL  = APP_CONTEXT + "/productcompanyCtl";
		public String PRODUCT_COMPANY_LISTCTL  = APP_CONTEXT + "/productcompanyList";
		public String PRODUCT_DETAILS_CTL  = APP_CONTEXT + "/productdetailsCtl";
		public String PRODUCT_DETAILS_LIST_CTL  = APP_CONTEXT + "/productdetailsList";
		public String IMAGE_CTL = APP_CONTEXT + "/image";
		public String ORDER_CTL = APP_CONTEXT + "/orderCtl";
		public String CART_CTL = APP_CONTEXT + "/cartCtl";
		public String CART_LIST_CTL = APP_CONTEXT + "/cartListCtl";
		public String PAYMENT_CTL = APP_CONTEXT + "/paymentCtl";
		public String PAYMENT_LIST_CTL = APP_CONTEXT + "/paymentListCtl";



		//View-------------------------------------
		public String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
		public String REGISTRATION_VIEW = PAGE_FOLDER + "/RegistrationView.jsp";
		public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
		public String PRODUCT_TYPE_VIEW = PAGE_FOLDER + "/ProductType.jsp";
		public String PRODUCT_TYPE_LISTVIEW = PAGE_FOLDER + "/ProductTypeListView.jsp";
		public String PRODUCT_COMPANY_VIEW = PAGE_FOLDER + "/ProductCompanyView.jsp";
		public String PRODUCT_COMPANY_LISTVIEW = PAGE_FOLDER + "/ProductCompanyList.jsp";
		public String PRODUCT_DETAILS_VIEW = PAGE_FOLDER + "/ProductDetailsView.jsp";
		public String PRODUCT_DETAILS_LIST_VIEW = PAGE_FOLDER + "/ProductDetailsListView.jsp";
		public String ORDER_VIEW = PAGE_FOLDER + "/OrderView.jsp";
		public String CART_VIEW = PAGE_FOLDER + "/CartView.jsp";
		public String CART_LIST_VIEW = PAGE_FOLDER + "/CartListView.jsp";
		public String PAYMENT_VIEW = PAGE_FOLDER + "/PaymentView.jsp";
		public String PAYMENT_LIST_VIEW = PAGE_FOLDER + "/PaymentListView.jsp";

}