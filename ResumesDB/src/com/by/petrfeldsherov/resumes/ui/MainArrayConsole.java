package com.by.petrfeldsherov.resumes.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.by.petrfeldsherov.resumes.model.Resume;
import com.by.petrfeldsherov.resumes.storage.ArrayStorage;

public class MainArrayConsole {
    private static final Storage STORAGE = new ArrayStorage();

    public static void main(String[] args) throws IOException {
	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	while (true) {
	    System.out.println(
		    "Type in one of the following commands:\n\tlist\n\tlist <fullName>\n\tsize\n\tsave <fullName>\n\tget <uuid>\n\tdelete <uuid>\n\tclear\n\texit");
	    String[] parameters = reader.readLine().trim().toLowerCase().split(" ");
	    if (!isValidCommand(parameters)) {
		System.out.println("Invalid command.");
		continue;
	    }
	    String parameter = (parameters.length > 1) ? parameters[1].intern() : null;
	    switch (parameters[0]) {
	    case "list":
		Resume[] allResumes = STORAGE.getAll();
		if (parameter == null) {
		    for (Resume r : allResumes) {
			System.out.println(r);
		    }
		} else {
		    for (Resume r : allResumes) {
			if (r.getFullName().equals(parameter)) {
			    System.out.println(r.getUuid());
			}
		    }
		}
		break;
	    case "size":
		System.out.println(STORAGE.size());
		break;
	    case "save":
		STORAGE.save(new Resume(parameter));
		break;
	    case "get":
		System.out.println(STORAGE.get(parameter));
	    case "delete":
		STORAGE.delete(parameter);
		break;
	    case "clear":
		STORAGE.clear();
		break;
	    case "exit":
		return;
	    }
	}
    }

    private static boolean isValidCommand(String[] parameters) {
	if (!(parameters.length >= 1 && parameters.length <= 2)) {
	    return false;
	}
	return true;
    }
}
