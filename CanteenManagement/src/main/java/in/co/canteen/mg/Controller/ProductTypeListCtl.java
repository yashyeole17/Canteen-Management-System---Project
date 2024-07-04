package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Model.ProductTypeModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "ProductTypeListCtl",urlPatterns = "/productTypeList")
public class ProductTypeListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ProductTypeListCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductTypeModel model = new ProductTypeModel();
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
		return CMSView.PRODUCT_TYPE_LISTVIEW;
	}

}
