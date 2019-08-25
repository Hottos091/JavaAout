package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Ingredient;

import java.util.ArrayList;

public interface IngredientDBAccessDA {
    public ArrayList<Ingredient> getAllIngredients () throws DataException;
}
