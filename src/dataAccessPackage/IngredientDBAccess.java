package dataAccessPackage;

import modelPackage.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDBAccess {
    public ArrayList<Ingredient> getAllIngredients (){
        ArrayList<Ingredient> allIngredients = new ArrayList<>();

        Connection connection = SingletonConnection.getInstance();
        ResultSet data = null;

        Ingredient ingredient;
        String labelIngredient;
        Integer stockQuantityIngredient;

        String sql = "SELECT * from ingredient;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            data = statement.executeQuery();

            while(data.next()){
                ingredient = new Ingredient();
                labelIngredient = data.getString("ingredientlabel");
                ingredient.setLabel(labelIngredient);

                stockQuantityIngredient = data.getInt("quantiteenstock");
                ingredient.setQuantityInStock(stockQuantityIngredient);

                allIngredients.add(ingredient);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return allIngredients;
    }
}
