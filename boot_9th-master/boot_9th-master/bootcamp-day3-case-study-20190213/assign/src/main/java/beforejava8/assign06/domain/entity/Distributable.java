package beforejava8.assign06.domain.entity;

import java.util.List;

public interface Distributable {

	public abstract List<Assign> distribute(List<Customer> satisfiedCustomers, List<Consultant> consultants);
	
}
