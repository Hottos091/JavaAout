package dataAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection uniqueConnection;

    public static Connection getInstance(){
        if (uniqueConnection == null){ //La connexion n'existe pas encore. Il faut donc (essayer de) créer la connexion à la BD
            try {
                uniqueConnection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test3?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
                        "root",
                        "Bk645yRp");
            } catch (SQLException e){ //En cas d'échec de la connexion à la BD
               System.out.println(e.getMessage());
            }
        }
        return uniqueConnection;
    }
}
