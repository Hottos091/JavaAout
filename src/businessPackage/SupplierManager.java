package businessPackage;

import dataAccessPackage.SupplierDBAccess;
import dataAccessPackage.SupplierDBAccessDA;
import exceptionPackage.DataException;

import java.util.ArrayList;

public class SupplierManager {
    private SupplierDBAccessDA supplierDBAccessDA;

    public SupplierManager(){
        supplierDBAccessDA = new SupplierDBAccess();
    }

    public ArrayList<String> getAllSuppliers() throws DataException{
        return supplierDBAccessDA.getAllSupplier();
    }
    public String getIdSupplier(String firstname, String name) throws DataException {
        return supplierDBAccessDA.getIdSupplier(firstname, name);
    }


}
