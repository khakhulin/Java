import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game {
    private final View view;
    int[][] Matrix = new int[400][400];
    int k = 0;
    Snake snake;
    Food food;
    public static Game game;

    public Game(View view) {
        this.view = view;
    }

    public void start() {

        snake = new Snake(7,7);
        view.createFood();
        Matrix = updateMatrix();
        view.updateMainPanel(Matrix);
        while(snake.AliveStatus()){
            if(view.hasEvents()){
                KeyEvent event = view.getEvent();
                if (event.getKeyChar() == 'q') {
                    System.out.println("exit");
                    System.exit(0);
                }
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(DirectionSnake.LEFT);

                if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(DirectionSnake.RIGHT);

                if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(DirectionSnake.UP);

                if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(DirectionSnake.DOWN);
                //processPressedKey();
            }

            processPressedKey();
            pause();
        }

        System.out.println("Game over");
        view.GameOver();
    }

    public Food getFood(){
        return food;
    }

    public void processPressedKey() {
        //TODO
        snake.move();
        view.updateMainPanel(updateMatrix());
    }
    private int[][] updateMatrix(){
        int[][] matrix = new int[400][400];
        //Color[] colors = {Color.blue, Color.red};
        ArrayList<Body> SnakeBody = new ArrayList<Body>(snake.getSnakeBody());
        for(Body oneSection: SnakeBody){
            matrix[oneSection.getY()][oneSection.getX()] = 1;
        }

        System.out.println("size::" + SnakeBody.size());
        System.out.println(food.getX());
        matrix[food.getY()][food.getX()] = 4;
       // matrix[10][10] = 100;
        return matrix;
    }
    private static int[] delayList = {1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 50};

    public void pause(){
        try{
            int level = snake.getSnakeBody().size();
            int delay = level < delayList.length ? delayList[level] - 50 : 50;
            Thread.sleep(delay);
        }
        catch (InterruptedException ex){

        }
    }
    public void eatFood(){
        view.createFood();
    }

}
