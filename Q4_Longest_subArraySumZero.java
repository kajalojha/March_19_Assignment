package March_20_Assignment;

import java.util.HashMap;
import java.util.Scanner;

public class Q4_Longest_subArraySumZero {
    public static int longestSubarrayLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                maxLength = i + 1; // Subarray from index 0 to i has sum zero
            } else {
                if (map.containsKey(sum)) {
                    maxLength = Math.max(maxLength, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // Calculate and output the result
        int result = longestSubarrayLength(nums);
        System.out.println("Length of the longest subarray with sum zero: " + result);
    }
}
