import java.util.List;

public class Recipe {
    private String imageFilepath;
    private List<Ingredient> ingredientList;
    private float totalPrice;

    public String getImageFilepath() {
        return imageFilepath;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
}
