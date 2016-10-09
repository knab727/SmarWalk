package knab.pl.smartwalk.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignalAdapter {
    private List<SignalSampleSensorWrapper> rawSignal = new ArrayList<>();
    private Map<String, List<SignalSample>> sensorSignals = new HashMap<>();

    public SignalAdapter() {
        sensorSignals.put(SensorNames.LEFT_TOP, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_ONE_OUTER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_ONE_INNER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_TWO_OUTER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_TWO_INNER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_THREE_OUTER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_THREE_INNER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.LEFT_BOTTOM, new ArrayList<SignalSample>());

        sensorSignals.put(SensorNames.RIGHT_TOP, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_ONE_OUTER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_ONE_INNER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_TWO_OUTER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_TWO_INNER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_THREE_OUTER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_THREE_INNER, new ArrayList<SignalSample>());
        sensorSignals.put(SensorNames.RIGHT_BOTTOM, new ArrayList<SignalSample>());
    }

    public void addMessage(SignalSampleSensorWrapper message) {
        rawSignal.add(message);
        adapt(message);
    }

    private void adapt(SignalSampleSensorWrapper message) {
        SignalSample sample = new SignalSample(message.milis, message.value);
        sensorSignals.get(message.sensorName).add(sample);
    }

    public void clearAdapter() {
        rawSignal.clear();
        sensorSignals.clear();
    }

    public List<SignalSample> getSignalForSensor(String sensorName) {
        return sensorSignals.get(sensorName);
    }
}
