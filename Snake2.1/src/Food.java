import java.awt.*;
import java.util.Random;

public class Food {

    Random randomX = new Random(13);
    Random randomY = new Random(7);

    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    private Node food;

    public Food(int x, int y){
        food = new Node(x, y, false);
    }

    public void draw(Graphics g){
        food.draw(g);
    }

    public Rectangle getRect(){
        return food.getRect();
    }

    public boolean eat(Snake s){
        if(this.getRect().intersects(s.getRect())){
            food.x = randomX.nextInt(40) * WIDTH;
            food.y = randomY.nextInt(40) * HEIGHT;
            return true;
        }
        return false;
    }
}
