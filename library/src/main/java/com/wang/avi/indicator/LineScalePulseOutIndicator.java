package com.wang.avi.indicator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class LineScalePulseOutIndicator extends LineScaleIndicator {

    int index;

    @Override
    public void createAnimation() {
        int[] delays=new int[]{500,250,0,250,500};
        for (int i = 0; i < 5; i++) {
            index=i;
            processScaleAnimation(new float[] {1,0.3f,1}, 900, -1, delays[i], null);
        }
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        scaleYFloats[index] = (float) animation.getAnimatedValue();
        postInvalidate();
    }
}
