package com.by.petrfeldsherov.resumes.model;

import java.util.Objects;

public class DescriptionSection extends Section {
	
	private String content;
	
	public DescriptionSection(String content) {
		Objects.requireNonNull(content, "content mustn't be null");
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DescriptionSection other = (DescriptionSection) obj;
		return Objects.equals(content, other.content);
	}
	@Override
	public String toString() {
		return "DescriptionSection [content=" + content + "]";
	}
	
}
