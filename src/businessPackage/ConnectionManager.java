package businessPackage;

import dataAccessPackage.ConnectionDB;
import dataAccessPackage.ConnectionDBDA;
import exceptionPackage.CloseConnectionException;

public class ConnectionManager {
    private ConnectionDBDA connectionDBDA;

    public ConnectionManager(){
        connectionDBDA = new ConnectionDB();
    }

    public void closeConnection() throws CloseConnectionException {
        connectionDBDA.closeConnection();
    }
}
