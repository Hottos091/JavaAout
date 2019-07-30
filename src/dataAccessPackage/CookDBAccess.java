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

        String labelRecipe;

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
}
