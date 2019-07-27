package modelPackage;

import java.util.GregorianCalendar;

public class PreparationOrder {
    private String code;
    private Integer numberPortions;
    private double pricePortion;
    private GregorianCalendar productionDate;
    private GregorianCalendar expiryDate;
    private GregorianCalendar saleDate;
    private String chiefCommentary;
    private String cookCommentary;
    private String cookIdNumber;
    private String labelRecipe;
    private boolean isUrgent;


    //GETTORS
    public String getCode() {
        return code;
    }

    public Integer getNumberPortions() {
        return numberPortions;
    }

    public double getPricePortion() {
        return pricePortion;
    }

    public GregorianCalendar getProductionDate() {
        return productionDate;
    }

    public GregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    public GregorianCalendar getSaleDate() {
        return saleDate;
    }

    public String getChiefCommentary() {
        return chiefCommentary;
    }

    public String getCookCommentary() {
        return cookCommentary;
    }

    public String getCookIdNumber() {
        return cookIdNumber;
    }

    public String getLabelRecipe() {
        return labelRecipe;
    }

    public boolean getIsUrgent() {
        return isUrgent;
    }

    /*public Cook getCook() {
        return cook;
    }*/

    //SETTORS
    public void setCode(String code) {
        this.code = code;
    }

    public void setNumberPortions(Integer numberPortions) {
        this.numberPortions = numberPortions;
    }

    public void setPricePortion(double pricePortion) {
        this.pricePortion = pricePortion;
    }

    public void setProductionDate(GregorianCalendar productionDate) {
        this.productionDate = productionDate;
    }

    public void setExpiryDate(GregorianCalendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setSaleDate(GregorianCalendar saleDate) {
        this.saleDate = saleDate;
    }

    public void setChiefCommentary(String chiefCommentary) {
        this.chiefCommentary = chiefCommentary;
    }

    public void setCookCommentary(String cookCommentary) {
        this.cookCommentary = cookCommentary;
    }

    public void setCookIdNumber(String cookIdNumber) {
        this.cookIdNumber = cookIdNumber;
    }

    public void setLabelRecipe(String labelRecipe) {
        this.labelRecipe = labelRecipe;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    /*public void setCook(Cook cook) {
        this.cook = cook;
    }*/
}
