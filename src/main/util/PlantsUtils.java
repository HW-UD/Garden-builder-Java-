package util;

import java.util.HashMap;
import java.util.Map;

public class PlantsUtils {

    private final Map<String, Integer> map = new HashMap<>();

    private PlantsUtils() {
    }

    private static class PlantsUtilsHolder {
        static PlantsUtils instance = new PlantsUtils();
    }

    public static PlantsUtils getInstance() {
        return PlantsUtilsHolder.instance;
    }

    public void put(String key, Integer value) {
        this.map.put(key, value);
    }

    public Integer get(String key) {
        return this.map.get(key);
    }

    public void clear() {
        this.map.clear();
    }

    public Map<String, Integer> map() {
        return this.map;
    }

}
