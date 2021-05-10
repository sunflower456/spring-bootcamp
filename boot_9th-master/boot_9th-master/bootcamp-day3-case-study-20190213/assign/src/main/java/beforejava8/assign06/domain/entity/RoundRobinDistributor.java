package beforejava8.assign06.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinDistributor implements Distributable {

	@Override
	public List<Assign> distribute(List<Customer> satisfiedCustomers, List<Consultant> consultants) {
		int index = 0;
		List<Assign> assigns = new ArrayList<Assign>();
		for (Consultant consultant: consultants) {
			for (int i=0; i<consultant.getAssignLimit(); i++) {
				assigns.add(new Assign(consultant, fetchCustomer(satisfiedCustomers, index)));
				index++;
			}
		}
		
		return assigns;
	}
	
	private Customer fetchCustomer(List<Customer> satisfiedCustomers, int index) {
		//
		return satisfiedCustomers.get(index);
	}

}
