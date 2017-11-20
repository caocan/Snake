import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Node {

    int x , y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 20,20);
        g.setColor(c);
    }


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
