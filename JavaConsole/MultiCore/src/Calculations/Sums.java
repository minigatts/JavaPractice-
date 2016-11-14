import java.util.*;
import java.util.concurrent.*;
import static java.util.Arrays.asList;

/*  Not sure wha this does exactly, simple program showing implementation of 
 *  java.util concurrent functionality for multithreading.  Will break it down
 *  and study it later.
 */

public class Sums {
    
    static class Sum implements Callable<Long> 
    {
        private final long from;
        private final long to;
            Sum(long from, long to) 
            {
                this.from = from;
                this.to = to;
            }
        
        @Override
        public Long call() 
        {
            long acc = 0;
            for (long i = from; i <= to; i++) 
            {
                acc = acc + i;
            }
            return acc;
        }                
    }
    
    public static void main(String[] args) throws Exception 
    {
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        List <Future<Long>> results = executor.invokeAll(asList(
            new Sum(0, 10), new Sum(100, 1_000), new Sum(10_000, 1_000_000)
        ));
        
        /*
         * Executor service must be shut down. If it is not shut down, the Java 
         * Virtual Machine will not exit when the main method does, because 
         * there will still be active threads around.
         */
        executor.shutdown();         
        
        for (Future<Long> result : results) 
        {
            System.out.println(result.get());
        }
        
    }    
}