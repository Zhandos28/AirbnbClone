package form;

import org.formbeanfactory.FieldOrder;
import org.formbeanfactory.FormBean;
import org.formbeanfactory.InputType;

@FieldOrder("balance")
public class BalanceForm extends FormBean {
	private String balance;
	private String action;
	public String getAction()    { return action; }
	public String getBalance() {
		return balance;
	}
	@InputType("text")
	public void setBalance(String balance) {
		this.balance = balance;
	}
	@InputType("button")
    public void setAction(String s)    { action   = s;        }
	
	public void validate() {
        super.validate();
        if (hasValidationErrors()) {
            return;
        }
        
        if (balance.length()==0) {
            this.addFieldError("balance", "Can not be empty");
        }
    }
}
