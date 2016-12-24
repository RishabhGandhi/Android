package silentmodetoggle.android.dummies.com.secondapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by ADMINN on 24-09-2016.
 */
public class Gfxsurface extends Activity implements View.OnTouchListener{

    Mybringsurface x;
    float x1,y1,sx,sy,fx,fy,dx,dy,anix,aniy,scx,scy;
    Bitmap test,plus;
    public  void onCreate(Bundle instance){

        super.onCreate(instance);
        x=new Mybringsurface(this);
        x.setOnTouchListener(this);
        setContentView(x);
        x1=0;
        y1=0;
        sx=0;
        sy=0;
        fx=0;
        fy=0;
        dx=dy=anix=aniy=scx=scy=0;
        test=BitmapFactory.decodeResource(getResources(),R.mipmap.splash_launcher);
       plus=BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

    }
    public void onPause(){
        super.onPause();
        x.pause();
    }
    public void onResume(){
        super.onResume();
        x.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x1=event.getX();
        y1=event.getY();
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                sx=event.getX();
                sy=event.getY();
                dx=dy=anix=aniy=scx=scy=0;
                fx=0;fy=0;
                break;
            case MotionEvent.ACTION_UP:
                fx=event.getX();
                fy=event.getY();
                dx=fx-sx;
                dy=fy-sy;
                scx=dx/30;
                scy=dy/30;
                x1=y1=0;
                break;

        }
        return true;
    }
    public class Mybringsurface extends SurfaceView implements Runnable {

        SurfaceHolder holder;
        Thread thread=null;
        boolean r=false;
        public Mybringsurface(Context context) {
            super(context);
            holder = getHolder();

        }
        public void pause(){
            r=false;
            while(true) {
                try {
                    thread.join();
                } catch (InterruptedException x) {
                    x.printStackTrace();
                }

                break;
            }
        }

        public void resume(){
            r=true;
            thread=new Thread(this);
            thread.start();
        }
        @Override
        public void run() {
            while(r){

                if(!holder.getSurface().isValid())
                    continue;

                Canvas canvas=holder.lockCanvas();
                canvas.drawRGB(200,150,42);
                if(x1!=0 && y1!=0)
                {
                    canvas.drawBitmap(test,x1-test.getWidth()/2,y1-test.getHeight()/2,null);
                }
                if(sx!=0 && sy!=0)
                {
                    canvas.drawBitmap(plus,sx-plus.getWidth()/2,sy-plus.getHeight()/2,null);
                }
                if(fx!=0 && fy!=0)
                {
                    canvas.drawBitmap(test,(fx-plus.getWidth()/2)-anix,(fy-plus.getHeight()/2)-aniy,null);
                    canvas.drawBitmap(plus,fx-plus.getWidth()/2,fy-plus.getHeight()/2,null);
                }
                anix=anix+scx;
                aniy=aniy+scy;
                holder.unlockCanvasAndPost(canvas);
            }

        }
    }

}
