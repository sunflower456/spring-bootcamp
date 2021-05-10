package beforejava8.assign07.domain.entity;

import java.util.ArrayList;
import java.util.List;

import beforejava8.assign07.domain.rule.FilterRule;

public class FilterEngine {

	public List<Customer> filter(List<Customer> candidates, List<FilterRule> filters) {
		List<Customer> satistiedCustomers = new ArrayList<Customer>();

		for (FilterRule filter: filters) {
			for (Customer candidate: candidates) {
				if (filter.isSatisfied(candidate)) {
					satistiedCustomers.add(candidate);
				}
			}
		}
		
		return satistiedCustomers;
	}
	
}
