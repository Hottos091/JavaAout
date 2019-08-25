package dataAccessPackage;

import modelPackage.RecipeStep;

import java.util.ArrayList;

public interface RecipeStepDBAccessDA {
    public ArrayList<RecipeStep> getRecipeSteps(String recipelabel);
}
