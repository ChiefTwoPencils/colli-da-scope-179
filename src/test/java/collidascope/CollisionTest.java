package collidascope;

import examples.Enemy;
import examples.Friend;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollisionTest {

    private Collision mycollision;
    private Friend tempf;
    private Enemy tempe;
    @Before
    public void setUp() throws Exception {
        tempf = new Friend();
        tempe = new Enemy();
        mycollision = new Collision(tempf, tempe);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetPriority() throws Exception {
        assertEquals(mycollision.getPriority(), 5);//default is 5 when made.
    }

    @Test
    public void testGetOne() throws Exception {
        assertEquals(mycollision.getOne(), tempf);//first parameter should be the getOne
    }

    @Test
    public void testGetTheOther() throws Exception {
        assertEquals(mycollision.getTheOther(tempf), tempe);//second parameter should be getother, if getother is passed getone
        assertEquals(mycollision.getTheOther(mycollision.getOne()),tempe);
    }

    @Test
    public void testGetCollisionKey() throws Exception {
        assertEquals(mycollision.getCollisionKey(),tempf.getCollisionKey() + tempe.getCollisionKey());
        //assertEquals(Collider.getCollisionString(tempf, tempe), tempf.getCollisionKey() + tempe.getCollisionKey());
        //not sure if needed, same as the above case, but more direct.
    }
}