package dataAccessPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CookDBAccess {
    public ArrayList<String> getAllCooks(){
        ArrayList<String> allCooks = new ArrayList<>();

        String name;
        String firstname;

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        String sql = "SELECT prenom, nom FROM cuisinier;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            dataRS = statement.executeQuery();
            while (dataRS.next()) {
                String fullName;

                name = dataRS.getString("nom");
                firstname = dataRS.getString("prenom");

                fullName = firstname + " " + name;
                allCooks.add(fullName);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return allCooks;
    }

    public String getCookName(Integer cookId){
        Connection connection = SingletonConnection.getInstance();

        ResultSet dataRS = null;
        String fullName = null;

        String sql = "SELECT prenom, nom FROM cuisinier WHERE matricule = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, cookId);
            dataRS = statement.executeQuery();
            while (dataRS.next()) {
                String name;
                String firstname;

                name = dataRS.getString("nom");
                firstname = dataRS.getString("prenom");

                fullName = firstname + " " + name;
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return fullName;
    }

    public Integer getCookId(String firstname, String name) {
        Integer cookId = null;

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        String sql = "SELECT matricule " +
                "FROM cuisinier " +
                "WHERE cuisinier.nom=" +"'" + name + "'" +
                " AND cuisinier.prenom=" + "'" + firstname + "';";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();
            while(dataRS.next()) {
                cookId = dataRS.getInt("matricule");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return cookId;
    }
}
