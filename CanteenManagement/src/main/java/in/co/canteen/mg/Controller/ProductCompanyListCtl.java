package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Bean.ProductCompanyBean;
import in.co.canteen.mg.Model.ProductCompanyModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "ProductCompanyListCtl",urlPatterns = "/productcompanyList")
public class ProductCompanyListCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ProductCompanyListCtl() {
        super();
    }
    
    protected BaseBean populateBean(HttpServletRequest request) {
		ProductCompanyBean bean = new ProductCompanyBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCompanyName(DataUtility.getString(request.getParameter("companyName")));
		//bean.setProductName(DataUtility.getString(request.getParameter("productname")));
		//System.out.println(" productname" + request.getParameter("productname"));
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductCompanyModel model = new ProductCompanyModel();
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
		return CMSView.PRODUCT_COMPANY_LISTVIEW;
	}

}
