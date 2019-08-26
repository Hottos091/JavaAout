package viewPackage;

import controllerPackage.ApplicationController;
import viewPackage.Thread.ArcPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainJFrame extends JFrame {
    private JMenuBar menuBar;
    private JMenu preparationOrderMenu, searchMenu, helpMenu, orderMenu;
    private JMenuItem exit, newPreparationOrder, modifyPreparationOrder, listingPreparationOrder, research, newOrder, home;
    private Container container;
    private AllPreparationOrdersPanel allPreparationOrdersPanel;
    private NewOrderPanel newOrderPanel;
    private NewPreparationOrderPanel newPreparationOrderPanel;
    private ModifyOrderPanel modifyOrderPanel;
    private ResearchPanel searchPanel;
    private ApplicationController applicationController;

    private WelcomePanel welcomePanel;
    private JPanel arcPanel;

    public MainJFrame(){
        //Appel au constructeur de la classe JFrame (prend un titre en argument)
        super ("Grand Bazar - Service Traiteur");
        //Définition de la taille et position de la fenêtre
        this.setBounds(100,100, 1024, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.welcomePanel = new WelcomePanel();
        this.add(welcomePanel, BorderLayout.NORTH);
        welcomePanel.setVisible(true);


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

        orderMenu = new JMenu("Commande");
        menuBar.add(orderMenu);

        helpMenu = new JMenu("?");
        menuBar.add(helpMenu);

        //Instanciations des JMenuItems
        //Ordre de préparation
        newPreparationOrder = new JMenuItem("Nouveau");
        preparationOrderMenu.add(newPreparationOrder);
        newPreparationOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                container.removeAll();
                newPreparationOrderPanel = new NewPreparationOrderPanel(applicationController);
                container.add(newPreparationOrderPanel);
                container.revalidate();
            }
        });
        //TODO un ecouteur auquel on passe le panneau à devoir affiche. Car les écouteurs font tous la même chose, seul le panneau change.
        modifyPreparationOrder = new JMenuItem("Modifier/Supprimer");
        modifyPreparationOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                container.removeAll();
                modifyOrderPanel = new ModifyOrderPanel(applicationController);
                container.add(modifyOrderPanel);
                container.revalidate();
            }
        });
        preparationOrderMenu.add(modifyPreparationOrder);

        listingPreparationOrder = new JMenuItem("Listing");
        preparationOrderMenu.add(listingPreparationOrder);
        listingPreparationOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                container.removeAll();
                allPreparationOrdersPanel = new AllPreparationOrdersPanel(applicationController);
                container.add(allPreparationOrdersPanel);
                container.revalidate();
            }
        });

        //Recherches
        research = new JMenuItem("Infos ingrédients");
        research.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                searchPanel = new ResearchPanel(applicationController);
                container.add(searchPanel);
                container.revalidate();
            }
        });
        searchMenu.add(research);

        //Help Menu
        home = new JMenuItem("Accueil");
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                container.removeAll();
                container.add(welcomePanel, BorderLayout.NORTH);
                container.add(arcPanel, BorderLayout.CENTER);
                container.repaint();
            }
        });
        helpMenu.add(home);
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
                container.revalidate();
            }
        });
        arcPanel = new ArcPanel();
        this.add(arcPanel, BorderLayout.CENTER);
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
