package beforejava8.assign06.domain.rule;

import beforejava8.assign06.domain.entity.Customer;

public interface FilterRule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
