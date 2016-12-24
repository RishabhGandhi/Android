package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ADMINN on 05-10-2016.
 */

public class Sqlview extends Activity {
    public void onCreate(Bundle instances) {
        super.onCreate(instances);
        setContentView(R.layout.slview);
        TextView tv=(TextView)findViewById(R.id.getinfos);
        Hotornot ht=new Hotornot(this);
        ht.open();
        String x=ht.getdata();
        ht.close();
        tv.setText(x);
    }
    }

