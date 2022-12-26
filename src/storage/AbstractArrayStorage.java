package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume getResume(Object index) {
        return storage[(int) index];
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void saveResume(Object index, Resume r) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            saveArrayResume(index, r);
            size++;
        }
    }

    public void deleteResume(Object index) {
        deleteArrayResume((int) index);
        size--;
        storage[size] = null;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    protected void updateResume(Object index, Resume r) {
        storage[(int) index] = r;
    }

    public int size() {
        return size;
    }

    protected abstract void saveArrayResume(Object index, Resume r);

    protected abstract void deleteArrayResume(int index);

    protected abstract Object findSearchKey(String uuid);
}
