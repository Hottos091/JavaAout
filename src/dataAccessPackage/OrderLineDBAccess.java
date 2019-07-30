package dataAccessPackage;

import modelPackage.OrderLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderLineDBAccess {
    public void addOrderLines(ArrayList<OrderLine> orderLines, Integer orderId) {
        Connection connection = SingletonConnection.getInstance();
        String sql = "INSERT INTO lignecommande VALUES (?, ?, ?)";

        for(OrderLine orderLine : orderLines){
            try {
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, orderId);
                statement.setString(2, orderLine.getIngredientLabel());
                statement.setInt(3, orderLine.getQuantity());

                statement.executeUpdate();
            } catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
