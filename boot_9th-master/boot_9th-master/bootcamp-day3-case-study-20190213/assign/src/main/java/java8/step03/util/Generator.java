package java8.step03.util;

import java.util.ArrayList;
import java.util.List;

import java8.step03.domain.entity.Birthday;
import java8.step03.domain.entity.Contact;
import java8.step03.domain.entity.ContactType;
import java8.step03.domain.entity.Customer;
import java8.step03.domain.entity.GenderType;

public class Generator {

	public static List<Customer> generateCustomers() {
		//
		List<Customer> customers = new ArrayList<Customer>();
		
		//
		Customer customer1 = new Customer("100", "조재윤", GenderType.MALE, new Birthday("19810101"));
		Contact homeContact1 = new Contact(ContactType.HOME, "0311234567");
		customer1.addContact(homeContact1);
		customers.add(customer1);
		
		Customer customer2 = new Customer("101", "김영희", GenderType.FEMALE, new Birthday("19981209"));
		customers.add(customer2);
		
		Customer customer3 = new Customer("102", "김철수", GenderType.MALE, new Birthday("20040623"));
		Contact homeContact3 = new Contact(ContactType.HOME, "0311234567");
		customer3.addContact(homeContact3);
		Contact mobileContact1 = new Contact(ContactType.MOBILE, "01012345678");
		customer3.addContact(mobileContact1);
		customers.add(customer3);
		
		Customer customer4 = new Customer("103", "이동윤", GenderType.FEMALE, new Birthday("20011029"));
		Contact mobileContact2 = new Contact(ContactType.MOBILE, "01058749387");
		customer4.addContact(mobileContact2);
		customers.add(customer4);
		
		Customer customer5 = new Customer("104", "송철수", GenderType.FEMALE, new Birthday("19810102"));
		Contact homeContact5 = new Contact(ContactType.HOME, "0311234567");
		customer5.addContact(homeContact5);
		customers.add(customer5);
		
		return customers;
	}

}
