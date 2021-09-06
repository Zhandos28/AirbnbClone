package form;

import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;



public class UserEmailForm extends FormBean {
	private String userEmail;

	public String getUserEmail() { return userEmail;    }
	
	
	@InputType("hidden")
	public void setUserEmail(String id) { this.userEmail = id; }

	public void validate() {
	    super.validate();

	    if (hasValidationErrors()) {
	        return;
	    }

	}
}