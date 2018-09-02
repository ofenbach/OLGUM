package catgames.player;

import android.graphics.Canvas;
import catgames.handler.GhostHandler;
import catgames.handler.RaisinHandler;
import catgames.enemies.Rocket;
import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.framework.Sound;
import catgames.views.GameView;

public class Olgum {

	// Dateien
	public static Image olgum;
	public static Image olgumfart;
	public static Fart fart;
	Hat hat;
	
	// Fart
	public static boolean farting;
	int farttimer;
	
	// Animation
	double yvelocity;
	
	// Sound
	Sound gameoversound;
	
	
	/* CONSTRUCTOR */
	public Olgum() {
		
		// Loading
		olgum = new Image(R.drawable.olgum);
		olgumfart = new Image(R.drawable.olgumfart);
		fart = new Fart();
		hat = new Hat();
		gameoversound = new Sound(R.raw.gameoversound);
        gameoversound.setVolume(1.5);
		
		// Scaling
		olgum.scale();
		olgumfart.scale();
		
		// Position
		if (MainActivity.currentscreen == "MenuView") {				// Menu
			olgum.x = Settings.getScreenWidth() / 2.2;
			olgumfart.x = Settings.getScreenWidth() / 2.2;
			fart.load();
		} else {													// Game
			olgum.x = Settings.getScreenWidth() / 4;
			olgumfart.x = Settings.getScreenWidth() / 4;
			fart.load();
		}
		
	}


	/* LOAD RESET */
	public void load() {

		// Position
		if (MainActivity.currentscreen == "MenuView") {				// Menu
			olgum.x = Settings.getScreenWidth() / 2.2;
			olgumfart.x = Settings.getScreenWidth() / 2.2;
			fart.load();
		} else {													// Game
			olgum.x = Settings.getScreenWidth() / 4;
			olgumfart.x = Settings.getScreenWidth() / 4;
			fart.load();
		}

		// Var Reset
		farting = false;
		farttimer = 0;
		yvelocity = 0;

	}

	
	/* ANIMATE */
	public void animate(Canvas c) {

		// Animation
		if (Settings.gamePaused == false || MainActivity.currentscreen == "MenuView") {
			yvelocity += (double) c.getHeight() / (850);    // 30 FPS fix (*2)
		}

		if (MainActivity.currentscreen == "GameView") {
			if (yvelocity > c.getHeight() / 90) {            // Speed Lock
				yvelocity -= (double) c.getHeight() / 850;
				yvelocity += (double) c.getHeight() / (1200);
			}
		}
		
		// Affect Olgum Gravity
		if (Settings.gamePaused == false || MainActivity.currentscreen == "MenuView") {
			olgum.y += (double) yvelocity / 1.5;            // devide by 2 because 60fps
		}

		// Y-Lock Top (InGame)
		if (olgum.y < 0) {
			
			// Reset
			olgum.y = 0;
			yvelocity = 0;
			
		}
		
		// Angle
		if (Settings.gamePaused == false || MainActivity.currentscreen == "MenuView") {
			olgum.setRotation(-c.getHeight() / (36 * 2) + yvelocity / 2);
		}
		
		// Menu
		if (MainActivity.currentscreen == "MenuView") {
			
			// Y-Check
			if (olgum.y > c.getHeight() / 1.55) {
				
				// Positionreset
				olgum.y = c.getHeight() / 1.55;
				
				// Velocity Reset
				yvelocity = -c.getHeight() / (36);
				
				// Fartanimation (0.2sec)
				farting = true;
				fart.load();
				farttimer = 0;
				
			}
			
		}
		
		
		// Gameover Check
		if (MainActivity.currentscreen == "GameView") {
			
			// Ghosts
			for (int i = 0; i <= 22; i++) {
				if (olgum.collidesWith(GhostHandler.ghosts[i].ghost0)) {

					// Sound
					if (!Settings.sound && !GameView.gameover) {		// Prevent multiple Sound
						gameoversound.play();
					}

					// Gameover
					GameView.gameover = true;

				}
			}
			
			// Ground or Rocket
			if (olgum.y >= c.getHeight() - olgum.getHeight() / 4.8 || olgum.collidesWith(Rocket.rocket)) {
				
				// GAME OVER
				if (!Settings.sound && !GameView.gameover) {			// Prevent multiple Sound
					gameoversound.play();
				}
				GameView.gameover = true;
				
			}
			
			// Raisins
			if (olgum.collidesWith(RaisinHandler.raisins[0].raisin0) || olgum.collidesWith(RaisinHandler.raisins[1].raisin0) || olgum.collidesWith(RaisinHandler.raisins[2].raisin0) || olgum.collidesWith(RaisinHandler.raisins[3].raisin0) || olgum.collidesWith(RaisinHandler.raisins[4].raisin0)) {
				
				// Update Raisins
				GameView.raisinscore ++;
				
			}
		}
		
		
		// Draw
		if (Settings.gamePaused == false || MainActivity.currentscreen == "MenuView") {
			fart.draw(c);
		}


		if (!farting) {
			
			// Olgum
			olgum.draw(c);
			hat.animate(c);
			
		} else {
			
			// Olgumfart
			olgumfart.x = olgum.x;
			olgumfart.y = olgum.y;
			olgumfart.setRotation(olgum.getAngle());
			olgumfart.draw(c);
			hat.animate(c);
			
			// How long Olgumfart
			if (Settings.gamePaused == false || MainActivity.currentscreen == "MenuView") {
				farttimer++;
				if (farttimer > 12) {
					farting = false;
					farttimer = 0;
				}
			}
			
		}
		
	}
	
	
	/* TOUCH */
	public void jump() {
		
		// Jump
		yvelocity = -Settings.getScreenHeight() / 36;
		farting = true;
		fart.load();
		farttimer = 0;
		
	}
	
}