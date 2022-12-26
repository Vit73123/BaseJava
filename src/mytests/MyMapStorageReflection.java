package mytests;

import model.Resume;
import storage.MapStorage;
import storage.Storage;

import java.lang.reflect.Field;

public class MyMapStorageReflection {

    private final Storage myStorage = new MapStorage();

    public static void main(String[] args) throws NoSuchFieldException {

        MyMapStorageReflection sr = new MyMapStorageReflection();
        sr.myStorage.save(new Resume("uuid1"));
        sr.myStorage.save(new Resume("uuid2"));
        sr.myStorage.save(new Resume("uuid3"));
        Resume[] resumes = new Resume[3];
        sr.getAllExpected(sr.myStorage, resumes);
    }

    protected Resume[] getAllExpected(Storage testedStorage, Resume[] expected) throws NoSuchFieldException {
        Resume[] storageArray = new Resume[testedStorage.size()];
        Class<? extends Storage> storageClass = testedStorage.getClass();
        Field field = storageClass.getDeclaredField("storage");
        field.setAccessible(true);
        int i = 0;
        System.out.println((MapStorage) testedStorage);

//        for(Map.Entry<String, Resume> entry : ((MapStorage) testedStorage).storage.entrySet()) {
//            storageArray[i] = entry.getValue();
//            i++;
//        }
        field.setAccessible(false);

        return storageArray;
    }
}
