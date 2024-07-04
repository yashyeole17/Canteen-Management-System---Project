package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.canteen.mg.Bean.CartBean;
import in.co.canteen.mg.Bean.PaymentBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Model.CartModel;
import in.co.canteen.mg.Model.PaymentModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.DataValidator;
import in.co.canteen.mg.Utility.PropertyReader;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "PaymentCtl", urlPatterns = "/paymentCtl")
public class PaymentCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	public PaymentCtl() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PaymentBean bean = null;
		CartBean cbean = new CartBean();
		CartModel cartmodel = new CartModel();
		PaymentModel model = new PaymentModel();
		
		
		long id = DataUtility.getLong(request.getParameter("id"));
		String accountNo = DataUtility.getString(request.getParameter("accountNo"));
		String email = DataUtility.getString(request.getParameter("email"));
		String userName = DataUtility.getString(request.getParameter("userName"));
		String bankname = DataUtility.getString(request.getParameter("bankname"));
		String cardNo = DataUtility.getString(request.getParameter("cardNo"));
		long totalPrice = DataUtility.getLong(request.getParameter("totalprice"));

		List<CartBean> clist = null;
		try {
			clist = cartmodel.cartlist(id);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		HttpSession session = request.getSession();
		String op = DataUtility.getString(request.getParameter("operation"));
		if (OP_PAYMENT_NOW.equalsIgnoreCase(op)) {

			if (clist.isEmpty()) {
				System.out.println("is Empty");
				session.setAttribute("msg", "Cart is Empty !!");
				String encode = response.encodeUrl(request.getContextPath());
				response.sendRedirect(encode + "/cartListCtl");
			} else {
				try {
					ArrayList<PaymentBean> paymentlist = new ArrayList<PaymentBean>();
					Random r = new Random();
					for (CartBean c : clist) {
						bean = new PaymentBean();
						bean.setOrderID("orderID" + r.nextInt(1000));
						bean.setProductname(c.getProductName());
						bean.setTotalprice(c.getPrice());
						bean.setQuantity(c.getQuantity());
						bean.setUseremail(email);
						bean.setUsername(userName);
						bean.setStatus("Paid");
						paymentlist.add(bean);
					}
					bean.setTotalCharge(totalPrice);
					bean.setAccountno(accountNo);
					bean.setBankname(bankname);
					bean.setCardname(cardNo);

					long pk = model.add(paymentlist);
					ServletUtility.forward(getView(), request, response);

				} catch (DuplicateRecordException e) {
					System.out.println("Duplicate Record");
					ServletUtility.setbean(bean, request);
					ServletUtility.setErrorMessage(e.getMessage(), request);
					String encode = response.encodeUrl(request.getContextPath());
					response.sendRedirect(encode + "/cartListCtl");
				} catch (ApplicationException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected String getView() {
		return CMSView.PAYMENT_VIEW;
	}

}
