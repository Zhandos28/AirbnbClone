package form;

import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("adminEmail, firstName, lastName, password, confirm")
public class AdminAddForm extends FormBean {
    private String action;
    private String firstName;
    private String lastName;
    private String adminEmail;
    private String password;
    private String confirm;
    
    public String getConfirm() 		{ return confirm; }
    public String getFirstName() 		{ return firstName; }
    public String getLastName() 		{ return lastName; }
    public String getPassword()        { return password; }
    public String getAdminEmail()        { return adminEmail; }

    public void setFirstName(String s) { firstName = s; }
    public void setLastName(String s) { lastName = s; }
    
    @InputType("email")
    public void setAdminEmail(String s)  { adminEmail = s;    }
    public String getAction()    { return action; }
	
    @InputType("password")
    public void setConfirm(String s) { confirm = s; }
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
        
        if (lastName.matches(".*[<>\"].*")) {
            this.addFieldError("lastName", "May not contain angle brackets or quotes");
        }
        if (firstName.matches(".*[<>\"].*")) {
            this.addFieldError("firstName", "May not contain angle brackets or quotes");
        }
        
        if (!password.equals(confirm)) {
            this.addFieldError("password", "Passwords do not match!");
        }
    }
}
