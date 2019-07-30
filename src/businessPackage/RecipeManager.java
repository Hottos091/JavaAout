package businessPackage;

import dataAccessPackage.RecipeDBAccess;
import modelPackage.Recipe;

import java.util.ArrayList;

public class RecipeManager {
    private RecipeDBAccess recipeDBAccess;

    public RecipeManager() {
        this.recipeDBAccess = new RecipeDBAccess();
    }

    public ArrayList<String> getAllRecipesLabels(){
        return recipeDBAccess.getAllRecipesLabels();
    }
    public Recipe getRecipe(String recipeLabel){
        return recipeDBAccess.getRecipe(recipeLabel);
    }
}
