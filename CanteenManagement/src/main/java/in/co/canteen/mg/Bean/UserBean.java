package in.co.canteen.mg.Bean;

public class UserBean extends BaseBean {

	private String userName;

	private String email;

	private String password;

	private long roleId;

	private String roleName;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return userName;
	}
}
