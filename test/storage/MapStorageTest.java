package storage;

import model.Resume;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class MapStorageTest extends AbstractStorageTest {

    MapStorageTest() {
        super(new MapStorage());
    }

    protected Resume[] getAllExpected(Storage storage, Resume[] expected) throws NoSuchFieldException, IllegalAccessException {
        Resume[] storageArray = new Resume[storage.size()];
        Class<? extends Storage> storageClass = storage.getClass();
        Field field = storageClass.getDeclaredField("storage");
        field.setAccessible(true);
        Map<String, Resume> testStorage = (HashMap) field.get(storage);
        int i = 0;
        for(Map.Entry<String, Resume> entry : testStorage.entrySet()) {
            storageArray[i] = entry.getValue();
            i++;
        }
        field.setAccessible(false);

        return storageArray;
    }
}
