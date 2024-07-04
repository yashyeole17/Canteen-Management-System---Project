package in.co.canteen.mg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.canteen.mg.Bean.ProductCompanyBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Utility.JDBCDataSource;

public class ProductCompanyModel {
	
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM productcompany");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(ProductCompanyBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;
		ProductCompanyModel model = new ProductCompanyModel();
		ProductCompanyBean existbean = findByProductCompanyName(bean.getCompanyName());
		if (existbean != null) {
			throw new DuplicateRecordException("Product Company Name is already exist");
		}
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO productcompany VALUES(?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getCompanyName());
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
	
	private ProductCompanyBean findByProductCompanyName(String productcompanyName) throws Exception {
		ProductCompanyBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM productcompany WHERE companyName=?");
			ps.setString(1, productcompanyName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductCompanyBean();
				bean.setId(rs.getLong(1));
			    bean.setCompanyName(rs.getString(2));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public ProductCompanyBean findByPk(long pk) throws Exception {
		ProductCompanyBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM productcompany WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductCompanyBean();
				bean.setId(rs.getLong(1));
			    bean.setCompanyName(rs.getString(2));
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
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from productcompany");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ProductCompanyBean bean = new ProductCompanyBean();
			bean.setId(rs.getLong(1));
		    bean.setCompanyName(rs.getString(2));
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
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM productcompany WHERE id=?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
}

	
	public long Update(ProductCompanyBean bean) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update productcompany set companyName=? where id=?");
			ps.setString(1, bean.getCompanyName());
			ps.setLong(2, bean.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	

}
