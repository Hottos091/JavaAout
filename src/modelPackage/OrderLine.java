package modelPackage;

public class OrderLine {
    private Integer code;
    private Integer quantity;
    private Integer orderCode;
    private String ingredientLabel;

    //GETTORS
    public Integer getCode() {
        return code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public String getIngredientLabel() {
        return ingredientLabel;
    }

    //SETTORS
    public void setCode(Integer code) {
        this.code = code;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public void setIngredientLabel(String ingredientLabel) {
        this.ingredientLabel = ingredientLabel;
    }
}
