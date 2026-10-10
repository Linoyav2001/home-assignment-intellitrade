import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void testNormalIntersection() {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        
        int[] result = Task6.intersection(arr1, arr2);
        
        Arrays.sort(result);
        assertArrayEquals(new int[]{2}, result);
    }

    @Test
    void testIntersectionWithMultipleElements() {
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9, 4, 9, 8, 4};
        
        int[] result = Task6.intersection(arr1, arr2);
        Arrays.sort(result);
        
        assertArrayEquals(new int[]{4, 9}, result);
    }

    @Test
    void testNoIntersection() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        
        int[] result = Task6.intersection(arr1, arr2);
        
        assertEquals(0, result.length);
    }

    @Test
    void testEmptyArrays() {
        int[] arr1 = {};
        int[] arr2 = {1, 2};
        
        int[] result = Task6.intersection(arr1, arr2);
        assertEquals(0, result.length);
    }

    @Test
    void testNullArrays() {
        int[] arr1 = null;
        int[] arr2 = {1, 2};
        
        int[] result = Task6.intersection(arr1, arr2);
        assertEquals(0, result.length);
    }
}