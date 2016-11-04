package knab.pl.smartwalk.ui.views;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

import knab.pl.smartwalk.model.SensorNames;

public class FootView extends View {

    private Path path;
    private Paint paint;
    private Rect footBackground;
    private int margin = 20;
    private Map<String, Rect> rectangles = new HashMap<>();
    private boolean isRight;
    private int w;
    private int h;

    public FootView(Context context, boolean isRight) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.rgb(220, 120, 90));
        paint.setStrokeWidth(150);
        this.isRight = isRight;
    }


    @Override
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.w = w;
        this.h = h;
        footBackground = new Rect(margin, margin, w - margin, h - margin);

        updateSensorViewsSizes();
    }

    private void updateSensorViewsSizes() {
        for (String sensorName : SensorNames.sensorNames) {
            rectangles.put(sensorName, getRectByName(sensorName));
        }
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(footBackground, paint);
//        canvas.drawCircle(500, 500, 300, paint);
//        canvas.drawText("This is bloody good!", canvas.getWidth()/2, canvas.getHeight()/2, paint);
//        canvas.drawRect(canvas.getClipBounds(), paint);
    }

    public int calculateColorFromPressure(int pressure) {
        float R = (255 * pressure) / 100;
        float G = 0;
        float B = (255 * (100 - pressure)) / 100;
        return Color.rgb((int) R, (int) G, (int) B);
    }

    private Rect getRectByName(String name) {
        int width = 3 * w / 10 - 23 * w / 100;
        int height = h / 15 - h / 50;
        switch (name) {
            case SensorNames.RIGHT_TOP:
                return new Rect(23 * w / 100, h / 50, 23 * w / 100 + width, h / 50 + height);
            case SensorNames.RIGHT_ONE_INNER:
                return new Rect(11 * w / 80, 2 * h / 13, 11 * w / 80 + width, 2 * h / 13 + height);
            case SensorNames.RIGHT_ONE_OUTER:
                return new Rect(18 * w / 43, 2 * h / 13, 18 * w / 43 + width, 2 * h / 13 + height);
            case SensorNames.RIGHT_TWO_INNER:
                return new Rect(14 * w / 81, 27 * h / 74, 14 * w / 81 + width, 27 * h / 74 + height);
            case SensorNames.RIGHT_TWO_OUTER:
                return new Rect(7 * w / 15, 28 * h / 77, 7 * w / 15 + width, 28 * h / 77 + height);
            case SensorNames.RIGHT_THREE_INNER:
                return new Rect(16 * w / 79, 17 * h / 25, 16 * w / 79 + width, 17 * h / 25 + height);
            case SensorNames.RIGHT_THREE_OUTER:
                return new Rect(37 * w / 84, 18 * h / 26, 37 * w / 84 + width, 18 * h / 26 + height);
            case SensorNames.RIGHT_BOTTOM:
                return new Rect(18 * w / 43 - width, 46 * h / 55, 18 * w / 43, 46 * h / 55 + height);
        }
        return new Rect(0, 0, 0, 0);
    }
}
