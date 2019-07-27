package controllerPackage;

import modelPackage.*;

import businessPackage.*;

import java.util.ArrayList;

public class ApplicationController {
    private PreparationOrderManager preparationOrderManager;    //Order = ordre
    private ConnectionManager connectionManager;
    private OrderManager orderManager;                          //Order = commande
    private IngredientManager ingredientManager;


    public ApplicationController(){
        this.preparationOrderManager = new PreparationOrderManager();
        this.connectionManager = new ConnectionManager();
        this.orderManager = new OrderManager();
        this.ingredientManager = new IngredientManager();
    }

    //CONNECTION
    public void closeConnection(){
        connectionManager.closeConnection();
        System.out.println("Connexion coupée. Au revoir !");
    }
    //ORDERS
    public void addOrder(ArrayList<OrderLine> orderLines){
        orderManager.addOrder();
    }

    //PREPARATION ORDERS
    public ArrayList<PreparationOrder> getAllPreparationOrders() { //TODO throws exceptionGetAllOrder
        return preparationOrderManager.getAllPreparationOrders();
    }

    //INGREDIENT
    public ArrayList<Ingredient> getAllIngredients(){
        return ingredientManager.getAllIngredients();
    }

}
