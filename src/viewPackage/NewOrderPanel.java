package viewPackage;

import controllerPackage.ApplicationController;
import dataAccessPackage.SingletonConnection;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
public class NewOrderPanel extends JPanel {
    private ApplicationController applicationController;
    private ArrayList<Ingredient> allIngredients;
    private ArrayList<String> allSuppliers;
    private JComboBox<String> comboBoxIngredients, comboBoxSuppliers;
    private JButton buttonShowList, buttonAddToList, buttonConfirm;
    private JLabel labelIngredient, labelQuantity;
    private JTextField fieldQuantity;

    private Order order;
    private ArrayList<OrderLine> orderLines;

    public NewOrderPanel(ApplicationController applicationController){
        this.applicationController = applicationController;
        orderLines = new ArrayList<>();
        //JLabels
        labelIngredient = new JLabel("Ingrédient : ");
        labelQuantity = new JLabel("Quantity : ");
        //Buttons
        buttonShowList = new JButton("Voir liste");
        buttonAddToList = new JButton("Ajouter à la liste");
        buttonAddToList.addActionListener(new ButtonAddToListListener());
        buttonConfirm = new JButton("Confirmer commande");
        buttonConfirm.addActionListener(new ButtonConfirmListener());
        //Field
        fieldQuantity = new JTextField();
        //JComboBox Lists
        allIngredients = applicationController.getAllIngredients();

        allSuppliers = applicationController.getAllSuppliers();


        //JComboBox
        comboBoxSuppliers = new JComboBox<String>();
        for(String supplier : allSuppliers){
            comboBoxSuppliers.addItem(supplier);
        }

        comboBoxIngredients = new JComboBox<String>();
        for(Ingredient ingredient : allIngredients) {
            comboBoxIngredients.addItem(ingredient.getLabel());
        }
        //GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2,2,2,2);

        //Ingredient
        this.add(labelIngredient, gbc);
        gbc.gridx++;
        this.add(comboBoxIngredients);

        //Quantity
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        this.add(labelQuantity, gbc);
        gbc.gridx++;
        this.add(fieldQuantity, gbc);
        //Supplier
        gbc.gridy++;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        this.add(comboBoxSuppliers, gbc);
        //Buttons
        gbc.gridx=0;
        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        this.add(buttonShowList, gbc);
        gbc.gridx = 2;
        this.add(buttonAddToList, gbc);

        gbc.gridx++;
        gbc.gridy++;
        this.add(buttonConfirm, gbc);
    }


    private class ButtonAddToListListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                Integer quantity = Integer.parseInt(fieldQuantity.getText());
                String label = String.valueOf(comboBoxIngredients.getSelectedItem());

                //Le code situé ci-dessous ne sera pas lu si l'exception est levée
                //OrderLine
                OrderLine newOrderLine = new OrderLine();
                newOrderLine.setQuantity(quantity);
                newOrderLine.setIngredientLabel(label);

                orderLines.add(newOrderLine);

            } catch(NumberFormatException n){
                System.out.println("Veuillez entrer un nombre dans le champ \"Quantité\"");
            }
        }

    }

    private class ButtonConfirmListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String supplierFullName = String.valueOf(comboBoxSuppliers.getSelectedItem());

            String[] splitFullName = supplierFullName.split("\\s+", -2);

            String supplierId = applicationController.getIdSupplier(splitFullName[0], splitFullName[1]);


            applicationController.addOrder(supplierId);
            applicationController.addOrderLines(orderLines);


        }
    }
}
