package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Recipe;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDBAccess implements RecipeDBAccessDA{
    public ArrayList<String> getAllRecipesLabels() throws DataException{
        ArrayList<String> allRecipes = new ArrayList<>();

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        //Données query
        String labelRecipe;

        String sql = "SELECT recettelabel FROM recette;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();
            while(dataRS.next()){
                allRecipes.add(dataRS.getString("recettelabel"));
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Echec de la saisie des labels des recettes.", "Erreur", 0);
        }
        return allRecipes;
    }

    public Recipe getRecipe(String recipeLabel) throws DataException{
        Recipe recipe = null;

        Connection connection = SingletonConnection.getInstance();

        ResultSet dataRS = null;
        String sql = "SELECT * FROM recette WHERE recettelabel = '" + recipeLabel +"';";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();
            while(dataRS.next()){
                recipe = new Recipe();

                recipe.setRecipeLabel(dataRS.getString("recettelabel"));

                recipe.setPreparationTime(dataRS.getInt("tempspreparation"));

                recipe.setNbPeople(dataRS.getInt("nbPersonnes"));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Echec de la saisie de la recette.", "Erreur", 0);
        }
        return recipe;
    }
}
