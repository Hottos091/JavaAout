package businessPackage;

import dataAccessPackage.OrderLineDBAccess;
import dataAccessPackage.OrderLineDBAccessDA;
import exceptionPackage.DataException;
import modelPackage.OrderLine;

import java.util.ArrayList;

public class OrderLineManager {
    private OrderLineDBAccessDA orderLineDBAccessDA;

    public OrderLineManager(){
        this.orderLineDBAccessDA = new OrderLineDBAccess();
    }

    public void addOrderLines(ArrayList<OrderLine> orderLines, Integer orderId) throws DataException {
        orderLineDBAccessDA.addOrderLines(orderLines, orderId);
    }
}
