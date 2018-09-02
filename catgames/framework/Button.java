package catgames.framework;

import android.view.MotionEvent;

/** Author: Tim Ofenbach **/

public class Button extends Image {

	/* CONSTRUCTOR */
	public Button(int path) { super(path); }

	/* TOUCH FUNCTION */
    public boolean isPressed(MotionEvent e) {
    	
    	// Touch coords
        int touchX = (int) e.getX();
        int touchY = (int) e.getY();
        
        // Return
        boolean pressed = false;
        
        // Hitbox check
        if (touchX > super.getX() && touchX < super.getX() + super.getWidth() && touchY > super.getY() && touchY < super.getY() + super.getHeight()) {
            pressed = true;
        } else {
            pressed = false;
        }
        
        return pressed;
    }
	
}