package collidascope.collidatracka;

import collidascope.Collision;
import examples.Enemy;
import examples.Friend;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import static org.junit.Assert.*;

public class TrackerTest {

    private Tracker mytracker;
    private Collision mycoll;
    private Set<Collision> setofcoll;
    private Friend tempf;
    private Enemy tempe;
    @Before
    public void setUp() throws Exception
    {
        mytracker = new Tracker();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testTrack() throws Exception {
        //i'm going to compare that when the stuff changes, it behaves the same as if it was in a set(since that's what it does.
        setofcoll =  new TreeSet<>((Collision one, Collision theOther)
                ->
                theOther.getPriority() - one.getPriority()
        );
        tempf = new Friend();
        tempe = new Enemy();
        mycoll = new Collision(tempf, tempe);
        setofcoll.add(mycoll);
        mytracker.track(mycoll);//insert similarly to how we inserted in a setof collisions.

        Iterator setofcolliter = setofcoll.iterator();//these should be very similar as well.
        Iterator mytrackeriter = mytracker.iterator();
        //If I iterate between the two, they should be virtually the same, since I ony inputted the same values.


        //assertEquals(setofcolliter.hasNext(), mytrackeriter.hasNext());//make sure the element exists
        assertEquals(setofcolliter.next(), mytrackeriter.next());

    }

    @Test
    public void testClear() throws Exception {
        //technically never used.
        setofcoll =  new TreeSet<>((Collision one, Collision theOther)
                ->
                theOther.getPriority() - one.getPriority()
        );
        setofcoll.clear();
        mytracker.clear();
        assertEquals(mytracker.iterator().hasNext(), setofcoll.iterator().hasNext());
        //make sure nothing exists in these, since the stuff was cleared.
    }

    @Test
    public void testIterator() throws Exception {
        //assertTrue(mytracker.iterator() instanceof Iterator<Collision>);//trivial test just make sure that it returns an iterator
        //TODO make sure above works
        assertNotEquals(mytracker.iterator(), null);
    }

    /*@Test
    public void testForEach() throws Exception {
        setofcoll =  new TreeSet<>((Collision one, Collision theOther)
                ->
                theOther.getPriority() - one.getPriority()
        );
        tempf = new Friend();
        tempe = new Enemy();
        mycoll = new Collision(tempf, tempe);
        setofcoll.add(mycoll);
        mytracker.track(mycoll);//insert similarly to how we inserted in a setof collisions.
    }*/

    @Test
    public void testSpliterator() throws Exception {
        //assertTrue(mytracker.spliterator() instanceof Spliterator<Collision>);
        //TODO make sure above works
        assertNotEquals(mytracker.iterator(), null);
    }
}