package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.IOException;
import java.io.InputStream;

import static silentmodetoggle.android.dummies.com.secondapp.R.mipmap.splash_launcher;

/**
 * Created by ADMINN on 21-09-2016.
 */
public class Camera extends Activity implements View.OnClickListener {

    ImageView images;
    Intent i;
    Button b;
    ImageButton ib;
    final static int captureData=0;
    Bitmap bmp;

    public void onCreate(Bundle x){

        super.onCreate(x);
        setContentView(R.layout.camera);
        initialise();
        InputStream is = getResources().openRawResource(R.mipmap.splash_launcher);
        bmp= BitmapFactory.decodeStream(is);

    }

    private void initialise() {

        images=(ImageView) findViewById(R.id.image);
        b=(Button)findViewById(R.id.but);
        ib=(ImageButton)findViewById(R.id.ib);
        b.setOnClickListener(this);
        ib.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.but:
                try {
                    getApplicationContext().setWallpaper(bmp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.ib:
                i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,captureData);
                break;
        }

    }
    public  void onActivityResult(int request,int result,Intent data){
        super.onActivityResult(request,result,data);
        if(result==RESULT_OK){
            Bundle extras=data.getExtras();
            bmp=(Bitmap)extras.get("data");
            images.setImageBitmap(bmp);

        }

    }
}
