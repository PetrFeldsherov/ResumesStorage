package com.by.petrfeldsherov.resumes.storage;

import java.util.LinkedList;
import java.util.List;

import com.by.petrfeldsherov.resumes.exception.AlreadyExistsException;
import com.by.petrfeldsherov.resumes.exception.NotFoundException;
import com.by.petrfeldsherov.resumes.model.Resume;

public class LinkedListStorage extends AbstractStorage {

    List<Resume> storage = new LinkedList<Resume>();

    public int size() {
	return storage.size();
    }

    @Override
    public void save(Resume resume) {
	String uuid = resume.getUuid();
	for (int i = 0; i < size(); i++) {
	    if (uuid.equals(storage.get(i).getUuid())) {
		throw new AlreadyExistsException(uuid);
	    }
	}
	storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
	for (int i = 0; i < size(); i++) {
	    if (uuid.equals(storage.get(i).getUuid())) {
		return storage.get(i);
	    }
	}
	throw new NotFoundException(uuid);
    }

    @Override
    public void delete(String uuid) {
	for (int i = 0; i < size(); i++) {
	    if (uuid.equals(storage.get(i).getUuid())) {
		storage.remove(i);
		return;
	    }
	}
	throw new NotFoundException(uuid);
    }

    @Override
    public void clear() {
	storage.clear();
    }

    @Override
    public Resume[] getAll() {
	Resume[] all = (Resume[]) storage.toArray();
	return all;
    }

}
