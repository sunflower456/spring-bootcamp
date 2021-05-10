package beforejava8.assign07.domain.entity;

import java.util.List;

public interface Distributable {

	public abstract List<Assign> distribute(List<Customer> satisfiedCustomers, List<Consultant> consultants);
	
}
