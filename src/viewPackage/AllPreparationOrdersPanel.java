package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.PreparationOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AllPreparationOrdersPanel extends JPanel {
    private ApplicationController applicationController;
    private ArrayList<PreparationOrder> allPreparationOrders;
    private JTable table;
    private AllPreparationOrdersModel model;
    private ListSelectionModel listSelectionModel;
    private JScrollPane scrollPane;

    public AllPreparationOrdersPanel(ApplicationController applicationController) {
        this.applicationController = applicationController;

        allPreparationOrders = applicationController.getAllPreparationOrders();

        this.setLayout(new BorderLayout());

        model = new AllPreparationOrdersModel(allPreparationOrders, applicationController);
        table = new JTable(model);
        scrollPane = new JScrollPane(table);
        //table.setLayout(new BorderLayout());
        table.setSelectionMode(listSelectionModel.SINGLE_SELECTION);

        listSelectionModel = table.getSelectionModel();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        scrollPane.setVisible(true);
        this.add(scrollPane);
        this.setVisible(true);
    }


    public JTable getTable(){
        return table;
    }

    public AllPreparationOrdersModel getModel(){
        return model;
    }
}
