package pacmiage2.vue.partie;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Aleckes9
 */
public class Partie_AffichageScoreTest {
    
    public Partie_AffichageScoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of render method, of class Partie_AffichageScore.
     */
    @Test
    public void testRender() throws Exception {
        System.out.println("render");
        Graphics g = null;
        Partie_AffichageScore instance = new Partie_AffichageScore();
        instance.render(g);
    }

    /**
     * Test of initPos method, of class Partie_AffichageScore.
     */
    @Test
    public void testInitPos() {
        System.out.println("initPos");
        int xPos = 0;
        int Ypos = 0;
        Partie_AffichageScore instance = new Partie_AffichageScore();
        instance.initPos(xPos, Ypos);
    }

    /**
     * Test of update method, of class Partie_AffichageScore.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int delta = 0;
        Partie_AffichageScore instance = new Partie_AffichageScore();
        instance.update(delta);
    }
    
}