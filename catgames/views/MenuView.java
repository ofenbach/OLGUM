package catgames.views;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import catgames.engine.MainActivity;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Button;
import catgames.framework.Image;
import catgames.framework.Sound;
import catgames.handler.CloudHandler;
import catgames.handler.OlgumFont;
import catgames.hud.Automat;
import catgames.hud.HighscoreHUD;
import catgames.hud.RaisinsHUD;
import catgames.player.Olgum;

public class MenuView extends View {

	// Background
	Image background;
	
	// HUD
	OlgumFont olgumfont;
	Automat automat;
	
	// Scores
	HighscoreHUD highscoreHUD;
	RaisinsHUD raisinshud;
	
	// Buttons
	Button startbutton;
	Button arrowleft, arrowright;
	Image hat;
	Button soundOn, soundOff;
	
	// Clouds
	CloudHandler cloudanimator;
	
	// Player
	Olgum olgum;
	
	// Animation
	boolean vanishanimation;
	boolean introanimation;
	
	// Sounds
	Sound buttonsound;
	
	/* CONSTRUKTOR */
	public MenuView() {
		super(MainActivity.getContext());

		// Loading
		background = new Image(R.drawable.backdrop);
		olgum = new Olgum();
		olgumfont = new OlgumFont();
		automat = new Automat();
		startbutton = new Button(R.drawable.startbutton);
		hat = new Image(R.drawable.hatbutton);
		arrowleft = new Button(R.drawable.arrowleft);
		arrowright = new Button(R.drawable.arrowright);
		highscoreHUD = new HighscoreHUD();
		raisinshud = new RaisinsHUD();
		cloudanimator = new CloudHandler();
		soundOn = new Button(R.drawable.soundon);
		soundOff = new Button(R.drawable.soundoff);
		buttonsound = new Sound(R.raw.buttonsound);

		// Scaling
		background.scaleFullscreen();
		startbutton.scale();
		hat.scale();
		arrowleft.scale();
		arrowright.scale();
		soundOn.scale(2);
		soundOff.scale(2);

	}
	
	
	/* LOADING */
	public void load() {

		// Var Reset
		vanishanimation = false;
		introanimation = true;
		this.setAlpha(0);
		
		// Position
		startbutton.x = Settings.getScreenWidth() * ((double) 330 / 480);
		startbutton.setYtoMiddle();
		hat.x = startbutton.x + startbutton.getWidth() / 2 - hat.getWidth() / 2;
		hat.y = Settings.getScreenHeight() * ((double) 216 / 360);
		arrowleft.x = hat.x - arrowleft.getWidth() * 0.65;
		arrowleft.y = hat.y + hat.getHeight() * 0.1;
		arrowright.x = hat.x + arrowright.getWidth() * 0.3;
		arrowright.y = startbutton.y + startbutton.getHeight() * 0.7;
		soundOn.x = Settings.getScreenWidth() - soundOn.getWidth();
		soundOn.y = Settings.getScreenHeight() - soundOff.getHeight();
		soundOff.x = Settings.getScreenWidth() - soundOn.getWidth();
		soundOff.y = Settings.getScreenHeight() - soundOff.getHeight();

		// Olgum Reset
		olgum.load();
		
	}
	
	
	/* ON DRAW */
	@SuppressWarnings("static-access")
	public void onDraw(Canvas c) {

		// Intro Animation
		if (this.getAlpha() < 1 && introanimation) {
			this.setAlpha((float) (this.getAlpha() + 0.1));
		} else {
			introanimation = false;
		}
		
		// Draw
		background.draw(c);
		cloudanimator.animate(c);
		olgum.animate(c);
		arrowright.draw(c);
		startbutton.draw(c);
		arrowleft.draw(c);
		hat.draw(c);
		olgumfont.animate(c);
		automat.draw(c);
		highscoreHUD.draw(c);
		highscoreHUD.drawScore(c);
		raisinshud.animateMenu(c);
		if (!Settings.sound) { soundOn.draw(c); } else { soundOff.draw(c); }

		// Pfeildurchsichtbarkeit
		if (Settings.currenthat == Settings.hats_unlocked) {
			arrowright.setAlpha(100);
		} else {
			arrowright.setAlpha(255);
		}
		if (Settings.currenthat == 0) {
			arrowleft.setAlpha(100);
		} else {
			arrowleft.setAlpha(255);
		}
		
		// Animation Check
		if (vanishanimation) {
			
			// Vanish
			this.setAlpha((float) (this.getAlpha() - 0.1));
			
			// Change Check
			if (this.getAlpha() <= 0) {

				// Change to Game
				MainActivity.setScreen("GameView");
				
			}
			
		}
		
		// Repeat
		invalidate();
		
	}
	
	
	/* TOUCH */
	public boolean onTouchEvent(MotionEvent e) {
		
		// Touch Down
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
		
		// Start Button
		if (startbutton.isPressed(e) && this.getAlpha() >= 1) {
			
			// Start Vanish Animation
			vanishanimation = true;
			
			// Sound
			if (!Settings.sound) {
				buttonsound.play();
			}
			
		}
		
		// Arrows
		if (arrowleft.isPressed(e) && Settings.currenthat >= 1) {
			
			// Sound
			if (!Settings.sound) {
				buttonsound.play();
			}
			
			// Change Hat
			Settings.currenthat --;
			
		}
		if (arrowright.isPressed(e) && Settings.getHatsUnlocked() > Settings.currenthat) {
			
			// Sound
			if (!Settings.sound) {
				buttonsound.play();
			}
			
			// Change Hat
			Settings.currenthat ++;
			
		}
		
		// Automat Check
		automat.touch(e);
		
		// Double Click Prevent
		boolean pressed = false;
		
		// SoundButtons
		if (soundOn.isPressed(e) && pressed == false && Settings.sound == false) {
			
			// Sound Off
			Settings.sound = true;
			Settings.setSound(true);
			
			// Stop Music
			MainActivity.backgroundmusic.pause();
			
			pressed = true;
		}
		if (soundOff.isPressed(e) && pressed == false && Settings.sound == true) {
			
			// Sound On
			Settings.sound = false;
			Settings.setSound(false);
			
			// Resume Music
			MainActivity.backgroundmusic.play();
			
		}
		
		}
		
		
		return true;
	}
	
}