package catgames.framework;

import android.media.AudioManager;
import android.media.SoundPool;
import catgames.engine.MainActivity;

public class Sound {

	// Soundpool
	SoundPool soundPool;
	
	// Path
	int path;
	
	
	/* KONSTRUKTOR */
	@SuppressWarnings("deprecation")
	public Sound(int sound_direction) {
		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
		this.path = soundPool.load(MainActivity.getContext(), sound_direction, 1);
	}
	
	
	/* PLAY */
	public void play() {
		soundPool.play(path, 1, 1, 0, 0, 1);
	}

	/* VOLUME */
	public void setVolume(double procent) {
		soundPool.setVolume(path, (float) procent, (float) procent);
	}

	/* DELETE */
	public void delete() {
		soundPool.unload(path);
	}
	
}