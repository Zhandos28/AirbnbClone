package bean;

import org.genericdao.PrimaryKey;

@PrimaryKey("adminEmail")
public class Admin {
    private String adminEmail;
    private String password;
    private String firstName;
    private String lastName;
    
    public String getPassword()        { return password; }
    public String getAdminEmail()        { return adminEmail; }

    public void setPassword(String s)  { password = s;    }
    public void setAdminEmail(String s)  { adminEmail = s;    }
	public void setFirstName(String f) {
		// TODO Auto-generated method stub
		firstName = f;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
}
