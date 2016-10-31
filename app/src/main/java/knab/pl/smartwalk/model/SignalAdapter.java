package knab.pl.smartwalk.model;


import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static knab.pl.smartwalk.model.SensorNames.*;

public class SignalAdapter {
    private List<SignalSampleSensorWrapper> rawSignal = new ArrayList<>();
    private Map<String, List<SignalSample>> sensorSignals = new HashMap<>();

    public SignalAdapter() {
        sensorSignals.put(LEFT_TOP, new ArrayList<SignalSample>());
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

        mockSignal();
    }

    private void mockSignal() {
        int numberOfSteps = 20;
        int numberOfMillisPerStep = 60000 / numberOfSteps;
        for (int i = 0; i < numberOfSteps; i++) {
            mockStep(numberOfMillisPerStep, i);
        }
    }

    private void mockStep(int numberOfMillisPerStep, int offset) {
        for (int i = 0; i < numberOfMillisPerStep; i = i + 5) {
            long milis = offset * numberOfMillisPerStep + i;
            int sinValue = (int) Math.round(Math.abs(Math.sin(i)*Math.pow(2, 12)));
            int cosValue = (int) Math.round(Math.abs(Math.cos(i)*Math.pow(2, 12)));

            sensorSignals.get(LEFT_TOP).add(new SignalSample(milis, sinValue));
            sensorSignals.get(LEFT_ONE_OUTER).add(new SignalSample(milis, sinValue));
            sensorSignals.get(LEFT_ONE_INNER).add(new SignalSample(milis, sinValue));
            sensorSignals.get(LEFT_TWO_OUTER).add(new SignalSample(milis, cosValue));
            sensorSignals.get(LEFT_TWO_INNER).add(new SignalSample(milis, cosValue));
            sensorSignals.get(LEFT_THREE_OUTER).add(new SignalSample(milis, sinValue));
            sensorSignals.get(LEFT_THREE_INNER).add(new SignalSample(milis, sinValue));
            sensorSignals.get(LEFT_BOTTOM).add(new SignalSample(milis, cosValue));

            sensorSignals.get(RIGHT_TOP).add(new SignalSample(milis, cosValue));
            sensorSignals.get(RIGHT_ONE_OUTER).add(new SignalSample(milis, cosValue));
            sensorSignals.get(RIGHT_ONE_INNER).add(new SignalSample(milis, cosValue));
            sensorSignals.get(RIGHT_TWO_OUTER).add(new SignalSample(milis, sinValue));
            sensorSignals.get(RIGHT_TWO_INNER).add(new SignalSample(milis, sinValue));
            sensorSignals.get(RIGHT_THREE_OUTER).add(new SignalSample(milis, cosValue));
            sensorSignals.get(RIGHT_THREE_INNER).add(new SignalSample(milis, cosValue));
            sensorSignals.get(RIGHT_BOTTOM).add(new SignalSample(milis, sinValue));
        }
    }

    public List<SignalSample> getSignalInMilis(long start, long end, String sensorName) {
        List<SignalSample> result = new ArrayList<>();
        List<SignalSample> signalSamples = sensorSignals.get(sensorName);
        for(SignalSample sample : signalSamples) {
            if(sample.milis > start && sample.milis < end) {
                result.add(sample);
            }
        }
        return result;
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

    public DataPoint[] getSignalAsDataPoints(String sensorName) {
        List<SignalSample> signalSamples = sensorSignals.get(sensorName);
        DataPoint points[] = new DataPoint[signalSamples.size()];
        int i = 0;
        for(SignalSample sample : signalSamples) {
            points[i++] = new DataPoint(sample.milis, sample.value);
        }
        return points;
    }
}
