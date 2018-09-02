package catgames.items;

import android.graphics.Canvas;

import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.framework.Sound;
import catgames.player.Olgum;
import catgames.views.GameView;

public class Bubble {

    // File
    Image bubble_full;
    Sound pop_sound;

    // Slow Timer
    public static int slow_timer;

    public Bubble() {

        // Loading
        bubble_full = new Image(R.drawable.bubble_full);
        pop_sound = new Sound(R.raw.bubble_pop);
        slow_timer = 0;

        // Scale
        bubble_full.scale(3);

        // Position
        bubble_full.x = Settings.getScreenWidth() * 6;
        bubble_full.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - bubble_full.getHeight();

    }

    public void load() {
        bubble_full.x = Settings.getScreenWidth() * 7;
        bubble_full.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - bubble_full.getHeight();
        slow_timer = 0;
    }

    public void animate(Canvas c) {

        // Draw
        bubble_full.draw(c);

        if (Settings.gamePaused == false) {

            // Links nach rechts Bewegung
            bubble_full.x -= Settings.getScreenWidth() / 120 * GameView.gamespeed;

            // Reset
            if (bubble_full.x < -bubble_full.getWidth()) {
                bubble_full.x = Settings.getScreenWidth() * 11;
                bubble_full.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - bubble_full.getHeight();
            }

            // Collisioncheck
            if (bubble_full.collidesWith(Olgum.olgum)) {

                // Sound
                pop_sound.play();

                // Reset
                bubble_full.x = Settings.getScreenWidth() * 13;
                bubble_full.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - bubble_full.getHeight();

                // Spiel langsamer
                GameView.gamespeed -= 0.5;
                slow_timer = 1;          // Timerstart

            }

            // Slow Timer
            if (slow_timer > 0 && MainActivity.currentscreen.equals("GameView")) {
                slow_timer ++;
                if (slow_timer == 60*6) {
                    slow_timer = 0;
                    bubble_full.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - bubble_full.getHeight();
                    GameView.gamespeed += 0.5;     // Reset
                }

                if (slow_timer > 0 && slow_timer < 60*1) {        // 5 sek
                    bubble_full.x = bubble_full.getWidth() * 5;
                    bubble_full.y = c.getHeight() - bubble_full.getHeight();
                    bubble_full.draw(c);
                }

                if (slow_timer > 0 && slow_timer < 60*2) {
                    bubble_full.x = bubble_full.getWidth() * 4;
                    bubble_full.draw(c);
                }

                if (slow_timer > 0 && slow_timer < 60*3) {
                    bubble_full.x  = bubble_full.getWidth() * 3;
                    bubble_full.draw(c);
                }

                if (slow_timer > 0 && slow_timer < 60*4) {
                    bubble_full.x  = bubble_full.getWidth() * 2;
                    bubble_full.draw(c);
                }

                if (slow_timer > 0 && slow_timer < 60*5) {
                    bubble_full.x  = bubble_full.getWidth() * 1;
                    bubble_full.draw(c);
                }

                if (slow_timer > 0 && slow_timer < 60*6) {
                    bubble_full.x = 0;
                    bubble_full.draw(c);
                }


            }


        }

    }

}