package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.PreparationOrder;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AllPreparationOrdersModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<PreparationOrder> contents;
    private ApplicationController applicationController;

    public AllPreparationOrdersModel(ArrayList<PreparationOrder> preparationOrders, ApplicationController applicationController){
        contents = preparationOrders;
        columnNames = new ArrayList<>();
        columnNames.add("Code");
        columnNames.add("Label recette");
        columnNames.add("Nom cuisinier");
        columnNames.add("Prix portion");
        columnNames.add("Date production");
        columnNames.add("Date peremption");
        columnNames.add("Date vente");
        columnNames.add("Nb portions");
        columnNames.add("Comm chef");
        columnNames.add("Comm cuisinier");
        columnNames.add("Urgent ?");

        this.applicationController = applicationController;

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

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        switch(column){
            case 0 : return preparationOrder.getCode();
            case 1 : return preparationOrder.getLabelRecipe();
            case 2 : return applicationController.getCookName(preparationOrder.getCookIdNumber());
            case 3 : return preparationOrder.getPricePortion();
            case 4 : return dateFormat.format(preparationOrder.getProductionDate().getTime());
            case 5 : return dateFormat.format(preparationOrder.getExpiryDate().getTime());
            case 6 : return dateFormat.format(preparationOrder.getSaleDate().getTime());
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
            case 4 : c = String.class;
            case 5 : c = String.class;
            case 6 : c = String.class;
            case 7 : c = Integer.class;
            case 8 : c = String.class;
            case 9 : c = String.class;
            case 10 : c = Boolean.class;
            default : c = String.class;
        }
        return c;
    }

    public void removeRow(int row) {
        contents.remove(row);
        fireTableRowsDeleted(row, row);
    }

}
