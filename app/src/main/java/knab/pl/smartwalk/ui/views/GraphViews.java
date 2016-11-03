package knab.pl.smartwalk.ui.views;


import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;
import java.util.Map;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.model.SensorNames;

public class GraphViews {
    private Map<String, GraphView> views = new HashMap<>();
    private Map<String, Integer> viewsBindings = new HashMap<>();
    private View rootView;

    public GraphViews(View rootView) {
        this.rootView = rootView;
        BindViewsToSensors();
        setupGraphViews();
    }

    private void BindViewsToSensors() {
        viewsBindings.put(SensorNames.RIGHT_BOTTOM, R.id.bottom_right_graph);
        viewsBindings.put(SensorNames.RIGHT_ONE_INNER, R.id.inner_1_right_graph);
        viewsBindings.put(SensorNames.RIGHT_ONE_OUTER, R.id.outer_1_right_graph);
        viewsBindings.put(SensorNames.RIGHT_TWO_INNER, R.id.inner_2_right_graph);
        viewsBindings.put(SensorNames.RIGHT_TWO_OUTER, R.id.outer_2_right_graph);
        viewsBindings.put(SensorNames.RIGHT_THREE_INNER, R.id.inner_3_right_graph);
        viewsBindings.put(SensorNames.RIGHT_THREE_OUTER, R.id.outer_3_right_graph);
        viewsBindings.put(SensorNames.RIGHT_TOP, R.id.top_right_graph);
    }

    private void setupGraphViews() {
        for (String sensorName : SensorNames.sensorNames) {
            Integer id = viewsBindings.get(sensorName);
            if(id == null)
                continue;
            GraphView graphView = (GraphView) rootView.findViewById(viewsBindings.get(sensorName));
            graphView.setTitle(sensorName);
            graphView.getViewport().setScalable(true);
            graphView.getViewport().setXAxisBoundsManual(true);
            graphView.getViewport().setYAxisBoundsManual(true);
            graphView.getViewport().setMinX(0);
            graphView.getViewport().setMaxX(1000);
            graphView.getViewport().setMinY(0);
            graphView.getViewport().setMaxY(5000);
            views.put(sensorName, graphView);
        }
    }

    public void updateDataForGraphView(DataPoint[] data, String sensorName) {
        GraphView graphView = views.get(sensorName);
        if(graphView == null)
            return;
        graphView.removeAllSeries();
        graphView.addSeries(new LineGraphSeries(data));
        graphView.getViewport().setMinX(data[0].getX());
        graphView.getViewport().setMaxX(data[data.length-1].getX());
    }
}
