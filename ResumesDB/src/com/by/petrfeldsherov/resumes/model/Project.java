package com.by.petrfeldsherov.resumes.model;

import java.time.LocalDate;
import java.util.Objects;

public class Project {
	public final LocalDate startDate;
	public final LocalDate endDate;
	public final String title;
	public final String description;

	public Project(LocalDate startDate, LocalDate endDate, String title, String description) {
		Objects.requireNonNull(startDate, "startDate mustn't be null");
		Objects.requireNonNull(endDate, "endDate mustn't be null");
		Objects.requireNonNull(title, "title mustn't be null");
		this.startDate = startDate;
		this.endDate = endDate;
		this.title = title;
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDate, startDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Project [startDate=" + startDate + ", endDate=" + endDate + ", title=" + title + ", description="
				+ description + "]";
	}
}