package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Bean.ProductDetailsBean;
import in.co.canteen.mg.Bean.ProductsTypeBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Model.ProductCompanyModel;
import in.co.canteen.mg.Model.ProductDetailsModel;
import in.co.canteen.mg.Model.ProductTypeModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.DataValidator;
import in.co.canteen.mg.Utility.PropertyReader;
import in.co.canteen.mg.Utility.ServletUtility;


@WebServlet(name = "ProductdetailsCtl",urlPatterns = "/productdetailsCtl")
@MultipartConfig(maxFileSize = 16177215)
public class ProductdetailsCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public ProductdetailsCtl() {
        super();
    }
    
	@Override
	protected void preload(HttpServletRequest request) {
		ProductTypeModel model = new ProductTypeModel();
		ProductCompanyModel companymodel = new ProductCompanyModel();
		try {
			List producttypelist = model.list();
			List companylist = companymodel.list();
			request.setAttribute("productTypeName", producttypelist);
			request.setAttribute("companyName", companylist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected boolean validate(HttpServletRequest request) {
		System.out.println("in validation method");
		boolean pass = true;
		
		if (DataValidator.isNull(request.getParameter("productName"))) {
			request.setAttribute("productName", PropertyReader.getvalue("error.require", "productName"));
			pass = false;
		}
	
		if (DataValidator.isNull(request.getParameter("price"))) {
			request.setAttribute("price", PropertyReader.getvalue("error.require", "price"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("type"))) {
			request.setAttribute("type", PropertyReader.getvalue("error.require", "type"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("company"))) {
			request.setAttribute("company", PropertyReader.getvalue("error.require", "company"));
			pass = false;
		}
		return pass;
	}
    
    @Override
	protected BaseBean populateBean(HttpServletRequest request) {
        ProductDetailsBean bean = new ProductDetailsBean();
        
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setProductName(DataUtility.getString(request.getParameter("productName")));
		bean.setTypeid(DataUtility.getLong(request.getParameter("type")));
		bean.setCompanyid(DataUtility.getLong(request.getParameter("company")));
		bean.setPrice(DataUtility.getLong(request.getParameter("price")));
		bean.setCartid(0);
		 Blob blob = null;
	        Part filePart;
	        try {
				filePart = request.getPart("image");
				blob =  medicinePacketUpload(filePart);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        System.out.println("image :" + blob);
		bean.setImage(blob);
		populateDTO(bean, request);
		return bean;
	}
    
    public Blob medicinePacketUpload(Part part) throws IOException {
		InputStream inputStream = null;
		Blob blob = null;
		inputStream = part.getInputStream();
		byte[] b = new byte[inputStream.available()];
		inputStream.read(b);
		try {
			blob = new SerialBlob(b);
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return blob;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do post");
		ProductDetailsModel model = new ProductDetailsModel();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		ProductDetailsBean bean = new ProductDetailsBean();
		bean = (ProductDetailsBean) populateBean(request);
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Product Added !!", request);
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
			//long pk = model.Update(bean);
			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Product Updated !!", request);
		}
		ServletUtility.forward(getView(), request, response);
		
	}

	@Override
	protected String getView() {
		return CMSView.PRODUCT_DETAILS_VIEW;
	}

}
