package catgames.enemies;

import android.graphics.Canvas;
import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.player.Olgum;
import catgames.views.GameView;

public class Rocket {

	// File
	public static Image rocket;
	
	// Random spawn
	public static int nextonetimer;		// 4 - 6 Sek (240 - 360 Frames)
	public static int randomtimer;
	
	// Sinustimer
	int timer;


	/* CONSTRUCTOR */
	public Rocket() {
		
		// Loading
		int r = MainActivity.random.nextInt(6);
		nextonetimer = 180;
		
		// Random Rocket
		if (r == 0) {
			rocket = new Image(R.drawable.rocket1);
		}
		if (r == 1) {
			rocket = new Image(R.drawable.rocket2);
		}
		if (r == 2) {
			rocket = new Image(R.drawable.rocket3);
		}
		if (r == 3) {
			rocket = new Image(R.drawable.rocket4);
		}
		if (r == 4) {
			rocket = new Image(R.drawable.rocket5);
		}
		if (r == 5) {
			rocket = new Image(R.drawable.rocket6);
		}
		
		// Scaling
		rocket.scale();
		
		// Position
		rocket.x = Settings.getScreenWidth();
		rocket.y = Olgum.olgum.y;
		rocket.setRotation(180);

	}


	/* LOADING */
	public void load() {

		// Position
		rocket.x = Settings.getScreenWidth();
		rocket.y = Olgum.olgum.y;
		rocket.setRotation(180);

		// Var Reset
		nextonetimer = 180;
		randomtimer = 0;


	}


	/* RESET */
	public static void reset() {

		// Loading
		int r = MainActivity.random.nextInt(6);
		
		// Random Rocket
		if (r == 0) {
			rocket = new Image(R.drawable.rocket1);
		}
		if (r == 1) {
			rocket = new Image(R.drawable.rocket2);
		}
		if (r == 2) {
			rocket = new Image(R.drawable.rocket3);
		}
		if (r == 3) {
			rocket = new Image(R.drawable.rocket4);
		}
		if (r == 4) {
			rocket = new Image(R.drawable.rocket5);
		}
		if (r == 5) {
			rocket = new Image(R.drawable.rocket6);
		}

		// Scaling
		rocket.scale();
		
		// Position
		rocket.x = Settings.getScreenWidth();
		rocket.y = Olgum.olgum.y;
		rocket.setRotation(180);
		
	}


	/* ANIMATE */
	public void animate(Canvas c) {

        // Draw
        rocket.draw(c);

		if (Settings.gamePaused == false) {

			// Down Movement
			if (timer <= 19) {
				rocket.y += c.getHeight() / 400;
			}

			// Up Movement
			if (timer >= 20) {
				rocket.y -= c.getHeight() / 400;
			}

			// Timer Check
			if (timer == 39) {
				timer = -1;
			}

			// Timer Update
			timer++;

			// Random Next One
			randomtimer++;

			// After 3-5 Secs
			if (randomtimer == nextonetimer) {

				// New NextOneTimer
				randomtimer = 0;
				nextonetimer = (MainActivity.random.nextInt(120) + 240);

				// Y-Reset
				reset();

			}

			// Angle
			double olgummiddley = Olgum.olgum.y + Olgum.olgum.getHeight() / 2;
			double rocketmiddley = rocket.y + rocket.getHeight() / 2;
			double deltay = rocketmiddley - olgummiddley;

			//double factor = ((double) c.getWidth() / c.getHeight()) / 12;
			// Rotation
			rocket.setRotation(deltay * 0.03 + 180);

			// Move c.getHeight / 70
			double distance = c.getHeight() / 74;
			double distanceX = -distance * Math.sin(Math.toRadians(rocket.getAngle() - 90));
			double distanceY = distance * Math.cos(Math.toRadians(rocket.getAngle() - 90));

			// Movement
			rocket.x += distanceX * GameView.gamespeed;
			rocket.y += distanceY * GameView.gamespeed;

		}
		
	}

	
}