package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.Ingredient;
import modelPackage.Order;
import modelPackage.OrderLine;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderDBAccess implements OrderDBAccessDA{

    public void addOrder(String supplierId) throws DataException {
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
            JOptionPane.showMessageDialog(null, "Echec de l'ajout de la commande dans la base de donnée", "Erreur", 0);
        }
    }

    public Integer getLastId() throws DataException{
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
            throw new DataException("Echec de l'obtention de l'id de la dernière commande.");
        }
        return code;
    }
}
