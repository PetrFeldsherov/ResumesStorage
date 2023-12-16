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
    public void save(Resume resume) throws AlreadyExistsException {
	LOG.info("SAVE " + resume.getUuid());
	String uuid = resume.getUuid();
	for (int i = 0; i < size(); i++) {
	    if (uuid.equals(storage.get(i).getUuid())) {
		LOG.warning("Resume with uuid " + uuid + " already exists.");
		throw new AlreadyExistsException(uuid);
	    }
	}
	storage.add(resume);
    }

    @Override
    public Resume get(String uuid) throws NotFoundException {
	LOG.info("GET  " + uuid);
	for (int i = 0; i < size(); i++) {
	    if (uuid.equals(storage.get(i).getUuid())) {
		return storage.get(i);
	    }
	}
	LOG.warning("Resume with uuid " + uuid + " is not found.");
	throw new NotFoundException(uuid);
    }

    @Override
    public void delete(String uuid) throws NotFoundException {
	LOG.info("DELETE  " + uuid);
	for (int i = 0; i < size(); i++) {
	    if (uuid.equals(storage.get(i).getUuid())) {
		storage.remove(i);
		return;
	    }
	}
	LOG.warning("Resume with uuid " + uuid + " is not found.");;
	throw new NotFoundException(uuid);
    }

    @Override
    public void clear() {
	LOG.info("CLEAR");
	storage.clear();
    }

    @Override
    public Resume[] getAll() {
	Resume[] all = (Resume[]) storage.toArray();
	return all;
    }

}
