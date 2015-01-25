package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class BuyForm extends FormBean {
	private String fundId;
	private long amount;
	
	public String getFundId() { return fundId; }
	public long getAmount() { return amount; }
	
	public void setFundId(String s) {fundId = s;}
	public void setAmount(long l) { amount = l;}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		
		if(amount == 0) {
			errors.add("Amount is required");
		}
		
		return errors;
	}

}
