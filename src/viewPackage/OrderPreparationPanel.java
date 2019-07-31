package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.Cook;
import modelPackage.PreparationOrder;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrderPreparationPanel extends JPanel {
    private ApplicationController applicationController;
    private JLabel  labelNbPortions, labelPrice, labelCook, labelProdDate, labelExpiryDate, labelSaleDate, labelChiefComm, labelCookComm;
    private JComboBox<String>  comboBoxCook;
    private JTextField fieldNbPortions, fieldPrice;
    private JTextArea areaChiefComm, areaCookComm;
    private JSpinner spinnerProdDate, spinnerExpiryDate, spinnerSaleDate;
    private JCheckBox checkIsUrgent;
    private JButton buttonConfirm;
    private SpinnerDateModel modelSpinnerDate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ArrayList<String> allCooks;

    private PreparationOrder preparationOrder;
    private String recipe;
    private Integer preparationTime;
    private Integer nbPortions;
    private double pricePortion;
    private Cook cook;
    private GregorianCalendar productionDate, expiryDate, saleDate;
    private boolean isUrgent;
    private String cookComm, chiefComm;


    public OrderPreparationPanel (ApplicationController applicationController){
        this.applicationController = applicationController;
        this.allCooks = applicationController.getAllCooks();
        //Label
        labelNbPortions = new JLabel("Nombre de portions : ");
        labelPrice = new JLabel("Prix/portions : ");
        labelProdDate = new JLabel("Date de production : ");
        labelExpiryDate = new JLabel ("Date de péremption : ");
        labelSaleDate = new JLabel ("Date de vente : ");
        labelCook = new JLabel("Cuisinier : ");
        labelChiefComm = new JLabel("Commentaire chef cuisinier : ");
        labelCookComm = new JLabel("Commentaire cuisinier ");
        //TextField
        Dimension fieldDimension = new Dimension(65,18);
        fieldNbPortions = new JTextField();
        fieldNbPortions.setPreferredSize(fieldDimension);
        fieldPrice = new JTextField();
        fieldPrice.setPreferredSize(fieldDimension);
        //JSpinner
        modelSpinnerDate = new SpinnerDateModel();
        spinnerExpiryDate = new JSpinner(modelSpinnerDate);
        spinnerExpiryDate.setEditor(new JSpinner.DateEditor(spinnerExpiryDate, simpleDateFormat.toPattern()));
        spinnerProdDate = new JSpinner(modelSpinnerDate);
        spinnerProdDate.setEditor(new JSpinner.DateEditor(spinnerProdDate, simpleDateFormat.toPattern()));
        spinnerSaleDate = new JSpinner(modelSpinnerDate);
        spinnerSaleDate.setEditor(new JSpinner.DateEditor(spinnerSaleDate, simpleDateFormat.toPattern()));
        //CheckBox
        checkIsUrgent = new JCheckBox("Urgent");
        //ComboBox
        comboBoxCook = new JComboBox<>();
        for(String cook : allCooks){
            comboBoxCook.addItem(cook);
        }
        //TextArea
        areaChiefComm = new JTextArea();
        areaCookComm = new JTextArea();
        //Button
        buttonConfirm = new JButton("Confirmer");

        //GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);


        //First row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(labelNbPortions, gbc);
        gbc.gridx++;
        this.add(fieldNbPortions, gbc);
        gbc.ipadx = 30;
        gbc.gridx++;
        this.add(labelProdDate, gbc);
        gbc.gridx++;
        this.add(spinnerProdDate, gbc);
        //Second row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy++;
        this.add(labelPrice, gbc);
        gbc.gridx++;
        this.add(fieldPrice, gbc);
        gbc.gridx++;
        this.add(labelExpiryDate, gbc);
        gbc.gridx++;
        this.add(spinnerExpiryDate, gbc);
        //Third row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=2;
        gbc.gridy++;
        this.add(labelSaleDate, gbc);
        gbc.gridx++;
        this.add(spinnerSaleDate, gbc);
        //Fourth row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy++;
        this.add(labelCook, gbc);
        gbc.gridx++;
        this.add(comboBoxCook, gbc);
        gbc.gridx++;
        this.add(checkIsUrgent, gbc);
        //Fifth row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridy++;
        this.add(labelChiefComm, gbc);
        gbc.gridx = 3;
        this.add(labelCookComm, gbc);
        //Sixth row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx=0;
        gbc.gridwidth = 2;
        gbc.gridy++;
        this.add(areaCookComm, gbc);
        gbc.gridx = 3;
        gbc.gridwidth = 2;
        this.add(areaChiefComm, gbc);


        gbc.gridx=4;
        gbc.gridy++;
        this.add(buttonConfirm, gbc);

        this.setVisible(true);

    }

}
