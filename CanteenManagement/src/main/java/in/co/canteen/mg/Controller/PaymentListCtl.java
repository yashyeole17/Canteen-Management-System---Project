package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.canteen.mg.Bean.PaymentBean;
import in.co.canteen.mg.Bean.UserBean;
import in.co.canteen.mg.Model.PaymentModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "PaymentListCtl", urlPatterns = "/paymentListCtl")
public class PaymentListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	public PaymentListCtl() {
		super();
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PaymentModel model = new PaymentModel();
//		PaymentBean bean = null;
//		 long id = DataUtility.getLong(request.getParameter("id"));
//		  if (id > 0) {
//			  try {
//				  //model.delete(id);
//				 ServletUtility.setSuccessMessage("Delete Payment History", request);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//		  }
//		    List list = null;
//	        HttpSession session = request.getSession(false);
//	    	UserBean bean2 = (UserBean) session.getAttribute("user");
//	    	String email = bean2.getEmail();
//	    			     try {
//							list =	model.Paymentlist(email);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//	    			     Iterator it =  list.iterator();
//	    			     while ( it.hasNext()) {
//	    			    	 bean =  (PaymentBean) it.next();
//						}
//	    			    ServletUtility.setList(list, request);
//	    			
//	        ServletUtility.forward(getView(), request, response);
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaymentModel model = new PaymentModel();
		PaymentBean bean = null;

		List list = null;
		HttpSession session = request.getSession(false);
		UserBean bean2 = (UserBean) session.getAttribute("user");
		String email = bean2.getEmail();
		long roleid = bean2.getRoleId();
		if (roleid == 2) {
			try {
				list = model.Paymentlist(email);
				ServletUtility.setList(list, request);
			} catch (Exception e) {
			}
		} else {
			try {
				list = model.list();
				ServletUtility.setList(list, request);
			} catch (Exception e) {

			}
			long id = DataUtility.getLong(request.getParameter("id"));

			if (id > 0) {
				model.delete(id);
				ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
			}

		}
		ServletUtility.forward(getView(), request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected String getView() {
		return CMSView.PAYMENT_LIST_VIEW;
	}

}
