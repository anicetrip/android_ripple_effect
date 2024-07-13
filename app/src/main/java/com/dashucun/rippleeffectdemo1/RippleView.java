package com.dashucun.rippleeffectdemo1;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;

public class RippleView extends View {
    private Paint paint1, paint2, paint3;
    private float radius1, radius2, radius3;
    private boolean isAnimating = false;
    float maxRaid = 0;
    public RippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {



        paint1 = new Paint();
        paint1.setColor(0xFFFFD700); // 深黄
        paint1.setStyle(Paint.Style.FILL);

        paint2 = new Paint();
        paint2.setColor(0xFFFFFF00); // 黄
        paint2.setStyle(Paint.Style.FILL);

        paint3 = new Paint();
        paint3.setColor(0xFFFFFFE0); // 浅黄
        paint3.setStyle(Paint.Style.FILL);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float centerX = getWidth() / 2f;
        float centerY = getHeight() / 2f;

        canvas.drawCircle(centerX, centerY, radius3, paint3);
        canvas.drawCircle(centerX, centerY, radius2, paint2);
        canvas.drawCircle(centerX, centerY, radius1, paint1);

        if (isAnimating) {
            radius1 += 0.01*maxRaid;
            radius2 += 0.015*maxRaid;
            radius3 += 0.02*maxRaid;

            if (radius1 > getWidth() / 2) {
                radius1 = 0;
                radius2 = 50;
                radius3 = 100;
            }
            invalidate();
        }
    }

    public void startRipple() {
        if (!isAnimating) {
            maxRaid = Math.min(getWidth(),getHeight()) / 2;
            Log.i("ripple", "init: " + maxRaid);
            isAnimating = true;
            radius1 = 0;
            radius2 = (float) (0.1 * maxRaid);
            radius3 = (float) (0.2 * maxRaid);
            invalidate();
        }
    }

    public void stopRipple() {
        isAnimating = false;
    }
}
