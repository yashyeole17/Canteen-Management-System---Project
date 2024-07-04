package in.co.canteen.mg.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Bean.UserBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Model.UserModel;
import in.co.canteen.mg.Utility.DataUtility;
import in.co.canteen.mg.Utility.DataValidator;
import in.co.canteen.mg.Utility.PropertyReader;
import in.co.canteen.mg.Utility.ServletUtility;

@WebServlet(name = "RegistrationCtl",urlPatterns = "/registration")
public class RegistrationCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;
       
    public RegistrationCtl() {
        super();
    }
    
    @Override
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		String op = request.getParameter("operation");

		if (DataValidator.isNull(request.getParameter("userName"))) {
			request.setAttribute("userName", PropertyReader.getvalue("error.require", "userName"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("email"))) {
			request.setAttribute("email", PropertyReader.getvalue("error.require", "email"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("password"))) {
			request.setAttribute("password", PropertyReader.getvalue("error.require", "password"));
			pass = false;
		}
		return pass;
	}


	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		UserBean bean = new UserBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setUserName(DataUtility.getString(request.getParameter("userName")));
		bean.setEmail(DataUtility.getString(request.getParameter("email")));
		bean.setPassword(DataUtility.getString(request.getParameter("password")));
		bean.setRoleId(2);
		bean.setRoleName("Student");
		populateDTO(bean, request);
		return bean;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel model = new UserModel();
		String op = DataUtility.getString(request.getParameter("operation"));
		long id = DataUtility.getLong(request.getParameter("id"));
		UserBean bean = new UserBean();
		bean = (UserBean) populateBean(request);
		if (OP_SUBMIT.equalsIgnoreCase(op)) {
			try {
				long pk = model.add(bean);
				ServletUtility.setbean(bean, request);
				ServletUtility.setSuccessMessage("Registration Complete !!", request);
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
			// long pk = model.Update(bean);
			ServletUtility.setbean(bean, request);
			ServletUtility.setSuccessMessage("Data Update !!", request);
		}
		ServletUtility.forward(getView(), request, response);
		
	}

	@Override
	protected String getView() {
		return CMSView.REGISTRATION_VIEW;
	}

}
