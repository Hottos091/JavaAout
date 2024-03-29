package dataAccessPackage;

import businessPackage.ConnectionManager;
import modelPackage.RecipeStep;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeStepDBAccess implements RecipeStepDBAccessDA{
    public ArrayList<RecipeStep> getRecipeSteps(String recipelabel){
        ArrayList<RecipeStep> recipeSteps = new ArrayList<>();

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        String sql = "select step_number, step_description " +
                "from  recipestep " +
                "where recipe_label = ?" +
                "order by step_number";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, recipelabel);
            dataRS = statement.executeQuery();
            while(dataRS.next()){
                RecipeStep recipeStep = new RecipeStep();

                recipeStep.setStepDescription(dataRS.getString("step_description"));
                recipeStep.setStepNumber(dataRS.getInt("step_number"));

                recipeSteps.add(recipeStep);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Impossible d'obtenir les étapes de la recette.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        return recipeSteps;
    }
}
