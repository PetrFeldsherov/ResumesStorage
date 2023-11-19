package com.by.petrfeldsherov.resumes.ui;

import java.util.List;

import com.by.petrfeldsherov.resumes.model.Resume;

public interface Storage {
    List<Resume> getAllSorted();

    int size();

    void save(Resume resume);

    Resume get(String uuid);

    void delete(String uuid);

    void clear();
}
