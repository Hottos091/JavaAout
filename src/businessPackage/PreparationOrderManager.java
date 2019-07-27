package businessPackage;

import dataAccessPackage.PreparationOrderDBAccess;
import modelPackage.PreparationOrder;

import java.util.ArrayList;

public class PreparationOrderManager {
    PreparationOrderDBAccess preparationOrderDB;

    public PreparationOrderManager(){
        this.preparationOrderDB = new PreparationOrderDBAccess();
    }



    public ArrayList<PreparationOrder> getAllPreparationOrders(){
        return preparationOrderDB.getAllPreparationOrders();
    }
}
