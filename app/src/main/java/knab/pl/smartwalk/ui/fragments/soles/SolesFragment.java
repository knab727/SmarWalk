package knab.pl.smartwalk.ui.fragments.soles;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import javax.inject.Inject;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;
import knab.pl.smartwalk.ui.views.FootView;
import knab.pl.smartwalk.ui.views.RectangleView;
import knab.pl.smartwalk.ui.views.SensorViews;

public class SolesFragment extends Fragment implements View.OnClickListener {

    int h, w;
    SensorViews sensorViews;
    private RangeSeekBar<Integer> rangeSeekBar;
    private Button startStopButton;
    private boolean isPlaying = false;
    private static final int SEEKBAR_MAX = 60;
    private static final int SEEKBAR_MIN = 0;

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
        View rootView = inflater.inflate(R.layout.fragment_soles, container, false);
        setupSeekBar(rootView);
        initButtons(rootView);
        initFeet((LinearLayout) rootView);
//        final ImageView iv = (ImageView) rootView.findViewById(R.id.right_foot);
//        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rect);
//        addSensorViews(relativeLayout);
//        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                h = iv.getMeasuredHeight();
//                w = iv.getMeasuredWidth();
//                sensorViews.update(h, w);
//            }
//        });
        return rootView;
    }

    private void initFeet(LinearLayout rootView) {
        LinearLayout canvas = (LinearLayout) rootView.findViewById(R.id.canvas_layout);
        FootView leftFoot = new FootView(this.getContext(), false);
        leftFoot.setLayoutParams(new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.MATCH_PARENT, 0.5f));
        canvas.addView(leftFoot);
        FootView righFoot = new FootView(this.getContext(), true);
        righFoot.setLayoutParams(new LinearLayout.LayoutParams(0,
                ViewGroup.LayoutParams.MATCH_PARENT, 0.5f));
        canvas.addView(righFoot);

    }

    private void initButtons(View rootView) {
        startStopButton = (Button) rootView.findViewById(R.id.start_stop_button);
        startStopButton.setOnClickListener(this);
    }


    private void setupSeekBar(View rootView) {
        rangeSeekBar = (RangeSeekBar) rootView.findViewById(R.id.soles_time_seek_bar);
        rangeSeekBar.setRangeValues(SEEKBAR_MIN, SEEKBAR_MAX);
        rangeSeekBar.setTextAboveThumbsColorResource(R.color.colorPrimaryDark);

        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                if (minValue.equals(maxValue))
                    return;
                //presenter.getPointsInTime(minValue, maxValue);
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
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


    @Override
    public void onClick(View v) {

    }

}
