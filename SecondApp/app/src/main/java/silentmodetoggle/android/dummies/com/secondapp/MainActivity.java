package silentmodetoggle.android.dummies.com.secondapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter;
    Button add,sub;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=0;
        sub=(Button)findViewById(R.id.subtract);
        add=(Button)findViewById(R.id.add);
        display=(TextView)findViewById(R.id.textView);
        final RelativeLayout relative = (RelativeLayout)findViewById(R.id.layout);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                display.setText("Your total is "+counter);
                relative.setBackgroundColor((int) Color.parseColor("#ffa500"));

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                display.setText("Your total is "+counter);
                relative.setBackgroundColor((int) Color.parseColor("#ff6666"));
            }
        });
    }
}
