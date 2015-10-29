package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;

/**
 * Created by Jack on 2015/10/17.
 */
public class BallPulseRiseIndicator extends BaseIndicatorController{

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float radius=getWidth()/10;
        canvas.drawCircle(getWidth()/4,radius*2,radius,paint);
        canvas.drawCircle(getWidth()*3/4,radius*2,radius,paint);

        canvas.drawCircle(radius,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()/2,getHeight()-2*radius,radius,paint);
        canvas.drawCircle(getWidth()-radius,getHeight()-2*radius,radius,paint);
    }

    @Override
    public void createAnimation() {
        String[] valueStringArray = {"rotationX"};
        float[][] valueFloatArray = {{0, 360}};
        processViewHolder(valueStringArray, valueFloatArray, -1, 1500, new LinearInterpolator());
    }
}
