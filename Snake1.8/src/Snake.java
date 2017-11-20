//package src;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Snake {
    List<Node> Body = new ArrayList<>();

    Snake(int x, int y){
        Node node = new Node(x, y);
        Body.add(node);
    }

    public void draw(Graphics g){
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

}
