package catgames.hud;

import android.graphics.Canvas;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;
import catgames.views.GameView;

public class RaisinsHUD {

	// Files
	Image one, two, three, four, five, six, seven, eight, nine, zero;
	Image numbers[] = new Image[10];
	Image raisins;
	
	/* CONSTRUCTOR */
	public RaisinsHUD() {
		
		// Loading
		one = new Image(R.drawable.number_1); two = new Image(R.drawable.number_2);
		three = new Image(R.drawable.number_3); four = new Image(R.drawable.number_4);
		five = new Image(R.drawable.number_5); six = new Image(R.drawable.number_6);
		seven = new Image(R.drawable.number_7); eight = new Image(R.drawable.number_8);
		nine = new Image(R.drawable.number_9); zero = new Image(R.drawable.number_0);
		numbers[0] = zero; numbers[1] = one; numbers[2] = two; numbers[3] = three;
		numbers[4] = four; numbers[5] = five; numbers[6] = six; numbers[7] = seven;
		numbers[8] = eight; numbers[9] = nine; numbers[0] = zero;
		raisins = new Image(R.drawable.r);
		
		// Scaling
		for (int i = 0; i <= 9; i++) {
			numbers[i].scale();
		}
		raisins.scale();
		
		// Position
		for (int i = 0; i <= 9; i++) {
			numbers[i].y = Settings.getScreenHeight() / ((double) 360 / 340) - one.getHeight();
		}
		raisins.y = one.y + one.getHeight() - raisins.getHeight();
		
	}
	
	
	/* ANIMATE GAME */
	public void animate(Canvas c) {
		
		// Current Score
		int score = (int) GameView.raisinscore;
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
			raisins.x = numbers[einer].x + one.getWidth();
			raisins.draw(c);
			
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
			raisins.x = numbers[einer].x + one.getWidth();
			raisins.draw(c);
			
		} else if (score >= 10) {
			
			// Zehner
			numbers[zehner].setX(c.getWidth() / 2 - one.getWidth());
			numbers[zehner].draw(c);
				
			// Einer
			numbers[einer].setX(c.getWidth() / 2);
			numbers[einer].draw(c);
			
			// Meter
			raisins.x = numbers[einer].x + one.getWidth();
			raisins.draw(c);
			
		} else if (score >= 0) {
			
			// Einer
			numbers[(int) GameView.raisinscore].setXtoMiddle();
			numbers[(int) GameView.raisinscore].draw(c);
			
			// Meter
			raisins.x = numbers[(int) GameView.raisinscore].x + one.getWidth();
			raisins.draw(c);
			
		}
		
	}
	
	
	/* MENUE */
	public void animateMenu(Canvas c) {
		
		// Y-Position Fix
		for (int i = 0; i <= 9; i++) {
			numbers[i].y = Settings.getScreenHeight() / ((double) 360 / 340) - one.getHeight();
		}
		raisins.y = one.y + one.getHeight() - raisins.getHeight();
		
		// X-Fix
		for (int i = 0; i <= 9; i++) {
			numbers[i].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2;
		}
		
		// Current Score
		int score = (int) Settings.getRaisins();
		int einer = score % 10;
		int zehner = (score % 100) / 10;
		int hunderter = (score % 1000) / 100;
		int tausender = score / 1000;
		
		// Draw Score
		if (score >= 1000) {
			
			// Tausender
			numbers[tausender].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2 - one.getWidth() * 2;
			numbers[tausender].draw(c);
					
			// Hunderter
			numbers[hunderter].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2 - one.getWidth() * 1;
			numbers[hunderter].draw(c);
					
			// Zehner
			numbers[zehner].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2;
			numbers[zehner].draw(c);
					
			// Einer
			numbers[einer].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2 + one.getWidth() * 1;
			numbers[einer].draw(c);
			
			// Meter
			raisins.x = numbers[einer].x + one.getWidth();
			raisins.draw(c);
			
		} else if (score >= 100) {
			
			// Hunderter
			numbers[hunderter].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2 - one.getWidth() * 1.5;
			numbers[hunderter].draw(c);
					
			// Zehner
			numbers[zehner].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2 - one.getWidth() / 2;
			numbers[zehner].draw(c);
					
			// Einer
			numbers[einer].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2 + one.getWidth() * 0.5;
			numbers[einer].draw(c);
			
			// Meter
			raisins.x = numbers[einer].x + one.getWidth();
			raisins.draw(c);
			
		} else if (score >= 10) {
			
			// Zehner
			numbers[zehner].x -= one.getWidth();
			numbers[zehner].draw(c);
				
			// Einer
			numbers[einer].x = Automat.automat_green.x + Automat.automat_green.getWidth() / 2;
			numbers[einer].draw(c);
			
			// Meter
			raisins.x = numbers[einer].x + one.getWidth();
			raisins.draw(c);
			
		} else if (score >= 0) {
			
			// Einer
			numbers[score].draw(c);
			
			// Meter
			raisins.x = numbers[score].x + one.getWidth();
			raisins.draw(c);
			
		}
		
	}
	
}