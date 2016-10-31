package knab.pl.smartwalk.ui.fragments;

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

import javax.inject.Inject;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SensorNames;
import knab.pl.smartwalk.model.SignalAdapter;

public class SoleSensorGraphFragment extends Fragment {

    private GraphView rightBottomGraphView;

    @Inject
    SignalAdapter signalAdapter;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
