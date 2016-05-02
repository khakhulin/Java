import java.util.ArrayList;

/**
 * Created by tar on 02.05.16.
 */
public class Snake {
    private DirectionSnake direction;

    private ArrayList<Body> SnakeBody;

    //Game game;

    private boolean isAlive;

    public Snake(int x, int y) {
        SnakeBody = new ArrayList<Body>();
        SnakeBody.add(new Body(x,y));
        isAlive = true;
    }

    public boolean AliveStatus(){
        return isAlive;
    }

    public DirectionSnake getDirection(){
        return direction;
    }

    public void setDirection(DirectionSnake direction){
        this.direction = direction;
    }

    public ArrayList<Body> getSnakeBody(){
        return SnakeBody;
    }

    //head of snake
    public int getX(){
        return SnakeBody.get(0).getX();
    }

    public int getY(){
        return  SnakeBody.get(0).getY();
    }

    public void move(){
        if (!AliveStatus())
            return;
        if (direction == DirectionSnake.DOWN)
            move(0, 1);
        if (direction == DirectionSnake.UP)
            move(0,-1);
        if (direction ==  DirectionSnake.LEFT)
            move(-1,0);
        if (direction == DirectionSnake.RIGHT)
            move(1,0);
    }

    public void move(int n_x, int n_y) {
        Body head  = SnakeBody.get(0);
        head = new Body(head.getX() + n_x, head.getY() + n_y);

        checkHead(head);
        if (!AliveStatus())
            return;
        checkBody(head);
        if (!AliveStatus())
            return;

        Food food = View.game.getFood();
        if(head.getX() == food.getX() && head.getY() == food.getY()){
            SnakeBody.add(0, head);
            View.game.eatFood();
        }
        else{
            SnakeBody.add(0, head);
            SnakeBody.remove(SnakeBody.size() - 1);
        }
    }

    private void checkHead(Body head){
        if((head.getX() < 0 ) || head.getX() >= 20 ||
                head.getY() < 0 || head.getY() >=  20 )
            isAlive = false;

    }

    private void checkBody(Body head){
        if (SnakeBody.contains(head))
            isAlive = false;
    }

}
