package businessPackage;

import dataAccessPackage.OrderDBAccess;
import dataAccessPackage.OrderDBAccessDA;
import exceptionPackage.DataException;

public class OrderManager {
    private OrderDBAccessDA orderDBAccessDA;

    public OrderManager(){
        this.orderDBAccessDA = new OrderDBAccess();
    }

    public void addOrder(String supplierId) throws DataException {
        orderDBAccessDA.addOrder(supplierId);
    }

    public Integer getLastId() throws DataException{
        return orderDBAccessDA.getLastId();
    }













    }
