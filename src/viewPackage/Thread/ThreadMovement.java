package viewPackage.Thread;

public class ThreadMovement extends Thread{
    private ArcPanel arcPanel;

    public ThreadMovement(ArcPanel arcPanel){ this.arcPanel = arcPanel;}

    public void run(){
        Arc arc = arcPanel.getArc();
        while(true){
            arc.move();
            arcPanel.repaint();
            try{
                Thread.sleep(3);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
