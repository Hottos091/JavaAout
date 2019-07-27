package modelPackage;

public class Ingredient {
    private String label;
    private Integer quantityInStock;

    //SETTORS
    public void setLabel(String label) {
        this.label = label;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    //GETTORS
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public String getLabel(){
        return label;
    }

    //toString
    public String toString(){
        return label;
    }
}
