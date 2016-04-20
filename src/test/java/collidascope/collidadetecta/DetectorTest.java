package collidascope.collidadetecta;

import collidascope.Collision;
import collidascope.ICollider;
import examples.Enemy;
import examples.Friend;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.junit.Assert.*;

/**
 * Created by Austin on 4/20/2016.
 */
public class DetectorTest {
    private Detector mydetect;
    private Friend tempf;
    private Enemy tempe;
    private String tempkey;
    @Before
    public void setUp() throws Exception {
        mydetect = new Detector();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddDetectors() throws Exception {

    }

    @Test
    public void testAddDetectors1() throws Exception {

    }

    @Test
    public void testDetectCollision() throws Exception {
        assertEquals(mydetect.detectCollision(null,null,null), false);//make sure it defaults to false
        assertEquals(mydetect.detectCollision(tempf, tempe, null), false);//should also be false, no key.
        tempf = new Friend();
        tempe = new Enemy();
        tempkey = tempf.getCollisionKey() + tempe.getCollisionKey();//get key


        mydetect.addDetectors(tempf.getDetectors());//add detectors for these things.
        mydetect.addDetectors(tempe.getDetectors());



        assertEquals(mydetect.detectCollision(tempf, tempe, tempkey), true);//now the thing should work properly.
        tempf = new Friend(new Point2D.Double(250, 250));
        tempe = new Enemy(new Point2D.Double(250, 250));


        mydetect.addDetectors(tempf.getDetectors());//add detectors for these things.
        mydetect.addDetectors(tempe.getDetectors());
        tempkey = tempf.getCollisionKey() + tempe.getCollisionKey();//get key
        assertEquals(mydetect.detectCollision(tempf, tempe, tempkey), true);//now the thing should work properly.


        //test to make sure it's false if they are too far away.
        tempf = new Friend(new Point2D.Double(0, 0));
        tempe = new Enemy(new Point2D.Double(500, 500));


        mydetect.addDetectors(tempf.getDetectors());//add detectors for these things.
        mydetect.addDetectors(tempe.getDetectors());
        tempkey = tempf.getCollisionKey() + tempe.getCollisionKey();//get key
        assertEquals(mydetect.detectCollision(tempf, tempe, tempkey), false);//now the thing should work properly.

}
}