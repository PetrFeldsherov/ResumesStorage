package com.by.petrfeldsherov.resumes.model;

import java.util.List;
import java.util.Objects;

public class ProfessionalActivitiesSection extends Section {
	
	private final List<ProfessionalActivity> activities;

	public ProfessionalActivitiesSection(List<ProfessionalActivity> activities) {
		Objects.requireNonNull(activities, "activities mustn't be null");
		this.activities = activities;
	}

	public List<ProfessionalActivity> getActivities() {
		return activities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(activities);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessionalActivitiesSection other = (ProfessionalActivitiesSection) obj;
		return Objects.equals(activities, other.activities);
	}

	@Override
	public String toString() {
		return "ProfessionalActivitySection [activities=" + activities + "]";
	}
		
}
