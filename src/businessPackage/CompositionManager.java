package businessPackage;

import dataAccessPackage.CompositionDBAccess;
import dataAccessPackage.CompositionDBAccessDA;
import exceptionPackage.DataException;
import modelPackage.Composition;

import java.util.ArrayList;

public class CompositionManager {
    private CompositionDBAccessDA compositionDBAccessDA;

    public CompositionManager(){
        compositionDBAccessDA = new CompositionDBAccess();
    }

    public ArrayList<Composition> getComposition(String labelRecipe) throws DataException {
        return compositionDBAccessDA.getComposition(labelRecipe);
    }
}
