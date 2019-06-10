import sofia.micro.*;
import sofia.micro.jeroo.*;
import static sofia.micro.jeroo.CompassDirection.*;
import static sofia.micro.jeroo.RelativeDirection.*;

// -------------------------------------------------------------------------
/**
 *  Tests the methods in MazeRunner
 *
 *  @author Andrew Perry (andrewperry)
 *  @version 2018.09.17
 */
public class MazeRunnerTest extends TestCase
{
    //~ Fields ................................................................


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new MazeRunnerTest test object.
     */
    public MazeRunnerTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
    }


    // ----------------------------------------------------------
    /*# Insert your own test methods here */
    
    /**
     * Test the goBack method with one false
     */
    public void testgoBackOneFale()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(2);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 3, 6);

        // 2. Call the method(s) you are testing
        todd.goBack();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(3, todd.getGridX());
        assertEquals(6, todd.getGridY());
        assertTrue(todd.isFacing(EAST));

    }
    
    /**
     * Test the goForward method
     */
    public void testgoForward()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(2);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 1, 9);

        // 2. Call the method(s) you are testing
        todd.goForward();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(3, todd.getGridX());
        assertEquals(9, todd.getGridY());
        assertTrue(todd.isFacing(EAST));

    }
    
    /**
     * Test the goForward method with one false
     */
    public void testgoForwardOneFalse()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(2);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 1, 8);

        // 2. Call the method(s) you are testing
        todd.goForward();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(1, todd.getGridX());
        assertEquals(8, todd.getGridY());
        assertTrue(todd.isFacing(EAST));

    }
    
    /**
     * Test the pickFlowers method
     */
    public void testpickFlowers()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(100);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 6, 5);

        // 2. Call the method(s) you are testing
        todd.pickFlowers();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(7, todd.getGridX());
        assertEquals(5, todd.getGridY());
        assertTrue(todd.isFacing(EAST));

    }
    
    /**
     * Test the disableNets method
     */
    public void testdisableNets()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(100);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 8, 3);

        // 2. Call the method(s) you are testing
        todd.disableNets();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(9, todd.getGridX());
        assertEquals(3, todd.getGridY());
        assertTrue(todd.isFacing(EAST));

    }
    
    /**
     * Test the takeTurn() method
     */
    public void testtakeTurn()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(22);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 5, 5);

        // 2. Call the method(s) you are testing
        todd.takeTurn();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(5, todd.getGridX());
        assertEquals(6, todd.getGridY());
        assertTrue(todd.isFacing(SOUTH));

    }
    /**
     * Test the takeTurn method on flowers
     */
    public void testtakeTurnFlowers()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(22);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 1, 4);

        // 2. Call the method(s) you are testing
        todd.takeTurn();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(1, todd.getGridX());
        assertEquals(5, todd.getGridY());
        assertTrue(todd.isFacing(SOUTH));
        assertEquals(10, island.getObjects(Flower.class).size());

    }
    /**
     * Test the takeTurn method with nets
     */
    public void testtakeTurnNets()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(22);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 5, 2);

        // 2. Call the method(s) you are testing
        todd.takeTurn();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(5, todd.getGridX());
        assertEquals(3, todd.getGridY());
        assertTrue(todd.isFacing(SOUTH));
        assertEquals(11, island.getObjects(Net.class).size());

    }
     /**
     * Test myProgram() method
     */
    public void testmyProgram()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(2);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 3, 9);

        // 2. Call the method(s) you are testing
        todd.myProgram();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(1, todd.getGridX());
        assertEquals(1, todd.getGridY());
        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());

    }
    
    /**
     * Test myProgram() method on a flower
     */
    public void testmyProgramOnFlower()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(55);
        MazeRunner todd = new MazeRunner(15);
        island.add(todd, 1, 5);

        // 2. Call the method(s) you are testing
        todd.myProgram();

        // 3. Make assertions capturing your expected outcomes
        assertEquals(0, island.getObjects(Flower.class).size());
        assertEquals(0, island.getObjects(Net.class).size());

    }
    
    /**
     * Test MazeRunner default constructor
     */
    public void testMazeRunner()
    {
        // 1. Set up initial conditions
        Island island = new MazeIsland(55);
        MazeRunner todd = new MazeRunner();
        island.add(todd, 1, 5);

        // 3. Make assertions capturing your expected outcomes
        assertTrue(todd.hasFlower());
        

    }

}
