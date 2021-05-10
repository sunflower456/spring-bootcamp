package java8.step02.domain.entity.rule;

import java.util.function.Predicate;

import java8.step02.domain.entity.Customer;
import java8.step02.domain.entity.GenderType;

public class GenderRule implements Predicate<Customer> {
	
	private GenderType genderType;
	
	public GenderRule(GenderType genderType) {
		this.genderType = genderType;
	}

	@Override
	public boolean test(Customer customer) {
		return customer.getGender() == genderType;
	}

}
