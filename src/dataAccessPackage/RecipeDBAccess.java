package dataAccessPackage;

import modelPackage.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecipeDBAccess {
    public ArrayList<String> getAllRecipesLabels(){
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
            System.out.println(e.getMessage());
        }
        return allRecipes;
    }

    public Recipe getRecipe(String recipeLabel){
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
            System.out.println(e.getMessage());
        }
        return recipe;
    }
}
