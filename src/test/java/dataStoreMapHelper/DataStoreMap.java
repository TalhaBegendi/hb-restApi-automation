package dataStoreMapHelper;

import java.util.HashMap;
import java.util.Map;

public class DataStoreMap {

    private static Map<String, Object> dataStoreMap;

    static {
        if (dataStoreMap == null) {
            dataStoreMap = new HashMap<>();
        }
    }

    public DataStoreMap() {
    }

    public void setContext(String key, Object value) {
        dataStoreMap.put(key, value);
    }

    public Object getContext(String key) {
        return dataStoreMap.get(key);
    }

}
