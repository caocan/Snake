import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    List<Node> Body = new ArrayList<>();

    Snake(int x, int y){
        Node node = new Node(x, y, true);
        Body.add(node);
    }

    public void draw(Graphics g){

        Color c = g.getColor();
        g.setColor(Color.ORANGE);
        g.drawString("x = " + Body.get(0).x, 10, 70);
        g.drawString("y = " + Body.get(0).y, 10, 90);
        g.setColor(c);

        Iterator it = Body.iterator();
        while(it.hasNext()){
            Node CurrentNode = (Node)it.next();
            CurrentNode.draw(g);
        }
    }

    public void keyPressed(KeyEvent e){
        Node Head = Body.get(0);
        Head.keyPressed(e);
    }

    public void keyRelease(KeyEvent e) {
        Node Head = Body.get(0);
        Head.keyRelease(e);
    }

    public Rectangle getRect(){
        return new Rectangle(Body.get(0).x, Body.get(0).y, WIDTH, HEIGHT);
    }

}
