package businessPackage;

import dataAccessPackage.OrderDBAccess;
import modelPackage.Ingredient;

import java.util.ArrayList;

public class OrderManager {
    private OrderDBAccess orderDBAccess;

    public OrderManager(){
        this.orderDBAccess = new OrderDBAccess();
    }

    public ArrayList<Ingredient> getAllIngredients(){
        return orderDBAccess.getAllIngredients();
    }






}
