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


import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class AbstractShapeFactoryTest {

    @Test
    public void testGetShapeFactory(){

         assertNull(AbstractShapeFactory.getShapeFactory(1));
    }
}
