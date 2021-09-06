package form;

import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;


public class EmailForm extends FormBean {
	private String adminEmail;

	public String getAdminEmail() { return adminEmail;    }
	
	
	@InputType("hidden")
	public void setAdminEmail(String id) { this.adminEmail = id; }

	public void validate() {
	    super.validate();

	    if (hasValidationErrors()) {
	        return;
	    }

	}
}
