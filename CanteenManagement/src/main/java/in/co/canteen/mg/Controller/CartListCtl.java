package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.canteen.mg.Bean.CartBean;
import in.co.canteen.mg.Bean.UserBean;
import in.co.canteen.mg.Model.CartModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.ServletUtility;


@WebServlet(name = "CartListCtl",urlPatterns = "/cartListCtl")
public class CartListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public CartListCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartModel model = new CartModel();
		CartBean bean = null;
		 long id = DataUtility.getLong(request.getParameter("id"));
		  if (id > 0) {
			  try {
				  model.delete(id);
				 ServletUtility.setSuccessMessage("Remove Item From Cart", request);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		  }
		    List list = null;
	        HttpSession session = request.getSession(false);
	    	UserBean bean2 = (UserBean) session.getAttribute("user");
	    	long roleid = bean2.getRoleId();
	    	if (roleid==2) {
	    		   try {
	    			     list =	model.cartlist(bean2.getId());
	    			     Iterator it =  list.iterator();
	    			     long totalprice = 0;
	    			     while ( it.hasNext()) {
	    			    	 bean =  (CartBean) it.next();
	    			    	 totalprice = totalprice+bean.getPrice();
	    			    	 bean.setTotal_price(totalprice);
						}
	    			  
	    			} catch (Exception e) {
	    				e.printStackTrace();
	    			}
			}
	    	ServletUtility.setList(list, request);
	        ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected String getView() {
		return CMSView.CART_LIST_VIEW;
	}

}
