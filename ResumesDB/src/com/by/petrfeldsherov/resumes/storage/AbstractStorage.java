package com.by.petrfeldsherov.resumes.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import com.by.petrfeldsherov.resumes.model.Resume;
import com.by.petrfeldsherov.resumes.ui.Storage;

public abstract class AbstractStorage implements Storage {

    protected static final Logger LOG = Logger.getLogger(ArrayStorage.class.getName());

    protected static class ResumeComparator implements Comparator<Resume> {
	@Override
	public int compare(Resume o1, Resume o2) {
	    return o1.getFullName().compareTo(o2.getFullName());
	}
    }

    protected static class ResumeUuidComparator implements Comparator<Resume> {
	@Override
	public int compare(Resume o1, Resume o2) {
	    return o1.getUuid().compareTo(o2.getUuid());
	}
    }

    @Override
    public List<Resume> getAllSorted() {
	LOG.info("GET ALL SORTED");
	Resume[] allResumes = getAll();
	Arrays.sort(allResumes, new ResumeComparator());
	return new ArrayList<Resume>(Arrays.asList(allResumes));
    }

    public abstract Resume[] getAll();

}
