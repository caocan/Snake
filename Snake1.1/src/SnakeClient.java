import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeClient extends Frame {

    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.blue);

        g.fillRect(600, 600, 20, 20);
        g.setColor(c);
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
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SnakeClient sc = new SnakeClient();
        sc.lauchFrame();
    }
}
