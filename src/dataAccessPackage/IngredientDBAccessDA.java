package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Ingredient;
import modelPackage.OrderLine;

import java.util.ArrayList;

public interface IngredientDBAccessDA {
    public ArrayList<Ingredient> getAllIngredients () throws DataException;

    public void addQuantity(ArrayList<OrderLine> orderLines) throws DataException;
}
