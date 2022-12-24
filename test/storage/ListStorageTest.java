package storage;

import model.Resume;

class ListStorageTest extends AbstractStorageTest {

    ListStorageTest() {
        super(new ListStorage());
    }

    protected Resume[] getAllExpected(Storage storage, Resume[] expected) {
        return expected;
   }
}