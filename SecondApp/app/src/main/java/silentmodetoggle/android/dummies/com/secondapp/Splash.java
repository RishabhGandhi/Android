package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by ADMINN on 17-09-2016.
 */
public class Splash extends Activity {

    MediaPlayer oursong;
    @Override
    protected void onCreate(Bundle Rishabh) {

        super.onCreate(Rishabh);
        setContentView(R.layout.splash);
        oursong=MediaPlayer.create(Splash.this,R.raw.song);
        oursong.start();
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent open = new Intent("android.intent.action.Menu");
                    startActivity(open);

                }

            }
        };
        timer.start();
    }
    public void onPause(){
        super.onPause();
        oursong.release();
        finish();
    }
}

