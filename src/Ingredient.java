import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ingredient {

    private String name;
    private float pricePer;

    public String getName(){
        return this.name;
    }

    public float getPrice(){
        return this.pricePer;
    }
    private Ingredient(String name, float pricePer){
        this.name = name;
        this.pricePer = pricePer;
    }
    public Ingredient getInstance(String name, float pricePer){
        try{
            //making sure name in correct format
            String nameRegex = "^[a-zA-Z ]+$";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(name);

            if(!nameMatcher.matches()){
                throw new IllegalArgumentException("name in wrong format");
            }
            //making sure price positive and not excessive
            if(pricePer <= 0 || pricePer > 15){
                throw new IllegalArgumentException("price either negative, 0 or excessive");
            }

        }
    }
}
