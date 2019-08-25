package businessPackage;

import dataAccessPackage.PreparationOrderDBAccess;
import dataAccessPackage.PreparationOrderDBAccessDA;
import modelPackage.PreparationOrder;
import modelPackage.ResearchResult;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PreparationOrderManager {
    PreparationOrderDBAccessDA preparationOrderDBDA;

    public PreparationOrderManager(){
        this.preparationOrderDBDA = new PreparationOrderDBAccess();
    }



    public ArrayList<PreparationOrder> getAllPreparationOrders(){
        return preparationOrderDBDA.getAllPreparationOrders();
    }
    public void addPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderDBDA.addPreparationOrder(preparationOrder);
    }
    public void deletePreparationOrder(Integer preparationOrderId){
        preparationOrderDBDA.deletePreparationOrder(preparationOrderId);
    }
    public void modifyPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderDBDA.modifyPreparationOrder(preparationOrder);
    }
    public ArrayList<ResearchResult> getResearchPreparationOrders(GregorianCalendar date1, GregorianCalendar date2) {
        return preparationOrderDBDA.getResearchPreparationOrders(date1, date2);
    }
}
