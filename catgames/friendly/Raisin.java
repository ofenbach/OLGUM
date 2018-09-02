package catgames.friendly;

import java.util.Random;

import android.graphics.Canvas;

import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.player.Olgum;
import catgames.framework.Image;
import catgames.framework.Sound;
import catgames.views.GameView;

public class Raisin {

	// File
	public Image raisin0, raisin1, raisin2, raisin3, raisin4;
	Image[] raisins = new Image[5];
	
	// Timer
	int spritetimer;		// 6 Frames -> 1 Spin
	int hittimer;			// Pause
	
	// Sound
	Sound raisinsound1, raisinsound2, raisinsound3, raisinsound4;
	
	/* CONSTRUCTOR */
	public Raisin() {
		
		// Loading
		raisin0 = new Image(R.drawable.raisin0);
		raisin1 = new Image(R.drawable.raisin1);
		raisin2 = new Image(R.drawable.raisin2);
		raisin3 = new Image(R.drawable.raisin3);
		raisin4 = new Image(R.drawable.raisin4);
		raisins[0] = raisin0;
		raisins[1] = raisin1;
		raisins[2] = raisin2;
		raisins[3] = raisin3;
		raisins[4] = raisin4;
		spritetimer = 0;
		raisinsound1 = new Sound(R.raw.raisinsound1);
		raisinsound2 = new Sound(R.raw.raisinsound2);
		raisinsound3 = new Sound(R.raw.raisinsound3);
		raisinsound4 = new Sound(R.raw.raisinsound4);
		
		
		// Scaling
		for (int i = 0; i <= 4; i++) {
			raisins[i].scale();
		}
		
		// Position
		double r = (double) MainActivity.random.nextInt(8) / 10;
		for (int i = 0; i <= 4; i++) {
			raisins[i].x = Settings.getScreenWidth();
			raisins[i].y = (double) Settings.getScreenHeight() * r;
		}
		
	}
	
	
	/* DRAW */
	public void animate(Canvas c) {
		
		// Draw
		raisins[spritetimer / 6].draw(c);


		if (Settings.gamePaused == false) {

			// Timer Update
			spritetimer++;

			// Sprite Check
			if (spritetimer == 6 * 5) {
				spritetimer = 0;
			}

			// Out of screen
			if (raisin0.x < -raisin0.getWidth()) {

				// Reset X
				for (int i = 0; i <= 4; i++) {
					raisins[i].x = c.getWidth() * 2;
				}

				// Random Y from: c.getHeight() / 6 to c.getHeight() / 1.125
				double r = MainActivity.random.nextInt(10);
				for (int i = 0; i <= 4; i++) {
					raisins[i].y = c.getHeight() / 6 + (r / 10) * (c.getHeight() / 1.125 - c.getHeight() / 6);
				}

			}

			// Hitbox Check
			if (raisin0.collidesWith(Olgum.olgum)) {

				// Play Sound
				if (!Settings.sound) {
					int ra = MainActivity.random.nextInt(4);
					if (ra == 0) {
						raisinsound1.play();
					}
					if (ra == 1) {
						raisinsound2.play();
					}
					if (ra == 2) {
						raisinsound3.play();
					}
					if (ra == 3) {
						raisinsound4.play();
					}
				}

				for (int i = 0; i <= 4; i++) {
					raisins[i].x = c.getWidth();
				}

				if (hittimer > 30) {
					if (Settings.gamePaused == false) {
						GameView.raisinscore += 1;
						hittimer = 0;
					}
				} else {
					hittimer++;
				}

				// Random Y from: c.getHeight() / 6 to c.getHeight() / 1.125
				double r = MainActivity.random.nextInt(10);
				for (int i = 0; i <= 4; i++) {
					raisins[i].y = c.getHeight() / 6 + (r / 10) * (c.getHeight() / 1.125 - c.getHeight() / 6);
				}

			}

			// Movement
			for (int i = 0; i <= 4; i++) {
				if (raisins[i].isInScreen()) {
					raisins[i].x -= (c.getWidth() / (80 * 2)) * GameView.gamespeed;
				}
			}

		}
		
	}
	
	
}