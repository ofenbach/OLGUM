package catgames.handler;

import java.util.Random;
import android.graphics.Canvas;

import catgames.engine.MainActivity;
import catgames.engine.Settings;
import catgames.friendly.Raisin;
import catgames.views.GameView;

public class RaisinHandler {

	// Alle 1-3 Sek -> 60-180 frames
	// 3 Max
	
	// File
	public static Raisin raisin0, raisin1, raisin2, raisin3, raisin4;
	public static Raisin raisins[] = new Raisin[5];

	// Random
	int randomtimer;
	double nextonetimer;
	
	
	/* CONSTRUCTOR */
	public RaisinHandler() {
		
		// Loading
		raisin0 = new Raisin();
		raisin1 = new Raisin();
		raisin2 = new Raisin();
		raisin3 = new Raisin();
		raisin4 = new Raisin();
		raisins[0] = raisin0;
		raisins[1] = raisin1;
		raisins[2] = raisin2;
		raisins[3] = raisin3;
		raisins[4] = raisin4;
		nextonetimer = 60*6;			// 6 Sec
		
	}


	/* LOAD RESET */
	public void load() {

		// Var Reset
		nextonetimer = 60*6;
		randomtimer = 0;

	}
	
	
	/* ANIMATE */
	public void animate(Canvas c) {
		
		// Draw
		for (int i = 0; i <= 4; i++) {
			if (raisins[i].raisin0.isInScreen()) {
				raisins[i].animate(c);
			}
		}

		if (GameView.gameover) {

			// Reset Position
			double r = (double) MainActivity.random.nextInt(8) / 10;
			for (int i = 0; i <= 4; i++) {
				raisins[i].raisin0.x = Settings.getScreenWidth();
				raisins[i].raisin0.y = (double) Settings.getScreenHeight() * r;
				raisins[i].raisin1.x = Settings.getScreenWidth();
				raisins[i].raisin1.y = (double) Settings.getScreenHeight() * r;
				raisins[i].raisin2.x = Settings.getScreenWidth();
				raisins[i].raisin2.y = (double) Settings.getScreenHeight() * r;
				raisins[i].raisin3.x = Settings.getScreenWidth();
				raisins[i].raisin3.y = (double) Settings.getScreenHeight() * r;
				raisins[i].raisin4.x = Settings.getScreenWidth();
				raisins[i].raisin4.y = (double) Settings.getScreenHeight() * r;
			}

		} else {

			if (Settings.gamePaused == false) {
				// Timer Update
				randomtimer++;

				// After 60 Frames (firsttime else between 50 and 170)
				if (GameView.gamespeed < 1) {
					if (randomtimer >= nextonetimer / (GameView.gamespeed * 10)) {

						// New NextOneTimer
						randomtimer = 0;
						nextonetimer = (MainActivity.random.nextInt(120) + 50);

						// Search for First one that isn't animated
						for (int i = 0; i <= 4; i++) {

							// Found
							if (!raisins[i].raisin0.isInScreen()) {

								// Start Animation
								raisins[i].raisin0.x = c.getWidth() - 1;
								raisins[i].raisin1.x = c.getWidth() - 1;
								raisins[i].raisin2.x = c.getWidth() - 1;
								raisins[i].raisin3.x = c.getWidth() - 1;
								raisins[i].raisin4.x = c.getWidth() - 1;

								// Schleifenabruch
								i = 23;

							}

						}

					}
				} else {
					if (randomtimer >= nextonetimer) {

						// New NextOneTimer
						randomtimer = 0;
						nextonetimer = (MainActivity.random.nextInt(120) + 50);

						// Search for First one that isn't animated
						for (int i = 0; i <= 4; i++) {

							// Found
							if (!raisins[i].raisin0.isInScreen()) {

								// Start Animation
								raisins[i].raisin0.x = c.getWidth() - 1;
								raisins[i].raisin1.x = c.getWidth() - 1;
								raisins[i].raisin2.x = c.getWidth() - 1;
								raisins[i].raisin3.x = c.getWidth() - 1;
								raisins[i].raisin4.x = c.getWidth() - 1;

								// Schleifenabruch
								i = 23;

							}

						}

					}
				}
			}

		}
		
	}
	
}