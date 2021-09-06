package bean;

import org.genericdao.PrimaryKey;

@PrimaryKey("userEmail")
public class User {
    private String userEmail;
    private String password;
    private String balance;
    private String adminStatus = "0";
    
    public String getPassword()        { return password; }
    public String getUserEmail()        { return userEmail; }
    public String getBalance()        { return balance; }
    public String getAdminStatus()    { return adminStatus; }

    public void setPassword(String s)  { password = s;    }
    public void setUserEmail(String s)  { userEmail = s;    }
    public void setBalance(String s)  { balance = s;    }
    public void setAdminStatus(String b) { adminStatus = b; }
}
