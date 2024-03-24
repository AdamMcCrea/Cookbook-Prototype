package user;

import recipe.Recipe;

import java.util.List;

public class User {
    private String username;
    private Recipe[] recipeList = new Recipe[5];

    public String getUsername(){
        return this.username;
    }
    public Recipe[] getRecipeList(){
        return this.recipeList;
    }
    public void setRecipeList(Recipe[] recipeList){
        this.recipeList = recipeList;
    }


}
