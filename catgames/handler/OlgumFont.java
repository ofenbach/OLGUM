package catgames.handler;

import android.graphics.Canvas;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;

public class OlgumFont {

	// Files
	Image o,l,g,u,m;
	
	// Animation
	int wobbletimer_o, wobbletimer_l, wobbletimer_g, wobbletimer_u, wobbletimer_m; 			// 16 = Peak
	double wobblespeed_o, wobblespeed_l, wobblespeed_g, wobblespeed_u, wobblespeed_m;
	int latenztimer;
	boolean firsttime_l, firsttime_g, firsttime_u, firsttime_m;
	
	/* CONSTRUCTOR */
	public OlgumFont() {
		
		// Loading
		o = new Image(R.drawable.font_o);
		l = new Image(R.drawable.font_l);
		g = new Image(R.drawable.font_g);
		u = new Image(R.drawable.font_u);
		m = new Image(R.drawable.font_m);
		
		wobblespeed_o = 8 * (double) Settings.getScreenHeight() / 1440;
		
		// Scaling
		o.scale();
		l.scale();
		g.scale();
		u.scale();
		m.scale();
		
		// Position
		o.x = Settings.getScreenWidth() * 0.45;
		o.y = Settings.getScreenHeight() * 0.125;
		l.x = o.x + o.getWidth() * 1.15;
		l.y = o.y;
		g.x = l.x + l.getWidth() + o.getWidth() * 0.1;
		g.y = o.y;
		u.x = g.x + g.getWidth() + o.getWidth() * 0.1;
		u.y = o.y;
		m.x = u.x + u.getWidth() + o.getWidth() * 0.1;
		m.y = o.y;
		
		
	}
	
	
	/* ANIMATION */
	public void animate(Canvas c) {
		
		// Draw
		o.draw(c);
		l.draw(c);
		g.draw(c);
		u.draw(c);
		m.draw(c);

		// Upanimation
		if (wobbletimer_o < 16 && wobbletimer_o >= 0) {
			// Update
			wobblespeed_o -= (double) Settings.getScreenHeight() / 1440;
		} else if (wobbletimer_o >= -16 && wobbletimer_o < 0) {				// Downanimation
			// Update
			wobblespeed_o += (double) Settings.getScreenHeight() / 1440;
		}
		
		// Upanimation
		if (latenztimer > 5) {
		if (wobbletimer_l < 16 && wobbletimer_l >= 0) {
			// Update
			wobblespeed_l -= (double) Settings.getScreenHeight() / 1440;
		} else if (wobbletimer_l >= -16 && wobbletimer_l < 0) {				// Downanimation
			// Update
			wobblespeed_l += (double) Settings.getScreenHeight() / 1440;
		}
		}
		
		// Upanimation
		if (latenztimer > 10) {
		if (wobbletimer_g < 16 && wobbletimer_g >= 0) {
			// Update
			wobblespeed_g -= (double) Settings.getScreenHeight() / 1440;
		} else if (wobbletimer_g >= -16 && wobbletimer_g < 0) {				// Downanimation
			// Update
			wobblespeed_g += (double) Settings.getScreenHeight() / 1440;
		}
		}
		
		// Upanimation
		if (latenztimer > 15) {
		if (wobbletimer_u < 16 && wobbletimer_u >= 0) {
			// Update
			wobblespeed_u -= (double) Settings.getScreenHeight() / 1440;
		} else if (wobbletimer_u >= -16 && wobbletimer_u < 0) {				// Downanimation
			// Update
			wobblespeed_u += (double) Settings.getScreenHeight() / 1440;
		}
		}
		
		// Upanimation
		if (latenztimer > 20) {
		if (wobbletimer_m < 16 && wobbletimer_m >= 0) {
			// Update
			wobblespeed_m -= (double) Settings.getScreenHeight() / 1440;
		} else if (wobbletimer_m >= -16 && wobbletimer_m < 0) {				// Downanimation
			// Update
			wobblespeed_m += (double) Settings.getScreenHeight() / 1440;
		}
		}
		
		// Down Peak
		if (wobbletimer_o >= 15) {
			wobbletimer_o = -17;
		}
		if (wobbletimer_l >= 15) {
			wobbletimer_l = -17;
		}
		if (wobbletimer_g >= 15) {
			wobbletimer_g = -17;
		}
		if (wobbletimer_u >= 15) {
			wobbletimer_u = -17;
		}
		if (wobbletimer_m >= 15) {
			wobbletimer_m = -17;
		}
		
		// Timer Update
		wobbletimer_o ++;
		if (latenztimer > 5) { wobbletimer_l ++; }
		if (latenztimer == 5) { firsttime_l = true; }
		if (latenztimer > 10) { wobbletimer_g ++;}
		if (latenztimer == 10) { firsttime_g = true; }
		if (latenztimer > 15) { wobbletimer_u ++; }
		if (latenztimer == 15) { firsttime_u = true; }
		if (latenztimer > 20) { wobbletimer_m ++; }
		if (latenztimer == 20) { firsttime_m = true; }
		latenztimer ++;
		
		
		if (firsttime_l) {
			// Speed
			wobblespeed_l = 8 * (double) Settings.getScreenHeight() / 1440;
			firsttime_l = false;
		}
		if (firsttime_g) {
			// Speed
			wobblespeed_g = 8 * (double) Settings.getScreenHeight() / 1440;
			firsttime_g = false;
		}
		if (firsttime_u) {
			// Speed
			wobblespeed_u = 8 * (double) Settings.getScreenHeight() / 1440;
			firsttime_u = false;
		}
		if (firsttime_m) {
			// Speed
			wobblespeed_m = 8 * (double) Settings.getScreenHeight() / 1440;
			firsttime_m = false;
		}
		
		// Update
		o.y += wobblespeed_o;
		l.y += wobblespeed_l;
		g.y += wobblespeed_g;
		u.y += wobblespeed_u;
		m.y += wobblespeed_m;
		
	}
	
}