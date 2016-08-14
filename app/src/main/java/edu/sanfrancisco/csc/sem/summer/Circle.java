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
 *
 * This class is used for drawing circles and filling with different colos and different styles
 * Created by Michael Menlikalew on 8/1/16.
 */
public class Circle extends Shape {

    Canvas canvas;
    Paint color;
    int combination;
    int pointX = (int)(Math.random() * (800));
    int pointY = (int)(Math.random() * (900));
    float radius = 180;


    public Circle(Context context, int combination) {
        super(context);
        color = new Paint();
        this.combination = combination;
    }


    @Override
    String getShapeType() {

        return Constants.CIRCLE;
    }


    /**
     * Drawing the circle with the given color combination.
     * @param outSideColor
     *        this color is for the outer circle.
     * @param insideColor
     *        this color is for the inner circle.
     */
    private void drawCircle(int outSideColor,int insideColor,Canvas canvas){
        System.out.println("Canvas object.."+canvas);
        color.setStyle(Paint.Style.FILL);
        color.setColor(outSideColor);
        canvas.drawCircle(pointX, pointY, radius, color);

        color.setStyle(Paint.Style.STROKE);
        color.setColor(insideColor);
        color.setStrokeWidth(90);
        canvas.drawCircle(pointX, pointY, radius, color);

    }


    /**
     * Used for drawing the shape  in this class we will be drawing circle.
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas) {
        Random rnd = new Random();
        color.setARGB(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        color.setFlags(Paint.ANTI_ALIAS_FLAG);
        color.setAntiAlias(true);


        if(combination == 0){
            drawCircle(Color.RED, Color.RED,canvas);
        }
        else if (combination == 1)
        {
            drawCircle(Color.BLUE, Color.RED,canvas);
        }
        else if (combination == 2){
            drawCircle(Color.YELLOW, Color.RED,canvas);

        }
        else if (combination == 3){
            drawCircle(Color.GREEN, Color.RED,canvas);
        }
        else if (combination == 4){
            drawCircle(Color.BLACK, Color.RED,canvas);

        }
        else if (combination == 5){
            drawCircle(Color.WHITE,Color.RED,canvas);

        }

    }
}