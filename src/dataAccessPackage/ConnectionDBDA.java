package dataAccessPackage;

import exceptionPackage.CloseConnectionException;

public interface ConnectionDBDA {
    public void closeConnection() throws CloseConnectionException;
}
