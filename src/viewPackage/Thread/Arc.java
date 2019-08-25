package viewPackage.Thread;

import javax.swing.*;
import java.awt.*;

public class Arc {
    private int x = 200;
    private int y = 300;
    private int startAngle=45;
    private int endAngle=135;
    private int deltaX = 1;
    private int deltaY = 1;
    private int deltaAngle = 1;
    private JPanel panel;
    private int r = 60;

    public Arc(JPanel panel){
        this.panel = panel;

    }

    public void move(){
        int panelWidth = panel.getWidth();
        int panelHeight = panel.getHeight();

        startAngle += deltaAngle;
        endAngle += deltaAngle;
        if(startAngle <= 0 || startAngle >= 270){
            deltaAngle*=-1;
        }
        if(x <= 0|| x >= panelWidth - 2*r){
            deltaX*=-1;
        }
        if(y <= 0 || y >= panelHeight - 2*r){
            deltaY*=-1;
        }
        y+=deltaY;
        x+=deltaX;
    }

    public void draw(Graphics g){
        g.drawArc(x,y, 2*r, 2*r, startAngle, endAngle);
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public void setEndAngle(int endAngle) {
        this.endAngle = endAngle;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public void setdeltaAngle(int deltaAngle) {
        this.deltaAngle = deltaAngle;
    }
}
