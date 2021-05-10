package beforejava8.assign02.story;

import java.util.ArrayList;
import java.util.List;

import beforejava8.assign02.domain.entity.Customer;
import beforejava8.assign02.domain.rule.AgeRule;
import beforejava8.assign02.domain.rule.HasContactRule;
import beforejava8.assign02.domain.rule.Rule;
import beforejava8.assign02.util.Generator;

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

		Rule rule = new AgeRule(10, 20);
		System.out.println("-------------------");
		List<Customer> filteredCustomersByAge = new ArrayList<Customer>();
		System.out.println("\nfiltered customers by age");
		System.out.println("-------------------");
		for (Customer customer: customers) {
			if (rule.isSatisfied(customer)) {
				filteredCustomersByAge.add(customer);
				System.out.println(customer.toString());
			}
		}
		
		Rule hasContactRule = new HasContactRule();
		System.out.println("-------------------");
		List<Customer> filteredCustomersByHasContactRule = new ArrayList<Customer>();
		System.out.println("\nfiltered customers by contact");
		System.out.println("-------------------");
		for (Customer customer: customers) {
			if (hasContactRule.isSatisfied(customer)) {
				filteredCustomersByHasContactRule.add(customer);
				System.out.println(customer.toString());
			}
		}
	}
	
}
