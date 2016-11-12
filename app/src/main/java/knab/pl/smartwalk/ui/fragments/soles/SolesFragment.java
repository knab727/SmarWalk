package knab.pl.smartwalk.ui.fragments.soles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;
import knab.pl.smartwalk.ui.views.BackgroundView;
import knab.pl.smartwalk.ui.views.RectangleView;
import knab.pl.smartwalk.ui.views.SensorViews;

public class SolesFragment extends Fragment {

    int h, w;
    SensorViews sensorViews;
    BackgroundView backgroundView;



    @Inject
    SignalAdapter signalAdapter;

    public SolesFragment() {
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

        final View rootView = inflater.inflate(R.layout.fragment_soles, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rect);
        relativeLayout = (RelativeLayout) rootView.findViewById(R.id.container);

        addSensorViews(relativeLayout);
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
                {
            @Override
            public void onGlobalLayout() {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                h = rootView.getMeasuredHeight();
                w = rootView.getMeasuredWidth();
                sensorViews.update(h, w);
            }
        });
        relativeLayout.addView(new BackgroundView(getActivity(), h, w));
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
        //backgroundView = new BackgroundView(this.getContext());
        //backgroundView.invalidate();
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
