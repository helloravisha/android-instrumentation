package edu.sanfrancisco.csc.sem.summer;

import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

// Tests for MainActivity
public class MainActivityInstrumentationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityInstrumentationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testCircleClick() {
        String expectedResult = "0" + " rectangles, " + "1" + " circles";
        onView(withId(R.id.btn_circ)).perform(click());
        //onView(withId(R.id.tv_shape_count)).check(matches(expectedResult));
        onView(withId(R.id.tv_shape_count)).check(matches(withText(expectedResult)));

    }

    public void testRectangleClick() {
        String expectedResult = "1" + " rectangles, " + "0" + " circles";
        onView(withId(R.id.btn_rect)).perform(click());
        //onView(withId(R.id.tv_shape_count)).check(matches(expectedResult));
        onView(withId(R.id.tv_shape_count)).check(matches(withText(expectedResult)));

    }

    public void testClearClick() {
        String expectedResult = "1" + " rectangles, " + "1" + " circles";
        onView(withId(R.id.btn_rect)).perform(click());
        onView(withId(R.id.btn_circ)).perform(click());
        //onView(withId(R.id.tv_shape_count)).check(matches(expectedResult));
        onView(withId(R.id.tv_shape_count)).check(matches(withText(expectedResult)));
        onView(withId(R.id.btn_clr)).perform(click());

    }

    public void testStyleClick() {
        String expectedResult = "2" + " rectangles, " + "2" + " circles";
        onView(withId(R.id.btn_rect)).perform(click());// one rectangle
        onView(withId(R.id.btn_circ)).perform(click());// circle
        onView(withId(R.id.btn_style)).perform(click());// change the style
        onView(withId(R.id.btn_circ)).perform(click());// click on circle
        onView(withId(R.id.btn_rect)).perform(click());// click on circle
        onView(withId(R.id.tv_shape_count)).check(matches(withText(expectedResult)));


    }







}