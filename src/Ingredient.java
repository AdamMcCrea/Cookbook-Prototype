import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ingredient {

    private String name;
    private float pricePer;
    //for shopping, true if ingredient can be bought individually e.g. a pepper, false if not e.g. milk
    private boolean finiteAmount;

    public String getName(){
        return this.name;
    }

    public float getPrice(){
        return this.pricePer;
    }
    private Ingredient(String name, float pricePer, boolean finiteAmount){
        this.name = name;
        this.pricePer = pricePer;
        this.finiteAmount = finiteAmount;
    }
    public Ingredient getInstance(String name, float pricePer, boolean finiteAmount){
        try{
            //making sure name in correct format
            String nameRegex = "^[a-zA-Z ]+$";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(name);

            if(!nameMatcher.matches()){
                throw new IllegalArgumentException("name in wrong format");
            }
            //making sure price positive and not excessive and in right format
            String priceString = String.valueOf(pricePer);
            String priceRegex = "^\\d+\\.\\d{2}$";
            Pattern pricePattern = Pattern.compile(priceRegex);
            Matcher priceMatcher = pricePattern.matcher(priceString);

            if(!priceMatcher.matches()){
                throw new IllegalArgumentException("price not to 2dp");
            }
            if(pricePer <= 0 || pricePer > 15){
                throw new IllegalArgumentException("price either negative, 0 or excessive");
            }

            return new Ingredient(name, pricePer, finiteAmount);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
