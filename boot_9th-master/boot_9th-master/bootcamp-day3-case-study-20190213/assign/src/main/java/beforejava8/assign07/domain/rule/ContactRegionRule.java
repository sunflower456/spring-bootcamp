package beforejava8.assign07.domain.rule;

import beforejava8.assign07.domain.entity.Contact;
import beforejava8.assign07.domain.entity.ContactType;
import beforejava8.assign07.domain.entity.Customer;
import beforejava8.assign07.domain.exception.AssignException;

public class ContactRegionRule implements FilterRule {
	
	private String value;

	public ContactRegionRule(String value) {
		this.value = value;
	}

	@Override
	public boolean isSatisfied(Customer customer) {
		//
		try {
			Contact contact = customer.findContact(ContactType.HOME);
			return contact.getNo().startsWith(this.value);
		} catch (AssignException e) {
			return false;
		}
	}

}
