package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class BallScaleMultipleIndicator extends BaseIndicatorController {

    float[] scaleFloats=new float[]{1,1,1};
    int[] alphaInts=new int[]{255,255,255};
    int index;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float circleSpacing=4;
        for (int i = 0; i < 3; i++) {
            paint.setAlpha(alphaInts[i]);
            canvas.scale(scaleFloats[i],scaleFloats[i],getWidth()/2,getHeight()/2);
            canvas.drawCircle(getWidth()/2,getHeight()/2,getWidth()/2-circleSpacing,paint);
        }
    }

    @Override
    public void createAnimation() {
        int[] delays=new int[]{0, 200, 400};
        for (int i = 0; i < 3; i++) {
            index=i;
            processScaleAnimation(new float[] {0, 1}, 1000, -1, delays[i], new LinearInterpolator());
            processAlphaAnimation(new int[] {255, 0}, 1000, -1, delays[i], new LinearInterpolator());
        }
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        scaleFloats[index] = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onAlphaAnimationUpdate(ValueAnimator animation) {
        super.onAlphaAnimationUpdate(animation);
        alphaInts[index] = (int) animation.getAnimatedValue();
        postInvalidate();
    }
}
