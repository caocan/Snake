import java.awt.*;
import java.awt.event.KeyEvent;

public class Node {
    public static final int XSPEED = 20;
    public static final int YSPEED = 20;

    int x , y;

    private boolean bL = false;
    private boolean bU = false;
    private boolean bR = false;
    private boolean bD = false;

    private Direction dir = Direction.STOP;

    enum Direction{
        L, R, U, D, STOP
    }

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    //可以传方向来构造节点
    public Node(int x, int y, Direction dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.BLUE);
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

    //设定方向
    private void locateDirection() {
        if(bL && !bU && !bR && !bD) dir = Direction.L;
        else if(!bL && bU && !bR && !bD) dir = Direction.U;
        else if(!bL && !bU && bR && !bD) dir = Direction.R;
        else if(!bL && !bU && !bR && bD) dir = Direction.D;
    }

}
