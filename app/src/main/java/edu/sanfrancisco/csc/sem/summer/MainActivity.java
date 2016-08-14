package edu.sanfrancisco.csc.sem.summer;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;



/**
 * Created by Michael Menlikalew on 8/1/16.
 */
public class MainActivity extends AppCompatActivity {

    private RelativeLayout drawingImageView;
    private TextView tvShapeCount;

    private Canvas canvas;
    private ShapeFactory shapeFactory;

    private List<Shape> shapes;
    int ColorCombo = 0;

    ShapeFactory sfMagnetaGreen = AbstractShapeFactory.getShapeFactory(0);
    ShapeFactory sfRedYellow = AbstractShapeFactory.getShapeFactory(0);
    ShapeFactory sfGreenMagenta = AbstractShapeFactory.getShapeFactory(0);
    ShapeFactory sfMagnetaYellow = AbstractShapeFactory.getShapeFactory(0);
    ShapeFactory sfCyanBlue= AbstractShapeFactory.getShapeFactory(0);
    ShapeFactory sfBlueGreen = AbstractShapeFactory.getShapeFactory(0);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hideActionBar();

        Vector v = new Vector(2, 2);
        //v.addElement(new Shape());





        drawingImageView = (RelativeLayout) this.findViewById(R.id.iv_drawing);
        tvShapeCount = (TextView) this.findViewById(R.id.tv_shape_count);
        updateShapeCount();

        sfMagnetaGreen = AbstractShapeFactory.getShapeFactory(1);
        sfRedYellow = AbstractShapeFactory.getShapeFactory(2);
        sfGreenMagenta = AbstractShapeFactory.getShapeFactory(3);
        sfMagnetaYellow = AbstractShapeFactory.getShapeFactory(4);
        sfCyanBlue = AbstractShapeFactory.getShapeFactory(5);
        sfBlueGreen = AbstractShapeFactory.getShapeFactory(0);

        shapes = new ArrayList<>();
        shapeFactory = sfMagnetaGreen;

        Button btnRect = (Button) findViewById(R.id.btn_rect);
        Button btnCirc = (Button) findViewById(R.id.btn_circ);
        Button btnClear = (Button) findViewById(R.id.btn_clr);
        Button btnStyle = (Button) findViewById(R.id.btn_style);


        btnRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Shape rectShape = shapeFactory.getShape(MainActivity.this, "Rectangle", canvas);
                drawingImageView.addView(rectShape);

                shapes.add(rectShape);
                //rectCount++;

                adjustShapeAlpha();
                updateShapeCount();
            }
        });

        btnCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Shape circleShape = shapeFactory.getShape(MainActivity.this, "Circle", canvas);
                drawingImageView.addView(circleShape);

                shapes.add(circleShape);

                adjustShapeAlpha();
                updateShapeCount();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawingImageView.removeAllViews();
                shapes.clear();
                updateShapeCount();
            }
        });
        btnStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorCombo++;
                if (ColorCombo > 6) {
                    ColorCombo = 0;

                }
                if (ColorCombo == 0) {
                    shapeFactory = sfMagnetaGreen;
                } else if (ColorCombo == 1) {
                    shapeFactory = sfRedYellow;
                } else if (ColorCombo == 2) {
                    shapeFactory = sfGreenMagenta;
                } else if (ColorCombo == 3) {
                    shapeFactory = sfMagnetaYellow;
                } else if (ColorCombo == 4) {
                    shapeFactory = sfCyanBlue;
                } else if (ColorCombo == 5) {
                    shapeFactory = sfBlueGreen;
                }

                updateShapeCount();
                iterateShape();
            }

        });

    }
    private void hideActionBar() {

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
    }


    public void iterateShape(){


            Iterator<Shape> itr = shapes .iterator();
           int count = 0;
            while (itr.hasNext()) {

                Shape shape = itr.next();
                count++;
                System.out.print(" Shape "+count+" "+shape.getShapeType() + "\n");

            }



    }

    private void adjustShapeAlpha() {

        for (int i = 0; i < shapes.size(); i++) {

            Shape shape = shapes.get(i);

            if (shape != null) {

                if (shape.getShapeAlpha() > 0) {

                    float newAlpha = shape.getShapeAlpha() - 0.05f;

                    if (newAlpha < 0.1f)
                        newAlpha = 0;

                    shape.setShapeAlpha(newAlpha);
                } else {

                    drawingImageView.removeView(shape);
                }

                drawingImageView.clearDisappearingChildren();
            }
        }
    }

    private void updateShapeCount() {

        int childCount = drawingImageView.getChildCount();

        int rectCount = 0;
        int circCount = 0;

        for (int i = 0; i < childCount; i++) {

            if (drawingImageView.getChildAt(i) instanceof Rectangle)
                rectCount++;
            else if (drawingImageView.getChildAt(i) instanceof Circle)
                circCount++;
        }

        String count = rectCount + " rectangles, " + circCount + " circles";
        tvShapeCount.setText(count);
    }
}
