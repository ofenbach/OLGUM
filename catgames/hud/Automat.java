package catgames.hud;

import java.util.Random;

import android.app.Activity;
import android.graphics.Canvas;
import android.view.MotionEvent;

import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Button;
import catgames.framework.Sound;

public class Automat {

	// Files
	public static Button automat_red, automat_green;
	
	// Sound
	Sound shopsound1, shopsound2;
	
	/* CONSTRUCTOR */
	public Automat() {
		
		// Loading
		automat_red = new Button(R.drawable.automat_red);
		automat_green = new Button(R.drawable.automat_green);
		shopsound1 = new Sound(R.raw.shopsound1);
		shopsound2 = new Sound(R.raw.shopsound2);
		
		// Scaling
		automat_red.scale();
		automat_green.scale();
		
		// Position
		automat_red.x = Settings.getScreenWidth() / 10;
		automat_red.y = Settings.getScreenHeight() / 1.5 - automat_red.getHeight() / 2;
		automat_green.x = automat_red.x;
		automat_green.y = automat_red.y;
		
	}
	
	
	/* DRAW */
	public void draw(Canvas c) {
		
		// Draw
		if (Settings.getRaisins() >= 10 && Settings.hats_unlocked < 35) {
			automat_green.draw(c);
		} else {
			automat_red.draw(c);
		}

		// Fade out when every hat is purchased
		if (Settings.hats_unlocked >= 35) {
			automat_red.setAlpha(100);
		} else {
			automat_red.setAlpha(255);
		}
		
	}
	
	
	/* TOUCH */
	public void touch(MotionEvent e) {
		
		// Buy
		if (automat_red.isPressed(e) || automat_green.isPressed(e)) {
			
			// Raisinscheck
			if (Settings.getRaisins() >= 10 && Settings.hats_unlocked < 35) {
				
				// Play Sound
				if (!Settings.sound) {
					int r = MainActivity.random.nextInt(2);
					if (r == 0) { shopsound1.play(); } else if (r == 1) { shopsound2.play(); }
				}
				
				// Update Hats
				Settings.addNewHat();
				Settings.currenthat = Settings.getHatsUnlocked();
				Settings.addRaisins(-10);

				// Show Ad
				//Activity activity = (Activity) MainActivity.context;
				//AdBuddiz.showAd(activity);
				
			}
			
		}
		
	}
	
}