package beforejava8.assign03.domain.rule;

import beforejava8.assign03.domain.entity.Customer;
import beforejava8.assign03.domain.entity.GenderType;

public class GenderRule implements FilterRule {
	
	private GenderType genderType;

	public GenderRule(GenderType genderType) {
		this.genderType = genderType;
	}

	@Override
	public boolean isSatisfied(Customer customer) {
		//
		return customer.getGender() == genderType ? true : false;
	}

}
