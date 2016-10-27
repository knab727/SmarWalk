package knab.pl.smartwalk.ui.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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

public class GoniometerFragment extends Fragment {

    int h, w;

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

        View rootView = inflater.inflate(R.layout.fragment_goniometer, container, false);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rect);
        final ImageView iv = (ImageView) rootView.findViewById(R.id.right_foot);
        relativeLayout.addView(new Rectangle(getActivity()));
        iv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                iv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                h = iv.getMeasuredHeight();
                w = iv.getMeasuredWidth();
            }
        });
        return rootView;
    }

    private class Rectangle extends View {
        Paint paint_RIGHT_TOP = new Paint();
        Paint paint_RIGHT_ONE_INNER = new Paint();
        Paint paint_RIGHT_ONE_OUTER = new Paint();
        Paint paint_RIGHT_TWO_INNER = new Paint();
        Paint paint_RIGHT_TWO_OUTER = new Paint();
        Paint paint_RIGHT_THREE_INNER = new Paint();
        Paint paint_RIGHT_THREE_OUTER = new Paint();
        Paint paint_RIGHT_BOTTOM = new Paint();

        public Rectangle(Context context) {
            super(context);
        }
        public int setColorPalate(int n) {
            float R = (255 * n) / 100;
            float G = 0;
            float B = (255 * (100 - n)) / 100;
            return Color.rgb((int)R, (int)G, (int)B);
        }
    @Override
    public void onDraw(Canvas canvas) {
        int width = 3*w/10 - 23*w/100;
        int height = h/15 - h/50;
        paint_RIGHT_TOP.setColor(setColorPalate(50));
        paint_RIGHT_ONE_INNER.setColor(setColorPalate(25));
        paint_RIGHT_ONE_OUTER.setColor(setColorPalate(5));
        paint_RIGHT_TWO_INNER.setColor(setColorPalate(32));
        paint_RIGHT_TWO_OUTER.setColor(setColorPalate(40));
        paint_RIGHT_THREE_INNER.setColor(setColorPalate(65));
        paint_RIGHT_THREE_OUTER.setColor(setColorPalate(85));
        paint_RIGHT_BOTTOM.setColor(setColorPalate(100));

        Rect RIGHT_TOP = new Rect(23*w/100, h/50, 23*w/100 + width, h/50 + height);
        Rect RIGHT_ONE_INNER = new Rect(11*w/80, 2*h/13, 11*w/80 + width, 2*h/13 + height);
        Rect RIGHT_ONE_OUTER = new Rect(18*w/43, 2*h/13, 18*w/43 + width, 2*h/13 + height);
        Rect RIGHT_TWO_INNER = new Rect(14*w/81, 27*h/74, 14*w/81 + width, 27*h/74 + height);
        Rect RIGHT_TWO_OUTER = new Rect(7*w/15, 28*h/77, 7*w/15 + width, 28*h/77 + height);
        Rect RIGHT_THREE_INNER = new Rect(16*w/79, 17*h/25, 16*w/79 + width, 17*h/25 + height);
        Rect RIGHT_THREE_OUTER = new Rect(37*w/84, 18*h/26, 37*w/84 + width, 18*h/26 + height);
        Rect RIGHT_BOTTOM = new Rect(18*w/43 - width, 46*h/55, 18*w/43, 46*h/55 + height);


        canvas.drawRect(RIGHT_TOP, paint_RIGHT_TOP);
        canvas.drawRect(RIGHT_ONE_INNER, paint_RIGHT_ONE_INNER);
        canvas.drawRect(RIGHT_ONE_OUTER, paint_RIGHT_ONE_OUTER);
        canvas.drawRect(RIGHT_TWO_INNER, paint_RIGHT_TWO_INNER);
        canvas.drawRect(RIGHT_TWO_OUTER, paint_RIGHT_TWO_OUTER);
        canvas.drawRect(RIGHT_THREE_INNER, paint_RIGHT_THREE_INNER);
        canvas.drawRect(RIGHT_THREE_OUTER, paint_RIGHT_THREE_OUTER);
        canvas.drawRect(RIGHT_BOTTOM, paint_RIGHT_BOTTOM);
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
