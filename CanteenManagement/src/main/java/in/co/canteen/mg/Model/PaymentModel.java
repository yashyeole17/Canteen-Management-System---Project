package in.co.canteen.mg.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.co.canteen.mg.Bean.PaymentBean;
import in.co.canteen.mg.Utility.JDBCDataSource;

public class PaymentModel {

	public Integer nextPk() throws Exception {
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM payment");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pk + 1;
	}

	public long add(List<PaymentBean> plist) throws Exception {
		Connection conn = null;
		int pk = 0;
//		PaymentBean existbean = findByStatus(PaymentBean.getStatus());
//		if (existbean != null) {
//			throw new DuplicateRecordException("this Product is already Paid");
//		}
		try {
			conn = JDBCDataSource.getConnection();
			// pk = nextPk();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO payment VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			for (PaymentBean bean : plist) {
				ps.setLong(1, bean.getId());
				ps.setString(2, bean.getOrderID());
				ps.setString(3, bean.getProductname());
				ps.setString(4, bean.getUseremail());
				ps.setString(5, bean.getUsername());
				ps.setString(6, bean.getAccountno());
				ps.setString(7, bean.getBankname());
				ps.setString(8, bean.getCardname());
				ps.setLong(9, bean.getTotalprice());
				ps.setLong(10, bean.getTotalCharge());
				ps.setString(11, bean.getStatus());
				ps.addBatch();
			}
			int[] count = ps.executeBatch();
			conn.commit();
			pk = 0;
			conn.setAutoCommit(true);
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pk;
	}
	
	private PaymentBean findByStatus(String status) throws Exception {
		PaymentBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM payment WHERE status=?");
			ps.setString(1, status);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean = new PaymentBean();
				bean.setId(rs.getLong(1));
				bean.setOrderID(rs.getString(2));
				bean.setProductname(rs.getString(3));
				bean.setUseremail(rs.getString(4));
				bean.setUsername(rs.getString(5));
				bean.setAccountno(rs.getString(6));
				bean.setBankname(rs.getString(7));
				bean.setCardname(rs.getString(8));
				bean.setTotalprice(rs.getLong(9));
				bean.setTotalCharge(rs.getLong(10));
				bean.setStatus(rs.getString(11));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	

	public List Paymentlist(String email) throws Exception {
		StringBuffer sql = new StringBuffer(
				"SELECT * from payment where useremail=?");
		
		//sql.append("order by id desc limit 1");
		ArrayList list = new ArrayList();

		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		// PreparedStatement pstmt = conn.prepareStatement("SELECT distinct
		// useremail,userName,accountNo,bankname,cardName from payment where
		// useremail=?");
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setOrderID(rs.getString(2));
			bean.setProductname(rs.getString(3));
			bean.setUseremail(rs.getString(4));
			bean.setUsername(rs.getString(5));
			bean.setAccountno(rs.getString(6));
			bean.setBankname(rs.getString(7));
			bean.setCardname(rs.getString(8));
			bean.setTotalprice(rs.getLong(9));
			bean.setTotalCharge(rs.getLong(10));
			list.add(bean);
		}
		return list;
	}
	
	public List list() throws Exception {
		ArrayList list = new ArrayList();
		Connection conn = null;
		conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from payment");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			PaymentBean bean = new PaymentBean();
			bean.setId(rs.getLong(1));
			bean.setOrderID(rs.getString(2));
			bean.setProductname(rs.getString(3));
			bean.setUseremail(rs.getString(4));
			bean.setUsername(rs.getString(5));
			bean.setAccountno(rs.getString(6));
			bean.setBankname(rs.getString(7));
			bean.setCardname(rs.getString(8));
			bean.setTotalprice(rs.getLong(9));
			bean.setTotalCharge(rs.getLong(10));
			list.add(bean);
		}
		return list;
	}
	
	
	
	public static long delete(long id) {
		int i = 0;
		try {
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement("DELETE from payment where id=?");
			stmt.setLong(1, id);
			i = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	

}
