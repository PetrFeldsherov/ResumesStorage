package com.by.petrfeldsherov.resumes.exception;

public class NotFoundException extends StorageException {

    public NotFoundException(String message, String uuid) {
	super("Resume with uuid " + uuid + " is not found.", uuid);
    }

    public NotFoundException(String uuid) {
	super(uuid);
    }

}
