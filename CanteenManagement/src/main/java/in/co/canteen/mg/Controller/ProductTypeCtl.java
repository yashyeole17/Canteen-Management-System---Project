package in.co.canteen.mg.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Bean.ProductsTypeBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Model.ProductTypeModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.DataValidator;
import in.co.canteen.mg.Utility.PropertyReader;
import in.co.canteen.mg.Utility.ServletUtility;


@WebServlet(name = "ProductTypeCtl",urlPatterns = "/productType")
public class ProductTypeCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ProductTypeCtl() {
        super();
    }

    @Override
  	protected boolean validate(HttpServletRequest request) {
  		boolean pass = true;
  		String op = request.getParameter("operation");

  		if (DataValidator.isNull(request.getParameter("productid"))) {
  			request.setAttribute("productid", PropertyReader.getvalue("error.require", "Product Id"));
  			pass = false;
  		}

  		if (DataValidator.isNull(request.getParameter("productName"))) {
  			request.setAttribute("productName", PropertyReader.getvalue("error.require", "Product Name"));
  			pass = false;

  		}
  		return pass;
  	}

    protected BaseBean populateBean(HttpServletRequest request) {
 		ProductsTypeBean bean = new ProductsTypeBean();
 		bean.setId(DataUtility.getLong(request.getParameter("id")));
 		bean.setProductID(DataUtility.getString(request.getParameter("productid")));
 		bean.setProductName(DataUtility.getString(request.getParameter("productName")));
 		populateDTO(bean, request);
 		return bean;
 	}
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductTypeModel model = new ProductTypeModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			ProductsTypeBean bean = null;
			try {
				bean = model.findByPk(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.setbean(bean, request);
		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post");
		ProductTypeModel model = new ProductTypeModel();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		ProductsTypeBean bean = new ProductsTypeBean();
		bean = (ProductsTypeBean) populateBean(request);
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Product Type Submitted !!", request);
				ServletUtility.forward(getView(), request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setbean(bean, request);
				ServletUtility.setErrorMessage(e.getMessage(), request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			long pk = model.Update(bean);
			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Product Type Update !!", request);
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return CMSView.PRODUCT_TYPE_VIEW;
	}

}
