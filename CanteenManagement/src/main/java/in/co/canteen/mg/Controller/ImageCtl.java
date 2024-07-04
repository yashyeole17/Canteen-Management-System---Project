package in.co.canteen.mg.Controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Utility.JDBCDataSource;

@WebServlet(name = "ImageCtl",urlPatterns = "/image")
@MultipartConfig(maxFileSize = 16177215)
public class ImageCtl extends BaseCtl {
	
	private static final long serialVersionUID = 1L;
       
    public ImageCtl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("image/jpeg");
		  int id = Integer.parseInt(request.getParameter("id"));
		  Connection conn;
		try {
			conn = JDBCDataSource.getConnection();
			 String sql = "SELECT * FROM productdetails WHERE ID ='"+id+"'";
			  PreparedStatement ps;
			  ps = conn.prepareStatement(sql);
			   ResultSet rs = ps.executeQuery();
			   if(rs.next()){
			    byte [] imageData = rs.getBytes("image"); // extract byte data from the resultset..
			    OutputStream os = response.getOutputStream(); // output with the help of outputStream 
			             os.write(imageData);
			             os.flush();
			             os.close();
			   }
			   }catch (Exception e1) {
			e1.printStackTrace();
		}
		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	protected String getView() {
		return null;
	}

}
