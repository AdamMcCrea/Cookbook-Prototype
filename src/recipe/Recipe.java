package recipe;

import ingredient.Ingredient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    private String imageFilepath;
    private List<Ingredient> ingredientList;
    private List<String> amounts;
    private final Map<Ingredient, String> amountOfIngredients = new HashMap<>();
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
    private Recipe(String imageFilepath, List<Ingredient> ingredientList, List<String> amounts){
        this.imageFilepath = imageFilepath;
        this.ingredientList = ingredientList;
        this.amounts = amounts;

        //populating hashmap:
        for(int i = 0; i < ingredientList.size(); i++){
            Ingredient ingredient = ingredientList.get(i);
            String amount = amounts.get(i);
            amountOfIngredients.put(ingredient, amount);
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
