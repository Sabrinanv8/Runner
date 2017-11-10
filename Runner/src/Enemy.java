import edu.princeton.cs.introcs.StdDraw;
import sun.font.EAttribute;

import java.awt.*;

public class Enemy {

    public double xPosition;
    private double yPosition;
    private final double rate =0.02;
    private boolean up;
    private static String monster = "Bill3.png";
    public double[] enemyposition = {xPosition, yPosition};


    public Enemy(double x, double y){

        xPosition = x;
        yPosition =  y;

    }
    public double getxPosition() {return xPosition;}
    public double getyPosition(){return yPosition;}
    public void drawEnemy(){
        StdDraw.picture(getxPosition(), getyPosition(), monster);

    }
    public void SlideLeft()  {
        if (xPosition<=1.0) {
            xPosition-=0.01;}
            drawEnemy();

    }
    public boolean CollisionCheck(eagle hawk) {
        if (Math.abs(xPosition - hawk.getxPosition()) < 0.1 && Math.abs(yPosition - hawk.getyPosition()) < 0.15) {
            //StdDraw.setPenColor(Color.RED);
           //StdDraw.setCanvasSize(1400,800  );
          // StdDraw.setXscale(0,1);
          // StdDraw.setYscale(0,1);
            //StdDraw.filledSquare(0, 0, 3);
            StdDraw.clear(Color.red);
            return false;
        }
        return true;
    }

}

