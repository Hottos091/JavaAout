package viewPackage;

import controllerPackage.ApplicationController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu preparationOrderMenu, searchMenu, helpMenu, orderMenu;
    private JMenuItem exit, newPreparationOrder, deleteOrder, modifyOrder, listingOrder, firstSearch, secondSearch, thirdSearch, help, newOrder;
    private Container container;
    private AllPreparationOrdersPanel allPreparationOrdersPanel;
    //private RecipePanel recipePanel;
    //private OrderPreparationPanel orderPreparationPanel;
    private NewOrderPanel newOrderPanel;
    private NewPreparationOrderPanel newPreparationOrderPanel;
    private ApplicationController applicationController;

    public MainJFrame(){
        //Appel au constructeur de la classe JFrame (prend un titre en argument)
        super ("Grand Bazar - Service Traiteur");
        //Définition de la taille et position de la fenêtre
        this.setBounds(100,100, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationController = new ApplicationController();
        container = getContentPane();

        //Création (instanciation) de la JMenuBar + ajout à la fenêtre
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        //Instanciations des JMenus
        preparationOrderMenu = new JMenu("Ordre préparation");
        menuBar.add(preparationOrderMenu);

        searchMenu = new JMenu("Recherches");
        menuBar.add(searchMenu);

        helpMenu = new JMenu("Infos");
        menuBar.add(helpMenu);

        orderMenu = new JMenu("Commande");
        menuBar.add(orderMenu);

        //Instanciations des JMenuItems
        //Ordre de préparation
        newPreparationOrder = new JMenuItem("Nouveau");
        preparationOrderMenu.add(newPreparationOrder);
        newPreparationOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                container.removeAll();
                newPreparationOrderPanel = new NewPreparationOrderPanel(applicationController);
                container.add(newPreparationOrderPanel);
            }
        });

        modifyOrder = new JMenuItem("Modifier");
        preparationOrderMenu.add(modifyOrder);

        deleteOrder = new JMenuItem("Supprimer");
        preparationOrderMenu.add(deleteOrder);
        preparationOrderMenu.addSeparator();

        listingOrder = new JMenuItem("Listing");
        preparationOrderMenu.add(listingOrder);
        listingOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                container.removeAll();
                allPreparationOrdersPanel = new AllPreparationOrdersPanel(applicationController);
                container.add(allPreparationOrdersPanel);
            }
        });

        //Recherches
        firstSearch = new JMenuItem("Premiere recherche");
        searchMenu.add(firstSearch);

        secondSearch = new JMenuItem("Deuxième recherche");
        searchMenu.add(secondSearch);

        thirdSearch = new JMenuItem("Troisieme recherche");
        searchMenu.add(thirdSearch);

        //aide
        help = new JMenuItem("Aide");
        helpMenu.add(help);
        helpMenu.addSeparator();

        exit = new JMenuItem("Quitter");
        exit.addActionListener(new ExitListener());
        helpMenu.add(exit);

        //Commande
        newOrder = new JMenuItem("Nouvelle commande");
        orderMenu.add(newOrder);
        newOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                newOrderPanel = new NewOrderPanel(applicationController);
                container.add(newOrderPanel);
                container.validate();
            }
        });

        this.setVisible(true);
    }
    private class ExitListener implements ActionListener  {
        public void actionPerformed(ActionEvent event) {
            try {
                applicationController.closeConnection();

            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.exit(0);
        }
    }
}
