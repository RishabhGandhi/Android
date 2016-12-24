package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by ADMINN on 21-09-2016.
 */
public class OpenedClass extends Activity  implements View.OnClickListener,RadioGroup.OnCheckedChangeListener {

    TextView ques,ans;
    Button returndata;
    RadioGroup grp1;
    String gotbread;
    String x;

    public void onCreate(Bundle instance){

        super.onCreate(instance);
        setContentView(R.layout.send);
        initialise();
       //Bundle getbread=getIntent().getExtras();
        //gotbread=getbread.getString("key");
        //ques.setText(gotbread);

    }

    private void initialise() {
        ques=(TextView)findViewById(R.id.tvq);
        ans=(TextView)findViewById(R.id.hell);
        returndata=(Button)findViewById(R.id.rbutton);
        returndata.setOnClickListener(this);
        grp1=(RadioGroup)findViewById(R.id.group1);
        grp1.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent p=new Intent();
        Bundle b=new Bundle();
        b.putString("anss",x);
        p.putExtras(b);
        setResult(RESULT_OK,p);
        finish();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){

            case R.id.good:
                x="1";
                break;
            case R.id.bad:
                x="12";
                break;
            case R.id.both:
                x="123";
                break;
        }
        ans.setText(x);

    }
}