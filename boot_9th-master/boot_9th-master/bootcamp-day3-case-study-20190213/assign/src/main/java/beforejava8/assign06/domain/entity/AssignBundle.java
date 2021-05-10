package beforejava8.assign06.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beforejava8.assign06.domain.rule.FilterRule;
import beforejava8.assign06.domain.rule.SortRule;

public class AssignBundle {

	private List<Customer> candidates;
	
	private List<Consultant> consultants;
	
	private List<FilterRule> filters;
	
	private SortRule sorter;
	
	private Distributable distributor;
	
	public AssignBundle() {
		//
		candidates = new ArrayList<Customer>();
		consultants = new ArrayList<Consultant>();
		filters = new ArrayList<FilterRule>();
		distributor = new RoundRobinDistributor();
	}
	
	public List<Assign> assign() {
		//
		List<Customer> satisfiedCustomers = filter();
		sort(satisfiedCustomers);
		List<Assign> assigns = distributor.distribute(satisfiedCustomers, consultants);
		
		return assigns;
	}
	
	private List<Customer> filter() {
		//
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
	
	private void sort(List<Customer> satisfiedCustomers) {
		//
		Collections.sort(satisfiedCustomers, sorter);
	}
	
	public void addFilter(FilterRule filter) {
		//
		this.filters.add(filter);
	}
	
	public void addCandidates(List<Customer> candidates) {
		//
		this.candidates.addAll(candidates);
	}
	
	public void addConstultans(List<Consultant> consultants) {
		//
		this.consultants.addAll(consultants);
	}
	
	public List<Customer> getCandidates() {
		return candidates;
	}

	public List<Consultant> getConsultants() {
		return consultants;
	}

	public List<FilterRule> getFilters() {
		return filters;
	}

	public SortRule getSorter() {
		return sorter;
	}

	public void setSorter(SortRule sorter) {
		this.sorter = sorter;
	}

}
