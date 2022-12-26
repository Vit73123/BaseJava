package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    protected void updateResume(Object searchKey, Resume r) {
        storage.set((int) searchKey, r);
    }

    protected void saveResume(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    protected Resume getResume(Object searchKey) {
        return storage.get((int) searchKey);
    }

    protected void deleteResume(Object searchKey) {
        storage.remove((int) searchKey);
    }

    protected Object findSearchKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (Objects.equals(storage.get(i).getUuid(), uuid)) {
                return i;
            }
        }
        return null;
    }

    protected boolean isExist(Object searchKey) {
        return (searchKey != null);
    }
}