package edu.sanfrancisco.csc.sem.summer;

/**
 * Created by Michael Menlikalew on 8/1/16.
 */
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import edu.sanfrancisco.csc.sem.summer.constants.Constants;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RectangleTest {

    @Test
    public void getShapeType(){
        try{
            new Rectangle(null,0);
        }
        catch(Exception exception){
            String message = exception.getMessage();
            assertEquals("java.lang.NullPointerException","java.lang.NullPointerException");
        }

    }
}