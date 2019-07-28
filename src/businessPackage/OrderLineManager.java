package businessPackage;

import dataAccessPackage.OrderLineDBAccess;
import modelPackage.OrderLine;

import java.util.ArrayList;

public class OrderLineManager {
    private OrderLineDBAccess orderLineDBAccess;

    public OrderLineManager(){
        this.orderLineDBAccess = new OrderLineDBAccess();
    }

    public void addOrderLines(ArrayList<OrderLine> orderLines){
        orderLineDBAccess.addOrderLines(orderLines);
    }
}
