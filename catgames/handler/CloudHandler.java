package catgames.handler;

import android.graphics.Canvas;
import catgames.friendly.Cloud;

public class CloudHandler {
	
	// Every 0.5 secs -> Timer = 30
	int timer;
	
	// Random cloud
	Cloud cloud0, cloud1, cloud2, cloud3, cloud4, cloud5, cloud6, cloud7, cloud8, cloud9;
	public Cloud clouds[] = new Cloud[10];
	
	
	/* CONSTRUCTOR */
	public CloudHandler() {
		
		// Loading
		cloud0 = new Cloud();
		cloud1 = new Cloud();
		cloud2 = new Cloud();
		cloud3 = new Cloud();
		cloud4 = new Cloud();
		cloud5 = new Cloud();
		cloud6 = new Cloud();
		cloud7 = new Cloud();
		cloud8 = new Cloud();
		cloud9 = new Cloud();
		clouds[0] = cloud0;
		clouds[1] = cloud1;
		clouds[2] = cloud2;
		clouds[3] = cloud3;
		clouds[4] = cloud4;
		clouds[5] = cloud5;
		clouds[6] = cloud6;
		clouds[7] = cloud7;
		clouds[8] = cloud8;
		clouds[9] = cloud9;
		
	}
	
	
	/* ANIMATE */
	public void animate(Canvas c) {
		
		// Draw
		for (int i = 0; i<=9; i++) {
			clouds[i].animate(c);
		}
		
	}
	
}