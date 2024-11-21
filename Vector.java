package ReviewCreateBallRectStar;

public class Vector {
    // คุณสมบัติ
    public double x, y;

    // default constructor
    public Vector () {

    }
    // parameter constructor
    public Vector (double x, double y) {
        this.x = x;
        this.y = y;
    }
    // method
    public Vector add (Vector v) {
        return new Vector (this.x + v.x, this.y + v.y);
    }
}
