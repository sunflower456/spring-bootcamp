package java8.step03.domain.entity.rule;

import java.util.function.Predicate;

import java8.step03.domain.entity.Customer;

public class AgeRule implements Predicate<Customer> {
	
	private int min;
	private int max;

	public AgeRule(int min, int max) {
		//
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean test(Customer customer) {
		//
		int age = customer.getAge();
		
		if (min <= age && age <= max) {
			return true;
		} else {
			return false;
		}
	}

}
