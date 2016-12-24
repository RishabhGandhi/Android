package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Random;

/**
 * Created by ADMINN on 19-09-2016.
 */
public class TextPlay extends Activity implements View.OnClickListener{

    EditText edit;
    TextView textview;
    Button buton;
    ToggleButton togle;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        initialise();
        togle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (togle.isChecked()) {
                    edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    edit.setInputType(InputType.TYPE_CLASS_TEXT);
                }
            }
        });
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = edit.getText().toString();
                textview.setText(check);
                if (check.contentEquals("left")) {
                    textview.setGravity(Gravity.LEFT);
                } else if (check.contentEquals("right")) {
                    textview.setGravity(Gravity.RIGHT);
                } else if (check.contentEquals("center")) {
                    textview.setGravity(Gravity.CENTER);
                }else if (check.contentEquals("blue")) {
                    textview.setTextColor(Color.BLUE);
                }else if (check.contentEquals("wtf")){
                    textview.setText("wtf!!!!!");
                    Random crazy=new Random();
                    textview.setTextSize(crazy.nextInt(75));
                    textview.setTextColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));

                }else{
                    textview.setText("invalid");
                    textview.setGravity(Gravity.CENTER);
                }
                }

            });

    }

    private void initialise() {
        edit=(EditText)findViewById(R.id.et);
        textview=(TextView)findViewById(R.id.tt);
        buton=(Button)findViewById(R.id.bt);
        togle=(ToggleButton)findViewById(R.id.tb);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt:
                String check = edit.getText().toString();
                textview.setText(check);
                if (check.contentEquals("left")) {
                    textview.setGravity(Gravity.LEFT);
                } else if (check.contentEquals("right")) {
                    textview.setGravity(Gravity.RIGHT);
                } else if (check.contentEquals("center")) {
                    textview.setGravity(Gravity.CENTER);
                }else if (check.contentEquals("blue")) {
                    textview.setTextColor(Color.BLUE);
                }else if (check.contentEquals("wtf")){
                    textview.setText("wtf!!!!!");
                    Random crazy=new Random();
                    textview.setTextSize(crazy.nextInt(75));
                    textview.setTextColor(Color.rgb(crazy.nextInt(255),crazy.nextInt(255),crazy.nextInt(255)));

                }else{
                    textview.setText("invalid");
                    textview.setGravity(Gravity.CENTER);
                }
                break;
            case R.id.tb:
                if (togle.isChecked()) {
                    edit.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                } else {
                    edit.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                break;
        }
    }
}
