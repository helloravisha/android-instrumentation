package edu.sanfrancisco.csc.sem.summer;

/**
 * Created by owner on 8/1/16.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Michael Menlikalew on 8/1/16.
 */
public abstract class Shape extends View {

    public Shape(Context context) {
        super(context);
    }

    public void setShapeAlpha(float alpha) {

        this.setAlpha(alpha);
    }

    public float getShapeAlpha() {

        return this.getAlpha();
    }

    public void removeShape() {

        this.setVisibility(GONE);
    }

    abstract String getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);
}