package nyc.c4q.testsolution.backend;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApiResponse {
    private static final String JSON_SUCCESS = "success";
    private static final String JSON_ANIMALS = "animals";
    private static final String JSON_NAME = "name";
    private static final String JSON_TEXT_COLOR = "textColor";
    private static final String JSON_BACKGROUND = "background";
    private boolean success;
    private List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }

    public static ApiResponse parse(String response) {
        try {
            JSONObject json = new JSONObject(response);
            String success = json.getString(JSON_SUCCESS);
            JSONArray animals = json.getJSONArray(JSON_ANIMALS);

            ApiResponse result = new ApiResponse();
            result.success = Boolean.parseBoolean(success);
            result.animals = parseAnimals(animals);
            return result;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return errorCase();
    }

    private static List<Animal> parseAnimals(JSONArray animals) {
        List<Animal> result = new ArrayList<>();
        for (int index = 0; index < animals.length(); index++){
            try {
                JSONObject currentAnimal = animals.getJSONObject(index);
                String name = currentAnimal.getString(JSON_NAME);
                String textColor = currentAnimal.getString(JSON_TEXT_COLOR);
                String background = currentAnimal.getString(JSON_BACKGROUND);
                Animal animal = new Animal(name, textColor, background);
                result.add(animal);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static ApiResponse errorCase() {
        ApiResponse error = new ApiResponse();
        error.success = false;
        error.animals = Collections.emptyList();
        return error;
    }
}
