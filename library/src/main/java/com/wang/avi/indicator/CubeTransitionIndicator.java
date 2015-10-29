package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/18.
 */
public class CubeTransitionIndicator extends BaseIndicatorController {

    float[] translateX=new float[2],translateY=new float[2];
    float degrees,scaleFloat=1.0f;
    int index;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        float rWidth=getWidth()/5;
        float rHeight=getHeight()/5;
        for (int i = 0; i < 2; i++) {
            canvas.save();
            canvas.translate(translateX[i], translateY[i]);
            canvas.rotate(degrees);
            canvas.scale(scaleFloat,scaleFloat);
            RectF rectF=new RectF(-rWidth/2,-rHeight/2,rWidth/2,rHeight/2);
            canvas.drawRect(rectF,paint);
            canvas.restore();
        }
    }

    @Override
    public void createAnimation() {
        float startX=getWidth()/5;
        float startY=getHeight()/5;
        for (int i = 0; i < 2; i++) {
            index=i;
            translateX[index]=startX;
            float[] valueXArray = new float[] {startX,getWidth()-startX,getWidth()-startX, startX,startX};
            if (i == 1) {
                valueXArray = new float[] {getWidth()-startX,startX,startX, getWidth()-startX,getWidth()-startX};
            }
            processTranslateAnimation(valueXArray, 1600, -1, 0, new LinearInterpolator());
            translateY[index]=startY;
            float[] valueYArray = new float[] {startY,startY,getHeight()-startY,getHeight()- startY,startY};
            if (i == 1) {
                valueYArray = new float[] {getHeight()-startY,getHeight()-startY,startY,startY,getHeight()-startY};
            }
            processTranslateYAnimation(valueYArray, 1600, -1, 0, new LinearInterpolator());
        }
        processScaleAnimation(new float[] {1,0.5f,1,0.5f,1}, 1600, -1, 0, new LinearInterpolator());
        processRotateAnimation(new float[] {0,180,360,1.5f*360,2*360}, 1600, -1, 0, new LinearInterpolator());
    }

    @Override
    public void onTranslateAnimationUpdate(ValueAnimator animation) {
        super.onTranslateAnimationUpdate(animation);
        translateX[index] = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onTranslateYAnimationUpdate(ValueAnimator animation) {
        super.onTranslateYAnimationUpdate(animation);
        translateY[index] = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        scaleFloat = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onDegreeAnimationUpdate(ValueAnimator animation) {
        super.onDegreeAnimationUpdate(animation);
        degrees = (float) animation.getAnimatedValue();
        postInvalidate();
    }
}
