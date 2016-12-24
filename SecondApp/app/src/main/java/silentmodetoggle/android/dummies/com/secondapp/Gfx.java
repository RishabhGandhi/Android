package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by ADMINN on 24-09-2016.
 */
public class Gfx extends Activity {

    Mybringback ourview;
    PowerManager.WakeLock wm;

    public void onCreate(Bundle instance){

        PowerManager pm=(PowerManager)getSystemService(Context.POWER_SERVICE);
        wm=pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"whatever");
        super.onCreate(instance);
        ourview = new Mybringback(this);
        wm.acquire();
        setContentView(ourview);

    }
    public void onPause(){
        super.onPause();
        wm.release();

    }
}
