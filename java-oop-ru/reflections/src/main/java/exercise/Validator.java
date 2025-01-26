package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> nulls = new ArrayList<>();
        Class<?> aClass = address.getClass();
        try {
            Field[] fields = aClass.getDeclaredFields();
            for (var i = 0; i < fields.length - 1; i++) {
                fields[i].setAccessible(true);
                if (fields[i].get(address) == null) {
                    nulls.add(fields[i].getName());
                }
            }
        } catch (IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }
        return nulls;
    }
}
// END
