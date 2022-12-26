package storage;

import exception.StorageException;
import model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static storage.AbstractArrayStorage.STORAGE_LIMIT;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    private final Storage storage;

    AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
    }

    protected Resume[] getAllExpected(Storage storage, Resume[] expected) {
        return expected;
    }

    @Test
    public void overflowStorage() {
        try {
            while (storage.size() < STORAGE_LIMIT) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("Failed: Too early overflow");
        }
        assertThrows(StorageException.class, () ->
                storage.save(new Resume()));
    }
}