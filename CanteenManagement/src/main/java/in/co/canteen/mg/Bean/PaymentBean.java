package in.co.canteen.mg.Bean;

public class PaymentBean extends BaseBean{
	
	private String productname;
	private String typename;
	private String companyname;
	private long totalprice;
	private int quantity;
	private String useremail;
	private String username;
	private String accountno;
	private String bankname;
	private String cardname;
	private long userId;
	private String orderID;
	private long totalCharge;
    private static String status;

	public static String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		PaymentBean.status = status;
	}

	public long getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(long totalCharge) {
		this.totalCharge = totalCharge;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public long getUserId() {
		return userId;
	}

	public  void setUserId(long userId) {
		this.userId = userId;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public long getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(long totalprice) {
		this.totalprice = totalprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
