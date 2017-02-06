package hello;

import com.google.gson.JsonObject;

/**
 * This class provides model for JSON verification.  It is made relative to
 * the model which is provided in the test jsons. However, it (Fields and accepted datatypes)
 * can be changed/updated to suit the needs, the underlying concept will remain the same.
 */
public class JsonParser {
    // The keys business and shops are taken from sample data, they may be changed, removed altogether.
    final String businessKey = "businesses";
    final String shopsKey = "shops";
    final String idKey = "id";
    final String nameKey = "name";
    final String phoneKey = "display-phone";
    final String imageUrl = "image_url";
    final String description = "description";

    public Venture getVenture(JsonObject jo){
        Venture venture = new Venture();
        venture.id = Long.parseLong(valueOrNull(jo, this.idKey));
        venture.name = valueOrNull(jo, this.nameKey);
        venture.description = valueOrNull(jo, this.description);
        venture.displayPhone = valueOrNull(jo, this.phoneKey);
        venture.imageUrl = valueOrNull(jo, this.imageUrl);
        return venture;
    }

    public static String valueOrNull(JsonObject jo, String key){
        if (jo.get(key) != null){
            return jo.get(key).toString();
        } else {
            return null;
        }
    }
}
