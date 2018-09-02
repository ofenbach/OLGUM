package catgames.friendly;

import java.util.Random;

import android.graphics.Canvas;

import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.views.GameView;

public class Cloud {
	
	// File
	public Image cloud;
	
	// Random saver
	double r;
	
	
	/* CONSTRUCTOR */
	public Cloud() {
		
		// Loading
		r =  MainActivity.random.nextInt(6);
		
		// Random cloud
		if (r == 0) {
			cloud = new Image(R.drawable.cloud0);
		}
		if (r == 1) {
			cloud = new Image(R.drawable.cloud1);
		}
		if (r == 2) {
			cloud = new Image(R.drawable.cloud2);
		}
		if (r == 3) {
			cloud = new Image(R.drawable.cloud3);
		}
		if (r == 4) {
			cloud = new Image(R.drawable.cloud4);
		}
		if (r == 5) {
			cloud = new Image(R.drawable.cloud5);
		}
		
		// Scaling
		cloud.scale();
		
		// Position & Alpha
		cloud.setAlpha((int) ((255 * 0.6) - ((r+1) * 5)));
		r = MainActivity.random.nextInt(10);
		cloud.y = Settings.getScreenHeight() * (r/10);
		cloud.x = Settings.getScreenWidth();
		
	}

	
	/* DRAW */
	public void animate(Canvas c) {
		
		// Draw
		cloud.draw(c);

		if (Settings.gamePaused == false) {

			// Movement
			if (MainActivity.currentscreen.equals("GameView")) { cloud.x -= (c.getWidth() / 480) * r * GameView.gamespeed; } else { cloud.x -= (c.getWidth() / 480) * r; }

			// Border Check Left
			if (cloud.x <= -cloud.getWidth()) {
				cloud.x = Settings.getScreenWidth();
			}

		}
		
	}
	
	
}