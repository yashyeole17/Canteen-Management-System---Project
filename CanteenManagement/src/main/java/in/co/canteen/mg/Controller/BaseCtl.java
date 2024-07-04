package in.co.canteen.mg.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Bean.UserBean;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.DataValidator;
import in.co.canteen.mg.Utility.ServletUtility;

public abstract class BaseCtl extends HttpServlet {
	public static final String OP_CANCEL = "cancel";
	public static final String OP_DELETE = "delete";
	public static final String OP_LIST = "List";
	public static final String OP_VIEW = "view";
	public static final String OP_SEARCH = "search";
	public static final String OP_NEW = "New";
	public static final String OP_SAVE = "Save";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "previous";
	public static final String OP_GO = "go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOGOUT = "Logout";
	public static final String OP_RESET = "Reset";
	public static final String OP_UPDATE = "update";
	public static final String OP_SUBMIT = "Submit";
	public static final String OP_SINGIN = "SignIn";
	public static final String OP_SING_UP = "SignUp";
	public static final String OP_ADD_CART = "Add Card";
	public static final String OP_PAYMENT_NOW = "Payment Now";
	public static final String MSG_ERROR = "error";

	public static final String MSG_SUCCESS = "success";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseCtl() {
		super();
	}

	protected boolean validate(HttpServletRequest request){
		return true;
	}

	protected void preload(HttpServletRequest request) {

	}

	protected BaseBean populateBean(HttpServletRequest request){
		return null;
	}

	public BaseBean populateDTO(BaseBean bean, HttpServletRequest request) {
		String createdBy = request.getParameter("createdby");
		String modifiedby = null;
		UserBean userbean = (UserBean) request.getSession().getAttribute("user");
		if (userbean == null) {
			createdBy = "root";
			modifiedby = "root";
		} else {
			/* modifiedby = userbean.getLogin(); */

			if ("null".equals(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedby;
			}
		}
		//bean.setCreatedby(createdBy);
		//bean.setModifiedby(modifiedby);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));
		if (cdt > 0L) {
			//bean.setCreatedatetime(DataUtility.getTimestamp(cdt));
		} else {
			//bean.setCreatedatetime(DataUtility.getCurrentTimestamp());
		}
		//bean.setModifieddatetime(DataUtility.getCurrentTimestamp());
		return bean;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		preload(request);
		String op = DataUtility.getString(request.getParameter("operation"));
		if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op)
				&& !OP_DELETE.equalsIgnoreCase(op) 
				&& !OP_RESET.equalsIgnoreCase(op) 
				&& !OP_VIEW.equalsIgnoreCase(op)) {

			if(!validate(request)) {
				BaseBean bean = (BaseBean)populateBean(request);
				ServletUtility.setbean(bean, request);			
				ServletUtility.forward(getView(), request, response);
				return;
			}
		}
		System.out.println("in service");
		System.out.println(op);
		super.service(request, response);
	}
	
	protected abstract String getView();


}