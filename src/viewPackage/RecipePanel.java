package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.Recipe;
import modelPackage.RecipeStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RecipePanel extends JPanel{
    private ApplicationController applicationController;
    private JLabel labelRecipe, labelPrepTime, labelRecipeSteps, labelNbPeople, nbPeople, prepTime;
    private JComboBox comboBoxRecipe;
    private JTextArea areaRecipeSteps;
    private ArrayList<String> allRecipesLabel;



    public RecipePanel(ApplicationController applicationController){

        this.applicationController = applicationController;
        this.allRecipesLabel = applicationController.getAllRecipesLabels();

        //TextArea
        this.areaRecipeSteps = new JTextArea();
        areaRecipeSteps.setLineWrap(true);
        areaRecipeSteps.setWrapStyleWord(true);


        //Label
        labelRecipe = new JLabel("Recette : ");
        labelPrepTime = new JLabel("Temps de préparation : ");
        labelRecipeSteps = new JLabel("Description recette : ");
        labelNbPeople = new JLabel("Nombre de personnes");
        nbPeople = new JLabel();
        prepTime = new JLabel();
        //ComboBox
        comboBoxRecipe = new JComboBox<String>();
        for(String recipe : allRecipesLabel){
            comboBoxRecipe.addItem(recipe);
        }
        comboBoxRecipe.addItemListener(new ItemChangeListener());
        //GridBagLayout
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(labelRecipe, gbc);

        //Recipe
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx=1;
        this.add(comboBoxRecipe, gbc);


        //TextArea
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        this.add(areaRecipeSteps, gbc);
        this.setVisible(true);
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

                nbPeople.setText(Integer.toString(recipe.getNbPeople()));
                prepTime.setText(Integer.toString(recipe.getPreparationTime()));

                recipeSteps = applicationController.getRecipeSteps(item.toString());

                for(RecipeStep step : recipeSteps){
                    areaRecipeSteps.append(step.toString());
                }

                JOptionPane.showMessageDialog(null, "Area mise à jour");
            }
        }
    }

}
