package dataAccessPackage;

import exceptionPackage.DataException;
import modelPackage.OrderLine;

import java.util.ArrayList;

public interface OrderLineDBAccessDA {
    public void addOrderLines(ArrayList<OrderLine> orderLines, Integer orderId) throws DataException;
}
