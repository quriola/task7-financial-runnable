package formbeans;

import java.util.ArrayList;
import java.util.List;

import org.mybeans.form.FormBean;

public class SellForm extends FormBean {
	private String fundName;
	private long shareNumber;
	
	public String getFundName() {
		return fundName;
	}
	public long getShareNumber() {
		return shareNumber;
	}
	
	public void setFundName(String s) {
		fundName = s;
	}
	public void setShareNumber(long l) {
		shareNumber = l;
	}
	
	public List<String> getValidationErrors() {
		List<String> errors = new ArrayList<String>();
		
		if(shareNumber == 0) {
			errors.add("Number of shares required");
		}
		
		return errors;
	}

}
