package dataAccessPackage;

import exceptionPackage.CloseConnectionException;

import java.sql.SQLException;

public class ConnectionDB implements ConnectionDBDA { //TODO throws exception
    public void closeConnection() throws CloseConnectionException {
        try {
            SingletonConnection.getInstance().close();
        } catch (SQLException e) {
            throw new CloseConnectionException();
        }
    }
}
