package silentmodetoggle.android.dummies.com.secondapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by ADMINN on 24-09-2016.
 */
public class Mybringback extends View {

    Bitmap gball;
    float changey;
    public Mybringback(Context context) {
        super(context);
        gball= BitmapFactory.decodeResource(getResources(), R.mipmap.splash_launcher);
        changey=0;
    }
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        canvas.drawBitmap(gball,canvas.getWidth()/2,changey,null);
        if(changey<canvas.getHeight())
        {
            changey+=10;
        }else
        {
            changey=0;
        }
        Rect rect=new Rect();
        rect.set(0,400,canvas.getWidth(),500);
        Paint paint=new Paint();
        paint.setColor(Color.GREEN);
        canvas.drawRect(rect,paint);
        invalidate();
    }
}
