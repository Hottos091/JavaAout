package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Ingredient;
import modelPackage.OrderLine;

import java.sql.*;
import java.util.ArrayList;

public class IngredientDBAccess implements IngredientDBAccessDA{
    public ArrayList<Ingredient> getAllIngredients () throws DataException {
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
                labelIngredient = dataRS.getString("label_ingredient");
                ingredient.setLabel(labelIngredient);

                stockQuantityIngredient = dataRS.getInt("in_stock_quantity");
                ingredient.setQuantityInStock(stockQuantityIngredient);

                allIngredients.add(ingredient);
            }
        } catch (SQLException e){
            throw new DataException("Echec de la saisie des ingrédients.\n");
        }
        return allIngredients;
    }

    public void addQuantity (ArrayList<OrderLine> orderLines) throws DataException {
        Connection connection = SingletonConnection.getInstance();

        String sql = "UPDATE Ingredient " +
                "SET in_stock_quantity = in_stock_quantity + ? " +
                "WHERE label_ingredient = ?";

        for(OrderLine orderLine : orderLines){
            try {
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, orderLine.getQuantity());
                statement.setString(2, orderLine.getIngredientLabel());

                statement.executeUpdate();
            } catch (SQLException e){
                throw new DataException("Echec lors de la mise à jour de la quantité des ingrédients.\n");
            }
        }
    }
}
