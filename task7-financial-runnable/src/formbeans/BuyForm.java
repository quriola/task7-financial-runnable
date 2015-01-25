package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class BuyForm extends FormBean {
	private String fundName;
	private long amount;
	
	public String getFundName() { return fundName; }
	public long getAmount() { return amount; }
	
	public void setFundName(String s) {fundName = s;}
	public void setAmount(long l) { amount = l;}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		
		if(amount == 0) {
			errors.add("Amount is required");
		}
		
		return errors;
	}

}
