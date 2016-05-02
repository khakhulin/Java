/**
 * Created by tar on 02.05.16.
 */
public class Body {
    private int x;
    private int y;

    public Body(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Body o = (Body) obj;
        if(x != o.getX()) return false;
        if(y != o.getY()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = result * 3 + y * 2;
        return result;

    }
}
