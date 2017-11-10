import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import edu.princeton.cs.introcs.Picture;
import edu.princeton.cs.introcs.StdDraw; //Upload libraries

import java.awt.*;
import java.awt.event.KeyEvent;

import static edu.princeton.cs.introcs.StdDraw.*;

public class Runner {
    private static boolean spaceBarPressed = false;
    private static int canvasWidth = 1400;
    private static int canvasHeight = 800;

public static int loss(int t, int highscore){
    if(t > highscore){
        return t;
    }
    else{return highscore;}
}



    public static void main(String[] args) throws InterruptedException {
    StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(canvasWidth, canvasHeight);
        StdDraw.setXscale(0, 1.0);
        StdDraw.setYscale(0, 1.0);
        String background = "Sci4.png";

        eagle bWCEagle = new eagle(0.5, 0.5, true);
        Font font = new Font("Arial", Font.BOLD, 70);
        StdDraw.setFont(font);
        StdDraw.text(0.5, 0.5, "Bridgewater Eagle Run");
        Font smallFont = new Font("Arial", Font.PLAIN, 40);
        StdDraw.setFont(smallFont);
        StdDraw.text(0.5, 0.3, "Press Space to start");
        Enemy[] army = new Enemy[100];
        army[0] = new Enemy(1.0, 0.4);
        for(int i = 0; i<100; i++) {
            double height = Math.random();
            army[i] = new Enemy(1, height);
        }
        int j = 0;
        int k = 1;
        int m = 0;
        int p = 0;
        boolean t = true;
        boolean s = true;
        int score = 0;
        int highscore = 0;

        TopTube[] a = new TopTube[100];
        for(int i = 0; i<a.length; i++){
            double c = Math.random();
            double d = 1-c;
            if(c>d){
            a[i] = new TopTube(1.1, c, d );}
            else{
                a[i] = new TopTube(1.1, d, c);
            }
        }
        StdDraw.setPenColor(Color.WHITE);
        boolean z = true;
        StdDraw.setFont(font);
        StdDraw.show();

        while (true) {

                if (getSpaceBarPress()) {
                    while (t&&s) {

                        StdDraw.text(0.9, 0.9, Integer.toString(score));

                        army[j].SlideLeft();

                        if(army[0].getxPosition()<=0.4){
                            army[k].SlideLeft();
                        }
                        s = army[j].CollisionCheck(bWCEagle);
                        t = army[k].CollisionCheck(bWCEagle);

                        if(army[j].getxPosition()<=0){
                            j+=2;
                        }
                        if(army[k].getxPosition()<=0){
                            k+=2;
                        }



                        if (getSpaceBarPress()) {
                            bWCEagle.moveUp();

                        } else {
                            bWCEagle.moveDown();
                        }

                        if(j>=50){
                            j=2;
                        }
                        if(k>=50){
                            k=1;
                        }
                        if(score==190){
                            StdDraw.clear(Color.RED);
                            StdDraw.show();
                            StdDraw.setFont(font);
                            StdDraw.text(0.5, 0.6, "Level 2");
                            StdDraw.show();
                            pause(500);
                            StdDraw.show();
                            StdDraw.text(0.5, 0.5, "Bill Says:");
                            StdDraw.show();
                            pause(900);
                            StdDraw.text(0.53, 0.4, "\"NEIL BEFORE ME!!!\"");
                            StdDraw.show();
                            pause(1090);


                        }
                        if(score>200){
                            a[m].PipeMove();
                        t=a[m].CollisionCheckNeil(bWCEagle);}
                        if(a[m].getXPosition()<0.1){
                            m++;
                        }

                        pause(30);
                        StdDraw.show();
                        StdDraw.picture(0.5,0.6, background);

                        score ++;




                    }
                    StdDraw.clear(Color.red);
                    StdDraw.show();
                    StdDraw.setFont(font);
                    StdDraw.text(0.5, 0.6, "Bill Nye Wins!!!");
                    StdDraw.show();
                    pause(500);
                    StdDraw.text(0.4, 0.4, "Bill");
                    StdDraw.show();
                    pause(500);
                    StdDraw.text(0.5, 0.4, "Bill");
                    StdDraw.show();
                    pause(500);
                    StdDraw.text(0.6, 0.4, "Bill");
                    StdDraw.show();
                    highscore = loss(score, highscore);
                    pause(600);
                    StdDraw.text(0.5, 0.3, "Your Score Is " + score);
                    StdDraw.show();
                    pause(600);
                    StdDraw.text(0.5, 0.2, "Your HighScore Is " + highscore );
                    StdDraw.show();
                    pause(600);
                    score = 0;
                    t = true;
                    s = true;
                   reset(bWCEagle, army, a);
                    j=0;
                    k=1;








                }
        }


        }


        public static void reset(eagle bWCEagle, Enemy[] fleetBill, TopTube[] fleetTubes ){
                bWCEagle.setYPosition(0.5);
                for(int i = 0; i<fleetBill.length; i++){
                    fleetBill[i].xPosition = 1.0;
                    fleetTubes[i].XPosition = 1.0;
                }



        }


    /**
     * These methods fired when a key is pressed don't worry about them for now.
     */

    public static boolean getSpaceBarPress(){
        if(Runner.spaceBarPressed  || StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
            Runner.spaceBarPressed  = false;
            return true;
        }
        return false;
    }

}
