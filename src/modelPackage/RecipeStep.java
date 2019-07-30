package modelPackage;

public class RecipeStep {
    private Integer stepNumber;
    private String stepDescription;
    private String recipeLabel;


    public String toString(){
        return this.stepNumber + ". " + stepDescription + "\n";
    }





    //SETTORS
    public void setStepNumber(Integer stepNumber) {
        this.stepNumber = stepNumber;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public void setRecipeLabel(String recipeLabel) {
        this.recipeLabel = recipeLabel;
    }

    //GETTORS
    public Integer getStepNumber() {
        return stepNumber;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public String getRecipeLabel() {
        return recipeLabel;
    }
}
