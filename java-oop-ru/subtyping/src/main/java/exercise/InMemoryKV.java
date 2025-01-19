package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
class InMemoryKV implements KeyValueStorage{
    private final Map<String, String> map;

    public InMemoryKV(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
    }

    @Override
    public void unset(String key) {
        map.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!map.containsKey(key)) {
            return defaultValue;
        }
        return map.get(key);
    }

    @Override
    public Map<String, String> toMap() {
        return map;
    }
}
// END
