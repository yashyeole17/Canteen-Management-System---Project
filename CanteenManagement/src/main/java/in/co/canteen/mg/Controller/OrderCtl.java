package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Model.ProductDetailsModel;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "OrderCtl",urlPatterns = "/orderCtl")
public class OrderCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
    public OrderCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDetailsModel model = new ProductDetailsModel();
		List list = null;
		try {
			list = model.list();
			ServletUtility.setList(list, request);
		} catch (Exception e) {
			e.printStackTrace();
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
