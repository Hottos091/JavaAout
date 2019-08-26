package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Composition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompositionDBAccess implements CompositionDBAccessDA{
    public ArrayList<Composition> getComposition(String labelRecipe) throws DataException{
        Connection connection = SingletonConnection.getInstance();

        ResultSet dataRS = null;

        ArrayList<Composition> recipeComposition = new ArrayList<>();
        String ingredientLabel;
        int requiredQuantity;

        String sql = "SELECT label_ingredient, required_quantity " +
                "FROM Composition " +
                "WHERE recipe_label = ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, labelRecipe);
            dataRS = statement.executeQuery();
            while(dataRS.next()){
                Composition composition = new Composition();

                ingredientLabel = dataRS.getString("label_ingredient");
                requiredQuantity = dataRS.getInt("required_quantity");

                composition.setIngredientLabel(ingredientLabel);
                composition.setRequiredQuantity(requiredQuantity);

                recipeComposition.add(composition);
            }
        } catch(SQLException e){
            throw new DataException("Erreur lors de l'obtention de la composition de la recette.\n");
        }
        return recipeComposition;
    }

}
