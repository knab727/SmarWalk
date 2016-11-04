package knab.pl.smartwalk.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SensorNames {
    public static final String RIGHT_TOP = "RIGHT_TOP";
    public static final String RIGHT_ONE_OUTER = "RIGHT_ONE_OUTER";
    public static final String RIGHT_ONE_INNER = "RIGHT_ONE_INNER";
    public static final String RIGHT_TWO_OUTER = "RIGHT_TWO_OUTER";
    public static final String RIGHT_TWO_INNER = "RIGHT_TWO_INNER";
    public static final String RIGHT_THREE_INNER = "RIGHT_THREE_INNER";
    public static final String RIGHT_THREE_OUTER = "RIGHT_THREE_OUTER";
    public static final String RIGHT_BOTTOM = "RIGHT_BOTTOM";

    public static final String LEFT_TOP = "LEFT_TOP";
    public static final String LEFT_ONE_OUTER = "LEFT_ONE_OUTER";
    public static final String LEFT_ONE_INNER = "LEFT_ONE_INNER";
    public static final String LEFT_TWO_OUTER = "LEFT_TWO_OUTER";
    public static final String LEFT_TWO_INNER = "LEFT_TWO_INNER";
    public static final String LEFT_THREE_INNER = "LEFT_THREE_INNER";
    public static final String LEFT_THREE_OUTER = "LEFT_THREE_OUTER";
    public static final String LEFT_BOTTOM = "LEFT_BOTTOM";

    public static final List<String> sensorNames = Arrays.asList(SensorNames.LEFT_BOTTOM, SensorNames.LEFT_ONE_INNER, SensorNames.LEFT_ONE_OUTER,
            SensorNames.LEFT_TWO_INNER, SensorNames.LEFT_TWO_OUTER, SensorNames.LEFT_THREE_INNER, SensorNames.LEFT_THREE_OUTER,
            SensorNames.LEFT_TOP, SensorNames.RIGHT_BOTTOM, SensorNames.RIGHT_ONE_INNER, SensorNames.RIGHT_ONE_OUTER,
            SensorNames.RIGHT_TWO_INNER, SensorNames.RIGHT_TWO_OUTER, SensorNames.RIGHT_THREE_INNER, SensorNames.RIGHT_THREE_OUTER,
            SensorNames.RIGHT_TOP);

    public static final List<String> rightSensorNames = Arrays.asList(SensorNames.RIGHT_BOTTOM, SensorNames.RIGHT_ONE_INNER, SensorNames.RIGHT_ONE_OUTER,
            SensorNames.RIGHT_TWO_INNER, SensorNames.RIGHT_TWO_OUTER, SensorNames.RIGHT_THREE_INNER, SensorNames.RIGHT_THREE_OUTER,
            SensorNames.RIGHT_TOP);

    public static final List<String> leftSensorNames = Arrays.asList(SensorNames.LEFT_BOTTOM, SensorNames.LEFT_ONE_INNER, SensorNames.LEFT_ONE_OUTER,
            SensorNames.LEFT_TWO_INNER, SensorNames.LEFT_TWO_OUTER, SensorNames.LEFT_THREE_INNER, SensorNames.LEFT_THREE_OUTER,
            SensorNames.LEFT_TOP);
}
