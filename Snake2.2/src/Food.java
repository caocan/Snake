import java.awt.*;
import java.util.Iterator;
import java.util.Random;

public class Food {

    Random randomX = new Random(13);
    Random randomY = new Random(7);

    int NextX;
    int NextY;

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

            RandomGenerate();

            food.x = NextX * WIDTH;
            food.y = NextY * HEIGHT;

            Iterator it = s.Body.iterator();
            while(it.hasNext()){
                Node current = (Node)it.next();
                if(current.x == food.x && current.y == food.y){
                    RandomGenerate();
                    food.x = NextX * WIDTH;
                    food.y = NextY * HEIGHT;
                    it = s.Body.iterator();
                }
            }

            return true;
        }
        return false;
    }

    private void RandomGenerate() {

        NextX = randomX.nextInt(39);
        while(NextX == 0){
            NextX = randomX.nextInt(39);
        }

        NextY = randomY.nextInt(39);
        while(NextY < 2){
            NextY = randomY.nextInt(39);
        }

    }
}
