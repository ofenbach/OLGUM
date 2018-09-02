package catgames.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;

public class IntroView extends View {

	// Background
	Image logo;
	
	// Timer
	boolean firsttime;
	int timer;
	
	/* CONSTRUKTOR */
	public IntroView() {
		super(MainActivity.getContext());
		
		// Loading
		logo = new Image(R.drawable.logo);
		firsttime = true;
		timer = 0;
		
	}
	
	
	/* ON DRAW */
	public void onDraw(Canvas c) {
		
		// Draw
		logo.draw(c);
		
		// Timer
		if (timer > 30) {
			
			// Delete
			logo.delete();

			// Change View
			MainActivity.layout.removeView(this);
			MainActivity.layout.setBackgroundColor(Color.WHITE);
			MainActivity.setScreen("MenuView");
			
		}
		timer ++;
		
		// Firsttime
		if (firsttime) {
			
			// Update Parameter
			Settings.screenwidth = c.getWidth();
			Settings.screenheight = c.getHeight();

			// Loading
			MainActivity.menuview = new MenuView();
			MainActivity.gameview = new GameView();
			
			// Scaling
			logo.scaleFullscreen();
			
			firsttime = false;
		}
		
		
		// Repeat
		invalidate();
	}
	
}