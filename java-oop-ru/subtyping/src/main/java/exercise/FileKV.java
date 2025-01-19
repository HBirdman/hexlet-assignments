package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
private String json;

    public FileKV(String path, Map<String, String> map) {
        this.json = Utils.serialize(map);
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public void unset(String key) {

    }

    @Override
    public String get(String key, String defaultValue) {
        return "";
    }

    @Override
    public Map<String, String> toMap() {
        return Map.of();
    }
}
// END
