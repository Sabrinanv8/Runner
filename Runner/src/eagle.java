import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.lang.Math;

public class eagle {
    private double xPosition;
    private double yPosition;
    private double topPostion = 0.9;
    private double bottomPostion = 0.1;
    private final double upRate =0.02;
    private boolean up;
    private static String eagleUp = "eagleUp.png";
    private static String eagleDown = "eagleDown.png";
    public double[] eagleposition = {xPosition, yPosition};


    public eagle(double x, double y, boolean upPosition){

        xPosition = x;
        yPosition =  y;
        up = upPosition;

    }

    public double getxPosition(){
        return xPosition;
    }

    public double getyPosition(){
        return yPosition;
    }

    public String getEagleFile(){
        if(up){
            up =!up;
            return eagleDown;
        }else{
            up = !up;
            return eagleUp;
        }
    }

    public void moveUp(){
        if(yPosition < 0.9 ){
            yPosition += 0.02;
        }
        drawEagle();

    }


    public void  drawEagle(){
        StdDraw.picture(getxPosition(), getyPosition(), getEagleFile());
    }

    public void moveDown(){
        if(yPosition > 0.1 ){
            yPosition -= 0.01;
        }
        drawEagle();
    }


    public void setYPosition(double YPosition) {
        yPosition = YPosition;
    }
}


