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

        String sql = "INSERT INTO commande (datetransaction, numtelfournisseur) VALUES (?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, sqlDate);
            statement.setString(2, supplierId);

            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Integer getLastId(){
        Connection connection = SingletonConnection.getInstance();

        ResultSet dataRS = null;
        Integer code = null;

        String sql = "SELECT code\n" +
                "FROM commande\n" +
                "ORDER BY code DESC\n" +
                "LIMIT 1;\n";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();

            while(dataRS.next()){
                code = dataRS.getInt("code");
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return code;
    }
}
