package com.by.petrfeldsherov.resumes.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import com.by.petrfeldsherov.resumes.exception.StorageException;
import com.by.petrfeldsherov.resumes.model.Resume;
import com.by.petrfeldsherov.resumes.storage.ArrayStorage;

public class MainArrayConsole {
    private static final Storage STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
	    System.out.println(
		    "Available commands:\n\tlist\n\tsize\n\tsave <fullName>\n\tdelete <uuid>\n\tget <uuid>\n\tclear\n\texit");
	    String[] arguments = reader.readLine().trim().split(" ");
	    if (arguments.length == 1 && arguments[0].equals("exit")) {
		return;
	    }
	    if (!isValidCommand(arguments)) {
		System.out.println("Invalid command.");
		continue;
	    }
	    String parameter = (arguments.length == 1) ? null : arguments[1];
	    try {
		switch (arguments[0]) {
		case "list":
		    List<Resume> allResumes = STORAGE.getAllSorted();
		    for (Resume resume : allResumes) {
			System.out.println(resume);
		    }
		    System.out.println("\t" + STORAGE.size() + " resumes in total.");
		    break;
		case "size":
		    System.out.println("There are " + STORAGE.size() + " resumes in the storage.");
		    break;
		case "save":
		    STORAGE.save(new Resume(parameter));
		    break;
		case "delete":
		    STORAGE.delete(parameter);
		    break;
		case "get":
		    System.out.println(STORAGE.get(parameter));
		    break;
		case "clear":
		    STORAGE.clear();
		    break;
		}
	    } catch (StorageException e) {
		System.out.println(e.getMessage());
	    }
	}
    }

    private static boolean isValidCommand(String[] arguments) {
	for (ConsoleCommandFormat format : ConsoleCommandFormat.values()) {
	    if (format.getKeyWord().equals(arguments[0])) {
		String[] parameters = Arrays.copyOfRange(arguments, 1, arguments.length);
		if (format.parametersAreValid(parameters)) {
		    return true;
		} else {
		    return false;
		}
	    }
	}
	return false;
    }
}
