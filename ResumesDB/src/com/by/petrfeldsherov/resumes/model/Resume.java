package com.by.petrfeldsherov.resumes.model;

import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;

    public Resume() {
	this(UUID.randomUUID().toString(), "GUEST" + UUID.randomUUID().toString().substring(0, 10));
    }

    public Resume(String fullName) {
	this(UUID.randomUUID().toString(), fullName);
    }

    private Resume(String uuid, String fullName) {
	Objects.requireNonNull(uuid, "uuid mustn't be null");
	Objects.requireNonNull(fullName, "full name mustn't be null");
	this.uuid = uuid;
	this.fullName = fullName;
    }

    public String getUuid() {
	return uuid;
    }

    public String getFullName() {
	return fullName;
    }

    @Override
    public int hashCode() {
	return Objects.hash(fullName, uuid);
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
	return Objects.equals(fullName, other.fullName) && Objects.equals(uuid, other.uuid);
    }

    @Override
    public String toString() {
	return "fullName=" + fullName + ", uuid=" + uuid;
    }

    @Override
    public int compareTo(Resume o) {
	int cmpFN = fullName.compareTo(o.getFullName());
	return cmpFN != 0 ? cmpFN : uuid.compareTo(o.getUuid());
    }

}
