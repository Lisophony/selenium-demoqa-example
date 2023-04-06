package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonUtil {
    public static JSONObject getJson(String source) {
        JSONParser parser = new JSONParser();
        JSONObject obj;
        try (FileReader reader = new FileReader(source)) {
            obj = (JSONObject) parser.parse(reader);
        }
        catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }

    public static List<String> getArray(JSONObject jsonObject, String key) {
        return ((Stream<?>)((JSONArray)jsonObject.get(key)).stream()).map(Object::toString).collect(Collectors.toList());
    }
}
