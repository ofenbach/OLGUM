package catgames.enemies;

import android.graphics.Canvas;

import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.views.GameView;

public class Ghost {

	// Files
	public Image ghost0, ghost1;

	// Spritetimer
	int spritetimer;
	
	// Sinusanimation
	int timer;
	
	/* CONSTRUCTOR */
	public Ghost() {
		
		// Loading
		ghost0 = new Image(R.drawable.ghost1);
		ghost1 = new Image(R.drawable.ghost2);

		// Scaling
		ghost0.scale();
		ghost1.scale();
		
		// Position
		ghost0.x = Settings.getScreenWidth();
		ghost1.x = Settings.getScreenWidth();
		
	}
	
	/* ANIMATE */
	public void animate(Canvas c) {
		
		// Draw
		if (spritetimer <= 5) {				// 0.1 Secs
			ghost0.draw(c);
		} else if (spritetimer >= 6) {
			ghost1.draw(c);
		}
		
		// Timer Reset Check
		if (spritetimer == 11) {
			spritetimer = -1;
		}

		if (Settings.gamePaused == false) {

			// Timer Update
			spritetimer++;

			// Movement
			ghost0.x -= (c.getWidth() / (480 / 3.5)) * GameView.gamespeed;
			ghost1.x -= (c.getWidth() / (480 / 3.5)) * GameView.gamespeed;

			// Left Check
			if (ghost0.x <= -ghost0.getWidth()) {

				// X Reset
				ghost0.x = c.getWidth();
				ghost1.x = c.getWidth();

				// Y Reset Random		320 - 60
				double r = MainActivity.random.nextInt((int) (c.getHeight() / 1.4)) + c.getHeight() / (360 / 60);
				ghost0.y = r;
				ghost1.y = r;

			}

			// Down Movement
			if (timer <= 19) {
				ghost0.y += c.getHeight() / 720;
				ghost1.y += c.getHeight() / 720;
			}

			// Up Movement
			if (timer >= 20) {
				ghost0.y -= c.getHeight() / 720;
				ghost1.y -= c.getHeight() / 720;
			}

			// Timer Check
			if (timer == 39) {
				timer = -1;
			}

			// Timer Update
			timer++;

		}
		
	}
	
}