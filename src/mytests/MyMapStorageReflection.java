package mytests;

import model.Resume;
import storage.MapStorage;
import storage.Storage;

import java.lang.reflect.Field;
import java.util.Map;

public class MyMapStorageReflection {

    Storage

    public static void main(String[] args) {
        Resume[] resumes = getAllExpected()
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
