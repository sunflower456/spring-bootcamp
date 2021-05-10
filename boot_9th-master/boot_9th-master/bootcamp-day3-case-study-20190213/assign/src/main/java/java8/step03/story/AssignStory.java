package java8.step03.story;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8.step03.domain.entity.Customer;
import java8.step03.domain.entity.GenderType;
import java8.step03.domain.entity.rule.AgeRule;
import java8.step03.domain.entity.rule.GenderRule;
import java8.step03.util.Generator;

public class AssignStory {

	public static void main(String[] args) {
		//
		List<Customer> customers = Generator.generateCustomers();
		System.out.println("customers");
		System.out.println("-------------------");
		System.out.println("count: " + customers.size());
		System.out.println("-------------------");
		for (Customer customer: customers) {
			System.out.println(customer.toString());
		}
		
		System.out.println("-------------------");
		System.out.println("\nfiltered customers");
		System.out.println("-------------------");
		List<Customer> filteredCustomers =
			customers.stream()
				.filter(new GenderRule(GenderType.FEMALE))
				.collect(Collectors.toList());
		for (Customer customer: filteredCustomers) {
			System.out.println(customer.toString());
		}
		
		// 여성, 연령(14~33) 필터링 조합
		Predicate<Customer> predicate = new GenderRule(GenderType.FEMALE);
		predicate = predicate.and(new AgeRule(14, 33));
		
		System.out.println("-------------------");
		System.out.println("\ncomposite filtered customers");
		System.out.println("-------------------");
		List<Customer> compositFilteredCustomers =
			customers.stream()
				.filter(predicate)
				.collect(Collectors.toList());
		for (Customer customer: compositFilteredCustomers) {
			System.out.println(customer.toString());
		}
		
		Comparator<Customer> comparator = Comparator.comparing(Customer::getAge);
	    comparator = comparator.thenComparing(Comparator.comparing(Customer::getGender)).reversed();
	    List<Customer> sortedCustomers =
				customers.stream()
					.filter(predicate)
					.sorted(comparator)
					.collect(Collectors.toList());
	    
	    System.out.println("-------------------");
		System.out.println("\nsorted customers");
		System.out.println("-------------------");
		for (Customer customer: sortedCustomers) {
			System.out.println(customer.toString());
		}
	}
	
}
