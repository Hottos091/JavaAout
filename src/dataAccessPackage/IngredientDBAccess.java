package dataAccessPackage;

import dataAccessPackage.SingletonConnection;
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
        ResultSet dataRS = null;

        Ingredient ingredient;
        String labelIngredient;
        Integer stockQuantityIngredient;
        //TODO pas d'*
        String sql = "SELECT * from ingredient;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();

            while(dataRS.next()){
                ingredient = new Ingredient();
                labelIngredient = dataRS.getString("ingredientlabel");
                ingredient.setLabel(labelIngredient);

                stockQuantityIngredient = dataRS.getInt("quantiteenstock");
                ingredient.setQuantityInStock(stockQuantityIngredient);

                allIngredients.add(ingredient);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return allIngredients;
    }
}
