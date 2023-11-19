package com.by.petrfeldsherov.resumes.exception;

@SuppressWarnings("serial")
public class AlreadyExistsException extends StorageException {

    public AlreadyExistsException(String message, String uuid) {
	super(message, uuid);
    }

    public AlreadyExistsException(String uuid) {
	this("Resume with uuid " + uuid + " already exists.", uuid);
    }

}
