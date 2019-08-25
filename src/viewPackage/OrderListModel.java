package viewPackage;

import modelPackage.Ingredient;
import modelPackage.OrderLine;
import modelPackage.PreparationOrder;
import modelPackage.ResearchResult;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Date;

public class OrderListModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<OrderLine> contents;

    public OrderListModel(ArrayList<OrderLine> list){
        contents = list;
        columnNames = new ArrayList<>();
        columnNames.add("Label ingrédient");
        columnNames.add("Quantite voulue");
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
        OrderLine orderLine = contents.get(row);

        switch(column){
            case 0 : return orderLine.getIngredientLabel();
            case 1 : return orderLine.getQuantity();
            default : return null;
        }
    }

    public Class getColumnClass (int column) {
        Class c;
        switch (column){
            case 0 : c = String.class;
            case 1 : c = Integer.class;
            default : c = String.class;
        }
        return c;
    }
}
