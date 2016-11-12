package knab.pl.smartwalk.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Aisolug on 12.11.2016.
 */

public class BackgroundView extends View{

int width, height;

    public BackgroundView(Context context, int w, int h) {

        super(context);
        width = w;
        height = h;
    }


    public void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(Color.rgb(180,180,180));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawRect(0,0,width/3,height/5, paint);
        canvas.drawRect(100,100,300,300,paint);
    }



    }
