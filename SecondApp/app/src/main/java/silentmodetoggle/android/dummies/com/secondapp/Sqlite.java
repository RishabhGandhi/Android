package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by ADMINN on 05-10-2016.
 */

public class Sqlite extends Activity implements View.OnClickListener {

    EditText name1,hotness,rowid;
    Button update, view,getinfo,edit,delete;
   // private Dialog d;

    public void onCreate(Bundle instances){

        super.onCreate(instances);
        setContentView(R.layout.slite);
        name1=(EditText)findViewById(R.id.editText7);
        rowid=(EditText)findViewById(R.id.rowidno);
        hotness=(EditText)findViewById(R.id.hotedit);
        update=(Button)findViewById(R.id.update);
        view =(Button)findViewById(R.id.view);
        edit =(Button)findViewById(R.id.editentry);
        delete =(Button)findViewById(R.id.deleteentry);
        getinfo =(Button)findViewById(R.id.getinfo);
        update.setOnClickListener(this);
        view.setOnClickListener(this);
        getinfo.setOnClickListener(this);
        delete.setOnClickListener(this);
        edit.setOnClickListener(this);



    }
    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.update:
                    Boolean diditwork=true;
                    try {
                        String name = name1.getText().toString();
                        String hotnes = hotness.getText().toString();
                        Hotornot entry = new Hotornot(this);
                        entry.open();
                        entry.entry(name, hotnes);
                        entry.close();
                    }catch (Exception e){
                        diditwork=false;
                        Dialog d=new Dialog(this);
                        d.setTitle("Damnnn!!");
                        TextView tv=new TextView(this);
                        tv.setText(e.toString());
                        d.setContentView(tv);
                        d.show();
                    }finally {
                        if(diditwork){
                            Dialog d=new Dialog(this);
                            d.setTitle("Hech yea!!");
                            TextView tv=new TextView(this);
                            tv.setText("Success");
                            d.setContentView(tv);
                            d.show();
                        }
                    }
                break;
            case R.id.view:
                Intent vv=new Intent("android.intent.action.SqlView");
                startActivity(vv);

                break;
            case R.id.getinfo:
                String s=rowid.getText().toString();
                Long l=Long.parseLong(s);
                Hotornot ht=new Hotornot(this);
                ht.open();
                String name=ht.getname(l);
                String hotnesss=ht.gethotness(l);
                ht.close();
                name1.setText(name);
                hotness.setText(hotnesss);

                break;
            case R.id.deleteentry:
                String s11=rowid.getText().toString();
                Long l11=Long.parseLong(s11);
                Hotornot ht11=new Hotornot(this);
                ht11.open();
                ht11.deleteentry(l11);
                ht11.close();
                break;
            case R.id.editentry:
                String s1=rowid.getText().toString();
                Long l1=Long.parseLong(s1);
                String names = name1.getText().toString();
                String hotnes1 = hotness.getText().toString();
                Hotornot ht1=new Hotornot(this);
                ht1.open();
                ht1.updateentry(l1,names,hotnes1);
                ht1.close();


                break;
        }
    }
}
