package ingredient;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import util.MeasurementType;

public class Ingredient {

    private String name;
    private double pricePer;
    //for shopping, true if ingredient can be bought individually e.g. a pepper, false if not e.g. milk
    private boolean finiteAmount;
    private double amount;
    private MeasurementType type;

    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.pricePer;
    }
    public MeasurementType getType(){
        return this.type;
    }
    private Ingredient(String name, float pricePer, boolean finiteAmount, double amount, MeasurementType type){
        this.name = name;
        this.pricePer = pricePer;
        this.finiteAmount = finiteAmount;
        this.type = type;
    }
    public Ingredient getInstance(String name, float pricePer, boolean finiteAmount, double amount, MeasurementType type){
        try{
            //making sure name in correct format
            String nameRegex = "^[a-zA-Z ]+$";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(name);

            if(!nameMatcher.matches()){
                throw new IllegalArgumentException("name in wrong format");
            }
            //making sure price positive and not excessive and in right format
            if(!checkDPFormat(pricePer)){
                throw new IllegalArgumentException("price not int, 1dp or 2dp");
            }
            if(pricePer <= 0 || pricePer > 15){
                throw new IllegalArgumentException("price either negative, 0 or excessive");
            }

            //making sure price positive and in right format
            if(!checkDPFormat(amount)){
                throw new IllegalArgumentException("amount not int, 1dp or 2dp");
            }
            if(amount <= 0){
                throw new IllegalArgumentException("amount must be positive");
            }



            return new Ingredient(name, pricePer, finiteAmount, amount, type);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }catch (InputMismatchException e){
            throw new InputMismatchException("Incorrect type entered");
        }
    }

    /**
     * checks if a double number is an int, 1dp or 2dp
     * @param number - number being checked
     * @return true if number int, 1dp or 2dp, false if not
     */
    private boolean checkDPFormat(double number){
        String numStr = String.valueOf(number);
        if(numStr.contains(".")){
            return true;
        }
        int count = numStr.split("\\.")[1].length();
        if(count == 1 || count == 2){
            return true;
        }
        else return false;
    }
}
