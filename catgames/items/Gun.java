package catgames.items;

import android.graphics.Canvas;
import catgames.enemies.Rocket;
import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Button;
import catgames.framework.Image;
import catgames.framework.Sound;
import catgames.player.Olgum;
import catgames.views.GameView;

public class Gun {

    // Files
    public Image gun;
    public Button shoot_button;
    Image projectile;
    Image ammo_1, ammo_2, ammo_3, ammo_4, ammo_5;
    Image[] ammos = new Image[5];
    public Sound shoot;
    Sound collected_sound;

    // Game
    public int munition = 0;
    public boolean shooting = false;
    public static boolean item = true;


    /* CONSTRUCTOR */
    public Gun() {

        // Loading
        gun = new Image(R.drawable.player_green_gun);
        shoot_button = new Button(R.drawable.shoot_button);
        projectile = new Image(R.drawable.projecile);
        ammo_1 = new Image(R.drawable.ammo_1);
        ammo_2 = new Image(R.drawable.ammo_2);
        ammo_3 = new Image(R.drawable.ammo_3);
        ammo_4 = new Image(R.drawable.ammo_4);
        ammo_5 = new Image(R.drawable.ammo_5);
        ammos[0] = ammo_1; ammos[1] = ammo_2; ammos[2] = ammo_3; ammos[3] = ammo_4; ammos[4] = ammo_5;
        shoot = new Sound(R.raw.gun_sound);
        collected_sound = new Sound(R.raw.collected_gun1);

        // Scaling
        gun.scale();
        shoot_button.scale();
        projectile.scale();
        for (int i = 0; i < ammos.length; i ++) { ammos[i].scale(); }

        // Position
        gun.x = Settings.getScreenWidth() * 3;
        gun.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - gun.getHeight();
        shoot_button.x = Settings.getScreenWidth() - shoot_button.getWidth();
        shoot_button.y = Settings.getScreenHeight() - shoot_button.getHeight();
        for (int i = 0; i < ammos.length; i ++) { ammos[i].y = 0;
                                                  ammos[i].x = Settings.getScreenWidth() - ammos[i].getWidth(); }

    }


    /* RESET */
    public void load() {
        // Position
        gun.x = Settings.getScreenWidth() * 3;
        gun.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - gun.getHeight();
        shoot_button.x = Settings.getScreenWidth() - shoot_button.getWidth();
        shoot_button.y = Settings.getScreenHeight() - shoot_button.getHeight();
        for (int i = 0; i < ammos.length; i ++) { ammos[i].y = 0;
            ammos[i].x = Settings.getScreenWidth() - ammos[i].getWidth(); }
    }

    public void animate(Canvas c) {

        // Draw
        gun.draw(c);

        if (Settings.gamePaused == false) {

            if (item == true) {

                // Spinning left to right (Sinus?)
                gun.setRotation(gun.getAngle()+3);

                // Links nach rechts Bewegung
                gun.x -= Settings.getScreenWidth() / 120 * GameView.gamespeed;

                // Reset
                if (gun.x < -gun.getWidth()) {
                    gun.x = Settings.getScreenWidth() * 8;
                    gun.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - gun.getHeight();
                }

                // Collisioncheck
                if (gun.collidesWith(Olgum.olgum)) {
                    item = false;
                    gun.setRotation(0);
                    munition = 5;
                    collected_sound.play();
                }

            } else {
                animateCollected(c);
            }

        }

    }

    public void animateCollected(Canvas c) {

        // An OLGUM schmiegen
        gun.y = Olgum.olgum.y + Olgum.olgum.getHeight() / 4;
        gun.x = Olgum.olgum.x + Olgum.olgum.getWidth() / 2;

        // Schuss
        if (shooting) {

            // Projectile animieren
            projectile.draw(c);
            projectile.x += (Settings.getScreenWidth() / 20) * GameView.gamespeed;

            // Kollision
            if (projectile.collidesWith(Rocket.rocket)) {

                // Rakete loeschen
                Rocket.rocket.x = -Rocket.rocket.getWidth();
                shooting = false;

                // TODO: Sound

            }

            // Rechts raus
            if (projectile.x > Settings.getScreenWidth()) {
                shooting = false;
            }

        } else {
            projectile.x = Olgum.olgum.x;
            projectile.y = Olgum.olgum.y;
        }

        // Keine Munition mehr oder tot -> RESET
        if (munition == 0 || MainActivity.currentscreen.equals("MenuView")) {
            item = true;
            gun.x = Settings.getScreenWidth() * 8.5;
            gun.y = (Settings.getScreenHeight() / (MainActivity.random.nextInt(9) + 1)) - gun.getHeight();
        }

        // Schießbutton
        shoot_button.draw(c);
        if (munition > 0) { ammos[munition-1].draw(c); }

    }

}