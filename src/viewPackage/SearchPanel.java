package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.PreparationOrder;
import modelPackage.ResearchResult;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class SearchPanel extends JPanel {
    private ApplicationController applicationController;


    private JLabel labelFirstDate, labelSecondDate;
    private JSpinner spinnerFirstDate, spinnerSecondDate;
    private SpinnerDateModel spinnerModelFirstDate;
    private SpinnerDateModel spinnerModelSecondDate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private JPanel datePanel;
    private JPanel mainPanel;
    private JButton buttonConfirm;
    private ArrayList<ResearchResult> researchData;
    private String [] header = {"Date production", "Label recette", "Label ingrédient", "Quantité"};
    private ResearchModel model;
    private ListSelectionModel listSelectionModel;
    private JTable jtable;
    private JScrollPane scrollPane;

    public SearchPanel(ApplicationController applicationController){
        this.applicationController = applicationController;
        this.setLayout(new BorderLayout());

        mainPanel = new JPanel();

        jtable = new JTable();
        jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtable.setVisible(false);



        //jtable.setSelectionMode(listSelectionModel.SINGLE_SELECTION);
        //listSelectionModel = table.getSelectionModel

        this.datePanel = new JPanel();
        datePanel.setLayout(new GridBagLayout());
        //JLabel
        this.labelFirstDate = new JLabel("Date 1 : ");
        this.labelSecondDate = new JLabel("Date 2 : ");
        //JSpinner
        spinnerModelFirstDate = new SpinnerDateModel();
        spinnerModelSecondDate = new SpinnerDateModel();

        spinnerFirstDate = new JSpinner(spinnerModelFirstDate);
        spinnerFirstDate.setEditor(new JSpinner.DateEditor(spinnerFirstDate, simpleDateFormat.toPattern()));

        spinnerSecondDate = new JSpinner(spinnerModelSecondDate);
        spinnerSecondDate.setEditor(new JSpinner.DateEditor(spinnerSecondDate, simpleDateFormat.toPattern()));
        //JButton
        this.buttonConfirm = new JButton("Rechercher");
        buttonConfirm.addActionListener(new ButtonConfirmListener());
        //GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2,2,2,2);
        //First row
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        datePanel.add(labelFirstDate, gbc);
        gbc.gridx++;
        datePanel.add(spinnerFirstDate, gbc);
        gbc.gridx++;
        datePanel.add(labelSecondDate, gbc);
        gbc.gridx++;
        datePanel.add(spinnerSecondDate, gbc);
        gbc.gridy++;
        /*datePanel.add(spinnerSecondDate, gbc);
        datePanel.add(labelFirstDate);
        datePanel.add(spinnerFirstDate);
        datePanel.add(labelSecondDate);
        datePanel.add(spinnerSecondDate);*/
        this.add(datePanel, BorderLayout.NORTH);
        this.add(buttonConfirm, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);
        //Display table
    }

    private class ButtonConfirmListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                GregorianCalendar productionDate1 = new GregorianCalendar();
                GregorianCalendar productionDate2 = new GregorianCalendar();

                java.util.Date firstDate = (java.util.Date) spinnerFirstDate.getValue();
                java.util.Date secondDate = (java.util.Date) spinnerSecondDate.getValue();

                productionDate1.setTime(firstDate);
                productionDate2.setTime(secondDate);

                researchData = applicationController.getResearchPreparationOrders(productionDate1, productionDate2);

                model = new ResearchModel(researchData);
                jtable.setModel(model);
                jtable.setVisible(true);

                scrollPane = new JScrollPane(jtable);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                mainPanel.add(scrollPane);
                scrollPane.setVisible(true);
                mainPanel.revalidate();

            } catch (Exception ex){
                    System.out.println(ex.getMessage());
            }
        }
    }
}
