package user;

import ingredient.Ingredient;
import recipe.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private Recipe[] recipeList = new Recipe[5];
    private List<Ingredient> shoppingList;
    private List<Double> amounts;
    private final Map<Ingredient, Double> amountOfIngredients = new HashMap<>();

    public String getUsername() {
        return this.username;
    }

    public Recipe[] getRecipeList() {
        return this.recipeList;
    }

    public List<Ingredient> getShoppingList() {
        return this.shoppingList;
    }

    public void setRecipeList(Recipe[] recipeList) {
        this.recipeList = recipeList;
    }

    public List<Ingredient> generateShoppingList() {
        List<Ingredient> shoppingList = new ArrayList<>();

        for (Recipe recipe : recipeList) {
            for (Ingredient ingredient : recipe.getIngredientList()) {
                if (shoppingList.contains(ingredient)) {
                    if (ingredient.getFiniteAmount()) {
                        int pos = shoppingList.indexOf(ingredient);
                        //adds amount of ingredient to stored amount
                        amountOfIngredients.put(shoppingList.get(pos), amountOfIngredients.get(shoppingList.get(pos)) + ingredient.getAmount());
                    }
                }
                else {
                    shoppingList.add(ingredient);
                    amountOfIngredients.put(ingredient, ingredient.getAmount());
                }
            }
        }
        return shoppingList;
    }

    public void generateFiles(){

    }
}


