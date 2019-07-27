package businessPackage;

import dataAccessPackage.IngredientDBAccess;
import modelPackage.Ingredient;

import java.util.ArrayList;

public class IngredientManager {
    private IngredientDBAccess ingredientDBAccess;

    public IngredientManager(){
        this.ingredientDBAccess = new IngredientDBAccess();
    }

    public ArrayList<Ingredient> getAllIngredients(){
        return ingredientDBAccess.getAllIngredients();
    }
}
