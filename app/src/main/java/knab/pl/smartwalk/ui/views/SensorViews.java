package knab.pl.smartwalk.ui.views;


import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import knab.pl.smartwalk.model.SensorNames;

public class SensorViews {
    private Map<String, RectangleView> sensorViews = new HashMap<>();


    public SensorViews(Context context, int h, int w) {
        int width = 3 * w / 10 - 23 * w / 100;
        int height = h / 15 - h / 50;
        sensorViews.put(SensorNames.RIGHT_TOP, new RectangleView(context,23 * w / 100, h / 50, 23 * w / 100 + width, h / 50 + height, 50 ));
        sensorViews.put(SensorNames.RIGHT_ONE_INNER, new RectangleView(context,11 * w / 80, 2 * h / 13, 11 * w / 80 + width, 2 * h / 13 + height, 25 ));
        sensorViews.put(SensorNames.RIGHT_ONE_OUTER, new RectangleView(context,18 * w / 43, 2 * h / 13, 18 * w / 43 + width, 2 * h / 13 + height, 5 ));
        sensorViews.put(SensorNames.RIGHT_TWO_INNER, new RectangleView(context,14 * w / 81, 27 * h / 74, 14 * w / 81 + width, 27 * h / 74 + height, 32 ));
        sensorViews.put(SensorNames.RIGHT_TWO_OUTER, new RectangleView(context,7 * w / 15, 28 * h / 77, 7 * w / 15 + width, 28 * h / 77 + height, 14 ));
        sensorViews.put(SensorNames.RIGHT_THREE_INNER, new RectangleView(context,16 * w / 79, 17 * h / 25, 16 * w / 79 + width, 17 * h / 25 + height, 44 ));
        sensorViews.put(SensorNames.RIGHT_THREE_OUTER, new RectangleView(context,37 * w / 84, 18 * h / 26, 37 * w / 84 + width, 18 * h / 26 + height, 12 ));
        sensorViews.put(SensorNames.RIGHT_BOTTOM, new RectangleView(context,18 * w / 43 - width, 46 * h / 55, 18 * w / 43, 46 * h / 55 + height, 100 ));
    }

    public List<RectangleView> getViews() {
        List<RectangleView> result = new ArrayList<>();
        result.addAll(sensorViews.values());
        return result;
    }
}
