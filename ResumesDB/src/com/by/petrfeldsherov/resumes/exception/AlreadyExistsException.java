package com.by.petrfeldsherov.resumes.exception;

public class AlreadyExistsException extends StorageException {

    public AlreadyExistsException(String message, String uuid) {
	super("Resume with uuid " + uuid + " already exists.", uuid);
    }

    public AlreadyExistsException(String uuid) {
	super(uuid);
    }

}
