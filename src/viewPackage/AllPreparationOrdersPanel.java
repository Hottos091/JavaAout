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

    public AllPreparationOrdersPanel(ApplicationController applicationController) {
        this.applicationController = applicationController;

        allPreparationOrders = applicationController.getAllPreparationOrders();

        this.setLayout(new BorderLayout());

        model = new AllPreparationOrdersModel(allPreparationOrders);
        table = new JTable(model);
        table.setLayout(new BorderLayout());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listSelectionModel = table.getSelectionModel();
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setVisible(true);
        this.add(table);
        this.setVisible(true);
    }


    public JTable getTable(){
        return table;
    }

    public AllPreparationOrdersModel getModel(){
        return model;
    }
}
