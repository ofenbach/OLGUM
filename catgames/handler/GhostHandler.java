package catgames.handler;

import java.util.Random;

import android.graphics.Canvas;

import catgames.enemies.Ghost;
import catgames.engine.MainActivity;
import catgames.engine.Settings;
import catgames.views.GameView;

public class GhostHandler {
	
	// Alle 0.1 - 2 Sekunden (Zufall) neuer Geist
	// 23 Ghosts Maximal
	Ghost ghost0, ghost1, ghost2, ghost3, ghost4, ghost5, ghost6, ghost7, ghost8, ghost9, ghost10, ghost11, ghost12, ghost13, ghost14, ghost15, ghost16, ghost17, ghost18, ghost19, ghost20, ghost21, ghost22;
	public static Ghost[] ghosts = new Ghost[23];
	
	// Random
	int randomtimer;
	double nextonetimer;
	
	/* CONSTRUCTOR */
	public GhostHandler() {
		
		// Loading
		ghost0 = new Ghost(); ghost1 = new Ghost(); ghost2 = new Ghost(); ghost3 = new Ghost(); ghost4 = new Ghost(); ghost5 = new Ghost();
		ghost6 = new Ghost(); ghost7 = new Ghost(); ghost8 = new Ghost(); ghost9 = new Ghost(); ghost10 = new Ghost(); ghost11 = new Ghost();
		ghost12 = new Ghost(); ghost13 = new Ghost(); ghost14 = new Ghost(); ghost15 = new Ghost(); ghost16 = new Ghost(); ghost17 = new Ghost();
		ghost18 = new Ghost(); ghost19 = new Ghost(); ghost20 = new Ghost(); ghost21 = new Ghost(); ghost22 = new Ghost();
		nextonetimer = 24;		// 0.4 sec
		
		// Array
		ghosts[0] = ghost0;
		ghosts[1] = ghost1;
		ghosts[2] = ghost2;
		ghosts[3] = ghost3;
		ghosts[4] = ghost4;
		ghosts[5] = ghost5;
		ghosts[6] = ghost6;
		ghosts[7] = ghost7;
		ghosts[8] = ghost8;
		ghosts[9] = ghost9;
		ghosts[10] = ghost10;
		ghosts[11] = ghost11;
		ghosts[12] = ghost12;
		ghosts[13] = ghost13;
		ghosts[14] = ghost14;
		ghosts[15] = ghost15;
		ghosts[16] = ghost16;
		ghosts[17] = ghost17;
		ghosts[18] = ghost18;
		ghosts[19] = ghost19;
		ghosts[20] = ghost20;
		ghosts[21] = ghost21;
		ghosts[22] = ghost22;

		// Position
		for (int i = 0; i <= 22; i ++) {
			double r = MainActivity.random.nextInt((int) (Settings.getScreenHeight() / 1.4)) + Settings.getScreenHeight() / (360/60);
			ghosts[i].ghost0.y = r;
			ghosts[i].ghost1.y = r;
		}
		
	}


	/* LOAD RESET */
	public void load() {

		// Var Reset
		nextonetimer = 24;
		randomtimer = 0;

		// Position
		for (int i = 0; i <= 22; i ++) {
			double r = MainActivity.random.nextInt((int) (Settings.getScreenHeight() / 1.4)) + Settings.getScreenHeight() / (360/60);
			ghosts[i].ghost0.y = r;
			ghosts[i].ghost1.y = r;
			ghosts[i].ghost0.x = Settings.getScreenWidth();
			ghosts[i].ghost1.x = Settings.getScreenWidth();
		}

	}
	
	
	/* ANIMATE */
	public void animate(Canvas c) {
		
		// Draw
		for (int i = 0; i <= 22; i++) {
			if (ghosts[i].ghost0.isInScreen()) {			// If in Screen
				ghosts[i].animate(c);
			}
		}
		

		if (Settings.gamePaused == false) {
			// TODO: Timer Update nur wenn kein Boss (Settings.gamescore > 500 & < 750
			if (true) {
				randomtimer++;
			}
			// After 6 Frames (only firsttimer else between 24-100)
			if (randomtimer >= nextonetimer / GameView.gamespeed) {

				// New NextOneTimer
				randomtimer = 0;
				nextonetimer = MainActivity.random.nextInt(100 - 24) + 24;

				for (int i = 0; i <= 22; i++) {

					// Erster der nicht animiert wird
					if (!ghosts[i].ghost0.isInScreen()) {

						// Start animation
						ghosts[i].ghost0.x = c.getWidth() - 1;
						ghosts[i].ghost1.x = c.getWidth() - 1;

						// Y Reset Random		320 - 60
						double r = MainActivity.random.nextInt((int) (c.getHeight() / 1.4)) + (c.getHeight() / (360 / 60))*0.5;
						ghosts[i].ghost0.y = r;
						ghosts[i].ghost1.y = r;

						// Schleifenabbruch
						i = 23;

					}

				}

			}

		}
		
 	}

	
}