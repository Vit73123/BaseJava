package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    protected void updateResume(Object searchKey, Resume r) {
        storage.replace((String) searchKey, r);
    }

    protected void saveResume(Object searchKey, Resume resume) {
        storage.put((String) searchKey, resume);
    }

    protected Resume getResume(Object searchKey) {
        return storage.get((String) searchKey);
    }

    protected void deleteResume(Object searchKey) {
        storage.remove((String) searchKey);
    }

    protected Object findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        if (storage.containsKey((String) searchKey)) {
            return true;
        } else {
            return false;
        }
    }
}
