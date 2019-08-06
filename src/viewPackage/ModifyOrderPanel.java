package viewPackage;

import controllerPackage.ApplicationController;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyOrderPanel extends JPanel {
    private AllPreparationOrdersPanel allPreparationOrdersPanel;
    private JButton buttonDelete;
    private JButton buttonModify;
    private JPanel buttonsPanel;

    public ModifyOrderPanel(ApplicationController applicationController){
        allPreparationOrdersPanel = new AllPreparationOrdersPanel(applicationController);
        JTable table = allPreparationOrdersPanel.getTable();

        this.setLayout(new BorderLayout());
        this.add(allPreparationOrdersPanel);

        buttonsPanel = new JPanel();
        buttonDelete = new JButton("Supprimer");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                if (rowIndex != -1) {
                    applicationController.deletePreparationOrder(Integer.parseInt((String) table.getValueAt(rowIndex, 0)));
                    ((AllPreparationOrdersModel) table.getModel()).removeRow(rowIndex);
                }
            }
        });
        buttonModify = new JButton("Modifier");

        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.add(buttonDelete, BorderLayout.EAST);
        buttonsPanel.add(buttonModify, BorderLayout.WEST);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
}
