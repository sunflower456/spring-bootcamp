package java8.step01.story;

import java.util.List;
import java.util.stream.Collectors;

import java8.step01.domain.entity.Customer;
import java8.step01.domain.entity.GenderType;
import java8.step01.util.Generator;

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
				.filter((cust) -> cust.getGender() == GenderType.MALE)
				.collect(Collectors.toList());
		for (Customer customer: filteredCustomers) {
			System.out.println(customer.toString());
		}
	}
	
}
