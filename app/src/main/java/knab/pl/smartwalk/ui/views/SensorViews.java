package knab.pl.smartwalk.ui.views;


import android.content.Context;
import android.graphics.Rect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import knab.pl.smartwalk.model.SensorNames;

public class SensorViews {
    private Map<String, RectangleView> sensorViews = new HashMap<>();
    private Context context;


    public SensorViews(Context context, int h, int w) {
        this.context = context;
        setupViews(h, w);
    }

    private void setupViews(int h, int w) {
        int width = 3 * w / 10 - 23 * w / 100;
        int height = h / 15 - h / 50;
        sensorViews.put(SensorNames.RIGHT_TOP, new RectangleView(context, getRectByName(SensorNames.RIGHT_TOP, h, w), 50));
        sensorViews.put(SensorNames.RIGHT_ONE_INNER, new RectangleView(context, getRectByName(SensorNames.RIGHT_ONE_INNER, h, w), 25));
        sensorViews.put(SensorNames.RIGHT_ONE_OUTER, new RectangleView(context, getRectByName(SensorNames.RIGHT_ONE_OUTER, h, w), 5));
        sensorViews.put(SensorNames.RIGHT_TWO_INNER, new RectangleView(context, getRectByName(SensorNames.RIGHT_TWO_INNER, h, w), 32));
        sensorViews.put(SensorNames.RIGHT_TWO_OUTER, new RectangleView(context, getRectByName(SensorNames.RIGHT_TWO_OUTER, h, w), 14));
        sensorViews.put(SensorNames.RIGHT_THREE_INNER, new RectangleView(context, getRectByName(SensorNames.RIGHT_THREE_INNER, h, w), 44));
        sensorViews.put(SensorNames.RIGHT_THREE_OUTER, new RectangleView(context, getRectByName(SensorNames.RIGHT_THREE_OUTER, h, w), 12));
        sensorViews.put(SensorNames.RIGHT_BOTTOM, new RectangleView(context, getRectByName(SensorNames.RIGHT_BOTTOM, h, w), 100));
    }

    public List<RectangleView> getViews() {
        List<RectangleView> result = new ArrayList<>();
        result.addAll(sensorViews.values());
        return result;
    }

    public void update(int h, int w) {
        for (Map.Entry<String, RectangleView> view : sensorViews.entrySet()) {
            view.getValue().setRect(getRectByName(view.getKey(), h, w));
        }
    }

    private Rect getRectByName(String name, int h, int w) {
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
        return new Rect(0,0,0,0);
    }
}
