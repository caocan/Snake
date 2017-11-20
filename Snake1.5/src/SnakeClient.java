import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeClient extends Frame {

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 800;
    public static final int SLEEP_TIME = 200;

    int x = 600, y = 600;

    //虚拟的图片
    Image offScreenImage = null;

    //解决闪烁的问题
    public void update(Graphics g){
        //创建虚拟图片
        if(offScreenImage == null)
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);

        //拿到画笔
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }


    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.blue);

        g.fillRect(x, y, 20, 20);
        g.setColor(c);
    }

    public void lauchFrame(){
        this.setLocation(400, 300);
        this.setSize(GAME_WIDTH, GAME_HEIGHT);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.setResizable(false);
        this.setBackground(Color.BLACK);

        //创建用于监听键盘事件的监听器
        this.addKeyListener(new KeyMonitor());

        this.setVisible(true);

        new Thread(new PaintThread()).start();
    }

    public static void main(String[] args) {
        SnakeClient sc = new SnakeClient();
        sc.lauchFrame();
    }



    //绘画线程，使一个模块动起来
    private class PaintThread implements Runnable{

        @Override
        public void run() {
            while(true){
                repaint();
                try{
                    Thread.sleep(SLEEP_TIME);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //创建键盘监听事件，使得方块可以被键盘控制
    private class KeyMonitor extends KeyAdapter{

        //使得方块可以在四个方向上移动
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            switch(key){
                case KeyEvent.VK_LEFT: x -= 20; break;
                case KeyEvent.VK_RIGHT: x += 20; break;
                case KeyEvent.VK_UP: y -= 20; break;
                case KeyEvent.VK_DOWN: y+= 20; break;
            }
        }
    }
}
