package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Bean.ProductCompanyBean;
import in.co.canteen.mg.Bean.ProductsTypeBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Model.ProductCompanyModel;
import in.co.canteen.mg.Model.ProductTypeModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.DataValidator;
import in.co.canteen.mg.Utility.PropertyReader;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "ProductCompanyCtl", urlPatterns = "/productcompanyCtl")
public class ProductCompanyCtl extends BaseCtl {

	private static final long serialVersionUID = 1L;

	public ProductCompanyCtl() {
		super();
	}

	@Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		String op = request.getParameter("operation");

		if (DataValidator.isNull(request.getParameter("companyName"))) {
			request.setAttribute("companyName", PropertyReader.getvalue("error.require", "Company Name"));
			pass = false;
		}
		return pass;
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		ProductCompanyBean bean = new ProductCompanyBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCompanyName(DataUtility.getString(request.getParameter("companyName")));
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductCompanyModel model = new ProductCompanyModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0) {
			ProductCompanyBean bean = null;
			try {
				bean = model.findByPk(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ServletUtility.setbean(bean, request);
		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do post");
		ProductCompanyModel model = new ProductCompanyModel();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		ProductCompanyBean bean = new ProductCompanyBean();
		bean = (ProductCompanyBean) populateBean(request);
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Product Company Submitted !!", request);
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
		} else {
			 long pk = model.Update(bean);
			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Product Company Update !!", request);
		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		return CMSView.PRODUCT_COMPANY_VIEW;
	}

}
