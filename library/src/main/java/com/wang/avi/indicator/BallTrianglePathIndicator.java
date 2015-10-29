package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/19.
 */
public class BallTrianglePathIndicator extends BaseIndicatorController {

    float[] translateX=new float[3],translateY=new float[3];
    int index;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        for (int i = 0; i < 3; i++) {
            canvas.save();
            canvas.translate(translateX[i], translateY[i]);
            canvas.drawCircle(0, 0, getWidth() / 10, paint);
            canvas.restore();
        }
    }

    @Override
    public void createAnimation() {
        float startX=getWidth()/5;
        float startY=getWidth()/5;
        for (int i = 0; i < 3; i++) {
            index=i;

            float[] valueArray = new float[] {getWidth()/2,getWidth()-startX,startX,getWidth()/2};
            if (i == 1) {
                valueArray = new float[] {getWidth()-startX,startX,getWidth()/2,getWidth()-startX};
            } else if (i == 2) {
                valueArray = new float[] {startX,getWidth()/2,getWidth()-startX,startX};
            }
            processTranslateAnimation(valueArray, 2000, -1, 0, new LinearInterpolator());

            float[] valueYArray = new float[] {startY,getHeight()-startY,getHeight()-startY,startY};
            if (i == 1) {
                valueYArray = new float[] {getHeight()-startY,getHeight()-startY,startY,getHeight()-startY};
            } else if (i == 2) {
                valueYArray = new float[] {getHeight()-startY,startY,getHeight()-startY,getHeight()-startY};
            }
            processTranslateYAnimation(valueYArray, 2000, -1, 0, new LinearInterpolator());
        }
    }

    @Override
    public void onTranslateAnimationUpdate(ValueAnimator animation) {
        super.onTranslateAnimationUpdate(animation);
        translateX [index]= (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onTranslateYAnimationUpdate(ValueAnimator animation) {
        super.onTranslateYAnimationUpdate(animation);
        translateY [index]= (float) animation.getAnimatedValue();
        postInvalidate();
    }
}
