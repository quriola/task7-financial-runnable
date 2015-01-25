package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class CustomerForm extends FormBean{
    private String customerId;
    
    public String getCusId()           { return customerId;     }
    
    public void setCusId(String cusId) { this.customerId = cusId; }
    
    public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();

		if (customerId == null) {
			errors.add("Customer is required");
		}
		
		return errors;
	}
}
