package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ADMINN on 21-09-2016.
 */
public class Data extends Activity implements View.OnClickListener {

    EditText et;
    Button sa,safr;
    TextView tv;
    String yh;
    public void onCreate(Bundle instance){

        super.onCreate(instance);
        setContentView(R.layout.get);
        initialise();
    }

    private void initialise() {
        et=(EditText) findViewById(R.id.editText);
        sa=(Button)findViewById(R.id.bsa);
        safr=(Button)findViewById(R.id.bsafr);
        tv=(TextView)findViewById(R.id.textView7);
        sa.setOnClickListener(this);
        safr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bsa:
                String bread=et.getText().toString();
                Bundle bb=new Bundle();
                bb.putString("key",bread);
                Intent a=new Intent(Data.this,OpenedClass.class);
                a.putExtras(bb);
                startActivity(a);
                break;
            case R.id.bsafr:
                Intent i= new Intent(Data.this,OpenedClass.class);
                startActivityForResult(i,0);
                break;
        }

    }
    public void onActivityResult(int a,int b,Intent qwerty){
        super.onActivityResult(a, b, qwerty);
        if(b==RESULT_OK)
        {
            Bundle n =qwerty.getExtras();
            yh = n.getString("anss");
            tv.setText(yh);
        }

    }
}
