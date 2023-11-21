package com.by.petrfeldsherov.resumes.model;

public enum SectionType {
	PERSONAL("Personal qualities"),
	OBJECTIVE("Objective"),
	ACHIEVEMENTS("Achievements"),
	QUALIFICATIONS("Qualifications"),
	EXPERIENCE("Professional expirience"),
	EDUCATION("Education, certifications and affiliations");
	
	private String typeName;

	private SectionType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
}
