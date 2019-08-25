package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Recipe;

import java.util.ArrayList;

public interface RecipeDBAccessDA {
    public ArrayList<String> getAllRecipesLabels() throws DataException;

    public Recipe getRecipe(String recipeLabel) throws DataException;
}
