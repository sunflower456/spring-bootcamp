package beforejava8.assign02.domain.rule;

import beforejava8.assign02.domain.entity.Customer;

public interface Rule {
	
	public abstract boolean isSatisfied(Customer customer);
	
}
