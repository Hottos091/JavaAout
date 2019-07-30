/*package viewPackage;

import controllerPackage.*;
import modelPackage.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class NewPreparationOrderPanel extends JPanel {
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



    private JPanel recipePanel, preparationOrderPanel;
    private JSplitPane splitPane;



    public NewPreparationOrderPanel(ApplicationController applicationController){
        recipePanel = new JPanel();
        preparationOrderPanel = new JPanel();

        this.applicationController = applicationController;
        this.allCooks = applicationController.getAllCooks();

        //JLabel

        labelNbPortions = new JLabel("Nombre de portions");
        labelPrice = new JLabel("Prix/portions");
        labelCook = new JLabel("Cuisinier : ");
        labelProdDate = new JLabel("Date de production : ");
        labelExpiryDate = new JLabel("Date de péremption : ");
        labelSaleDate = new JLabel("Date de vente : ");
        labelChiefComm = new JLabel("Commentaire chef cuisinier : ");
        labelCookComm = new JLabel("Commentaire cuisinier : ");
        //ComboBox

        for(String cook: allCooks){
            comboBoxRecipe.addItem(cook);
        }

    }









}
*/