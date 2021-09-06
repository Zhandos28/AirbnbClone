package form;

import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("userEmail, password, confirm")
public class UserAddForm extends FormBean {
    private String action;
    private String confirm;
    private String userEmail;
    private String password;
    
    public String getConfirm() 		{ return confirm; }
    public String getPassword()        { return password; }
    public String getUserEmail()        { return userEmail; }
    
    @InputType("password")
    public void setConfirm(String s) { confirm = s; }
    
    @InputType("email")
    public void setUserEmail(String s)  { userEmail = s;    }
    public String getAction()    { return action; }
	
    @InputType("password")
    public void setPassword(String s)  { password = s.trim(); }
    @InputType("button")
    public void setAction(String s)    { action   = s.trim();        }

    public void validate() {
        super.validate();
        if (hasValidationErrors()) {
            return;
        }
        
        if (!action.equals("Create")) {
            this.addFormError("Invalid button");
        }
        
        if (!password.equals(confirm)) {
            this.addFieldError("password", "Passwords do not match!");
        }
        
    }
}