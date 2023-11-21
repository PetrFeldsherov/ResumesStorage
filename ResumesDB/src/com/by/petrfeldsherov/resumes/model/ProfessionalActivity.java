package com.by.petrfeldsherov.resumes.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProfessionalActivity {

	private final Link corporation;
    private final List<Project> corporationProjects = new ArrayList<>();

	public ProfessionalActivity(String corporationName, String corporationSite, LocalDate startDate, LocalDate endDate, String title,
			String description) {
		corporation = new Link(corporationName, corporationSite);
		corporationProjects.add(new Project(startDate, endDate, title, description));
	}
	
	public Link getCorporation() {
		return corporation;
	}
	public List<Project> getProjects() {
		return corporationProjects;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(corporation, corporationProjects);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessionalActivity other = (ProfessionalActivity) obj;
		return Objects.equals(corporation, other.corporation) && Objects.equals(corporationProjects, other.corporationProjects);
	}
	@Override
	public String toString() {
		return "ProfessionalActivity [corporation=" + corporation + ", projects=" + corporationProjects + "]";
	}
    
}
