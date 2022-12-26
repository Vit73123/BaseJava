package mytests;

import java.lang.reflect.Field;

public class MyReflectionClassTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        MyReflectionClassTest mt = new MyReflectionClassTest();
        mt.ReflectionTest();
    }

    void ReflectionTest() throws NoSuchFieldException, IllegalAccessException {
        MyReflectionClass tc = new MyReflectionClass();
        Class t = tc.getClass();
        Field field = t.getDeclaredField("s");
        field.setAccessible(true);

        System.out.println(t.getName());
        System.out.println(field.get(tc));
    }
}
