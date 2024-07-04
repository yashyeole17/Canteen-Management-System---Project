package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Model.ProductDetailsModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.ServletUtility;


@WebServlet(name = "ProductDetailsListCtl",urlPatterns = "/productdetailsList")
public class ProductDetailsListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ProductDetailsListCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDetailsModel model = new ProductDetailsModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id>0) {
			try {
				model.delete(id);
				ServletUtility.setSuccessMessage("Data Deleted Successfully", request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List list = null;
		try {
			list = model.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ServletUtility.setList(list, request);
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected String getView() {
		return CMSView.PRODUCT_DETAILS_LIST_VIEW;
	}

}
