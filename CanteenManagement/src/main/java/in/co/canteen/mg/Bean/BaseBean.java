package in.co.canteen.mg.Bean;

public abstract class BaseBean implements DropDownListBean,Comparable<BaseBean>{

	protected long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int compareTo(BaseBean o) {
		return getValue().compareTo(getKey());
	}


}