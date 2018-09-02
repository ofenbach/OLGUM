package catgames.enemies;

import android.graphics.Canvas;

import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;

public class BirdBoss {

    // Files
    Image bird;
    Image birdwing;

    /* CONSTRUCTOR */
    public BirdBoss() {

        // Laden
        bird = new Image(R.drawable.bird_red);
        birdwing = new Image(R.drawable.birdwing_red);

        // Scaling
        bird.scale(2);
        birdwing.scale(2);

        // Position
        bird.x = 0;
        bird.y = 0;
        birdwing.x = 0;
        birdwing.y = 0;

    }

    /* ANIMATE */
    public void animate(Canvas c) {

        // Alle 500meter spawnt er

        // Draw
        bird.draw(c);


        if (Settings.gamePaused == false) {

        }

    }

}