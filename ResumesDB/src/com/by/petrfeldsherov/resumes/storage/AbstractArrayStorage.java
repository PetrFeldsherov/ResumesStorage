package com.by.petrfeldsherov.resumes.storage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

import com.by.petrfeldsherov.resumes.exception.AlreadyExistsException;
import com.by.petrfeldsherov.resumes.exception.NotFoundException;
import com.by.petrfeldsherov.resumes.exception.StorageException;
import com.by.petrfeldsherov.resumes.model.Resume;
import com.by.petrfeldsherov.resumes.ui.Storage;

public abstract class AbstractArrayStorage implements Storage {
    private static final Logger LOG = Logger.getLogger(ArrayStorage.class.getName());
    static final int STORAGE_LIMIT = 1000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected static class ResumeComparator implements Comparator<Resume> {
	@Override
	public int compare(Resume o1, Resume o2) {
	    return o1.getFullName().compareTo(o2.getFullName());
	}
    }

    protected static class UuidComparator implements Comparator<Resume> {
	@Override
	public int compare(Resume o1, Resume o2) {
	    return o1.getUuid().compareTo(o2.getUuid());
	}
    }

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
	int resumeIndex = getIndex(resumeUuid);
	if (resumeIndex != -1) {
	    LOG.warning("Resume with uuid " + resumeUuid + " already exists.");
	    throw new AlreadyExistsException(resumeUuid);
	}
	insertResume(resume, resumeIndex);
	size++;
    }

    public Resume get(String uuid) {
	LOG.info("GET " + uuid);
	int resumeIndex = getIndex(uuid);
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
	int resumeIndex = getIndex(uuid);
	if (resumeIndex == -1) {
	    LOG.warning("Resume with uuid " + uuid + " is not found.");
	    throw new NotFoundException(uuid);
	}
	deleteResume(resumeIndex);
	size--;
    }

    public void clear() {
	LOG.info("CLEAR");
	size = 0;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(Resume resume, int resumeIndex);

    protected abstract void deleteResume(int resumeIndex);
}
