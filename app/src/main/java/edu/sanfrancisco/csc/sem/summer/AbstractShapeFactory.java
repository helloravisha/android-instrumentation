package edu.sanfrancisco.csc.sem.summer;

/**
 * Created by owner on 8/1/16.
 */
public abstract class AbstractShapeFactory {
    public static ShapeFactory getShapeFactory(int combination) {

        return new ShapeFactory(combination);
    }

}

