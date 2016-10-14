package knab.pl.smartwalk.ui.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import javax.inject.Inject;

import knab.pl.smartwalk.R;
import knab.pl.smartwalk.SmartWalkApplication;
import knab.pl.smartwalk.model.SignalAdapter;

public class GoniometerFragment extends Fragment {

    @Inject
    SignalAdapter signalAdapter;

    public GoniometerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SmartWalkApplication)getActivity().getApplication()).getSignalComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView =  inflater.inflate(R.layout.fragment_goniometer, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rect);
        relativeLayout.addView(new Rectangle(getActivity()));

        return rootView;
    }
    private class Rectangle extends View {
        Paint paint = new Paint();

        public Rectangle(Context context) {
            super(context);
        }
        @Override
        public void onDraw(Canvas canvas) {
            paint.setColor(Color.GREEN);
            Rect rect = new Rect(20, 6, 100, 52);
            canvas.drawRect(rect, paint );
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
