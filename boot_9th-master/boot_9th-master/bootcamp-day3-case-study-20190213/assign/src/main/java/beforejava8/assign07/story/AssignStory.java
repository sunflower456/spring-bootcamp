package beforejava8.assign07.story;

import java.util.List;

import beforejava8.assign07.domain.entity.Assign;
import beforejava8.assign07.domain.entity.AssignBundle;
import beforejava8.assign07.domain.rule.AgeRule;
import beforejava8.assign07.domain.rule.SortType;
import beforejava8.assign07.util.Generator;

public class AssignStory {

	public static void main(String[] args) {
		//
		AssignBundle bundle = new AssignBundle();

		bundle.addCandidates(Generator.generateCustomers());
		bundle.addConstultans(Generator.generateConsultants());
		bundle.addFilter(new AgeRule(10, 20));
		bundle.setSorter(new AgeRule(SortType.ASCENDING));

		List<Assign> assigns = bundle.assign();

		System.out.println("\nassigns");
		System.out.println("-------------------");
		for (Assign assign: assigns) {
			System.out.println(assign.toString());
		}
	}
	
}
