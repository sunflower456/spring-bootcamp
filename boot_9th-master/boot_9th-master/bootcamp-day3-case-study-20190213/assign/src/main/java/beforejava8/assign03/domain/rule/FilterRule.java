package beforejava8.assign03.domain.rule;

import beforejava8.assign03.domain.entity.Customer;

public interface FilterRule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
