package modelPackage;

import java.util.GregorianCalendar;

public class ResearchResult {
    private GregorianCalendar productionDate;
    private String labelRecipe;
    private Integer quantity;
    private String labelIngredient;


    public void setProductionDate(GregorianCalendar productionDate) {
        this.productionDate = productionDate;
    }

    public void setLabelRecipe(String labelRecipe) {
        this.labelRecipe = labelRecipe;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setLabelIngredient(String labelIngredient) {
        this.labelIngredient = labelIngredient;
    }

    public GregorianCalendar getProductionDate() {
        return productionDate;
    }

    public String getLabelRecipe() {
        return labelRecipe;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getLabelIngredient() {
        return labelIngredient;
    }
}
