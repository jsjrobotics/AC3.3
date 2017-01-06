package nyc.c4q.testsolution.backend;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiResponse {
    private static final String JSON_SUCCESS = "success";
    private static final String JSON_KEYBOARD_KEYS = "available keys";
    private static final String JSON_NAME = "name";
    private static final String JSON_TEXT_COLOR = "textColor";
    private static final String JSON_URL = "url";
    private boolean success;
    private List<KeyboardKey> availableKeys;

    public List<KeyboardKey> getKeys() {
        return availableKeys;
    }

    public static ApiResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            String success = json.getString(JSON_SUCCESS);
            JSONArray keys = json.getJSONArray(JSON_KEYBOARD_KEYS);

            ApiResponse result = new ApiResponse();
            result.success = Boolean.parseBoolean(success);
            result.availableKeys = parseAvailableKeys(keys);
            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorCase();
    }

    private static List<KeyboardKey> parseAvailableKeys(JSONArray keyList) {
        List<KeyboardKey> result = new ArrayList<>();
        for (int index = 0; index < keyList.length(); index++){
            try {
                JSONObject currentKey = keyList.getJSONObject(index);
                String name = currentKey.getString(JSON_NAME);
                String textColor = currentKey.getString(JSON_TEXT_COLOR);
                String url = currentKey.getString(JSON_URL);
                KeyboardKey key = new KeyboardKey(name, textColor, url);
                result.add(key);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static ApiResponse errorCase() {
        ApiResponse error = new ApiResponse();
        error.success = false;
        error.availableKeys = Collections.emptyList();
        return error;
    }
}
