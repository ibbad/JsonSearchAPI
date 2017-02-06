package hello;

import com.google.gson.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Controller for Searching in JSON.
 */
@RestController
public class SearchFromJson {

    @RequestMapping(method= RequestMethod.GET, value={"/search"})
    public ResponseEntity<String> searchKey(@RequestBody String jsonpayload,
                                            @RequestParam (value= "key", required = true) String key){
        System.out.println(jsonpayload);
        if (Helpers.isValidJson(jsonpayload)){
            Object result = Helpers.searchInJson(new JsonParser().parse(jsonpayload).getAsJsonObject(),
                    key);
            if (result == null){
                System.out.println(String.format("Given key=%s not found in the JSON data provided with request", key));
                return new ResponseEntity<String>("Given key does not exist in JSON.", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
            }
        } else {
            System.out.println("Bad JSON provided.");
            return new ResponseEntity<String>("Invalid JSON", HttpStatus.BAD_REQUEST);
        }
    }
}
