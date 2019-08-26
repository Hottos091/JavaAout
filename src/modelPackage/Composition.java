package modelPackage;

import java.util.ArrayList;

public class Composition {
    private String ingredientLabel;
    private String recipeLabel;
    private Integer requiredQuantity;


    public String toString(){
        return ingredientLabel + " : " + requiredQuantity+"\n";
    }
    //SETTORS
    public void setIngredientLabel(String ingredientLabel) {
        this.ingredientLabel = ingredientLabel;
    }

    public void setRecipeLabel(String recipeLabel) {
        this.recipeLabel = recipeLabel;
    }

    public void setRequiredQuantity(Integer requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    //GETTORS
    public String getIngredientLabel() {
        return ingredientLabel;
    }

    public String getRecipeLabel() {
        return recipeLabel;
    }

    public Integer getRequiredQuantity() {
        return requiredQuantity;
    }
}
