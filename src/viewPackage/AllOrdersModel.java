package viewPackage;

import modelPackage.PreparationOrder;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class AllOrdersModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<PreparationOrder> contents;

    public AllOrdersModel(ArrayList<PreparationOrder> preparationOrders){
        contents = preparationOrders;
        columnNames = new ArrayList<>();
        columnNames.add("Code");
        columnNames.add("Label recette");
        columnNames.add("Matricule cuisinier");
        columnNames.add("Prix portion");
        columnNames.add("Date production");
        columnNames.add("Date de peremption");
        columnNames.add("Date de vente");
        columnNames.add("Nombre de portions");
        columnNames.add("Commentaire chef cuistot");
        columnNames.add("Commentaire cuisinier");
        columnNames.add("Urgent");
    }

    public int getColumnCount(){
        return columnNames.size();
    }
    public int getRowCount(){
        return contents.size();
    }
    public String getColumnName(int column){
        return columnNames.get(column);
    }
    public Object getValueAt(int row, int column){
        PreparationOrder preparationOrder = contents.get(row);

        switch(column){
            case 0 : return preparationOrder.getCode();
            case 1 : return preparationOrder.getLabelRecipe();
            case 2 : return preparationOrder.getCookIdNumber();
            case 3 : return preparationOrder.getPricePortion();
            case 4 : return preparationOrder.getProductionDate();
            case 5 : return preparationOrder.getExpiryDate();
            case 6 : return preparationOrder.getSaleDate();
            case 7 : return preparationOrder.getNumberPortions();
            case 8 : { if (preparationOrder.getChiefCommentary() != null)
                return preparationOrder.getChiefCommentary();
            else return null;}
            case 9 : {if (preparationOrder.getCookCommentary() != null)
                return preparationOrder.getCookCommentary();
            else return null; }
            case 10 : return preparationOrder.getIsUrgent();
            default : return null;
        }
    }

    public Class getColumnClass (int column) {
        Class c;
        switch (column){
            case 0 : c = Integer.class;
            case 1 : c = String.class;
            case 2 : c = String.class;
            case 3 : c = Double.class;
            case 4 : c = Date.class;
            case 5 : c = Date.class;
            case 6 : c = Date.class;
            case 7 : c = Integer.class;
            case 8 : c = String.class;
            case 9 : c = String.class;
            case 10 : c = Boolean.class;
            default : c = String.class;
        }
        return c;
    }



}
