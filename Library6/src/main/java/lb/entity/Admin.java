package lb.entity;

public class Admin {

	private String admin_name;
	private String Password;
	public Admin(){}
	public Admin(String admin_name,String password)
	{
		this.admin_name=admin_name;
		this.Password=Password;
	}
	public String getadmin_name() {
		return admin_name;
	}
	public void setadmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}
