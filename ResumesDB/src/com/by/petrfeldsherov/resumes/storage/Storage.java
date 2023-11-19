package com.by.petrfeldsherov.resumes.storage;

import com.by.petrfeldsherov.resumes.model.Resume;

public interface Storage {
    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    void clear();

    Resume[] getAll();

    int size();
}
