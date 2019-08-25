package businessPackage;

import dataAccessPackage.RecipeDBAccess;
import dataAccessPackage.RecipeDBAccessDA;
import exceptionPackage.DataException;
import modelPackage.Recipe;

import java.util.ArrayList;

public class RecipeManager {
    private RecipeDBAccessDA recipeDBAccessDA;

    public RecipeManager() {
        this.recipeDBAccessDA = new RecipeDBAccess();
    }

    public ArrayList<String> getAllRecipesLabels() throws DataException{
        return recipeDBAccessDA.getAllRecipesLabels();
    }
    public Recipe getRecipe(String recipeLabel) throws DataException{
        return recipeDBAccessDA.getRecipe(recipeLabel);
    }
}
