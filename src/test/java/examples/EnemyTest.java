package examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyTest {
    private Enemy myEnemy;
    @Test
    public void update() throws Exception {

    }

    @Test
    public void getCollisionKey() throws Exception {
        myEnemy = new Enemy();//constructor doesn't matter, is always "Enemy".
        assertEquals(myEnemy.getCollisionKey(), "Friend");
    }
}