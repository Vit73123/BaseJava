package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void saveArrayResume(Object index, Resume r) {
        storage[size] = r;
    }

    protected void deleteArrayResume(int index) {
        storage[index] = storage[size];
    }

    protected Object findSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    protected boolean isExist(Object searchKey) {
        return (searchKey != null);
    }
}
