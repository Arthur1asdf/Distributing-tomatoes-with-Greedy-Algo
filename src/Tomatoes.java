/* Arthur Teng
 * Dr. Steinberg
 * COP3503 Spring 2024
 * Programming Assignment 3
 */
import java.util.Arrays;
public class Tomatoes {
    //array is given in driver file
    //we call this method in driver file and return the number of moves
    public int minTomatoMoves(int pots[])
    {
        //calculates the total amount of tomatoes
        int sumOfTomatoes = Arrays.stream(pots).sum();
        //for us to know how many tomatoes should be in each pot
        int numOfTomatoInEachPot = sumOfTomatoes/pots.length;
        //System.out.println("The number of Tomatoes" + sumOfTomatoes + " num of tomatoes in each pot" + numOfTomatoInEachPot);
        //To jump out of code if we notice that the number of tomatoes can not be divided equally among the pots
        if(sumOfTomatoes % pots.length != 0)
        {
            return 0;
        }
        //greedy approach
        int currentImbalance = 0;
        int currentDifference = 0;
        int currentMax;
        int prevMax = 0;
        for(int i = 0; i < pots.length; i++)
        {
           currentDifference = pots[i] - numOfTomatoInEachPot;
           //tracks the current imbalance
           currentImbalance = currentImbalance + currentDifference;

           currentMax = Math.max(currentDifference, Math.abs(currentImbalance));
           //checks to see if I need to replace the prev max with the current max
           if (prevMax < currentMax)
           {
            prevMax = currentMax;
           }
           //System.out.println(pots[i] + " currentDifference: " + currentDifference + " currentImbalance: " + currentImbalance + " currentMax: " + currentMax + " previous Max: " +prevMax);

        }
        return prevMax;
    }
}
