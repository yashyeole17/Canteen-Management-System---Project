package in.co.canteen.mg.Bean;

public class ProductCompanyBean  extends BaseBean{

	private String companyName;
	
	private String productName;
	
	private long producttypeid;
	
	
	
	public long getProducttypeid() {
		return producttypeid;
	}

	public void setProducttypeid(long producttypeid) {
		this.producttypeid = producttypeid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String getKey() {
		return id+"";
	}

	@Override
	public String getValue() {
		return companyName;
	}

}
