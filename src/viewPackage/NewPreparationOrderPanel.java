package viewPackage;

import controllerPackage.*;
import modelPackage.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class NewPreparationOrderPanel extends JPanel {
    private RecipePanel recipePanel;
    private OrderPreparationPanel orderPreparationPanel;
    private JSplitPane splitPane;

    public NewPreparationOrderPanel(ApplicationController applicationController){
        recipePanel = new RecipePanel(applicationController);
        orderPreparationPanel = new OrderPreparationPanel(applicationController);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, recipePanel, orderPreparationPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(250);

        this.setLayout(new BorderLayout());
        this.add(splitPane, BorderLayout.CENTER);
    }
}
