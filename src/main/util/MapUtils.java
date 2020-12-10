package util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    private final Map<String, Object> map = new HashMap<>();

    private MapUtils() {
    }

    private static class MapUtilsHolder {
        static MapUtils instance = new MapUtils();
    }

    public static MapUtils getInstance() {
        return MapUtilsHolder.instance;
    }

    public void put(String key, Object value) {
        this.map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

}
