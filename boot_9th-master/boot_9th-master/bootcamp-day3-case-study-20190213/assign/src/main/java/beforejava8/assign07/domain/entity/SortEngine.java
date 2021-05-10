package beforejava8.assign07.domain.entity;

import java.util.Collections;
import java.util.List;

import beforejava8.assign07.domain.rule.SortRule;

public class SortEngine {

	public List<Customer> sort(List<Customer> satisfiedCustomers, SortRule sorter) {
		Collections.sort(satisfiedCustomers, sorter);
		return satisfiedCustomers;
	}
}
