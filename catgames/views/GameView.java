package catgames.views;

import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Button;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import catgames.engine.*;
import catgames.framework.Image;
import catgames.handler.*;
import catgames.hud.*;
import catgames.items.*;
import catgames.enemies.Rocket;
import catgames.player.Olgum;

// 1.05 Play Pause Button
// Hud Fixes

// 1.051
// Changes: Ground Hitbox reduced
// 			Coins take longer to spawn (+fix when died and instant replay coins are directly on screen)
// 3 new Hats added
// Vanish Effect Arrows and Automat when out of hats

// NEXT UPDATE 1.1
// DONE: New Item: GUN
// DONE: Bubble Added (+ faster raisinspawn)
// DONE: Gray Pause Effect
// DONE: Game gets faster after 100m
// DONE: Ghosts spawn higher now (y)

// Update 1.11
// TODO: Score Anzeige Animation (Zahlen von unten nach oben)

public class GameView extends View {

	// Background
	Image background;
	
	// Player
	Olgum olgum;

	// Items
	Gun gun;
	Bubble bubble;

	// Clouds
	CloudHandler clouds;
	
	// Raisins
	RaisinHandler raisinhandler;
	
	// Ghosts
	GhostHandler ghosthandler;
	
	// Rocket
	Rocket rocket;
	
	// Scores
	ScoreHUD scorehud;				// Player Score
	RaisinsHUD raisinshud;			// Raisin Score

	// Pause Button
	Button pause;
	Button resume;
	Image pause_effect;
	
	// Game
	public static boolean gameover;
	public static double raisinscore;
	public static double score;
	public static double gamespeed;		// 1 = normal
	
	// Animation
	boolean introanimation;
	
	
	/* CONSTRUKTOR */
	public GameView() {
		super(MainActivity.getContext());

		// Loading
		background = new Image(R.drawable.backdrop);
		olgum = new Olgum();
		gun = new Gun();
		bubble = new Bubble();
		clouds = new CloudHandler();
		scorehud = new ScoreHUD();
		raisinshud = new RaisinsHUD();
		raisinhandler = new RaisinHandler();
		ghosthandler = new GhostHandler();
		rocket = new Rocket();
		pause = new Button(R.drawable.pause_fixed);
		resume = new Button(R.drawable.resume_fixed);
		pause_effect = new Image(R.drawable.effect);

		// Scaling
		background.scaleFullscreen();
		pause.scale();
		resume.scale();
		pause_effect.scaleFullscreen();
		pause_effect.setAlpha(150);

	}

	
	/* LOADING */
	public void load() {

		// Var Reset
		gameover = false;
		score = 0;
		raisinscore = 0;
		gamespeed = 1;
		introanimation = true;
		this.setAlpha(0);

		// Olgum Reset
		olgum.load();
        olgum.jump();
		raisinhandler.load();
		ghosthandler.load();
		rocket.load();
		bubble.load();
		gun.load();

		// Gamepause Reset
		Settings.gamePaused = false;
		
	}
	
	/* DRAW */
	public void onDraw(Canvas c) {
		
		// Draw
		background.draw(c);
		clouds.animate(c);
		scorehud.animate(c);
		raisinshud.animate(c);
		ghosthandler.animate(c);
		raisinhandler.animate(c);
		rocket.animate(c);
		olgum.animate(c);
		gun.animate(c);
		bubble.animate(c);

		if (Settings.gamePaused) {
			resume.draw(c);
			pause_effect.draw(c);
		} else {
			pause.draw(c);
		}
		
		// Intro Animation
		if (this.getAlpha() < 1 && introanimation) {
			this.setAlpha((float) (this.getAlpha() + 0.1));
		} else {
			introanimation = false;
		}
		
		// Gameover Animation
		if (gameover) {
			
			// Vanish
			this.setAlpha((float) (this.getAlpha() - 0.1));
			
			// Invisible -> Menu
			if (this.getAlpha() <= 0) {
				
				// Save Scores
				Settings.setHighscore((int) score);
				Settings.addRaisins((int) raisinscore);
				
				// Change to Menu
				Settings.gamePaused = false;
				Gun.item = true;
				MainActivity.setScreen("MenuView");
				
			}
			
			
		} else {			// Still InGame
			
			// Score Update
			if (Settings.gamePaused == false) {
				score += 0.16666666666;

				// Spiel schneller (erst nach 100m)
				if (gamespeed < 1.4 && score > 100) { gamespeed += 0.0005; }
			}
			
		}
		
		// Repeat
		invalidate();
	}
	
	
	/* TOUCH */
	@SuppressWarnings("static-access")
	public boolean onTouchEvent(MotionEvent e) {

		boolean touched = false;

		// Touch
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			
			// Sound
			if (!Settings.sound) {
				olgum.fart.playSound();
			}

			// Pause-Resume
			if (pause.isPressed(e) && Settings.gamePaused == false) {
				touched = true;
				Settings.gamePaused = !Settings.gamePaused;
			}

			// Pause-Resume
			if (resume.isPressed(e) && Settings.gamePaused == true && touched == false) {
				Settings.gamePaused = !Settings.gamePaused;
				touched = true;
			}

			// Shot
			if (gun.shoot_button.isPressed(e) && gun.munition > 0) {
				gun.shooting = true;
				gun.munition --;
				// TODO: Sound
				gun.shoot.play();
				touched = true;
			}

			if (touched == false && Settings.gamePaused == false) {
				// Jump
				olgum.jump();
			}
			
		}
		
		return true;
	}
	
}