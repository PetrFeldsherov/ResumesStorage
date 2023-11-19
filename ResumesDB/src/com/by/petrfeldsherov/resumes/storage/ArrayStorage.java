package com.by.petrfeldsherov.resumes.storage;

import com.by.petrfeldsherov.resumes.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
	for (int i = 0; i < size; i++) {
	    if (uuid.equals(storage[i].getUuid())) {
		return i;
	    }
	}
	return -1;
    }

    @Override
    protected void insertResume(Resume resume, int resumeIndex) {
	storage[size] = resume;
    }

    @Override
    protected void deleteResume(int resumeIndex) {
	storage[resumeIndex] = storage[size - 1];
    }
}