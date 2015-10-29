package com.wang.avi.indicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import com.nineoldandroids.animation.ValueAnimator;

/**
 * Created by Jack on 2015/10/16.
 */
public class BallClipRotateIndicator extends BaseIndicatorController {

    //缩放比例以及弧度
    float scaleFloat=1,degrees;

    @Override
    public void draw(Canvas canvas, Paint paint) {
        //设置画笔的尺寸
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

        //圆形的间距
        float circleSpacing=12;
        //对应的是宽度以及相应的高度
        float x = (getWidth()) / 2;
        float y=(getHeight()) / 2;
        Log.v("jfzhang2", "x = " + x);
        Log.v("jfzhang2", "y = " + y);
        //Canvas进行相应的处理
        //位移操作
        canvas.translate(x, y);
        //缩放操作
        canvas.scale(scaleFloat, scaleFloat);
        //旋转操作
        canvas.rotate(degrees);
        //定义一个矩形
        RectF rectF=new RectF(-x+circleSpacing,-y+circleSpacing,0+x-circleSpacing,0+y-circleSpacing);
        canvas.drawArc(rectF, -180, 270, false, paint);
    }

    @Override
    public void createAnimation() {
        //创建动画
        processScaleAnimation(new float[] {1,0.6f,0.5f,1}, 750, -1, 0, null);
        //设置旋转的弧度
        processRotateAnimation(new float[]{0,180,360}, 750, -1, 0, null);
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
