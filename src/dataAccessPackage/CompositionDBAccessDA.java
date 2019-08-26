package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Composition;

import java.util.ArrayList;

public interface CompositionDBAccessDA {
    public ArrayList<Composition> getComposition(String labelRecipe) throws DataException;
}
