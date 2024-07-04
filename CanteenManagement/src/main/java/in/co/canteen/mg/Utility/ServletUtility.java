package in.co.canteen.mg.Utility;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.BaseBean;
import in.co.canteen.mg.Controller.BaseCtl;

public class ServletUtility {
	
	public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	public static void redirect(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.sendRedirect(page);
	}

	public static void handleException(Exception ex, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("Exception", ex);
		ServletUtility.forward("page", request, response);
	}

	public static String getErrorMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static String getMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setErrorMessage(String msg, HttpServletRequest request) {
		request.setAttribute(BaseCtl.MSG_ERROR, msg);
	}

	public static String getErrorMessage(HttpServletRequest request) {
		String val = (String) request.getAttribute(BaseCtl.MSG_ERROR);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setSuccessMessage(String msg, HttpServletRequest request) {
		request.setAttribute(BaseCtl.MSG_SUCCESS, msg);
	}

	public static String getSuccessMessage(HttpServletRequest request) {
		String val = (String) request.getAttribute(BaseCtl.MSG_SUCCESS);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setbean(BaseBean bean, HttpServletRequest request) {
		request.setAttribute("bean", bean);
	}

	public static BaseBean getbean(HttpServletRequest request) {
		return (BaseBean) request.getAttribute("bean");
	}

	public static String getParameter(String property, HttpServletRequest request) {
		String val = request.getParameter(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setList(List list, HttpServletRequest request) {
		request.setAttribute("list", list);
	}

	public static List getList(HttpServletRequest request) {
		return (List) request.getAttribute("list");
	}

	public static void setPageNo(int pageNo, HttpServletRequest request) {
		request.setAttribute("pageNo", pageNo);
	}

	public static Integer getPageNo(HttpServletRequest request) {
		return (Integer) request.getAttribute("pageNo");
	}

	public static void setPageSize(int Pagesize, HttpServletRequest request) {
		request.setAttribute("Pagesize", Pagesize);
	}

	public static Integer getpageSize(HttpServletRequest request) {
		return (Integer) request.getAttribute("Pagesize");
	}

	public static void setOpration(String msg, HttpServletRequest request) {
		request.setAttribute("msg", msg);
	}

	public static String getOpration(HttpServletRequest request) {
		String val = (String) request.getAttribute("msg");
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

}
