package knab.pl.smartwalk.model;


import java.util.ArrayList;
import java.util.List;

public class SignalAdapterTestHelper {

    public static List<SignalSampleSensorWrapper> provideMessage() {
        List<SignalSampleSensorWrapper> message = new ArrayList<>();

        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_TOP, 1, 2));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_ONE_OUTER, 1, 3));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_ONE_INNER, 1, 4));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_TWO_OUTER, 1, 5));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_TWO_INNER, 1, 6));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_THREE_INNER, 1, 7));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_THREE_OUTER, 1, 8));
        message.add(new SignalSampleSensorWrapper(SensorNames.LEFT_BOTTOM, 1, 9));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_TOP, 1, 2));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_ONE_OUTER, 1, 3));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_ONE_INNER, 1, 4));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_TWO_OUTER, 1, 5));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_TWO_INNER, 1, 6));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_THREE_INNER, 1, 7));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_THREE_OUTER, 1, 8));
        message.add(new SignalSampleSensorWrapper(SensorNames.RIGHT_BOTTOM, 1, 9));

        return message;
    }
}
