package dataAccessPackage;

import exceptionPackage.DataException;

import java.util.ArrayList;

public interface SupplierDBAccessDA {
    public ArrayList<String> getAllSupplier() throws DataException;

    public String getIdSupplier(String firstname, String name) throws DataException;
}
