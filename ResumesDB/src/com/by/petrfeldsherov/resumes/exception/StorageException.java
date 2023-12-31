package com.by.petrfeldsherov.resumes.exception;

@SuppressWarnings("serial")
public class StorageException extends RuntimeException {

    private String uuid;

    public StorageException(String uuid) {
	this.uuid = uuid;
    }

    public StorageException(String message, String uuid) {
	super(message);
	this.uuid = uuid;
    }

    public String getUuid() {
	return uuid;
    }

}
