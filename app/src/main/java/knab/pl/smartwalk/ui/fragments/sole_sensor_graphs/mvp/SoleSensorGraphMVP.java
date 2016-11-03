package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp;


import com.jjoe64.graphview.series.DataPoint;

import java.util.List;
import java.util.Map;

import knab.pl.smartwalk.model.SignalSample;

public interface SoleSensorGraphMVP {

    interface Model {
        Map<String, List<SignalSample>> getSamples();
        List<SignalSample> getSamplesForSensor(String sensorName);
        List<SignalSample> getSamplesForSensorInTime(long milisStart, long milisEnd, String sensorName);
    }

    interface Presenter {
        void getPointsInTime(int startSecond, int endSecond);
    }

    interface View {
        void updateGraphForSensor(DataPoint[] data, String sensorName);
    }
}
