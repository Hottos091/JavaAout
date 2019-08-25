package controllerPackage;

import exceptionPackage.CloseConnectionException;
import exceptionPackage.CookException;
import exceptionPackage.DataException;
import modelPackage.*;

import businessPackage.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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
    public void closeConnection() throws CloseConnectionException {
        connectionManager.closeConnection();
        System.out.println("Connexion coupée. Au revoir !");
    }
    //ORDERS
    public void addOrder(String supplierId) throws DataException{
        orderManager.addOrder(supplierId);
    }

    public Integer getLastId() throws DataException{
        return orderManager.getLastId();
    }

    //ORDERLINE
    public void addOrderLines(ArrayList<OrderLine> orderLines, Integer orderId) throws DataException {
        orderLineManager.addOrderLines(orderLines, orderId);
    }

    //PREPARATION ORDERS
    public ArrayList<PreparationOrder> getAllPreparationOrders() {
        return preparationOrderManager.getAllPreparationOrders();
    }
    public void addPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderManager.addPreparationOrder(preparationOrder);
    }
    public void deletePreparationOrder(Integer preparationOrderId){
        preparationOrderManager.deletePreparationOrder(preparationOrderId);
    }
    public void modifyPreparationOrder(PreparationOrder preparationOrder){
        preparationOrderManager.modifyPreparationOrder(preparationOrder);
    }
    public ArrayList<ResearchResult> getResearchPreparationOrders(GregorianCalendar date1, GregorianCalendar date2) {
        return preparationOrderManager.getResearchPreparationOrders(date1, date2);
    }

    //INGREDIENT
    public ArrayList<Ingredient> getAllIngredients() throws DataException{
        return ingredientManager.getAllIngredients();
    }

    //SUPPLIER
    public ArrayList<String> getAllSuppliers() throws DataException{
        return supplierManager.getAllSuppliers();
    }
    public String getIdSupplier(String firstname, String name) throws DataException{
        return supplierManager.getIdSupplier(firstname, name);
    }

    //RECIPE
    public ArrayList<String> getAllRecipesLabels() throws DataException{
        return recipeManager.getAllRecipesLabels();
    }
    public Recipe getRecipe(String recipeLabel)throws DataException{
        return recipeManager.getRecipe(recipeLabel);
    }

    //RECIPESTEP
    public ArrayList<RecipeStep> getRecipeSteps(String recipelabel) throws DataException{
        return recipeStepManager.getRecipeSteps(recipelabel);
    }

    //COOK
    public ArrayList<String> getAllCooks(){
        return cookManager.getAllCooks();
    }
    public String getCookName(Integer cookId){
        return cookManager.getCookName(cookId);
    }

    public Integer getCookId(String firstname, String lastname){ return cookManager.getCookId(firstname, lastname); }
}
