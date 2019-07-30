package modelPackage;


import java.util.GregorianCalendar;

public class Recipe {
    private String recipeLabel;
    private Integer preparationTime; //minutes
    private Integer nbPeople;
    //TODO AJOUTER UNE VALEUR "Int jourAvantPeremption"


    public String getRecipeLabel() {
        return recipeLabel;
    }

    public void setRecipeLabel(String recipeLabel) {
        this.recipeLabel = recipeLabel;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getNbPeople() {
        return nbPeople;
    }

    public void setNbPeople(Integer nbPeople) {
        this.nbPeople = nbPeople;
    }
}
