//package src;

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

    Snake snake = new Snake(x, y);

    Node Snake2 = new Node(600, 300);

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
        snake.draw(g);
        Snake2.draw(g);
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

        @Override
        public void keyPressed(KeyEvent e) {
            snake.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) { snake.keyRelease(e); }
    }
}
