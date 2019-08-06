package controllerPackage;

import modelPackage.*;

import businessPackage.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ApplicationController {
    private PreparationOrderManager preparationOrderManager;    //Order = ordre
    private ConnectionManager connectionManager;
    private OrderManager orderManager;                          //Order = commande
    private IngredientManager ingredientManager;
    private SupplierManager supplierManager;
    private OrderLineManager orderLineManager;
    private RecipeManager recipeManager;
    private CookManager cookManager;
    private RecipeStepManager recipeStepManager;

    public ApplicationController(){
        this.preparationOrderManager = new PreparationOrderManager();
        this.connectionManager = new ConnectionManager();
        this.orderManager = new OrderManager();
        this.ingredientManager = new IngredientManager();
        this.supplierManager = new SupplierManager();
        this.orderLineManager = new OrderLineManager();
        this.recipeManager = new RecipeManager();
        this.cookManager = new CookManager();
        this.recipeStepManager = new RecipeStepManager();
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
    public Integer getLastId(){
        return orderManager.getLastId();
    }

    //ORDERLINE
    public void addOrderLines(ArrayList<OrderLine> orderLines, Integer orderId){
        orderLineManager.addOrderLines(orderLines, orderId);
    }

    //PREPARATION ORDERS
    public ArrayList<PreparationOrder> getAllPreparationOrders() { //TODO throws exceptionGetAllOrder
        return preparationOrderManager.getAllPreparationOrders();
    }
    public void addPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderManager.addPreparationOrder(preparationOrder);
    }
    public void deletePreparationOrder(Integer preparationOrderId){
        preparationOrderManager.deletePreparationOrder(preparationOrderId);
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

    //RECIPE
    public ArrayList<String> getAllRecipesLabels(){
        return recipeManager.getAllRecipesLabels();
    }
    public Recipe getRecipe(String recipeLabel){
        return recipeManager.getRecipe(recipeLabel);
    }

    //RECIPESTEP
    public ArrayList<RecipeStep> getRecipeSteps(String recipelabel){
        return recipeStepManager.getRecipeSteps(recipelabel);
    }

    //COOK
    public ArrayList<String> getAllCooks(){
        return cookManager.getAllCooks();
    }

    public Integer getCookId(String firstname, String lastname) { return cookManager.getCookId(firstname, lastname); }
}
