package dataAccessPackage;

import exceptionPackage.DataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDBAccess implements SupplierDBAccessDA{
    public ArrayList<String> getAllSupplier() throws DataException{
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
            throw new DataException("Echec de l'obtention de tous les fournisseurs.");
        }
        return suppliersNames;
    }

    public String getIdSupplier(String firstname, String name) throws DataException{
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
            throw new DataException("Echec de l'obtention de l'id du fournisseur.");
        }
        return phoneNumber;
    }
}
