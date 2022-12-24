package storage;

import model.Resume;

import java.lang.reflect.Field;
import java.util.Map;

class MapStorageTest extends AbstractStorageTest {

    MapStorageTest() {
        super(new MapStorage());
    }

    protected Resume[] getAllExpected(Storage storage, Resume[] expected) throws NoSuchFieldException {
        Resume[] storageArray = new Resume[storage.size()];
        Class<? extends Storage> storageClass = storage.getClass();
        Field field = storageClass.getDeclaredField("storage");
        field.setAccessible(true);
        int i = 0;
        for(Map.Entry<String, Resume> entry : ((MapStorage) storage).storage.entrySet()) {
            storageArray[i] = entry.getValue();
            i++;
        }
        field.setAccessible(false);

        return storageArray;
    }
}
