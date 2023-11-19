package com.by.petrfeldsherov.resumes.exception;

@SuppressWarnings("serial")
public class NotFoundException extends StorageException {

    public NotFoundException(String message, String uuid) {
	super(message, uuid);
    }

    public NotFoundException(String uuid) {
	this("Resume with uuid " + uuid + " is not found.", uuid);
    }

}
