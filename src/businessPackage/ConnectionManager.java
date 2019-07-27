package businessPackage;

import dataAccessPackage.ConnectionDB;

public class ConnectionManager {
    private ConnectionDB connectionDB;

    public ConnectionManager(){
        connectionDB = new ConnectionDB();
    }

    public void closeConnection(){
        connectionDB.closeConnection();
    }
}
