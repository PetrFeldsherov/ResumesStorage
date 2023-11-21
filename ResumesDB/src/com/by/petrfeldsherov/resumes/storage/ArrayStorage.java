package com.by.petrfeldsherov.resumes.storage;

import java.util.Arrays;
import java.util.List;

import com.by.petrfeldsherov.resumes.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public List<Resume> getAllSorted() {
	LOG.info("GET ALL SORTED");
	Resume[] storageCopy = Arrays.copyOf(storage, size);
	Arrays.sort(storageCopy, new ResumeComparator());
	return Arrays.asList(storageCopy);
    }

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
    protected void insertResume(int i, Resume r) {
	storage[size] = r;
    }

    @Override
    protected void deleteResume(int i) {
	storage[i] = storage[size - 1];
    }
}