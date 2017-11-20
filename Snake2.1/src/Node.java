import java.awt.*;
import java.awt.event.KeyEvent;

public class Node {
    public static final int XSPEED = 20;
    public static final int YSPEED = 20;

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    int x , y;

    private boolean bL = false;
    private boolean bU = false;
    private boolean bR = false;
    private boolean bD = false;

    private Direction dir = Direction.STOP;

    //判断是食物还是蛇
    boolean good;

    enum Direction{
        L, R, U, D, STOP
    }

    public Node(int x, int y, boolean good){
        this.x = x;
        this.y = y;
        this.good = good;
    }

    //可以传方向来构造节点
    public Node(int x, int y, boolean good, Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.good = good;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        if(good)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.YELLOW);
        g.fillRect(x, y, 20,20);
        g.setColor(c);

        move();
    }


    void move(){
        switch (dir){
            case L:
                x -= XSPEED;
                break;
            case U:
                y -= YSPEED;
                break;
            case R:
                x += XSPEED;
                break;
            case D:
                y += YSPEED;
                break;
            case STOP:
                break;
        }
    }

    //使得方块可以在四个方向上移动
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        switch(key){
            case KeyEvent.VK_LEFT: bL = true; break;
            case KeyEvent.VK_RIGHT: bR = true; break;
            case KeyEvent.VK_UP: bU = true; break;
            case KeyEvent.VK_DOWN: bD = true; break;
        }

        locateDirection();
    }

    //覆写按键释放的方法，解决bL等不能正常复位的bug
    public void keyRelease(KeyEvent e){
        int key = e.getKeyCode();

        switch (key){
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
        }
    }

    //设定方向
    private void locateDirection() {
        if(bL && !bU && !bR && !bD) dir = Direction.L;
        else if(!bL && bU && !bR && !bD) dir = Direction.U;
        else if(!bL && !bU && bR && !bD) dir = Direction.R;
        else if(!bL && !bU && !bR && bD) dir = Direction.D;
    }

    public Rectangle getRect(){
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

}
