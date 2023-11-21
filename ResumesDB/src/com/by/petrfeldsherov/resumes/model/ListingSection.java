package com.by.petrfeldsherov.resumes.model;

import java.util.List;
import java.util.Objects;

public class ListingSection extends Section {
	
	private final List<String> list;
	
	public ListingSection(List<String> list) {
		Objects.requireNonNull(list, "list mustn't be null");
		this.list = list;
	}
	
	public List<String> getList() {
		return list;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(list);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListingSection other = (ListingSection) obj;
		return Objects.equals(list, other.list);
	}
	@Override
	public String toString() {
		return "ListingSection [list=" + list + "]";
	}
	
}
