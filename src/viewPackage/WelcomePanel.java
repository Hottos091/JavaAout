package viewPackage;

import javax.swing.*;

public class WelcomePanel extends JPanel {
    JTextArea welcomeMessage = new JTextArea();

    public WelcomePanel(){
        welcomeMessage.setText("Bienvenue dans le programme de gestion du service traiteur du Grand Bazar ! " +
                "Vous êtes invités à utiliser les différents menus afin d'effectuer les différentes opérations.\n" +
                "Détail de la recherche : entrez deux dates pour avoir la liste des ingrédients nécessaires pour chaque ordre de préparation devant être préparé entre les deux dates entrées");
        welcomeMessage.setEditable(false);
        this.add(welcomeMessage);
        this.setVisible(true);
    }
}
