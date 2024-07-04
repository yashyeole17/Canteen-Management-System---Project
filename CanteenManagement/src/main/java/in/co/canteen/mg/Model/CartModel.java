package in.co.canteen.mg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.canteen.mg.Bean.CartBean;
import in.co.canteen.mg.Bean.ProductDetailsBean;
import in.co.canteen.mg.Controller.BaseCtl;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Utility.JDBCDataSource;
import in.co.canteen.mg.Utility.ServletUtility;

public class CartModel {

	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM cart");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(CartBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;
//		CartBean existbean = findByProductName(bean.getProductName());
//		if (existbean != null) {
//			throw new DuplicateRecordException("Product Quantity increased exist");
//		}
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO cart VALUES(?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setLong(2, bean.getUserID());
			ps.setString(3, bean.getProductName());
			ps.setLong(4, bean.getPrice());
			ps.setLong(5, bean.getQuantity());
			ps.setString(6, bean.getTypeName());
			ps.setString(7, bean.getCompanyName());
			ps.executeUpdate();
			conn.commit();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + e.getMessage());
			}
		} finally {
			JDBCDataSource.closeconnection(conn);
		}
		return pk;
	}

	private CartBean findByProductName(String productName) throws Exception {
		CartBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM cart WHERE productname=?");
			ps.setString(1, productName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new CartBean();
				bean.setId(rs.getLong(1));
				bean.setUserID(rs.getLong(2));
				bean.setProductName(rs.getString(3));
				bean.setPrice(rs.getLong(4));
				bean.setQuantity(rs.getInt(5));
				bean.setTypeName(rs.getString(6));
				bean.setCompanyName(rs.getString(7));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public List list() throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from cart");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CartBean bean = new CartBean();
			bean.setId(rs.getLong(1));
			bean.setUserID(rs.getLong(2));
			bean.setProductName(rs.getString(3));
			bean.setPrice(rs.getLong(4));
			bean.setQuantity(rs.getInt(5));
			bean.setTypeName(rs.getString(6));
			bean.setCompanyName(rs.getString(7));
			list.add(bean);
		}
		return list;
	}

	public List cartlist(long userID) throws Exception{
		ArrayList list = new ArrayList();
		
			Connection conn = null;
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT * from cart where userId=?");
			pstmt.setLong(1, userID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CartBean bean = new CartBean();
				bean.setId(rs.getLong(1));
				bean.setUserID(rs.getLong(2));
				bean.setProductName(rs.getString(3));
				bean.setPrice(rs.getLong(4));
				bean.setQuantity(rs.getInt(5));
				bean.setTypeName(rs.getString(6));
				bean.setCompanyName(rs.getString(7));
				list.add(bean);
			}
		return list;
	}

	public static long delete(long id) throws Exception {
		int pk = 0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM cart WHERE id=?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}

}
