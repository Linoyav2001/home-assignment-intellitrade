import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread-safe counter implementation using AtomicInteger for lock-free, 
 * high-performance concurrency.
 * 
 * An alternative approach would be using a standard 'int' variable alongside 
 * the 'synchronized' keyword. The 'synchronized' mechanism is lock-based; 
 * when one thread updates the counter, other threads are suspended and forced 
 * to wait in a queue. This creates operating system overhead and can lead to 
 * performance bottlenecks under high concurrency.
 * 
 * In contrast, AtomicInteger utilizes a hardware-level, lock-free mechanism 
 * known as CAS (Compare-And-Swap). This approach is significantly faster and 
 * more efficient for simple operations like counters. By eliminating the need 
 * to suspend and wake up threads, it ensures optimal performance even in 
 * highly concurrent environments.
 */
 
public class Task5 {
    
    private final AtomicInteger count;

    /**
     * Initializes the counter to a specified value.
     * 
     * @param initialValue The starting value of the counter.
     */
    public Task5(int initialValue) { // CONSTRUCTOR
        this.count = new AtomicInteger(initialValue);
    }

    /**
     * Increases the counter by 1.
     */
    public void increment() {
        count.incrementAndGet();
    }

    /**
     * Decreases the counter by 1.
     */
    public void decrement() {
        count.decrementAndGet();
    }

    /**
     * Retrieves the current value of the counter.
     * 
     * @return The current integer value.
     */
    public int getValue() {
        return count.get();
    }
}