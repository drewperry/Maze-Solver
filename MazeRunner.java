import sofia.micro.jeroo.*;

//-------------------------------------------------------------------------
/**
 *  Jeroo can now complete any maze
 *
 *  @author Andrew Perry (andrewperry)
 *  @version 2018.09.17
 */
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Andrew Perry (andrewperry)
public class MazeRunner extends Jeroo
{
    //~ Fields ................................................................



    //~ Constructor ...........................................................
    /**
    * Create a new MazeRunner facing east with int flowers.
    * @param flowers         number of flowers
    *
    */
    public MazeRunner(int flowers)
    {
        super(flowers);
    }
    
    /**
    * Create a new MazeRunner with 15 flowers
    *
    *
    */
    public MazeRunner()
    {
        super(15);
    }
    //~ Methods ...............................................................
    /**
    * Has the MazeRunner loop through the maze
    *
    */
    public void myProgram()
    {
        if (this.seesFlower(HERE))
        {
            this.pick();
        }
        while (getWorld().getObjects(Flower.class).size() != 
            0 || getWorld().getObjects(Net.class).size() != 0)
        {   
            this.disableNets();
            this.goForward();
            this.goBack();
            this.disableNets();
            this.pickFlowers();
            this.takeTurn();
        }
        while (this.getGridX() != 1 || this.getGridY() != 1)
        {
            this.goForward();
            this.goBack();
            this.takeTurn();
        }
        
    }
        

    /**
     * If at deadend, turns around
     * @precondition Jeroo cannot move forward
     * @postcondition Jeroo is facing the opposite direction
     */
    public void goBack()
    {
        while (this.seesWater(AHEAD) && this.seesWater(RIGHT))
        {
            this.turn(LEFT);
        }
    }
    
     /**
     * while it's clear ahead, Jeroo hops
     * @precondition Jeroo has water on right and is clear ahead
     * @postcondition Jeroo hops straight
     */
    public void goForward()
    {
        while (this.seesWater(RIGHT) && this.isClear(AHEAD))
        {
            this.hop();
        }
    }
    
    /**
     * while flower ahead, Jeroo hops and picks
     * @precondition Jeroo has flower ahead
     * @postcondition Jeroo picks flower
     */
    public void pickFlowers()
    {
        while (this.seesFlower(AHEAD))
        {
            this.hop();
            this.pick();
        }
    }
    
    /**
     * while net ahead, Jeroo tosses and hops
     * @precondition Jeroo has net ahead
     * @postcondition Jeroo has no net ahead
     */
    public void disableNets()
    {
        while (this.seesNet(AHEAD))
        {
            this.toss();
            this.hop();
        }
    }
    
    /**
     * Jeroo turns right if the right is clear
     * @precondition The right wall has a wing
     * @postcondition Jeroo turns down right wing
     */
    public void takeTurn()
    {
        if (this.isClear(RIGHT))
        {
            this.turn(RIGHT);
            this.hop();
        }
        if (this.seesFlower(RIGHT))
        {
            this.turn(RIGHT);
            this.hop();
            this.pick();
        }
        if (this.seesNet(RIGHT))
        {
            this.turn(RIGHT);
            this.disableNets();
        }
            
    }
    
    
    
    
    
    
    
 

}
