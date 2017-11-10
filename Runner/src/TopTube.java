import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class TopTube {
    public double XPosition;
    public double YPosition;
    public double YPosition2;
    private String PipeTop = "TysonTop.jpeg";
    private String PipeBottom = "TysonTopBottom.jpeg";
    private double move = 0.3;

    public TopTube(double x, double yTop, double yBottom) {
        XPosition = x;
        YPosition = yTop;
        YPosition2 = yBottom;
    }

    public double getXPosition() {
        return XPosition;
    }

    public double getYPosition() {
        return YPosition;
    }

    public double getYPosition2() {
        return YPosition2;
    }

    public void drawTube() {
        StdDraw.picture(getXPosition(), getYPosition(), PipeTop);
        StdDraw.picture(getXPosition(), getYPosition2(), PipeBottom);
    }

    public void PipeSlide() throws InterruptedException {
        XPosition = getXPosition() - 0.01;
        drawTube();
       // Thread.sleep(25);
    }


    public boolean CollisionCheckNeil(eagle hawk) {
        if (Math.abs(getXPosition() - hawk.getxPosition()) < 0.1 && ((Math.abs(getYPosition() - hawk.getyPosition()) < 0.15) ||
                (Math.abs(getYPosition2() - hawk.getyPosition()) < 0.15))) {
            StdDraw.clear(Color.red);
            return false;
        }
        return true;
    }



    public void PipeMove() throws InterruptedException {
        PipeSlide();
    }




}
