package modelPackage;

import java.util.ArrayList;

public class Composition {
    private String ingredientLabel;
    private String recipeLabel;
    private Integer quantityRequired;


    //SETTORS
    public void setingredientLabel(String ingredientLabel) {
        this.ingredientLabel = ingredientLabel;
    }

    public void setRecipeLabel(String recipeLabel) {
        this.recipeLabel = recipeLabel;
    }

    public void setQuantityRequired(Integer quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    //GETTORS
    public String getingredientLabel() {
        return ingredientLabel;
    }

    public String getRecipeLabel() {
        return recipeLabel;
    }

    public Integer getQuantityRequired() {
        return quantityRequired;
    }
}
