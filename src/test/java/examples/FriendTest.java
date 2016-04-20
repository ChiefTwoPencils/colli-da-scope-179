package examples;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;

import static org.junit.Assert.*;

/**
 * Created by Austin on 4/20/2016.
 */
public class FriendTest {
    private Friend myfriend;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    /*@Test
    public void testUpdate() throws Exception {
        //update only does a string.  Trivial,in this case.
    }*/

    @Test
    public void testGetCollisionKey() throws Exception {
        myfriend = new Friend();//constructor doesn't matter, is always "Friend".
        assertEquals(myfriend.getCollisionKey(), "Friend");
    }

    /*@Test
    public void testUpdate1() throws Exception {
        //trivial, only outputs strings.
    }*/

    @Test
    public void testGetLocation() throws Exception {
        //test that the default case matches.
        myfriend = new Friend();
        assertEquals(myfriend.getLocation(), new Point2D.Double(225, 245));

        //now, test that it will work for user inputted locations as well.
        Point2D.Double myloc = new Point2D.Double(100, 100);
        myfriend = new Friend(myloc);//values now start here.
        assertEquals(myfriend.getLocation(), myloc);//ensure what I put in is what I get out.
    }

    @Test
    public void testGetSize() throws Exception {
        myfriend = new Friend();//default
        assertEquals(myfriend.getSize(), 50);//defaults to this size, make sure it works.

        int size = 25;//the size to be tested
        myfriend = new Friend(new Point2D.Double(100, 100), size);//now, put a size in there.
        assertEquals(myfriend.getSize(), size);


    }

    @Test
    public void testAddHandler() throws Exception {

    }

    @Test
    public void testAddDetector() throws Exception {

    }

    @Test
    public void testGetHandlers() throws Exception {

    }

    @Test
    public void testGetDetectors() throws Exception {

    }

    @Test
    public void testGetBoundingShape() throws Exception {
        myfriend = new Friend();//default friends and gameobjects(super) are rectangles.
        assert(myfriend.getBoundingShape() instanceof Rectangle);




    }
}