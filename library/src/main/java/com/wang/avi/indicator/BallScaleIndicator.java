package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class BallScaleIndicator extends BaseIndicatorController {

    float scale=1;
    int alpha=255;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float circleSpacing=4;
        paint.setAlpha(alpha);
        canvas.scale(scale,scale,getWidth()/2,getHeight()/2);
        paint.setAlpha(alpha);
        canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2-circleSpacing,paint);
    }

    @Override
    public void createAnimation() {
        processScaleAnimation(new float[] {0, 1}, 1000, -1, 0, new LinearInterpolator());
        processAlphaAnimation(new int[] {255, 0}, 1000, -1, 0, new LinearInterpolator());
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
