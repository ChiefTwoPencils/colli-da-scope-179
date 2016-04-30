package collidascope.collidahandla;

import collidascope.ICollider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import static collidascope.CollidaTestUtil.*;

/**
 * Created by brian on 4/19/2016.
 */
public class HandlerTest {
    private Handler myHandler;
    private Map<String, BiConsumer<ICollider, ICollider>> handlers;
    private final int MANY = 2;
    private List<String> keys;
    private List<BiConsumer<ICollider, ICollider>> consumers;
    private static int expected = 0;
    private static int actual = 0;

    @Before
    public void setUp() throws Exception {
        myHandler = new Handler();
        keys =  getListOfKeys(MANY);
        consumers = getListOfConsumers(MANY);
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void addHandlers() throws Exception {
        handlers = new HashMap<>();
        myHandler.addHandlers(handlers);

    }

    @Test
    public void addHandlers1() throws Exception {
        myHandler.addHandlers(keys, consumers);
        expected = keys.size();
        actual = 0;
        for (String key : keys) {
            myHandler.handleCollision(null, null, key);
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void handleCollision() throws Exception {

    }

    @Test
    public void handleCollisions() throws Exception {

    }
    public static void callBack(ICollider a, ICollider b) {
        actual++;
    }
}