package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.PreparationOrder;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

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
                    applicationController.deletePreparationOrder((Integer) table.getValueAt(rowIndex, 0));
                    ((AllPreparationOrdersModel) table.getModel()).removeRow(rowIndex);
                }
            }
        });
        buttonModify = new JButton("Modifier");
        buttonModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = table.getSelectedRow();
                if(rowIndex != -1){
                    PreparationOrder modifiedOrder = new PreparationOrder();
                    GregorianCalendar calendarProduction = new GregorianCalendar();
                    GregorianCalendar calendarExpiry = new GregorianCalendar();
                    GregorianCalendar calendarSale = new GregorianCalendar();

                    modifiedOrder.setCode((Integer) table.getValueAt(rowIndex, 0));
                    modifiedOrder.setLabelRecipe((String) table.getValueAt(rowIndex, 1));
                    modifiedOrder.setCookIdNumber((Integer) table.getValueAt(rowIndex, 2));
                    modifiedOrder.setPricePortion((Double) table.getValueAt(rowIndex, 3));
                    calendarProduction.setTime((java.util.Date) table.getValueAt(rowIndex, 4));
                    modifiedOrder.setProductionDate(calendarProduction);
                    calendarExpiry.setTime((java.util.Date) table.getValueAt(rowIndex, 5));
                    modifiedOrder.setExpiryDate(calendarExpiry);
                    calendarSale.setTime((java.util.Date) table.getValueAt(rowIndex, 6));
                    modifiedOrder.setSaleDate(calendarSale);
                    modifiedOrder.setNumberPortions((Integer) table.getValueAt(rowIndex, 7));
                    modifiedOrder.setChiefCommentary((String) table.getValueAt(rowIndex, 8));
                    modifiedOrder.setCookCommentary((String) table.getValueAt(rowIndex, 9));
                    modifiedOrder.setUrgent((Boolean) table.getValueAt(rowIndex, 10));

                    JFrame frame = new JFrame("Modification ordre");
                    NewPreparationOrderPanel newPreparationOrderPanel = new NewPreparationOrderPanel(applicationController, modifiedOrder);
                    frame.setBounds(100,100, 800, 600);
                    Container container;
                    container = frame.getContentPane();
                    container.removeAll();
                    container.add(newPreparationOrderPanel);
                    container.validate();
                    frame.setVisible(true);

                    ((AllPreparationOrdersModel) table.getModel()).fireTableDataChanged();
                }
            }
        });

        buttonsPanel.setLayout(new BorderLayout());
        buttonsPanel.add(buttonDelete, BorderLayout.EAST);
        buttonsPanel.add(buttonModify, BorderLayout.WEST);

        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
}
