package dataAccessPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDBAccess {
    public ArrayList<String> getAllSupplier(){
        ArrayList<String> suppliersNames = new ArrayList<>();

        String name;
        String firstname;

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;

        String sql = "SELECT prenom, nom FROM fournisseur;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            dataRS = statement.executeQuery();
            while (dataRS.next()) {
                String fullName;

                name = dataRS.getString("nom");
                firstname = dataRS.getString("prenom");

                fullName = firstname + " " + name;
                suppliersNames.add(fullName);
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return suppliersNames;
    }

    public String getIdSupplier(String firstname, String name){
        String phoneNumber = null;

        Connection connection = SingletonConnection.getInstance();
        ResultSet dataRS = null;
        String sql = "SELECT numtel " +
                "FROM fournisseur " +
                "WHERE fournisseur.nom=" +"'" + name + "'" +
                " AND fournisseur.prenom=" + "'" + firstname + "';";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            dataRS = statement.executeQuery();
            while(dataRS.next()) {
                phoneNumber = dataRS.getString("numtel");
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return phoneNumber;
    }
}
