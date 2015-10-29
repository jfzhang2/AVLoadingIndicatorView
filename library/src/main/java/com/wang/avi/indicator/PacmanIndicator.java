package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.LinearInterpolator;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/16.
 */
public class PacmanIndicator extends BaseIndicatorController {

    private float translateX;

    private int alpha;

    private float degrees1, degrees2;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        drawPacman(canvas, paint);
        drawCircle(canvas, paint);
    }

    private void drawPacman(Canvas canvas, Paint paint) {
        float x = getWidth() / 2;
        float y = getHeight() / 2;

        canvas.save();

        canvas.translate(x, y);
        canvas.rotate(degrees1);
        paint.setAlpha(255);
        RectF rectF1 = new RectF(-x / 1.7f, -y / 1.7f, x / 1.7f, y / 1.7f);
        canvas.drawArc(rectF1, 0, 270, true, paint);

        canvas.restore();

        canvas.save();
        canvas.translate(x, y);
        canvas.rotate(degrees2);
        paint.setAlpha(255);
        RectF rectF2 = new RectF(-x / 1.7f, -y / 1.7f, x / 1.7f, y / 1.7f);
        canvas.drawArc(rectF2, 90, 270, true, paint);
        canvas.restore();
    }


    private void drawCircle(Canvas canvas, Paint paint) {
        float radius = getWidth() / 11;
        paint.setAlpha(alpha);
        canvas.drawCircle(translateX, getHeight() / 2, radius, paint);
    }

    @Override
    public void createAnimation() {
        float startT = getWidth() / 11;

        float[] translateArray = new float[]{getWidth() - startT, getWidth() / 2};
        processScaleAnimation(translateArray, 650, -1, 0, new LinearInterpolator());

        int[] alphaArray = new int[] {255, 122};
        processAlphaAnimation(alphaArray, 650, -1, 0, null);

        float[] rotateArray = new float[] {0, 45, 0};
        processTranslateYAnimation(rotateArray, 650, -1, 0, null);

        float[] rotate2Array = new float[] {0, -45, 0};
        processRotate2Animation(rotate2Array, 650, -1, 0, null);
    }

    @Override
    public void onScaleAnimationUpdate(ValueAnimator animation) {
        super.onScaleAnimationUpdate(animation);
        translateX = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onAlphaAnimationUpdate(ValueAnimator animation) {
        alpha = (int) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onDegreeAnimationUpdate(ValueAnimator animation) {
        super.onDegreeAnimationUpdate(animation);
        degrees1 = (float) animation.getAnimatedValue();
        postInvalidate();
    }

    @Override
    public void onDegree2AnimationUpdate(ValueAnimator animation) {
        super.onDegree2AnimationUpdate(animation);
        degrees2 = (float) animation.getAnimatedValue();
        postInvalidate();
    }
}
