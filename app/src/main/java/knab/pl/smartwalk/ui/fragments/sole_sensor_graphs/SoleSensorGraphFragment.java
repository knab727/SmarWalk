package knab.pl.smartwalk.ui.fragments.sole_sensor_graphs;

import android.content.Context;
import android.hardware.Sensor;
import android.net.Uri;
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
import knab.pl.smartwalk.model.SignalAdapter;

public class SoleSensorGraphFragment extends Fragment {

    private GraphView rightBottomGraphView;
    private RangeSeekBar rangeSeekBar;

    @Inject
    SignalAdapter signalAdapter;
    private View upRangeBar;

    public SoleSensorGraphFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SmartWalkApplication) getActivity().getApplication()).getSignalComponent().inject(this);
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
        rightBottomGraphView.getViewport().setXAxisBoundsManual(true);
        rightBottomGraphView.getViewport().setMinX(0);
        rightBottomGraphView.getViewport().setMaxX(500);

    }

    private void setUpGraphViews() {
        rightBottomGraphView.addSeries(new LineGraphSeries(signalAdapter.getSignalAsDataPoints(SensorNames.RIGHT_BOTTOM)));
    }

    public void setUpRangeBar(View rootView) {
        rangeSeekBar = (RangeSeekBar) rootView.findViewById(R.id.range_bar);
        rangeSeekBar.setRangeValues(0, 60);
        rangeSeekBar.setTextAboveThumbsColorResource(R.color.colorPrimaryDark);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
