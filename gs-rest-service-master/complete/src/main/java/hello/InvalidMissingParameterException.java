package hello;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hafeez on 3.2.2017.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidMissingParameterException extends RuntimeException {
    public InvalidMissingParameterException(String param){
        super(String.format("Unable to retrieve %s from query string.", param));
    }
}
