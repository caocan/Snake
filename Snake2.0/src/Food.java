import java.awt.*;

public class Food {

    private Node food;

    public Food(int x, int y){
        food = new Node(x, y, false);
    }

    public void draw(Graphics g){
        food.draw(g);
    }

}
