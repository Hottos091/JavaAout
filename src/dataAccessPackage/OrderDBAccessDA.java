package dataAccessPackage;

import exceptionPackage.DataException;

public interface OrderDBAccessDA {
    public void addOrder(String supplierId) throws DataException;

    public Integer getLastId() throws DataException;
}
