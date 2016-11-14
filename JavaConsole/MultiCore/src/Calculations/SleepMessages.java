/*
 * This is an efficient means of making processor time available to the other 
 * threads of an application or other applications that might be running on a 
 * computer system.
*/

public class SleepMessages {
    public static void main(String args[])
        throws InterruptedException 
        {
            String importantInfo[] = 
            {
                "Mares eat oats.",
                "Does eat oats.",
                "Little lambs eat ivy.",
                "A kid will eat ivy too.",
                "Wouldn't you?"
            };

            for (int i = 0;  i < importantInfo.length; i++) 
            {
                //Pause for 4 seconds
                Thread.sleep(4000);
                //Print a message
                System.out.println(importantInfo[i]);
            }
        }
}