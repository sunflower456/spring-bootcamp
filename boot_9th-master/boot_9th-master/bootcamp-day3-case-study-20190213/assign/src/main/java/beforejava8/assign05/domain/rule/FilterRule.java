package beforejava8.assign05.domain.rule;

import beforejava8.assign05.domain.entity.Customer;

public interface FilterRule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
