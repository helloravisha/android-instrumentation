package edu.sanfrancisco.csc.sem.summer;


import android.content.Context;
import android.graphics.Canvas;

import edu.sanfrancisco.csc.sem.summer.constants.Constants;

/**
 * Created by Michael Menlikalew on 8/1/16.
 */
public class ShapeFactory extends AbstractShapeFactory {

    int colorway;
    public ShapeFactory(int color) {
        colorway = color;
    }

    public Shape getShape(Context context, String shapeType, Canvas canvas){

        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase(Constants.CIRCLE)){
            return new Circle(context,colorway);

        } else if(shapeType.equalsIgnoreCase(Constants.RECTANGLE)){
            return new Rectangle(context, colorway);

        }

        return null;
    }
}