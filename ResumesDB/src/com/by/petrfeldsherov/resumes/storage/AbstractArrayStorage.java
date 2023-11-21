package com.by.petrfeldsherov.resumes.storage;

import java.util.Arrays;
import com.by.petrfeldsherov.resumes.exception.AlreadyExistsException;
import com.by.petrfeldsherov.resumes.exception.NotFoundException;
import com.by.petrfeldsherov.resumes.exception.StorageException;
import com.by.petrfeldsherov.resumes.model.Resume;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    static final int STORAGE_LIMIT = 1000;
    protected int size = 0;

    @Override
    public int size() {
	return size;
    }

    @Override
    public void save(Resume resume) throws StorageException, AlreadyExistsException {
	LOG.info("SAVE " + resume.getUuid());
	if (size == STORAGE_LIMIT) {
	    LOG.warning("Storage overflow.");
	    throw new StorageException("Storage overflow.", resume.getUuid());
	}
	String resumeUuid = resume.getUuid();
	int resumeIndex = getIndex(resumeUuid);
	if (resumeIndex != -1) {
	    LOG.warning("Resume with uuid " + resumeUuid + " already exists.");
	    throw new AlreadyExistsException(resumeUuid);
	}
	insertResume(resumeIndex, resume);
	size++;
    }

    @Override
    public Resume get(String uuid) throws NotFoundException {
	LOG.info("GET " + uuid);
	int resumeIndex = getIndex(uuid);
	if (resumeIndex == -1) {
	    LOG.warning("Resume with uuid " + uuid + " is not found.");
	    throw new NotFoundException(uuid);
	}
	return storage[resumeIndex];
    }

    @Override
    public void delete(String uuid) throws NotFoundException {
	LOG.info("DELETE " + uuid);
	int resumeIndex = getIndex(uuid);
	if (resumeIndex == -1) {
	    LOG.warning("Resume with uuid " + uuid + " is not found.");
	    throw new NotFoundException(uuid);
	}
	deleteResume(resumeIndex);
	size--;
    }

    @Override
    public void clear() {
	LOG.info("CLEAR");
	size = 0;
    }

    public Resume[] getAll() {
	return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(int i, Resume r);

    protected abstract void deleteResume(int i);
}
