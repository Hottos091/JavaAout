package viewPackage;

import controllerPackage.ApplicationController;
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
    private JComboBox<String> comboBoxIngredients;
    private JButton buttonShowList, buttonAddToList, buttonConfirm;
    private JLabel labelIngredient, labelQuantity;
    private JTextField fieldQuantity;

    private Order order;
    private ArrayList<OrderLine> orderLines;

    public NewOrderPanel(ApplicationController applicationController){
        this.applicationController = applicationController;
        //JLabels
        labelIngredient = new JLabel("Ingrédient : ");
        labelQuantity = new JLabel("Quantity : ");
        //Buttons
        buttonShowList = new JButton("Voir liste");
        buttonAddToList = new JButton("Ajouter à la liste");
        buttonAddToList.addActionListener(new ButtonAddToListListener());
        buttonConfirm = new JButton("Confirmer commande");
        //Field
        fieldQuantity = new JTextField();
        allIngredients = applicationController.getAllIngredients();



        //JComboBox
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
                OrderLine newOrderLine = new OrderLine();
                newOrderLine.setQuantity(quantity);
                newOrderLine.setIngredientLabel(label);

                //applicationController.addOrder();
            } catch(NumberFormatException n){
                System.out.println("Veuillez entrer un nombre dans le champ \"Quantité\"");
            }
        }

    }
}
