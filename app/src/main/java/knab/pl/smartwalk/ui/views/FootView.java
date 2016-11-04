package knab.pl.smartwalk.ui.views;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import knab.pl.smartwalk.model.SensorNames;

public class FootView extends View {

    private Paint paint;
    private Rect footBackground;
    private int margin = 20;
    private Map<String, Rect> rectangles = new HashMap<>();
    private Map<String, Paint> rectanglePaints = new HashMap<>();
    private boolean isRight;
    private int w;
    private int h;
    List<String> sensorNames;

    public FootView(Context context, boolean isRight) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.rgb(220, 120, 90));
        paint.setStrokeWidth(150);
        this.isRight = isRight;
        if (isRight) {
            sensorNames = SensorNames.rightSensorNames;
        } else {
            sensorNames = SensorNames.leftSensorNames;
        }
        for (String name : sensorNames) {
            rectanglePaints.put(name, new Paint());
            rectanglePaints.get(name).setColor(calculateColorFromPressure(22));
        }
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
        for (String sensorName : sensorNames) {
            rectangles.put(sensorName, getRectByName(sensorName));
        }
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(footBackground, paint);
        for (Map.Entry<String, Rect> rect : rectangles.entrySet()) {
            canvas.drawRect(rect.getValue(), rectanglePaints.get(rect.getKey()));
        }
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
                return new Rect(margin,
                        margin,
                        w / 5 + margin,
                        h / 10 + margin);
            case SensorNames.RIGHT_ONE_INNER:
                return new Rect(margin,
                        margin + h / 7,
                        margin + w / 5,
                        margin + h / 7 + h / 7);
            case SensorNames.RIGHT_ONE_OUTER:
                return new Rect(margin + w / 2,
                        margin + h / 7,
                        margin + w / 2 + w / 5,
                        margin + h / 7 + h / 8);
            case SensorNames.RIGHT_TWO_INNER:
                return new Rect(margin + (w / 5) / 2,
                        margin + 3 * h / 7,
                        margin + (w / 5) / 2 + w / 5,
                        margin + 3 * h / 7 + h / 10);
            case SensorNames.RIGHT_TWO_OUTER:
                return new Rect(margin + (w / 5) / 2 + w / 5,
                        margin + 2 * h / 7,
                        margin + (w / 5) / 2 + 2 * w / 5,
                        margin + 2 * h / 7 + h / 6);
            case SensorNames.RIGHT_THREE_INNER:
                return new Rect(margin + (w / 5) / 2,
                        margin + 27 * h / 42,
                        margin + (w / 5) / 2 + w / 5,
                        margin + 27 * h / 42 + h / 10);
            case SensorNames.RIGHT_THREE_OUTER:
                return new Rect(margin + (w / 5) / 2 + w / 5 + w / 20,
                        margin + 27 * h / 42,
                        margin + (w / 5) / 2 + w / 20 + 2 * w / 5,
                        margin + 27 * h / 42 + h / 10);
            case SensorNames.RIGHT_BOTTOM:
                return new Rect(margin + (w / 5) / 2 + w / 15,
                        margin + 27 * h / 42 + h / 10 + h / 100,
                        margin + (w / 5) / 2 + w / 15 + 7 * w / 20,
                        margin + 27 * h / 42 + 2 * h / 10);
            case SensorNames.LEFT_TOP:
                return new Rect(w - w / 5 - margin,
                        margin,
                        w - margin,
                        h / 10 + margin);
            case SensorNames.LEFT_ONE_INNER:
                return new Rect(w - (margin + w / 5),
                        margin + h / 7,
                        w - margin,
                        margin + h / 7 + h / 7);
            case SensorNames.LEFT_ONE_OUTER:
                return new Rect(
                        w - (margin + w / 2 + w / 5),
                        margin + h / 7,
                        w - (margin + w / 2),
                        margin + h / 7 + h / 8);
            case SensorNames.LEFT_TWO_INNER:
                return new Rect(w - (margin + (w / 5) / 2 + w / 5),
                        margin + 3 * h / 7,
                        w - (margin + (w / 5) / 2),
                        margin + 3 * h / 7 + h / 10);
            case SensorNames.LEFT_TWO_OUTER:
                return new Rect(w - (margin + (w / 5) / 2 + 2 * w / 5),
                        margin + 2 * h / 7,
                        w - (margin + (w / 5) / 2 + w / 5),
                        margin + 2 * h / 7 + h / 6);
            case SensorNames.LEFT_THREE_INNER:
                return new Rect(w- (margin + (w / 5) / 2 + w / 5),
                        margin + 27 * h / 42,
                        w - (margin + (w / 5) / 2),
                        margin + 27 * h / 42 + h / 10);
            case SensorNames.LEFT_THREE_OUTER:
                return new Rect(w - (margin + (w / 5) / 2 + w / 20 + 2 * w / 5),
                        margin + 27 * h / 42,
                        w - (margin + (w / 5) / 2 + w / 5 + w / 20),
                        margin + 27 * h / 42 + h / 10);
            case SensorNames.LEFT_BOTTOM:
                return new Rect(w - (margin + (w / 5) / 2 + w / 15 + 7 * w / 20),
                        margin + 27 * h / 42 + h / 10 + h / 100,
                        w - (margin + (w / 5) / 2 + w / 15),
                        margin + 27 * h / 42 + 2 * h / 10);
        }
        return new Rect(0, 0, 0, 0);
    }
}
