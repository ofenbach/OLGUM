package catgames.engine;

import android.content.SharedPreferences;

public class Settings {

	// Screensize
	public static int screenwidth;
	public static int screenheight;
	
	// Gamesaves
	public static int hats_unlocked = getHatsUnlocked();
	public static int highscore = getHighscore();
	public static int raisins = getRaisins();
	public static int currenthat = 0;
	
	// Settings
	public static boolean sound = getSoundSave();		// INVERTED
	
	/* GET FUNCTIONS */
	public static int getScreenHeight() {
		return screenheight;
	}
	public static int getScreenWidth() {
		return screenwidth;
	}

	/* PAUSED */
	public static boolean gamePaused = false;
	
	
	/** GAME SAVES */
	
	/* GET FUNCTIONS */
	public static int getHighscore() {
		SharedPreferences pref = MainActivity.context.getSharedPreferences("highscore", 0);
        return pref.getInt("HIGHSCORE", 0);
	}
	public static int getRaisins() {
		SharedPreferences pref = MainActivity.context.getSharedPreferences("raisins", 0);
       	return pref.getInt("RAISINS", 0);
	}
	public static int getHatsUnlocked() {
		SharedPreferences pref = MainActivity.context.getSharedPreferences("hats", 0);
        return pref.getInt("HATS", 0);
	}
	public static boolean getSoundSave() {
		SharedPreferences pref = MainActivity.context.getSharedPreferences("sound", 0);
		return pref.getBoolean("SOUND", false);
	}
	
	/* SET FUNCTIONS */
	public static void setHighscore(int score) {
		
		// Highscore Check
		if (score > highscore) {
			
			// Update Highscore
			highscore = score;
			
			// SharedPreferences
	        SharedPreferences pref = MainActivity.context.getSharedPreferences("highscore", 0);
	        SharedPreferences.Editor editor = pref.edit();
	        editor.putInt("HIGHSCORE", highscore);
	        editor.commit();
			
		}
		
	}
	public static void setSound(boolean soundon) {
		SharedPreferences pref = MainActivity.context.getSharedPreferences("sound", 0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("SOUND", soundon);
		editor.commit();
		sound = soundon;
	}
	public static void addRaisins(int raisinscore) {
		
		// Update Score
		raisins = getRaisins() + raisinscore;
		
		// SharedPreferences
        SharedPreferences pref = MainActivity.context.getSharedPreferences("raisins", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("RAISINS", raisins);
        editor.commit();
		
	}
	public static void addNewHat() {
		
		// Update Hats
		hats_unlocked ++;
		
		// SharedPreferences
        SharedPreferences pref = MainActivity.context.getSharedPreferences("hats", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("HATS", hats_unlocked);
        editor.commit();
		
	}
	
}