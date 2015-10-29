package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class BallScaleRippleIndicator extends BallScaleIndicator {


    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        super.draw(canvas, paint);
    }

    @Override
    public void createAnimation() {
        processScaleAnimation(new float[] {0, 1}, 1000, -1, 0, new LinearInterpolator());
        processAlphaAnimation(new int[] {0, 255}, 1000, -1, 0, new LinearInterpolator());
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        scale = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onAlphaAnimationUpdate(ValueAnimator animation) {
        super.onAlphaAnimationUpdate(animation);
        alpha = (int) animation.getAnimatedValue();
        postInvalidate();
    }
}
