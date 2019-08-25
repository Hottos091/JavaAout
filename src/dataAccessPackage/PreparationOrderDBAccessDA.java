package dataAccessPackage;

import modelPackage.PreparationOrder;
import modelPackage.ResearchResult;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface PreparationOrderDBAccessDA {
    public ArrayList<PreparationOrder> getAllPreparationOrders();

    public void addPreparationOrder(PreparationOrder preparationOrder);

    public void deletePreparationOrder(Integer preparationOrderId);

    public void modifyPreparationOrder(PreparationOrder preparationOrder);

    public ArrayList<ResearchResult> getResearchPreparationOrders(GregorianCalendar date1, GregorianCalendar date2);


}
