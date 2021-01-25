/*
 *	If you are getting a StackOverflow exception while running the following program, perform the following:
 *		1. Go to Run > Run Configurations
 *      2. Click on the tab that reads "(x)= Arguments"
 *      3. In the box labeled "VM arguments:", add this: -Xss64m
 */
public class FasterFunctions
{
    public static void main(String[] args)
    {
        float totalTime = 0;
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() ->
        {
            SlowFunctions.slowSortLargeArray();
        });
        Thread t2 = new Thread(() ->
        {
            SlowFunctions.ackermann(3, 14);
        });
        Thread t3 = new Thread(() ->
        {
            SlowFunctions.millionsOfSqrts();
        });
        t1.start();
        t2.start();
        t3.start();
        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //Your Code Here


        float endTime = (float) ((double) System.currentTimeMillis() - (double) startTime) / 1000.0f;
        totalTime += endTime;
        System.out.println("Total Time: " + totalTime);
    }
}
