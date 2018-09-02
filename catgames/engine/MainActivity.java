package catgames.engine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.Random;

import catgames.framework.Music;
import catgames.views.GameView;
import catgames.views.IntroView;
import catgames.views.MenuView;

public class MainActivity extends Activity {

    // Layout
    public static RelativeLayout layout;

    // Views
    public static IntroView introview;
    public static MenuView menuview;
    public static GameView gameview;
    public static String currentscreen;

    // Kontext
    public static Context context;

    // Music
    public static Music backgroundmusic;

    // Public Random
    public static Random random;


    /* ON CREATE */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Parameter Update
        context = this;
        random = new Random();

        // Layout
        layout = new RelativeLayout(this);
        setContentView(layout);
        layout.setBackgroundColor(Color.BLACK);

        // Views
        introview = new IntroView();

        // IntroView
        setScreen("IntroView");

        // Ad
        //AdBuddiz.setPublisherKey("c0a23817-0be7-4b0a-b753-c5931f76c776");
        //AdBuddiz.cacheAds(this);

        // Music
        backgroundmusic = new Music(R.raw.backgroundmusic);
        backgroundmusic.setVolume((float) 0.4);
        if (!Settings.sound) {
            backgroundmusic.play();
        }

    }


    /* ON PAUSE */
    protected void onPause() {
        super.onPause();

        // Music Pause
        backgroundmusic.pause();

    }

    /* ON RESUME */
    protected void onResume() {
        super.onResume();

        // Musik Resume
        if (!Settings.sound) {
            backgroundmusic.play();
        }

    }


    /* GET FUNCTIONS */
    public static Context getContext() {
        return context;
    }

    /* SET FUNCTIONS */
    public static void setScreen(String screen) {

        // Update Screen
        currentscreen = screen;

        // IntroView
        if (screen == "IntroView") {

            // Update Views
            layout.addView(introview);

        }

        // MenuView
        if (screen == "MenuView") {

            // MenuView
            layout.removeAllViews();
            menuview.load();
            menuview.setAlpha(0);
            layout.addView(menuview);

        }

        if (screen == "GameView") {

            // GameView
            layout.removeAllViews();
            gameview.load();
            gameview.setAlpha(0);
            layout.addView(gameview);

        }

    }

}