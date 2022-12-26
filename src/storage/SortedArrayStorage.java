package storage;

import model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveArrayResume(int index, Resume r) {
        int insertionIndex = -index - 1;
        System.arraycopy(storage, insertionIndex, storage, insertionIndex + 1, size - insertionIndex);
        storage[insertionIndex] = r;
    }

    @Override
    public void deleteArrayResume(int index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }

    @Override
    protected Object findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        Comparator.comparing(Resume::getUuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    protected boolean isExist(Object searchKey) {
        return (searchKey != null);
    }
}
