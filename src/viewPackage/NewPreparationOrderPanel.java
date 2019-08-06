package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.Cook;
import modelPackage.PreparationOrder;
import modelPackage.Recipe;
import modelPackage.RecipeStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class NewPreparationOrderPanel extends JPanel {
    private ApplicationController applicationController;

    //Recipe
    private JLabel labelRecipe, labelPrepTime, labelRecipeSteps, labelNbPeople, labelValueNbPeople, labelValuePrepTime;
    private JComboBox comboBoxRecipe;
    private JTextArea areaRecipeSteps;
    private ArrayList<String> allRecipesLabel;

    //PreparationOrder
    private JLabel labelNbPortions, labelPrice, labelCook, labelProdDate, labelExpiryDate, labelSaleDate, labelChiefComm, labelCookComm;
    private JComboBox<String> comboBoxCook;
    private JTextField fieldNbPortions, fieldPrice;
    private JTextArea areaChiefComm, areaCookComm;
    private JSpinner spinnerProdDate, spinnerExpiryDate, spinnerSaleDate;
    private JCheckBox checkIsUrgent;
    private SpinnerDateModel spinnerModelProduction;
    private SpinnerDateModel spinnerModelExpiry;
    private SpinnerDateModel spinnerModelSale;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ArrayList<String> allCooks;

    private PreparationOrder preparationOrder;
    private String recipe;
    private Integer nbPortions;
    private double pricePortion;
    private Cook cook;
    private GregorianCalendar productionDate, expiryDate, saleDate;
    private boolean isUrgent;
    private String cookComm, chiefComm;
    private JButton buttonConfirm;


    //SplitPane
    private JPanel recipePanel;
    private JPanel orderPreparationPanel;
    private JSplitPane splitPane;

    public NewPreparationOrderPanel(ApplicationController applicationController) {
        recipePanel = new JPanel();
        orderPreparationPanel = new JPanel();
        this.applicationController = applicationController;

        allCooks = applicationController.getAllCooks();
        //Label
        labelNbPortions = new JLabel("Nombre de portions : ");
        labelPrice = new JLabel("Prix/portions : ");
        labelProdDate = new JLabel("Date de production : ");
        labelExpiryDate = new JLabel("Date de péremption : ");
        labelSaleDate = new JLabel("Date de vente : ");
        labelCook = new JLabel("Cuisinier : ");
        labelChiefComm = new JLabel("Commentaire chef cuisinier : ");
        labelCookComm = new JLabel("Commentaire cuisinier ");
        //TextField
        Dimension fieldDimension = new Dimension(65, 18);
        fieldNbPortions = new JTextField();
        fieldNbPortions.setPreferredSize(fieldDimension);
        fieldPrice = new JTextField();
        fieldPrice.setPreferredSize(fieldDimension);
        //JSpinner
        spinnerModelProduction = new SpinnerDateModel();
        spinnerModelExpiry = new SpinnerDateModel();
        spinnerModelSale = new SpinnerDateModel();
        spinnerExpiryDate = new JSpinner(spinnerModelExpiry);
        spinnerExpiryDate.setEditor(new JSpinner.DateEditor(spinnerExpiryDate, simpleDateFormat.toPattern()));
        spinnerProdDate = new JSpinner(spinnerModelProduction);
        spinnerProdDate.setEditor(new JSpinner.DateEditor(spinnerProdDate, simpleDateFormat.toPattern()));
        spinnerSaleDate = new JSpinner(spinnerModelSale);
        spinnerSaleDate.setEditor(new JSpinner.DateEditor(spinnerSaleDate, simpleDateFormat.toPattern()));
        //CheckBox
        checkIsUrgent = new JCheckBox("Urgent");
        //ComboBox
        comboBoxCook = new JComboBox<>();
        for (String cook : allCooks) {
            comboBoxCook.addItem(cook);
        }
        //TextArea
        areaChiefComm = new JTextArea();
        areaCookComm = new JTextArea();
        //Button
        buttonConfirm = new JButton("Confirmer");
        buttonConfirm.addActionListener(new ButtonConfirmListener());
        //GridBagLayout
        orderPreparationPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        //First row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        orderPreparationPanel.add(labelNbPortions, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(fieldNbPortions, gbc);
        gbc.ipadx = 30;
        gbc.gridx++;
        orderPreparationPanel.add(labelProdDate, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(spinnerProdDate, gbc);
        //Second row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        orderPreparationPanel.add(labelPrice, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(fieldPrice, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(labelExpiryDate, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(spinnerExpiryDate, gbc);
        //Third row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy++;
        orderPreparationPanel.add(labelSaleDate, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(spinnerSaleDate, gbc);
        //Fourth row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        orderPreparationPanel.add(labelCook, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(comboBoxCook, gbc);
        gbc.gridx++;
        orderPreparationPanel.add(checkIsUrgent, gbc);
        //Fifth row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        orderPreparationPanel.add(labelChiefComm, gbc);
        gbc.gridx = 3;
        orderPreparationPanel.add(labelCookComm, gbc);
        //Sixth row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy++;
        orderPreparationPanel.add(areaCookComm, gbc);
        gbc.gridx = 3;
        gbc.gridwidth = 2;
        orderPreparationPanel.add(areaChiefComm, gbc);
        gbc.gridwidth = 1;
        gbc.gridy++;
        orderPreparationPanel.add(buttonConfirm, gbc);
        //REGION RECIPEPANEL



        allRecipesLabel = applicationController.getAllRecipesLabels();
        //TextArea
        areaRecipeSteps = new JTextArea();
        areaRecipeSteps.setLineWrap(true);
        areaRecipeSteps.setWrapStyleWord(true);
        //Label
        labelRecipe = new JLabel("Recette : ");
        labelPrepTime = new JLabel("Temps de préparation (minutes) : ");
        labelRecipeSteps = new JLabel("Description recette : ");
        labelNbPeople = new JLabel("Nombre de personnes : ");
        labelValueNbPeople = new JLabel("");
        labelValuePrepTime = new JLabel("");
        //ComboBox
        comboBoxRecipe = new JComboBox<String>();
        for(String recipe : allRecipesLabel){
            comboBoxRecipe.addItem(recipe);
        }
        comboBoxRecipe.addItemListener(new NewPreparationOrderPanel.ItemChangeListener());
        //GridBagLayout
        recipePanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        recipePanel.add(labelRecipe, gbc);
        //Recipe

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx=1;
        recipePanel.add(comboBoxRecipe, gbc);
        //PrepTime

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        recipePanel.add(labelPrepTime, gbc);
        gbc.gridx++;
        recipePanel.add(labelValuePrepTime, gbc);

        //DescriptionRecipe
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx=0;
        gbc.gridy++;
        recipePanel.add(labelRecipeSteps, gbc);
        gbc.gridx = 3;
        recipePanel.add(labelNbPeople, gbc);
        gbc.gridx++;
        recipePanel.add(labelValueNbPeople, gbc);

        //TextArea
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 3;
        gbc.weightx = 0.5;
        recipePanel.add(areaRecipeSteps, gbc);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, recipePanel, orderPreparationPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(250);

        this.setLayout(new BorderLayout());
        this.add(splitPane, BorderLayout.CENTER);
    }

    private class ButtonConfirmListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                String recipe = String.valueOf(comboBoxRecipe.getSelectedItem());
                String chiefComm = areaChiefComm.getText();
                String cookComm = areaCookComm.getText();
                Integer prepTime = Integer.parseInt(labelValuePrepTime.getText());
                Integer nbPeople = Integer.parseInt(labelValueNbPeople.getText());
                Integer nbPortions = Integer.parseInt(fieldNbPortions.getText());
                Double pricePortion = Double.parseDouble(fieldPrice.getText());
                String cook = String.valueOf(comboBoxCook.getSelectedItem());
                //Boolean isUrgent = Boolean.valueOf(checkIsUrgent.get)
                //Date
                GregorianCalendar productionCalendar = new GregorianCalendar();
                GregorianCalendar expiryCalendar = new GregorianCalendar();
                GregorianCalendar saleCalendar = new GregorianCalendar();

                java.util.Date prodDateSpinner = (java.util.Date) spinnerProdDate.getValue();
                java.util.Date saleDateSpinner = (java.util.Date) spinnerSaleDate.getValue();
                java.util.Date expiryDateSpinner = (java.util.Date) spinnerExpiryDate.getValue();

                productionCalendar.setTime(prodDateSpinner);
                expiryCalendar.setTime(expiryDateSpinner);
                saleCalendar.setTime(saleDateSpinner);

                String[] splitFullName = cook.split("\\s+", -2);

                PreparationOrder preparationOrder = new PreparationOrder();
                preparationOrder.setLabelRecipe(recipe);
                preparationOrder.setNumberPortions(nbPortions);
                preparationOrder.setPricePortion(pricePortion);
                preparationOrder.setCookIdNumber(applicationController.getCookId(splitFullName[0], splitFullName[1]));
                preparationOrder.setProductionDate(productionCalendar);
                preparationOrder.setExpiryDate(expiryCalendar);
                preparationOrder.setSaleDate(saleCalendar);
                preparationOrder.setCookCommentary(cookComm);
                preparationOrder.setChiefCommentary(chiefComm);

                applicationController.addPreparationOrder(preparationOrder);
            } catch(Exception e1){
                System.out.println(e1.getMessage());
            }
        }
    }

    private class ItemChangeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                Object item = event.getItem();

                ArrayList<RecipeStep> recipeSteps;
                Recipe recipe;

                System.out.println("Changement détecté");

                areaRecipeSteps.setText(null);

                recipe = applicationController.getRecipe(item.toString());

                labelValueNbPeople.setText(Integer.toString(recipe.getNbPeople()));
                labelValuePrepTime.setText(Integer.toString(recipe.getPreparationTime()));

                recipeSteps = applicationController.getRecipeSteps(item.toString());

                for(RecipeStep step : recipeSteps){
                    areaRecipeSteps.append(step.toString());
                }
            }
        }
    }
}
//TODO Un cuisinier ne peut avoir qu'un ordre par jour. ==> combinaison de la date de production et du matricule unique