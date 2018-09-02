package catgames.hud;

import android.graphics.Canvas;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;

public class HighscoreHUD {

	// Background
	Image localbackground;
	Image highscores;
	
	// Files
	Image one, two, three, four, five, six, seven, eight, nine, zero;
	Image numbers[] = new Image[10];
	Image meter;
	
	
	/* CONSTRUCTOR */
	public HighscoreHUD() {
		
		// Loading
		localbackground = new Image(R.drawable.highscorebackground);
		highscores = new Image(R.drawable.highscores);
		one = new Image(R.drawable.number_1); two = new Image(R.drawable.number_2);
		three = new Image(R.drawable.number_3); four = new Image(R.drawable.number_4);
		five = new Image(R.drawable.number_5); six = new Image(R.drawable.number_6);
		seven = new Image(R.drawable.number_7); eight = new Image(R.drawable.number_8);
		nine = new Image(R.drawable.number_9); zero = new Image(R.drawable.number_0);
		numbers[0] = zero; numbers[1] = one; numbers[2] = two; numbers[3] = three;
		numbers[4] = four; numbers[5] = five; numbers[6] = six; numbers[7] = seven;
		numbers[8] = eight; numbers[9] = nine; numbers[0] = zero;
		meter = new Image(R.drawable.m);
		
		// Scaling
		localbackground.scale();
        highscores.scale();
		for (int i = 0; i <= 9; i++) {
			numbers[i].scale();
		}
		meter.scale();
		
		// Position & Alpha
		localbackground.setAlpha(255 / 2);
		localbackground.x = Automat.automat_red.x + Automat.automat_red.getWidth() / 2 - localbackground.getWidth() / 2;
		localbackground.y = Settings.getScreenHeight() / 4.73684210526 - localbackground.getHeight() / 3;
        highscores.x = localbackground.x + localbackground.getWidth() / 2 - highscores.getWidth() / 2;
        highscores.y = localbackground.y - highscores.getHeight() / 2;
		
		// Position Numbers
		for (int i = 0; i <= 9; i++) {
			numbers[i].y = localbackground.y + localbackground.getHeight() / 2 - one.getHeight() / 2;
		}
		meter.y = one.y + one.getHeight() - meter.getHeight();
		
	}
	
	
	/* DRAW */
	public void draw(Canvas c) {
		
		// Draw
		localbackground.draw(c);
        highscores.draw(c);
		
	}
	
	
	/* SCORE */
	public void drawScore(Canvas c) {
	
		// Current Highscore
		int score = (int) Settings.getHighscore();
		int einer = score % 10;
		int zehner = (score % 100) / 10;
		int hunderter = (score % 1000) / 100;
		int tausender = score / 1000;
		
		// Draw Score
		if (score >= 1000) {
			
			// Tausender
			numbers[tausender].x = localbackground.x + localbackground.getWidth() / 2 - one.getWidth() * 2;
			numbers[tausender].draw(c);
					
			// Hunderter
			numbers[hunderter].x = localbackground.x + localbackground.getWidth() / 2 - one.getWidth() * 1;
			numbers[hunderter].draw(c);
					
			// Zehner
			numbers[zehner].x = localbackground.x + localbackground.getWidth() / 2;
			numbers[zehner].draw(c);
					
			// Einer
			numbers[einer].x = localbackground.x + localbackground.getWidth() / 2 + one.getWidth() * 1;
			numbers[einer].draw(c);
			
			// Meter
			meter.x = numbers[einer].x + one.getWidth();
			meter.draw(c);
			
		} else if (score >= 100) {
			
			// Hunderter
			numbers[hunderter].x =  localbackground.x + localbackground.getWidth() / 2 - one.getWidth() * 1.5;
			numbers[hunderter].draw(c);
					
			// Zehner
			numbers[zehner].x =  localbackground.x + localbackground.getWidth() / 2 - one.getWidth() * 0.5;
			numbers[zehner].draw(c);
					
			// Einer
			numbers[einer].x =  localbackground.x + localbackground.getWidth() / 2 + one.getWidth() * 0.5;
			numbers[einer].draw(c);
			
			// Meter
			meter.x = numbers[einer].x + one.getWidth();
			meter.draw(c);
			
		} else if (score >= 10) {
			
			// Zehner
			numbers[zehner].x =  localbackground.x + localbackground.getWidth() / 2 - one.getWidth();
			numbers[zehner].draw(c);
				
			// Einer
			numbers[einer].x =  localbackground.x + localbackground.getWidth() / 2;
			numbers[einer].draw(c);
			
			// Meter
			meter.x = numbers[einer].x + one.getWidth();
			meter.draw(c);
			
		} else if (score >= 0) {
			
			// Einer
			numbers[(int) Settings.getHighscore()].x =  localbackground.x + localbackground.getWidth() / 2 - one.getWidth() * 0.5;
			numbers[(int) Settings.getHighscore()].draw(c);
			
			// Meter
			meter.x = numbers[(int) Settings.getHighscore()].x + one.getWidth();
			meter.draw(c);
			
		}
		
	}
	
}