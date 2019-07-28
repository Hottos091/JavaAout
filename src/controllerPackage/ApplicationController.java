package controllerPackage;

import modelPackage.*;

import businessPackage.*;

import java.util.ArrayList;

public class ApplicationController {
    private PreparationOrderManager preparationOrderManager;    //Order = ordre
    private ConnectionManager connectionManager;
    private OrderManager orderManager;                          //Order = commande
    private IngredientManager ingredientManager;
    private SupplierManager supplierManager;
    private OrderLineManager orderLineManager;


    public ApplicationController(){
        this.preparationOrderManager = new PreparationOrderManager();
        this.connectionManager = new ConnectionManager();
        this.orderManager = new OrderManager();
        this.ingredientManager = new IngredientManager();
        this.supplierManager = new SupplierManager();
        this.orderLineManager = new OrderLineManager();
    }

    //CONNECTION
    public void closeConnection(){
        connectionManager.closeConnection();
        System.out.println("Connexion coupée. Au revoir !");
    }
    //ORDERS
    public void addOrder(String supplierId){
        orderManager.addOrder(supplierId);
    }

    //ORDERLINE
    public void addOrderLines(ArrayList<OrderLine> orderLines){
        orderLineManager.addOrderLines(orderLines);
    }

    //PREPARATION ORDERS
    public ArrayList<PreparationOrder> getAllPreparationOrders() { //TODO throws exceptionGetAllOrder
        return preparationOrderManager.getAllPreparationOrders();
    }

    //INGREDIENT
    public ArrayList<Ingredient> getAllIngredients(){
        return ingredientManager.getAllIngredients();
    }

    //SUPPLIER
    public ArrayList<String> getAllSuppliers(){
        return supplierManager.getAllSuppliers();
    }
    public String getIdSupplier(String firstname, String name){
        return supplierManager.getIdSupplier(firstname, name);
    }
}
