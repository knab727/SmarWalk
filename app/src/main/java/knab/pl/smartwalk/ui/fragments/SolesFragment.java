package knab.pl.smartwalk.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;
import knab.pl.smartwalk.ui.views.RectangleView;
import knab.pl.smartwalk.ui.views.SensorViews;

public class SolesFragment extends Fragment {

    int h, w;
    SensorViews sensorViews;

    @Inject
    SignalAdapter signalAdapter;

    public SolesFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_soles, container, false);
        final ImageView iv = (ImageView) rootView.findViewById(R.id.right_foot);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rect);
        addSensorViews(relativeLayout);
        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                h = iv.getMeasuredHeight();
                w = iv.getMeasuredWidth();
                sensorViews.update(h, w);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void addSensorViews(RelativeLayout relativeLayout) {
        sensorViews = new SensorViews(this.getContext(), h, w);
        for (RectangleView rectangleView : sensorViews.getViews()) {
            relativeLayout.addView(rectangleView);
        }
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
