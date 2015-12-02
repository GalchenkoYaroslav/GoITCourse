package com.gojava6;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by sergiigetman on 9/22/15.
 */
public class OneSwipeArrayTest {

    private OneSwipeArray oneSwipeArray;
    private int[] falseArray;
    private int[] trueArray;

    @Before
    public void setUp(){
        oneSwipeArray = new OneSwipeArray();
        trueArray = new int[]{1, 5, 3, 3, 7};
        falseArray = new int[]{1, 3, 5, 3, 4};
    }
    @Ignore
    @Test
    public void testSolution() {
        assertTrue(oneSwipeArray.solution(trueArray));
    }

    @Ignore
    @Test
    public void testSolutionTwo() {
        assertFalse(oneSwipeArray.solution(falseArray));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testSolutionNull() {
        oneSwipeArray.solution(null);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testSolutionLessThanTwo() {
        oneSwipeArray.solution(new int[1]);
    }
}