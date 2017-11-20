import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeClient extends Frame {

    int x = 600, y = 600;

    //虚拟的图片
    Image offScreenImage = null;

    //解决闪烁的问题
    public void update(Graphics g){
        //创建虚拟图片
        if(offScreenImage == null)
            offScreenImage = this.createImage(800, 800);

        //拿到画笔
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0, 800, 800);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


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
                    Thread.sleep(350);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
