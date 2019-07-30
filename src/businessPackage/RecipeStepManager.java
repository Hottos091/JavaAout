package businessPackage;

import dataAccessPackage.RecipeStepDBAccess;
import modelPackage.RecipeStep;

import java.util.ArrayList;

public class RecipeStepManager {
    private RecipeStepDBAccess recipeStepDBAccess;

    public RecipeStepManager(){
        this.recipeStepDBAccess = new RecipeStepDBAccess();
    }

    public ArrayList<RecipeStep> getRecipeSteps(String recipelabel){
        return recipeStepDBAccess.getRecipeSteps(recipelabel);
    }
}
