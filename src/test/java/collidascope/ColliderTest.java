package collidascope;

import examples.Enemy;
import examples.Friend;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColliderTest {
    private Collider mycollider;
    private Friend tempf;
    private Enemy tempe;
    private static int expected = 0;
    private static int actual = 0;
    @Before
    public void setUp() throws Exception {
        tempf = new Friend();
        tempe = new Enemy();
        mycollider = new Collider();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDetectedCollision() throws Exception {
        assertEquals(mycollider.detectedCollision(new Friend(), new Enemy()), false);
        //by default, the friend and enemy shouldn't collide.
    }

    /*@Test
    public void testTrackCollision() throws Exception {
        Collision tempcoll = new Collision(tempf, tempe);
        mycollider.trackCollision(tempcoll);
    }*/

    @Test
    public void testHandleCollision() throws Exception {
        mycollider.handleCollision(tempf, tempe);//handle one collision
    }

    @Test
    public void testHandleCollisions() throws Exception {
        mycollider.handleCollisions();//handle multiple collisions
    }

    /*@Test
    public void testAddHandlers() throws Exception {
        mycollider.addHandlers();//for lists
    }*/

    /*@Test
    public void testAddHandlers1() throws Exception {
        mycollider.addHandlers();//for maps
    }*/

    /*@Test
    public void testAddDetectors() throws Exception {
        mycollider.addDetectors();//for lists
    }*/

    /*@Test
    public void testAddDetectors1() throws Exception {
        mycollider.addDetectors();//for maps
    }*/

    @Test
    public void testGetCollisionString() throws Exception {

        assertEquals(mycollider.getCollisionString(tempf, tempe), tempf.getCollisionKey() + tempe.getCollisionKey());
    }
    public static void callBack(ICollider a, ICollider b) {
        actual++;
    }
}