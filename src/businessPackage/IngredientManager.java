package businessPackage;

import dataAccessPackage.IngredientDBAccess;
import dataAccessPackage.IngredientDBAccessDA;
import exceptionPackage.DataException;
import modelPackage.Ingredient;

import java.util.ArrayList;

public class IngredientManager {
    private IngredientDBAccessDA ingredientDBAccessDA;

    public IngredientManager() {
        this.ingredientDBAccessDA = new IngredientDBAccess();
    }

    public ArrayList<Ingredient> getAllIngredients() throws DataException {
        return ingredientDBAccessDA.getAllIngredients();
    }
}
