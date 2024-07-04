package in.co.canteen.mg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.canteen.mg.Bean.ProductsTypeBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Utility.JDBCDataSource;

public class ProductTypeModel {
	
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM producttype");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(ProductsTypeBean bean) throws Exception {
		System.out.println("in add method");
		Connection conn = null;
		int pk = 0;
		ProductTypeModel model = new ProductTypeModel();
		ProductsTypeBean existbean = findByProductName(bean.getProductName());
		if (existbean != null) {
			throw new DuplicateRecordException("Product Name is already exist");
		}
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO producttype VALUES(?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getProductID());
			ps.setString(3, bean.getProductName());
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
	
	private ProductsTypeBean findByProductName(String productName) throws Exception {
		ProductsTypeBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM producttype WHERE productName=?");
			ps.setString(1, productName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductsTypeBean();
				bean.setId(rs.getLong(1));
			    bean.setProductID(rs.getString(2));
			    bean.setProductName(rs.getString(3));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public ProductsTypeBean findByPk(long pk) throws Exception {
		ProductsTypeBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM producttype WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductsTypeBean();
				bean.setId(rs.getLong(1));
			    bean.setProductID(rs.getString(2));
			    bean.setProductName(rs.getString(3));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public List list() throws Exception {
		System.out.println("in model list");
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from producttype");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ProductsTypeBean bean = new ProductsTypeBean();
			bean.setId(rs.getLong(1));
		    bean.setProductID(rs.getString(2));
		    bean.setProductName(rs.getString(3));
			list.add(bean);
		}
		return list;
	}
	
	public static long delete(long id) throws Exception {
        int pk =  0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM producttype WHERE id=?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
}

	
	public long Update(ProductsTypeBean bean) {
		System.out.println("in model update method");
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update producttype set productid=?,productName=? where id=?");
			ps.setString(1, bean.getProductID());
			ps.setString(2, bean.getProductName());
			ps.setLong(3, bean.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
}
