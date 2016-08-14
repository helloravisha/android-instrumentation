package edu.sanfrancisco.csc.sem.summer;

/**
 * Created by owner on 8/1/16.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

import edu.sanfrancisco.csc.sem.summer.constants.Constants;

/**
 * Created by Michael Menlikalew on 8/1/16.
 */
public class Rectangle extends Shape {

    Canvas canvas;
    Paint color;
    int combination;
    public int myStyle;

    public Rectangle(Context context, int combination)
    {
        super(context);
        color = new Paint();
        this.combination = combination;
    }


    public Rectangle(Context context, Canvas canvas) {
        super(context);
        this.canvas = canvas;
        color = new Paint();

        Random rnd = new Random();
        int pointTop = (int)(Math.random() * (500));
        int pointLeft = (int)(Math.random() * (500));

        color.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        color.setFlags(Paint.ANTI_ALIAS_FLAG);
        float leftx = pointTop;
        float topy = pointTop;
        float rightx = pointLeft + 205;
        float bottomy = pointLeft + 265;


    }


    @Override
    public void onDraw(Canvas canvas) {

        Random rnd = new Random();
        int pointTop = (int)(Math.random() * (800));
        int pointLeft = (int)(Math.random() * (900));

        color.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        color.setFlags(Paint.ANTI_ALIAS_FLAG);
        float leftx = pointTop;
        float topy = pointTop;
        float rightx = pointLeft + 205;
        float bottomy = pointLeft + 265;
        if(combination == 0){

            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.RED);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.RED);
            color.setStrokeWidth(100);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

        }
        else if (combination == 1)
        {
            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.BLUE);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.RED);
            color.setStrokeWidth(200);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);
        }
        else if (combination == 2){
            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.YELLOW);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.RED);
            color.setStrokeWidth(200);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);
        }
        else if (combination == 3){
            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.GREEN);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.RED);
            color.setStrokeWidth(200);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);
        }
        else if (combination == 4){
            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.BLACK);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.RED);
            color.setStrokeWidth(200);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);
        }
        else if (combination == 5){
            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.WHITE);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.GREEN);
            color.setStrokeWidth(200);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);
        }
        else if (combination == 6) {
            color.setStyle(Paint.Style.FILL);
            color.setColor(Color.CYAN);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);

            color.setStyle(Paint.Style.STROKE);
            color.setColor(Color.YELLOW);
            color.setStrokeWidth(200);
            canvas.drawRect(leftx, topy, rightx, bottomy, color);


        }

    }
    @Override
    String getShapeType() {

        return Constants.RECTANGLE;
    }

}