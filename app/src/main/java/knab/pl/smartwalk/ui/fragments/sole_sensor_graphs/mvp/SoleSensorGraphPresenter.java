package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp;


import com.jjoe64.graphview.series.DataPoint;

import java.util.List;
import java.util.Map;

import knab.pl.smartwalk.model.SensorNames;
import knab.pl.smartwalk.model.SignalSample;

public class SoleSensorGraphPresenter implements SoleSensorGraphMVP.Presenter {

    private SoleSensorGraphMVP.Model model;
    private SoleSensorGraphMVP.View view;

    public SoleSensorGraphPresenter(SoleSensorGraphModel model, SoleSensorGraphMVP.View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getPointsInTime(int startSecond, int endSecond) {
        List<String> sensorNames = SensorNames.sensorNames;
        for(String name : sensorNames) {
            List<SignalSample> signalSamples = model.getSamplesForSensorInTime(startSecond * 1000, endSecond * 1000, name);
            DataPoint points[] = new DataPoint[signalSamples.size()];
            int i = 0;
            for (SignalSample sample : signalSamples) {
                points[i++] = new DataPoint(sample.milis, sample.value);
            }
            view.updateGraphForSensor(points, name);
        }
    }
}
