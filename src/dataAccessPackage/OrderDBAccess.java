package dataAccessPackage;

import modelPackage.Ingredient;
import modelPackage.Order;
import modelPackage.OrderLine;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderDBAccess {

    public void addOrder(String supplierId){
        Connection connection = SingletonConnection.getInstance();
        long millis = System.currentTimeMillis();
        java.sql.Date sqlDate = new java.sql.Date(millis);

        String sql = "INSERT INTO commande VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setDate(2, sqlDate);
            statement.setString(3, supplierId);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }






    }
}
