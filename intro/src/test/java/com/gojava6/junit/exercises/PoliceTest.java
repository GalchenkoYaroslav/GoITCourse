package com.gojava6.junit.exercises;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by sergiigetman on 9/28/15.
 */
public class PoliceTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Ignore
    @Test
    public void testDisarmPoliceman()  {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("policeman cannot be disarmed");
        Police police = new PoliceImpl();
        police.disarm("policeman");
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void testDisarmNullpointer() throws Exception {
        Police police = new PoliceImpl();
        police.disarm(null);
    }*/

    @Ignore
    @Category(CriminalCategory.class)
    @Test
    public void testEliminate() throws Exception {

    }

    @Ignore
    @Test
    public void testLockUp() throws Exception {

    }

    @Ignore
    @Test
    public void testGetLockedUp() throws Exception {

    }

    @Ignore
    @Category({AdministationCategory.class, CriminalCategory.class})
    @Test
    public void testMakeFee() throws Exception {

    }
}