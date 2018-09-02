package catgames.player;

import java.util.Random;
import android.graphics.Canvas;
import catgames.engine.R;
import catgames.engine.Settings;
import catgames.framework.Image;

public class Hat {

	// Hats
	Image hat0, hat1, hat2, hat3, hat4, hat5, hat6, hat7, hat8, hat9, hat10;
	Image hat11, hat12, hat13, hat14, hat15, hat16, hat17, hat18;
	Image hat19, hat20, hat21, hat22, hat23, hat24, hat25, hat26;
	Image hat27, hat28, hat29, hat30, hat31, hat32, hat33, hat34, hat35;
	Image[] hat = new Image[36];
	
	/* CONSTRUCTOR */
	public Hat() {
		
		// Loading
		hat0 = new Image(R.drawable.hat1);
		hat1 = new Image(R.drawable.hat2);
		hat2 = new Image(R.drawable.hat3);
		hat3 = new Image(R.drawable.hat4);
		hat4 = new Image(R.drawable.hat5);
		hat5 = new Image(R.drawable.hat6);
		hat6 = new Image(R.drawable.hat7);
		hat7 = new Image(R.drawable.hat8);
		hat8 = new Image(R.drawable.hat9);
		hat9 = new Image(R.drawable.hat10);
		hat10 = new Image(R.drawable.hat11);
		hat11 = new Image(R.drawable.hat12);
		hat12 = new Image(R.drawable.hat13);
		hat13 = new Image(R.drawable.hat14);
		hat14 = new Image(R.drawable.hat15);
		hat15 = new Image(R.drawable.hat16);
		hat16 = new Image(R.drawable.hat17);
		hat17 = new Image(R.drawable.hat18);
		hat18 = new Image(R.drawable.hat19);
		hat19 = new Image(R.drawable.hat20);
		hat20 = new Image(R.drawable.hat21);
		hat21 = new Image(R.drawable.hat22);
		hat22 = new Image(R.drawable.hat23);
		hat23 = new Image(R.drawable.hat24);
		hat24 = new Image(R.drawable.hat25);
		hat25 = new Image(R.drawable.hat26);
		hat26 = new Image(R.drawable.hat27);
		hat27 = new Image(R.drawable.hat28);
		hat28 = new Image(R.drawable.hat29);
		hat29 = new Image(R.drawable.hat30);
		hat30 = new Image(R.drawable.hat31);
		hat31 = new Image(R.drawable.hat32);
		hat32 = new Image(R.drawable.hat33);
		hat33 = new Image(R.drawable.hat34);
		hat34 = new Image(R.drawable.hat35);
		hat35 = new Image(R.drawable.hat36);

		
		// Array
		hat[0] = hat0;
		hat[1] = hat1;
		hat[2] = hat2;
		hat[3] = hat3;
		hat[4] = hat4;
		hat[5] = hat5;
		hat[6] = hat6;
		hat[7] = hat7;
		hat[8] = hat8;
		hat[9] = hat9;
		hat[10] = hat10;
		hat[11] = hat11;
		hat[12] = hat12;
		hat[13] = hat13;
		hat[14] = hat14;
		hat[15] = hat15;
		hat[16] = hat16;
		hat[17] = hat17;
		hat[18] = hat18;
		hat[19] = hat19;
		hat[20] = hat20;
		hat[21] = hat21;
		hat[22] = hat22;
		hat[23] = hat23;
		hat[24] = hat24;
		hat[25] = hat25;
		hat[26] = hat26;
		hat[27] = hat27;
		hat[28] = hat28;
		hat[29] = hat29;
		hat[30] = hat30;
		hat[31] = hat31;
		hat[32] = hat32;
		hat[33] = hat33;
		hat[34] = hat34;
		hat[35] = hat35;

		// Scaling
		for (int i = 0; i <= 35; i++) {
			hat[i].scale();
		}
		
		// Position
		
	}
	
	
	/* ANIMATE */
	public void animate(Canvas c) {
		
		// Right Angle
		double angle = Olgum.olgum.getAngle();
		Olgum.olgum.setRotation(0);
		
		// Right Position
		double v = -Olgum.olgum.getHeight() / 2 - hat[Settings.currenthat].getHeight() / 2;
		double vX = v * Math.sin(Math.toRadians(angle));
		double vY = v * Math.cos(Math.toRadians(angle));
		hat[Settings.currenthat].x = Olgum.olgum.x + Olgum.olgum.getWidth() / 2 - hat[Settings.currenthat].getWidth() / 2 - vX;
		hat[Settings.currenthat].y = (Olgum.olgum.y + Olgum.olgum.getHeight() / 2 - hat[Settings.currenthat].getHeight() / 2) + vY;
		
		// HAT FIXES (eine Stueck wieder zurueck)
		if (Settings.currenthat == 0) {
			double distance = hat[Settings.currenthat].getHeight() / 2.5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat0.x -= distanceX;
			hat0.y += distanceY;
		}
		if (Settings.currenthat == 1) {
			double distance = hat[Settings.currenthat].getHeight() / 2.5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat1.x -= distanceX;
			hat1.y += distanceY;
		}
		if (Settings.currenthat == 2) {
			double distance = hat[Settings.currenthat].getHeight() / 1.3;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat2.x -= distanceX;
			hat2.y += distanceY;
		}
		if (Settings.currenthat == 3) {
			double distance = hat[Settings.currenthat].getHeight() / 5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat3.x -= distanceX;
			hat3.y += distanceY;
		}
		if (Settings.currenthat == 4) {
			double distance = hat[Settings.currenthat].getHeight() / 5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat4.x -= distanceX;
			hat4.y += distanceY;
		}
		if (Settings.currenthat == 5) {
			double distance = hat[Settings.currenthat].getHeight() / 4.3;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat5.x -= distanceX;
			hat5.y += distanceY;
		}
		if (Settings.currenthat == 6) {
			double distance = hat[Settings.currenthat].getHeight() / 5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat6.x -= distanceX;
			hat6.y += distanceY;
		}
		if (Settings.currenthat == 7) {
			double distance = hat[Settings.currenthat].getHeight() / 2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat7.x -= distanceX;
			hat7.y += distanceY;
		}
		if (Settings.currenthat == 8) {
			double distance = hat[Settings.currenthat].getHeight() / 2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat8.x -= distanceX;
			hat8.y += distanceY;
		}
		if (Settings.currenthat == 9) {
			double distance = hat[Settings.currenthat].getHeight() / 1.25;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat9.x -= distanceX;
			hat9.y += distanceY;
		}
		if (Settings.currenthat == 10) {
			double distance = hat[Settings.currenthat].getHeight() / 8;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat10.x -= distanceX;
			hat10.y += distanceY;
		}
		if (Settings.currenthat == 11) {
			double distance = hat[Settings.currenthat].getHeight();
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat11.x -= distanceX;
			hat11.y += distanceY;
		}
		if (Settings.currenthat == 12) {
			double distance = hat[Settings.currenthat].getHeight() / 4;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat12.x -= distanceX;
			hat12.y += distanceY;
		}
		if (Settings.currenthat == 13) {
			double distance = hat[Settings.currenthat].getHeight() / 3;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat13.x -= distanceX;
			hat13.y += distanceY;
		}
		if (Settings.currenthat == 14) {
			double distance = hat[Settings.currenthat].getHeight() / 8;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat14.x -= distanceX;
			hat14.y += distanceY;
		}
		if (Settings.currenthat == 15) {
			double distance = hat[Settings.currenthat].getHeight();
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat15.x -= distanceX;
			hat15.y += distanceY;
		}
		if (Settings.currenthat == 16) {
			double distance = hat[Settings.currenthat].getHeight();
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat16.x -= distanceX;
			hat16.y += distanceY;
		}
		if (Settings.currenthat == 17) {
			double distance = hat[Settings.currenthat].getHeight() / 1.7;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat17.x -= distanceX;
			hat17.y += distanceY;
		}
		if (Settings.currenthat == 18) {
			double distance = hat[Settings.currenthat].getHeight() / 1.8;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat18.x -= distanceX;
			hat18.y += distanceY;
		}
		if (Settings.currenthat == 19) {
			double distance = hat[Settings.currenthat].getHeight();
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat19.x -= distanceX;
			hat19.y += distanceY;
		}
		if (Settings.currenthat == 20) {
			double distance = hat[Settings.currenthat].getHeight() / 1.5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat20.x -= distanceX;
			hat20.y += distanceY;
		}
		if (Settings.currenthat == 21) {
			double distance = hat[Settings.currenthat].getHeight() / 4;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat21.x -= distanceX;
			hat21.y += distanceY;
		}
		if (Settings.currenthat == 22) {
			double distance = hat[Settings.currenthat].getHeight() / 4;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat22.x -= distanceX;
			hat22.y += distanceY;
		}
		if (Settings.currenthat == 23) {
			double distance = hat[Settings.currenthat].getHeight() / 4;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat23.x -= distanceX;
			hat23.y += distanceY;
		}
		if (Settings.currenthat == 24) {
			double distance = hat[Settings.currenthat].getHeight() / 5;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat24.x -= distanceX;
			hat24.y += distanceY;
		}
		if (Settings.currenthat == 25) {
			double distance = hat[Settings.currenthat].getHeight() / 8;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat25.x -= distanceX;
			hat25.y += distanceY;
		}
		if (Settings.currenthat == 26) {
			double distance = hat[Settings.currenthat].getHeight() * 0.95;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat26.x -= distanceX;
			hat26.y += distanceY;
		}
		if (Settings.currenthat == 27) {
			double distance = hat[Settings.currenthat].getHeight() * 0.2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat27.x -= distanceX;
			hat27.y += distanceY;
		}
		if (Settings.currenthat == 28) {
			double distance = hat[Settings.currenthat].getHeight() * 0.3;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat28.x -= distanceX;
			hat28.y += distanceY;
		}
		if (Settings.currenthat == 29) {
			double distance = hat[Settings.currenthat].getHeight() * 0.2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat29.x -= distanceX;
			hat29.y += distanceY;
		}
		if (Settings.currenthat == 30) {
			double distance = hat[Settings.currenthat].getHeight() * 0.45;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat30.x -= distanceX;
			hat30.y += distanceY;
		}
		if (Settings.currenthat == 31) {
			double distance = hat[Settings.currenthat].getHeight() * 0.2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat31.x -= distanceX;
			hat31.y += distanceY;
		}
		if (Settings.currenthat == 32) {
			double distance = hat[Settings.currenthat].getHeight() * 0.2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat32.x -= distanceX;
			hat32.y += distanceY;
		}
		if (Settings.currenthat == 33) {
			double distance = hat[Settings.currenthat].getHeight() * 0.25;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat33.x -= distanceX;
			hat33.y += distanceY;
		}
		if (Settings.currenthat == 34) {
			double distance = hat[Settings.currenthat].getHeight() * 0.2;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat34.x -= distanceX;
			hat34.y += distanceY;
		}
		if (Settings.currenthat == 35) {
			double distance = hat[Settings.currenthat].getHeight() * 0.6;
			double distanceX = distance * Math.sin(Math.toRadians(angle));
			double distanceY = distance * Math.cos(Math.toRadians(angle));
			hat35.x -= distanceX;
			hat35.y += distanceY;
		}
		
		// Angle Reset
		Olgum.olgum.setRotation(angle);
		hat[Settings.currenthat].setRotation(angle);

		// Draw
		hat[Settings.currenthat].draw(c);
		
	}
	
}