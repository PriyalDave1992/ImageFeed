package practice.com.simpleimagefeed;

import android.app.Activity;
import practice.com.simpleimagefeed.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;

import practice.com.simpleimagefeed.ImageFeed.ImageFeedActivity;

public class SplashActivity extends Activity {

    private Thread mSplashThread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        final SplashActivity splashScreen = this;

        mSplashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(5000);
                    }
                } catch (InterruptedException ignored) {
                }

                finish();
                Intent intent = new Intent();
                intent.setClass(splashScreen, ImageFeedActivity.class);
                startActivity(intent);
            }
        };

        mSplashThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt) {
        if (evt.getAction() == MotionEvent.ACTION_DOWN) {
            synchronized (mSplashThread) {
                mSplashThread.notifyAll();
            }
        }
        return true;
    }
}
