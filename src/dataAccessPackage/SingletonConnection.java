package dataAccessPackage;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection uniqueConnection;

    public static Connection getInstance(){
        if (uniqueConnection == null){ //La connexion n'existe pas encore. Il faut donc (essayer de) créer la connexion à la BD
            try {
                uniqueConnection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bazar?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Paris",
                        "root",
                        "Bk645yRp");
            } catch (SQLException e){ //En cas d'échec de la connexion à la BD
                JOptionPane.showMessageDialog(null, "Erreur lors de la connexion à la base de données !", "Erreur critique",  0);
            }
        }
        return uniqueConnection;
    }
}
