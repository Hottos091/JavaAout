package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.OrderLine;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderLineDBAccess implements OrderLineDBAccessDA{
    public void addOrderLines(ArrayList<OrderLine> orderLines, Integer orderId) throws DataException{
        Connection connection = SingletonConnection.getInstance();
        String sql = "INSERT INTO orderline VALUES (?, ?, ?)";

        for(OrderLine orderLine : orderLines){
            try {
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, orderId);
                statement.setString(2, orderLine.getIngredientLabel());
                statement.setInt(3, orderLine.getQuantity());

                statement.executeUpdate();
            } catch (SQLException e){
                throw new DataException("Echec de l'ajout d'une ligne de commande.");
            }
        }
    }
}
