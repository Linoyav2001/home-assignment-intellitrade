import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task5Test {

    @Test
    void testBasicOperations() {
        Task5 counter = new Task5(10);
        
        counter.increment(); // 11
        counter.increment(); // 12
        counter.decrement(); // 11
        
        assertEquals(11, counter.getValue());
    }

    @Test
    void testConcurrencySafety() throws InterruptedException {
        Task5 counter = new Task5(0);
        int numberOfThreads = 100;
        int incrementsPerThread = 1000;
        
        // Use an ExecutorService to manage a thread pool
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        // Use a CountDownLatch to wait for all threads to finish before asserting
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.execute(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
                latch.countDown();
            });
        }

        // Wait for all threads to complete their work
        latch.await();
        executor.shutdown();

        // 100 threads * 1000 increments = 100,000 expected value
        assertEquals(100000, counter.getValue());
    }
}