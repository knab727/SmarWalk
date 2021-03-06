package knab.pl.smartwalk.ui.views;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class RectangleView extends View {

    private Paint sensorPaint;
    private Rect rect;

    public RectangleView(Context context, Rect rect, int pressure) {
        super(context);
        this.rect = rect;
        sensorPaint = new Paint();
        sensorPaint.setColor(setColorPalate(pressure));
    }

    public void setPressure(int pressure) {
        sensorPaint.setColor(setColorPalate(pressure));
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public int setColorPalate(int pressure) {
        float R = (255 * pressure) / 100;
        float G = 0;
        float B = (255 * (100 - pressure)) / 100;
        return Color.rgb((int) R, (int) G, (int) B);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(rect, sensorPaint);
    }

}