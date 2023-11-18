package com.by.petrfeldsherov.resumes.storage;

import java.util.Arrays;
import java.util.logging.Logger;

import com.by.petrfeldsherov.resumes.exception.AlreadyExistsException;
import com.by.petrfeldsherov.resumes.exception.NotFoundException;
import com.by.petrfeldsherov.resumes.exception.StorageException;
import com.by.petrfeldsherov.resumes.model.Resume;

public class ArrayStorage {
    private static final Logger LOG = Logger.getLogger(ArrayStorage.class.getName());
    private static final int STORAGE_LIMIT = 1000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public int size() {
	return size;
    }

    public void save(Resume resume) {
	LOG.info("SAVE " + resume.getUuid());
	if (size == STORAGE_LIMIT) {
	    LOG.warning("Storage overflow.");
	    throw new StorageException("Storage overflow.", resume.getUuid());
	}
	String resumeUuid = resume.getUuid();
	int resumeIndex = getSearchIndex(resumeUuid);
	if (resumeIndex != -1) {
	    LOG.warning("Resume with uuid " + resumeUuid + " already exists.");
	    throw new AlreadyExistsException(resumeUuid);
	}
	storage[size] = resume;
	size++;
    }

    public Resume get(String uuid) {
	LOG.info("GET " + uuid);
	int resumeIndex = getSearchIndex(uuid);
	if (resumeIndex == -1) {
	    LOG.warning("Resume with uuid " + uuid + " is not found.");
	    throw new NotFoundException(uuid);
	}
	return storage[resumeIndex];
    }

    public Resume[] getAll() {
	LOG.info("GET ALL");
	return Arrays.copyOfRange(storage, 0, size);
    }

    public void delete(String uuid) {
	LOG.info("DELETE " + uuid);
	int resumeIndex = getSearchIndex(uuid);
	if (resumeIndex == -1) {
	    LOG.warning("Resume with uuid " + uuid + " is not found.");
	    throw new NotFoundException(uuid);
	}
	storage[resumeIndex] = storage[size - 1];
	size--;
    }

    public void clear() {
	LOG.info("CLEAR");
	size = 0;
    }

    private int getSearchIndex(String uuid) {
	for (int i = 0; i < size; i++) {
	    if (uuid.equals(storage[i].getUuid())) {
		return i;
	    }
	}
	return -1;
    }
}