package storage;

import model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

//    private final Storage storage;

    AbstractArrayStorageTest(Storage storage) {
        super(storage);
//        this.storage = storage;
    }

    protected Resume[] getAllExpected(Storage storage, Resume[] expected) {
        return expected;
    }

//    @Test
//    public void overflowStorage() {
//        try {
//            while (storage.size() < STORAGE_LIMIT) {
//                storage.save(new Resume());
//            }
//        } catch (StorageException e) {
//            fail("Failed: Too early overflow");
//        }
//        assertThrows(StorageException.class, () ->
//                storage.save(new Resume()));
//    }
}