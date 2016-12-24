package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by ADMINN on 05-11-2016.
 */

public class Accelerometer extends Activity implements SensorEventListener {
    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
