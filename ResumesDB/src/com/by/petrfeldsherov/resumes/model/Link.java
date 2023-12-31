package com.by.petrfeldsherov.resumes.model;

import java.util.Objects;

public class Link {
	
	private final String name;
	private final String url;
	
	public Link(String name, String url) {
		Objects.requireNonNull(name, "name mustn't be null");
		this.name = name;
		this.url = url;
	}
	
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Link [name=" + name + ", url=" + url + "]";
	}
}
