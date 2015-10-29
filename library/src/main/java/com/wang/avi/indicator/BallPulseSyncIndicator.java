package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class BallPulseSyncIndicator extends BaseIndicatorController {

    float[] translateYFloats=new float[3];
    int index;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float circleSpacing=4;
        float radius=(getWidth()-circleSpacing*2)/6;
        float x = getWidth()/ 2-(radius*2+circleSpacing);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float translateX=x+(radius*2)*i+circleSpacing*i;
            canvas.translate(translateX, translateYFloats[i]);
            canvas.drawCircle(0, 0, radius, paint);
            canvas.restore();
        }
    }

    @Override
    public void createAnimation() {
        float circleSpacing=4;
        float radius=(getWidth()-circleSpacing*2)/6;
        int[] delays=new int[]{70,140,210};
        for (int i = 0; i < 3; i++) {
            index=i;
            processScaleAnimation(new float[] {getHeight()/2,getHeight()/2-radius*2,getHeight()/2}, 600, -1, delays[i], null);
        }
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        translateYFloats[index] = (float) animation.getAnimatedValue();
        postInvalidate();
    }
}
