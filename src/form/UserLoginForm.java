package form;

import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("userEmail, password")
public class UserLoginForm extends FormBean {
    private String userEmail;
    private String password;
    private String action;
    
    public String getUserEmail()  { return userEmail; }
    public String getPassword()  { return password; }
    public String getAction()    { return action; }
	
    @InputType("email")
    public void setUserEmail(String s)  { userEmail = s.trim(); }
    @InputType("password")
    public void setPassword(String s)  { password = s.trim(); }
    @InputType("button")
    public void setAction(String s)    { action   = s;        }

    public void validate() {
        super.validate();
        if (hasValidationErrors()) {
            return;
        }
        
        if (!action.equals("Login") && !action.equals("Register")) {
            this.addFormError("Invalid button");
        }
        
        if (userEmail.matches(".*[<>\"].*")) {
            this.addFieldError("userEmail", "May not contain angle brackets or quotes");
        }
    }
}
