package in.co.canteen.mg.Bean;

public class ProductsTypeBean extends BaseBean{

	
	private String productName;
    private String productID;
	
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	@Override
	public String getKey() {
		return id +"";
	}

	@Override
	public String getValue() {
		return productName;
	}
	
	

}
