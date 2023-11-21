package com.by.petrfeldsherov.resumes.model;

//HashMap<ContactType, String> contacts; setting field in ctor: go throw types and put <key, either null or info>
public enum ContactType {
	PHONE_NUMBER("Phone number"),
	EMAIL("Email"),
	SKYPE("Skype"),
	LINKEDIN("LinkedIn"),
	WEBSITE("Personal website"),
	GITHUB("GitHub"),
	STACK_OVERFLOW("Stack Overflow");
	
	private String typeName;
	
	ContactType(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}
}
