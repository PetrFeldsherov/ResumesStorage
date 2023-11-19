package com.by.petrfeldsherov.resumes.storage;

import java.util.Arrays;
import com.by.petrfeldsherov.resumes.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
	// default binary search requires Resume key, other search algorithm required
	if (size == 0) {
	    return -1;
	}
	int low = 0;
	int high = size - 1;
	while (low <= high) {
	    int mid = low + ((high - low) / 2);
	    int cmp = uuid.compareTo(storage[mid].getUuid());
	    if (cmp < 0) {
		high = mid - 1;
	    } else if (cmp > 0) {
		low = mid + 1;
	    } else {
		return mid;
	    }
	}
	return -1;
    }

    @Override
    protected void insertResume(Resume resume, int resumeIndex) {
	// https://codereview.stackexchange.com/a/36239
	//binarySearch returns -insertPos-1 if not found, j is insertPos
	int j = -1 * Arrays.binarySearch(storage, 0, size, resume, new UuidComparator()) - 1;
	System.arraycopy(storage, j, storage, j + 1, size - j);
	storage[j] = resume;
    }

    @Override
    protected void deleteResume(int resumeIndex) {
	int shiftLength = size - resumeIndex - 1;
	if (shiftLength > 0) {
	    System.arraycopy(storage, resumeIndex + 1, storage, resumeIndex, shiftLength);
	}
    }

}
