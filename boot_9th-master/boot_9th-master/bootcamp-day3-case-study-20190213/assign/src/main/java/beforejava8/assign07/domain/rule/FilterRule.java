package beforejava8.assign07.domain.rule;

import beforejava8.assign07.domain.entity.Customer;

public interface FilterRule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
