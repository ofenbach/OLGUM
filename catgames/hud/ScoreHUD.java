package catgames.hud;

import android.graphics.Canvas;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.views.GameView;

public class ScoreHUD {
	
	// Files
	Image one, two, three, four, five, six, seven, eight, nine, zero;
	Image numbers[] = new Image[10];
	Image meter;
	
	
	/* CONSTRUCTOR */
	public ScoreHUD() {
		
		// Loading
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
		for (int i = 0; i <= 9; i++) {
			numbers[i].scale();
		}
		meter.scale();
		
		// Position
		for (int i = 0; i <= 9; i++) {
			numbers[i].y = Settings.getScreenHeight() / (360 / 20);
		}
		meter.y = one.y + one.getHeight() - meter.getHeight();
		
	}
	
	
	/* ANIMATE */
	public void animate(Canvas c) {
		
		// Current Score
		int score = (int) GameView.score;
		int einer = score % 10;
		int zehner = (score % 100) / 10;
		int hunderter = (score % 1000) / 100;
		int tausender = score / 1000;
		
		// Draw Score
		if (score >= 1000) {
			
			// Tausender
			numbers[tausender].x = c.getWidth() / 2 - one.getWidth() * 2;
			numbers[tausender].draw(c);
					
			// Hunderter
			numbers[hunderter].x = c.getWidth() / 2 - one.getWidth();
			numbers[hunderter].draw(c);
					
			// Zehner
			numbers[zehner].x = c.getWidth() / 2;
			numbers[zehner].draw(c);
					
			// Einer
			numbers[einer].x = c.getWidth() / 2 + one.getWidth();
			numbers[einer].draw(c);
			
			// Meter
			meter.x = numbers[einer].x + one.getWidth();
			meter.draw(c);
			
		} else if (score >= 100) {
			
			// Hunderter
			numbers[hunderter].x = c.getWidth() / 2 - one.getWidth() * 1.5;
			numbers[hunderter].draw(c);
					
			// Zehner
			numbers[zehner].x = c.getWidth() / 2 - one.getWidth() * 0.5;
			numbers[zehner].draw(c);
					
			// Einer
			numbers[einer].x = c.getWidth() / 2 + one.getWidth() * 0.5;
			numbers[einer].draw(c);
			
			// Meter
			meter.x = numbers[einer].x + one.getWidth();
			meter.draw(c);
			
		} else if (score >= 10) {
			
			// Zehner
			numbers[zehner].setX(c.getWidth() / 2 - one.getWidth());
			numbers[zehner].draw(c);
				
			// Einer
			numbers[einer].setX(c.getWidth() / 2);
			numbers[einer].draw(c);
			
			// Meter
			meter.x = numbers[einer].x + one.getWidth();
			meter.draw(c);
			
		} else if (score >= 0) {
			
			// Einer
			numbers[(int) GameView.score].setXtoMiddle();
			numbers[(int) GameView.score].draw(c);
			
			// Meter
			meter.x = numbers[(int) GameView.score].x + one.getWidth();
			meter.draw(c);
			
		}
		
		
	}
	
	
}