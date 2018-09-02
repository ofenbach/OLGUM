package catgames.player;

import java.util.Random;

import android.graphics.Canvas;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.framework.Sound;

public class Fart {

	// Dateien
	Image fart0, fart1, fart2, fart3, fart4, fart5;
	Image[] farts = new Image[6];
	
	// Timer
	int farttimer;		// 3 Frames -> 0.05sec
	double airtimer;	// Rotationanimation
	
	// Sounds
	Sound fartsound0, fartsound1, fartsound2, fartsound3;
	Sound fartsounds[] = new Sound[4];
	
	/* CONSTRUCTOR */
	public Fart() {
		
		// Loading
		fart0 = new Image(R.drawable.fart0);
		fart1 = new Image(R.drawable.fart1);
		fart2 = new Image(R.drawable.fart2);
		fart3 = new Image(R.drawable.fart3);
		fart4 = new Image(R.drawable.fart4);
		fart5 = new Image(R.drawable.fart5);
		farts[0] = fart0;
		farts[1] = fart1;
		farts[2] = fart2;
		farts[3] = fart3;
		farts[4] = fart4;
		farts[5] = fart5;
		fartsound0 = new Sound(R.raw.fartsound1);
		fartsound1 = new Sound(R.raw.fartsound2);
		fartsound2 = new Sound(R.raw.fartsound3);
		fartsound3 = new Sound(R.raw.fartsound4);
		fartsounds[0] = fartsound0;
		fartsounds[1] = fartsound1;
		fartsounds[2] = fartsound2;
		fartsounds[3] = fartsound3;
		
		// Scaling
		for (int i = 0; i <= 5; i++) {
			farts[i].scale();
		}

        fartsound0.setVolume(2);
        fartsound1.setVolume(2);
        fartsound2.setVolume(2);
        fartsound3.setVolume(2);

	}
	
	/* LOADING */
	public void load() {
		
		// Position, Rotation, Alpha
		for (int i = 0; i <= 5; i++) {
			
			// Position
			farts[i].x = Olgum.olgum.x;
			farts[i].y = Olgum.olgum.y + Olgum.olgumfart.getHeight();
			
			// Winkel
			farts[i].setRotation(-20);
			
			// Alpha
			farts[i].setAlpha(255);
			
		}
		
		// Timer Reset
		farttimer = 0;
		airtimer = Settings.getScreenHeight() / 360;
		
	}
	
	
	/* DRAW */
	public void draw(Canvas c) {
		
		// Draw
		if (farttimer <= 17*2) { farts[farttimer / 6].draw(c); }
		
		// Change x y and rotation
		for (int i = 0; i <= 5; i ++) {
			
			// Position
			farts[i].x -= (double) c.getWidth() / 480;
			farts[i].y += (double) airtimer;
			
			// Alpha
			farts[i].setAlpha((int) (farts[i].getAlpha() - (double) (255*0.025)));
			
			// Rotation
			farts[i].setRotation(farts[i].getAngle() + 2);
			
		}
		
		// Timer
		farttimer ++;
		airtimer -= (c.getHeight() * 0.00027777777);
		
	}
	
	/* SOUND */
	public void playSound() {
		
		// Random Fart Sound
		Random random = new Random();
		int r = random.nextInt(4);
        fartsounds[r].play();

	}
	
}