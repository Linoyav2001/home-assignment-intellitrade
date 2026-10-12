import java.util.HashSet;
import java.util.Set;

/**
 * Solution for Task 6: Array Intersection.
 * 
 * Trade-offs & Alternatives:
 * /*
 * Design Considerations & Trade-offs:
 * 
 * For the array intersection, I chose a HashSet approach. This provides an 
 * average time complexity of O(N+M), though it is an average-case bound rather 
 * than a worst-case guarantee due to potential hash collisions. To optimize 
 * memory, the code dynamically ensures the set is built from the smaller array, 
 * bounding the space complexity to O(min(N,M)).
 * 
 * An alternative approach would be to sort both arrays and use two pointers 
 * to find matching elements. While this reduces the auxiliary space complexity 
 * to O(1), the sorting step increases the time complexity to O(N log N + M log M). 
 * Therefore, the HashSet approach is faster for unsorted data, while the sorting 
 * approach is preferable only under strict memory limitations.
 */


public class Task6 {

    /**
     * Finds the intersection of two integer arrays.
     * The returned array contains unique elements that are present in both input arrays.
     * 
     * @param arr1 The first array.
     * @param arr2 The second array.
     * @return An array containing the intersection. Returns an empty array if inputs are null or empty.
     */
    public static int[] intersection(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return new int[0];
        }

        if (arr1.length > arr2.length) {
            return intersection(arr2, arr1);
        }

        Set<Integer> set1 = new HashSet<>();
        for (int num : arr1) {
            set1.add(num);
        }

        Set<Integer> intersectionSet = new HashSet<>();
        for (int num : arr2) {
            if (set1.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }
}