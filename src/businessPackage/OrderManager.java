package businessPackage;

import dataAccessPackage.OrderDBAccess;
import modelPackage.Ingredient;
import modelPackage.OrderLine;

import java.util.ArrayList;

public class OrderManager {
    private OrderDBAccess orderDBAccess;

    public OrderManager(){
        this.orderDBAccess = new OrderDBAccess();
    }

    public void addOrder(String supplierId){
        orderDBAccess.addOrder(supplierId);
    }












}
