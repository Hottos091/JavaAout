package viewPackage;

import modelPackage.PreparationOrder;
import modelPackage.ResearchResult;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ResearchModel extends AbstractTableModel {

    private ArrayList<String> columnNames;
    private ArrayList<ResearchResult> contents;

    public ResearchModel(ArrayList<ResearchResult> researchData){
        contents = researchData;
        columnNames = new ArrayList<>();
        columnNames.add("Date production");
        columnNames.add("Label recette");
        columnNames.add("Label ingredient");
        columnNames.add("Quantité nécessaire");
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
        ResearchResult researchResult = contents.get(row);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        switch(column){
            case 0 : return dateFormat.format(researchResult.getProductionDate().getTime());
            case 1 : return researchResult.getLabelRecipe();
            case 2 : return researchResult.getLabelIngredient();
            case 3 : return researchResult.getQuantity();
            default : return null;
        }
    }

    public Class getColumnClass (int column) {
        Class c;
        switch (column){
            case 0 : c = String.class;
            case 1 : c = String.class;
            case 2 : c = String.class;
            case 3 : c = Integer.class;
            default : c = String.class;
        }
        return c;
    }
}
