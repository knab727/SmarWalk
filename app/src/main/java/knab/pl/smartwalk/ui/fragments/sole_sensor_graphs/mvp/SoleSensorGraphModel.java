package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import knab.pl.smartwalk.model.SensorNames;
import knab.pl.smartwalk.model.SignalAdapter;
import knab.pl.smartwalk.model.SignalSample;

public class SoleSensorGraphModel implements SoleSensorGraphMVP.Model {

    private SignalAdapter signalAdapter;

    @Inject
    public SoleSensorGraphModel(SignalAdapter signalAdapter) {
        this.signalAdapter = signalAdapter;
    }


    @Override
    public List<SignalSample> getSamplesForSensor(String sensorName) {
        return signalAdapter.getSignalForSensor(sensorName);
    }

    @Override
    public List<SignalSample> getSamplesForSensorInTime(long milisStart, long milisEnd, String sensorName) {
        return signalAdapter.getSignalInMilis(milisStart, milisEnd, sensorName);
    }

    @Override
    public Map<String, List<SignalSample>> getSamples() {
        return signalAdapter.getSignals();
    }

}
