package viewPackage.Thread;


import javax.swing.*;
import java.awt.*;

public class ArcPanel extends JPanel {

    private Arc arc = new Arc(this);

    ThreadMovement thread;
    public ArcPanel(){
        thread = new ThreadMovement(this);
        thread.start();
    }
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       arc.draw(g);
   }

   public Arc getArc(){
        return this.arc;
   }

}
