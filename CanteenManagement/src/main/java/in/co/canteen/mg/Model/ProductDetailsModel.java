package in.co.canteen.mg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.canteen.mg.Bean.ProductCompanyBean;
import in.co.canteen.mg.Bean.ProductDetailsBean;
import in.co.canteen.mg.Bean.ProductsTypeBean;
import in.co.canteen.mg.Exception.ApplicationException;
import in.co.canteen.mg.Exception.DuplicateRecordException;
import in.co.canteen.mg.Utility.JDBCDataSource;

public class ProductDetailsModel {
	
	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM productdetails");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(ProductDetailsBean bean) throws Exception {
		Connection conn = null;
		int pk = 0;
		
		ProductTypeModel model = new ProductTypeModel();
		ProductsTypeBean typeBean = new ProductsTypeBean();
		typeBean = model.findByPk(bean.getTypeid());
		String typeName = typeBean.getProductName();
		
		ProductCompanyModel model1 = new ProductCompanyModel();
		ProductCompanyBean companyBean = new ProductCompanyBean();
		companyBean = model1.findByPk(bean.getCompanyid());
		String companyName = companyBean.getCompanyName();
		
		ProductDetailsBean existbean = findByProductName(bean.getProductName());
		if (existbean != null) {
			throw new DuplicateRecordException("Product Name is already exist");
		}
		
		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO productdetails VALUES(?,?,?,?,?,?,?,?)");
			ps.setLong(1, pk);
			ps.setString(2, bean.getProductName());
			ps.setLong(3, bean.getPrice());
			ps.setBlob(4, bean.getImage());
			ps.setLong(5, bean.getTypeid());
			ps.setString(6, typeName);
			ps.setLong(7, bean.getCompanyid());
			ps.setString(8, companyName);
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
	
	private ProductDetailsBean findByProductName(String productName) throws Exception {
		ProductDetailsBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM productdetails WHERE productName=?");
			ps.setString(1, productName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductDetailsBean();
				bean.setId(rs.getLong(1));
			    bean.setProductName(rs.getString(2));
			    bean.setPrice(rs.getLong(3));
			    bean.setImage(rs.getBlob(4));
			    bean.setTypeid(rs.getLong(5));
			    bean.setTypeName(rs.getString(6));
			    bean.setCompanyid(rs.getLong(7));
			    bean.setComapnyName(rs.getString(8));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public ProductDetailsBean findByPk(long pk) throws Exception {
		ProductDetailsBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM productdetails WHERE id=?");
			ps.setLong(1, pk);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new ProductDetailsBean();
				bean.setId(rs.getLong(1));
			    bean.setProductName(rs.getString(2));
			    bean.setPrice(rs.getLong(3));
			    bean.setImage(rs.getBlob(4));
			    bean.setTypeid(rs.getLong(5));
			    bean.setTypeName(rs.getString(6));
			    bean.setCompanyid(rs.getLong(7));
			    bean.setComapnyName(rs.getString(8));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public List list() throws Exception {
		ArrayList list = new ArrayList();
		try {
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from productdetails");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			ProductDetailsBean bean = new ProductDetailsBean();
			bean.setId(rs.getLong(1));
		    bean.setProductName(rs.getString(2));
		    bean.setPrice(rs.getLong(3));
		    bean.setImage(rs.getBlob(4));
		    bean.setTypeid(rs.getLong(5));
		    bean.setTypeName(rs.getString(6));
		    bean.setCompanyid(rs.getLong(7));
		    bean.setComapnyName(rs.getString(8));
			list.add(bean);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static long delete(long id) throws Exception {
        int pk =  0;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM productdetails WHERE id=?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
}
	
	public long cartIdUpdate(long id,long Cid) {
		int pk = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("update productdetails set cartid='" + Cid + "' where id=?");
			ps.setLong(1, Cid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}


}
