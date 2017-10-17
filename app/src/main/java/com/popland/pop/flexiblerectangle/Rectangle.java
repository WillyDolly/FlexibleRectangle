package com.popland.pop.flexiblerectangle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hai on 17/10/2017.
 */

public class Rectangle extends View {
    Paint paint;
    float L,T,R,B;

    Rectangle(Context context,int width,int height){
        super(context);
        paint = new Paint();
        paint.setColor(Color.CYAN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        //show rect at center
        L = width/4;
        R = width*3/4;
        T = height/4;
        B = height*3/4;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rect = new RectF(L,T,R,B);
        canvas.drawRect(rect,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_MOVE) {
                float X = event.getX();
                float Y = event.getY();
                //split rect into 4 parts
                if (X < (L + R) / 2 && Y < (T + B) / 2) {
                    L = X;
                    T = Y;
                    invalidate();
                } else if (X > (L + R) / 2 && Y < (T + B) / 2) {
                    R = X;
                    T = Y;
                    invalidate();
                } else if (X > (L + R) / 2 && Y > (T + B) / 2) {
                    R = X;
                    B = Y;
                    invalidate();
                } else if (X < (L + R) / 2 && Y > (T + B) / 2) {
                    L = X;
                    B = Y;
                    invalidate();
                }
            }
        return true;
    }

}
