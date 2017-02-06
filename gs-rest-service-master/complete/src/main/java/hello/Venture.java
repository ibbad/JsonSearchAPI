package hello;

/**
 * Created by developer on 2/4/17.
 */

public class Venture {
    public long id = 0;
    public String name = "";
    public String displayPhone = "";
    public String imageUrl = "";       // Should use URL type for this.
    public String description = "";

    public Venture(long id, String name, String displayPhone, String imageUrl, String description){
        this.id = id;
        this.name = name;
        this.displayPhone = displayPhone;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public Venture(){

    }
}
