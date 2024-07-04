package in.co.canteen.mg.Bean;

public class OrderBean extends BaseBean{
	
	
	private String orderid;
	private String price;
	private String productName;
	private int quantity;
	private long totalbill;
	
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(long totalbill) {
		this.totalbill = totalbill;
	}

	@Override
	public String getKey() {
		
		return null;
	}
	
	@Override
	public String getValue() {
		
		return null;
	}

}
