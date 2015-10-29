package com.wang.avi.indicator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class LineScalePulseOutRapidIndicator extends LineScaleIndicator {

    int index;
    @Override
    public void createAnimation() {
        int[] delays=new int[]{400,200,0,200,400};
        for (int i = 0; i < 5; i++) {
            index=i;
            processScaleAnimation(new float[] {1,0.4f,1}, 1000, -1, delays[i], null);
        }
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        scaleYFloats[index] = (float) animation.getAnimatedValue();
        postInvalidate();
    }
}
