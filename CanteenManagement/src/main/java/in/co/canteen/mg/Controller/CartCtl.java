package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.canteen.mg.Bean.CartBean;
import in.co.canteen.mg.Bean.UserBean;
import in.co.canteen.mg.Model.CartModel;
import in.co.canteen.mg.Model.ProductDetailsModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "CartCtl",urlPatterns = "/cartCtl")
public class CartCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public CartCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartBean bean = new CartBean();
		CartModel model = new CartModel();
		
		String typeName = request.getParameter("typeName");
		String companyName = request.getParameter("companyName");
		String productName = request.getParameter("productName");
		long price = DataUtility.getLong(request.getParameter("price"));
		HttpSession session = request.getSession();
		UserBean userbBean = (UserBean) session.getAttribute("user");
		long userId = userbBean.getId();
		
		
		bean.setUserID(userId);
		bean.setTypeName(typeName);
		bean.setCompanyName(companyName);
		bean.setProductName(productName);
		bean.setPrice(price);
		bean.setQuantity(1);
		
		 try {
			long pk = model.add(bean);
			ServletUtility.setSuccessMessage("Product Added to cart", request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 List list = null;
		 ProductDetailsModel promodel = new ProductDetailsModel();
			try {
				list = promodel.list();
				ServletUtility.setList(list, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (list == null && list.size()==0) {
				ServletUtility.setErrorMessage("No Item in Cart", request);
			}
			
		 ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	@Override
	protected String getView() {
		return CMSView.ORDER_VIEW;
	}

}
