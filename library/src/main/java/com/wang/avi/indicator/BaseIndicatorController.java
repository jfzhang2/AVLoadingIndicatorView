package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.Interpolator;

import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/15.
 */
public abstract class BaseIndicatorController {

    private View mTarget;


    public void setTarget(View target){
        this.mTarget=target;
    }

    public View getTarget(){
        return mTarget;
    }


    public int getWidth(){
        return mTarget.getWidth();
    }

    public int getHeight(){
        return mTarget.getHeight();
    }

    public void postInvalidate(){
        mTarget.postInvalidate();
    }

    /**
     * draw indicator what ever
     * you want to draw
     * @param canvas
     * @param paint
     */
    public abstract void draw(Canvas canvas,Paint paint);

    /**
     * create animation or animations
     * ,and add to your indicator.
     */
    public abstract void createAnimation();

    public void processScaleAnimation(float[] valueArray, long duration, int repeatCounter,int startDelay, Interpolator interpolator) {
        ValueAnimator scaleAnim=ValueAnimator.ofFloat(valueArray);
        scaleAnim.setDuration(duration);
        scaleAnim.setRepeatCount(repeatCounter);
        scaleAnim.setStartDelay(startDelay);
        if (interpolator != null) {
            scaleAnim.setInterpolator(interpolator);
        }
        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onScaleAnimationUpdate(animation);
            }
        });
        scaleAnim.start();
    }

    public void processRotate2Animation(float[] valueArray, long duration, int repeatCounter,int startDelay, Interpolator interpolator) {
        ValueAnimator rotateAnim=ValueAnimator.ofFloat(valueArray);
        rotateAnim.setDuration(duration);
        rotateAnim.setRepeatCount(repeatCounter);
        rotateAnim.setStartDelay(startDelay);
        if (interpolator != null) {
            rotateAnim.setInterpolator(interpolator);
        }
        rotateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onDegreeAnimationUpdate(animation);
            }
        });
        rotateAnim.start();
    }

    public void processRotateAnimation(float[] valueArray, long duration, int repeatCounter,int startDelay, Interpolator interpolator) {
        ValueAnimator rotateAnim=ValueAnimator.ofFloat(valueArray);
        rotateAnim.setDuration(duration);
        rotateAnim.setRepeatCount(repeatCounter);
        rotateAnim.setStartDelay(startDelay);
        if (interpolator != null) {
            rotateAnim.setInterpolator(interpolator);
        }
        rotateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onDegreeAnimationUpdate(animation);
            }
        });
        rotateAnim.start();
    }

    public void processAlphaAnimation(int[] valueArray, long duration, int repeatCounter, int startDelay, Interpolator interpolator) {
        ValueAnimator alphaAnim=ValueAnimator.ofInt(valueArray);
        alphaAnim.setDuration(duration);
        alphaAnim.setRepeatCount(repeatCounter);
        alphaAnim.setStartDelay(startDelay);
        if (interpolator != null) {
            alphaAnim.setInterpolator(interpolator);
        }
        alphaAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onAlphaAnimationUpdate(animation);
            }
        });
        alphaAnim.start();
    }

    public void processTranslateAnimation(float[] valueArray, long duration, int repeatCounter, int startDelay, Interpolator interpolator) {
        ValueAnimator translateAnim=ValueAnimator.ofFloat(valueArray);
        translateAnim.setDuration(duration);
        translateAnim.setRepeatCount(repeatCounter);
        translateAnim.setStartDelay(startDelay);
        if (interpolator != null) {
            translateAnim.setInterpolator(interpolator);
        }
        translateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onTranslateAnimationUpdate(animation);
            }
        });
        translateAnim.start();
    }

    public void processTranslateYAnimation(float[] valueArray, long duration, int repeatCounter, int startDelay, Interpolator interpolator) {
        ValueAnimator translateAnim=ValueAnimator.ofFloat(valueArray);
        translateAnim.setDuration(duration);
        translateAnim.setRepeatCount(repeatCounter);
        translateAnim.setStartDelay(startDelay);
        if (interpolator != null) {
            translateAnim.setInterpolator(interpolator);
        }
        translateAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                onTranslateYAnimationUpdate(animation);
            }
        });
        translateAnim.start();
    }


    public void processViewHolder(String[] valueString, float[][] valueArray, int repeatCounter, int duration, Interpolator interpolator) {
        PropertyValuesHolder[] propertyValueHolderArray = new PropertyValuesHolder[valueString.length];
        for (int i = 0; i < valueString.length; i ++) {
            propertyValueHolderArray[i] = PropertyValuesHolder.ofFloat(valueString[i], valueArray[i]);
        }
        ObjectAnimator animator=ObjectAnimator.ofPropertyValuesHolder(getTarget(), propertyValueHolderArray);
        animator.setInterpolator(interpolator);
        animator.setRepeatCount(repeatCounter);
        animator.setDuration(duration);
        animator.start();
    }

    public void onScaleAnimationUpdate(ValueAnimator animation) {

    }

    public void onDegreeAnimationUpdate(ValueAnimator animation) {

    }

    public void onDegree2AnimationUpdate(ValueAnimator animation) {

    }

    public void onAlphaAnimationUpdate(ValueAnimator animation) {

    }

    public void onTranslateAnimationUpdate(ValueAnimator animation) {

    }

    public void onTranslateYAnimationUpdate(ValueAnimator animation) {

    }


}
