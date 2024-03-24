package recipe;

import ingredient.Ingredient;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Recipe {
    private String name;
    private String imageFilepath;
    private List<Ingredient> ingredientList;
    private List<Double> amounts;
    private final Map<Ingredient, Double> amountOfIngredients = new HashMap<>();
    private double totalPrice;

    public String getImageFilepath() {
        return imageFilepath;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    private Recipe(String name, String imageFilepath, List<Ingredient> ingredientList, List<Double> amounts){
        this.imageFilepath = imageFilepath;
        this.ingredientList = ingredientList;
        this.amounts = amounts;

        //populating hashmap:
        for(int i = 0; i < ingredientList.size(); i++){
            Ingredient ingredient = ingredientList.get(i);
            Double amount = amounts.get(i);
            amountOfIngredients.put(ingredient, amount);
        }
    }
    public Recipe getInstance(String name, String imageFilepath, List<Ingredient> ingredientList, List<Double> amounts){
        try{
            //making sure name only contains letters
            String nameRegex = "^[a-zA-Z]+$";
            Pattern namePattern = Pattern.compile(nameRegex);
            Matcher nameMatcher = namePattern.matcher(name);

            if(!nameMatcher.matches()){
                throw new IllegalArgumentException("name in wrong format");
            }

            //checking if image file exists
            File file = new File(imageFilepath);
            if(!file.exists()){
                throw new IllegalArgumentException("No file for corresponding filepath");
            }

            //checking for duplicate ingredients
            Set<Ingredient> ingredientSet = new HashSet<>();
            for(Ingredient ingredient : ingredientList){
                if(!ingredientSet.add(ingredient)){
                    throw new IllegalArgumentException("Ingredient List has duplicates");
                }
            }
            return new Recipe(name, imageFilepath, ingredientList, amounts);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }catch (InputMismatchException e){
            throw new InputMismatchException("One of the parameters was entered with an incorrect type");
        }
    }
    public void calculateTotalPrice(int multiplier){
        double total = 0;
        for (Ingredient ingredient : ingredientList) {
            total += (ingredient.getPrice() * multiplier);
        }
        this.totalPrice = total;
    }
}
