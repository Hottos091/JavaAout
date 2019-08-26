package dataAccessPackage;

import exceptionPackage.DataException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CookDBAccess implements CookDBAccessDA{
    public ArrayList<String> getAllCooks() {
        ArrayList<String> allCooks = new ArrayList<>();

        String name;
        String firstname;

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        String sql = "SELECT firstname, name FROM cook;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            dataRS = statement.executeQuery();
            while (dataRS.next()) {
                String fullName;

                name = dataRS.getString("name");
                firstname = dataRS.getString("firstname");

                fullName = firstname + " " + name;
                allCooks.add(fullName);
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Echec de l'obtention des cooks", "Erreur", 0);
        }
        return allCooks;
    }

    public String getCookName(Integer cookId) {
        Connection connection = SingletonConnection.getInstance();

        ResultSet dataRS = null;
        String fullName = null;

        String sql = "SELECT firstname, name FROM cook WHERE id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cookId);
            dataRS = statement.executeQuery();
            while (dataRS.next()) {
                String name;
                String firstname;

                name = dataRS.getString("name");
                firstname = dataRS.getString("firstname");

                fullName = firstname + " " + name;
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problème lors de l'obtention du name du cook.", "Erreur", 0);
        }
        return fullName;
    }

    public Integer getCookId(String cook) {
        Integer cookId = null;

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        String[] splitFullName = cook.split("\\s+", -2);

        String sql = "SELECT id " +
                "FROM cook " +
                "WHERE cook.name=? " +
                " AND cook.firstname=?;";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, splitFullName[1]);
            statement.setString(2, splitFullName[0]);

            dataRS = statement.executeQuery();
            while(dataRS.next()) {
                cookId = dataRS.getInt("id");
            }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problème lors de l'obtention de l'id du cook.", "Erreur", 0);
        }
        return cookId;
    }
}
