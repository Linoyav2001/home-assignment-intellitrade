import java.util.concurrent.atomic.AtomicInteger;

/**
 * A thread-safe counter implementation using AtomicInteger for lock-free, 
 * high-performance concurrency.
 */
public class Task5 {
    
    private final AtomicInteger count;

    /**
     * Initializes the counter to a specified value.
     * 
     * @param initialValue The starting value of the counter.
     */
    public Task5(int initialValue) {
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