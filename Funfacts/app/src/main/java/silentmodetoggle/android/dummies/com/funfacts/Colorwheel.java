package silentmodetoggle.android.dummies.com.funfacts;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by ADMINN on 10-09-2016.
 */
public class Colorwheel {
    public String[] mcolor = {"#000000",
            "#FF0000",
            "#800000",
            "#FFFF00",
            "#FFFF00",
            "#f18685",
            "#008516",
            "#ffa388",
            "#967760",
            "#a74b59",
            "#252e42",
    };
    public int getcolor() {

        String color = "";
        Random randomgenerator = new Random();
        int randomnumber = randomgenerator.nextInt(mcolor.length);
        color = mcolor[randomnumber];
        int colorasint= Color.parseColor(color);
        return colorasint;
    }
}



