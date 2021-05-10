package beforejava8.assign04.domain.rule;

import beforejava8.assign04.domain.entity.Customer;

public interface FilterRule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
