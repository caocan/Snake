import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeClient extends Frame {

    int x = 600, y = 600;


    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.blue);

        g.fillRect(x, y, 20, 20);
        g.setColor(c);

        y += 5;
    }

    public void lauchFrame(){
        this.setLocation(400, 300);
        this.setSize(800, 800);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setVisible(true);

        new Thread(new PaintThread()).start();
    }

    public static void main(String[] args) {
        SnakeClient sc = new SnakeClient();
        sc.lauchFrame();
    }

    private class PaintThread implements Runnable{

        @Override
        public void run() {
            while(true){
                repaint();
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
