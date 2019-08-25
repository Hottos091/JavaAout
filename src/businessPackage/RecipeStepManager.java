package businessPackage;

import dataAccessPackage.RecipeStepDBAccess;
import dataAccessPackage.RecipeStepDBAccessDA;
import modelPackage.RecipeStep;

import java.util.ArrayList;

public class RecipeStepManager {
    private RecipeStepDBAccessDA recipeStepDBAccessDA;

    public RecipeStepManager(){
        this.recipeStepDBAccessDA = new RecipeStepDBAccess();
    }

    public ArrayList<RecipeStep> getRecipeSteps(String recipelabel){
        return recipeStepDBAccessDA.getRecipeSteps(recipelabel);
    }
}
