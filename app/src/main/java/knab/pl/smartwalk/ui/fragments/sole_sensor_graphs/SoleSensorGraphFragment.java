package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import javax.inject.Inject;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SensorNames;
import knab.pl.smartwalk.ui.fragments.sole_sensor_graphs.mvp.SoleSensorGraphMVP;

public class SoleSensorGraphFragment extends Fragment implements SoleSensorGraphMVP.View{

    private GraphView rightBottomGraphView;
    private RangeSeekBar<Integer> rangeSeekBar;
    private static final int SEEKBAR_MAX = 60;
    private static final int SEEKBAR_MIN = 0;

    @Inject
    SoleSensorGraphMVP.Presenter presenter;

    private View upRangeBar;

    public SoleSensorGraphFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SmartWalkApplication) getActivity().getApplication()).provideDependencyInjector().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sole_sensor_graph, container, false);
        bindGraphViews(rootView);
        setUpGraphViews();
        setUpRangeBar(rootView);

        return rootView;
    }

    private void bindGraphViews(View rootView) {
        rightBottomGraphView = (GraphView) rootView.findViewById(R.id.bottom_right_graph);
        rightBottomGraphView.setTitle(SensorNames.RIGHT_BOTTOM);
        rightBottomGraphView.getViewport().setScalable(true);
        rightBottomGraphView.getViewport().setXAxisBoundsManual(true);
        rightBottomGraphView.getViewport().setYAxisBoundsManual(true);
        rightBottomGraphView.getViewport().setMinX(0);
        rightBottomGraphView.getViewport().setMaxX(1000);
        rightBottomGraphView.getViewport().setMinY(0);
        rightBottomGraphView.getViewport().setMaxY(5000);

    }

    private void setUpGraphViews() {
        presenter.getPointsInTime(SEEKBAR_MIN, SEEKBAR_MAX);
    }

    public void setUpRangeBar(View rootView) {
        rangeSeekBar = (RangeSeekBar) rootView.findViewById(R.id.range_bar);
        rangeSeekBar.setRangeValues(SEEKBAR_MIN, SEEKBAR_MAX);
        rangeSeekBar.setTextAboveThumbsColorResource(R.color.colorPrimaryDark);

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                presenter.getPointsInTime(minValue, maxValue);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void updateGraphForSensor(DataPoint[] data, String sensorName) {
        rightBottomGraphView.removeAllSeries();
        rightBottomGraphView.addSeries(new LineGraphSeries(data));
        rightBottomGraphView.getViewport().setMinX(data[0].getX());
        rightBottomGraphView.getViewport().setMaxX(data[data.length-1].getX());
    }
}
