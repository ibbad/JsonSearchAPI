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

    public static void main(String[] args){
        String a = "{\n" +
                "\"businesses\": [\n" +
                "{\n" +
                "\"id\": \"yelp-tropisueno\",\n" +
                "\"name\" : \"Tropisueno\",\n" +
                "\"display_phone\": \"+1-415-908-3801\",\n" +
                "\"image_url\": \"http://s3-media2.ak.yelpcdn.com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg\",\n" +
                "\"description\": \"\"\n" +
                "}\n" +
                "]\n" +
                "}";

        String c  = "{\n" +
                "\"businesses\": [{\n" +
                "\"id\": \"yelp-tropisueno\",\n" +
                "\"name\": \"Tropisueno\",\n" +
                "\"display_phone\": \"+1-415-908-3801\",\n" +
                "\"image_url\": \"http://s3-media2.ak.yelpcdn.com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg\",\n" +
                "\"description\": \"\",\n" +
                "\"nested_object\": {\n" +
                "\"nested_key\": \"a\",\n" +
                "\"nested_key_b\": \"b\"\n" +
                "}\n" +
                "}, {\n" +
                "\"id\": \"yelp-tropisueno2\",\n" +
                "\"name\": \"Tropisueno2\",\n" +
                "\"display_phone\": \"+1-415-908-38012\",\n" +
                "\"image_url\": \"http://s3-media2.ak.yelpcdn.com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg2\",\n" +
                "\"description\": \"\",\n" +
                "\"nested_object\": {\n" +
                "\"nested_key\": \"a2\",\n" +
                "\"nested_key_b\": \"b2\"\n" +
                "}\n" +
                "}],\n" +
                "\"attribute\": \"value\"\n" +
                "}";

        String b = "{\n" +
                "\"shops\": [\n" +
                "{\n" +
                "\"id\": \"sample-shop\",\n" +
                "\"name\" : \"Mingalaba\",\n" +
                "\"display_phone\": \"+1-408-366-6600\",\n" +
                "\"image_url\": \"http://s3-media2.ak.yelpcdn.com/bphoto/7DIHu8a0AHhw-BffrDIxPA/ms.jpg\",\n" +
                "\"description\": \"Best Asian lovingly prepare by Jack \"Papa\" Rasmussen\"\n" +
                "}\n" +
                "]\n" +
                "}";

//        System.out.println(Task2.isValidJson(a));
//        System.out.println(Task2.isValidJson(b));
//        System.out.println(Task2.isValidJson(c));
//        System.out.println(Task2.searchInJson(new JsonParser().parse(c).getAsJsonObject(), "nested_key_b"));

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
