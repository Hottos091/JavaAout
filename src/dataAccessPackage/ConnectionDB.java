package dataAccessPackage;

import java.sql.SQLException;

public class ConnectionDB { //TODO throws exception
    public void closeConnection() {
        try {
            SingletonConnection.getInstance().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
