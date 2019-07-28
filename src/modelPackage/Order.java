package modelPackage;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Order {
    private Integer code;
    private GregorianCalendar transactionDate;
    private Supplier supplier;


    //SETTORS
    public void setTransactionDate(GregorianCalendar transactionDate) {
        this.transactionDate = transactionDate;
    }
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    //GETTORS
    public GregorianCalendar getTransactionDate() {
        return transactionDate;
    }
    public Supplier getSupplier() {
        return supplier;
    }
}
