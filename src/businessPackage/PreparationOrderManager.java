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
    public void addPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderDB.addPreparationOrder(preparationOrder);
    }
    public void deletePreparationOrder(Integer preparationOrderId){
        preparationOrderDB.deletePreparationOrder(preparationOrderId);
    }
    public void modifyPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderDB.modifyPreparationOrder(preparationOrder);
    }
}
