package businessPackage;

import dataAccessPackage.SupplierDBAccess;
import modelPackage.Supplier;

import javax.swing.*;
import java.util.ArrayList;

public class SupplierManager {
    private SupplierDBAccess supplierDBAccess;

    public SupplierManager(){
        supplierDBAccess = new SupplierDBAccess();
    }

    public ArrayList<String> getAllSuppliers(){
        return supplierDBAccess.getAllSupplier();
    }
    public String getIdSupplier(String firstname, String name){
        return supplierDBAccess.getIdSupplier(firstname, name);
    }


}
