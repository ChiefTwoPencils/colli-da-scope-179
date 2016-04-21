package collidascope.collidahandla;

import collidascope.ICollider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.junit.Assert.*;

/**
 * Created by brian on 4/19/2016.
 */
public class HandlerTest {
    private Handler myHandler;
    private Map<String, BiConsumer<ICollider, ICollider>> handlers;

    @Before
    public void setUp() throws Exception {

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
        List<String> keys = new ArrayList<String>();
        List<BiConsumer<ICollider, ICollider>> handlers = new ArrayList<>();
        myHandler.addHandlers(keys, handlers);
    }

    @Test
    public void handleCollision() throws Exception {

    }

    @Test
    public void handleCollisions() throws Exception {

    }

}