package com.by.petrfeldsherov.resumes.model;

import java.util.Objects;
import java.util.UUID;

public class Resume {

    private final String uuid;

    public Resume(String uuid) {
	this.uuid = uuid;
    }

    public Resume() {
	this(UUID.randomUUID().toString());
    }

    @Override
    public int hashCode() {
	return Objects.hash(uuid);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Resume other = (Resume) obj;
	return uuid.equals(other.getUuid());
    }

    @Override
    public String toString() {
	return uuid;
    }

    public String getUuid() {
	return uuid;
    }

}
