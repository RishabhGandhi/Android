package silentmodetoggle.android.dummies.com.secondapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ADMINN on 18-09-2016.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "TextPlay", "Email", "Camera", "Data", "Gfx", "Gfxsurface", "Browser","Sqlite"};

    @Override
    public void onCreate(Bundle x) {

        super.onCreate(x);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_expandable_list_item_1, classes));
    }

    public void onListItemClick(ListView l, View v, int position, long d) {

        super.onListItemClick(l, v, position, d);
        String cheese = classes[position];
        try {
            Class ourClass = Class.forName("silentmodetoggle.android.dummies.com.secondapp."+cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
   /* public boolean onCreateOptionsMenu(android.view.Menu menu){

        super.onCreateOptionsMenu(menu);
        MenuInflater xyz=getMenuInflater();
        xyz.inflate(R.menu.coolmenu,menu);
        return true;
    }*/
}
