package hello;

import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import java.util.Map;
import java.util.Set;

/**
 * Created by developer on 2/4/17.
 */
public class Helpers {


    public static Object searchInJson(JsonObject jo, String searchKey){
        Set<Map.Entry<String, JsonElement>> entries = jo.entrySet();
        for (Map.Entry<String, JsonElement> entry: entries){
            if (entry.getKey().equalsIgnoreCase(searchKey)){
                return entry.getValue();
            } else if (entry.getValue() instanceof JsonObject) {
                return searchInJson(entry.getValue().getAsJsonObject(), searchKey);
            } else if (entry.getValue() instanceof JsonArray) {
                JsonArray ja = entry.getValue().getAsJsonArray();
                for (int i=0; i<ja.size(); i++){
                    return searchInJson(ja.get(i).getAsJsonObject(), searchKey);
                }
            }
        }
        return null;
    }

    public static boolean isValidJson(String json){
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonParseException e) {
            return false;
        }
    }
}
