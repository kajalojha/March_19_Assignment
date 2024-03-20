package March_20_Assignment;

import java.util.Scanner;

public class Q2_Longest_SubArray {
    public static int longestSubarrayLength(int[] nums, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (right < nums.length) {
            max = Math.max(max, nums[right]);
            min = Math.min(min, nums[right]);

            if (Math.abs(max - min) <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                left = right + 1;
                right = left;
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

        // Input value of K
        System.out.print("Enter the value of K: ");
        int k = scanner.nextInt();

        // Calculate and output the result
        int result = longestSubarrayLength(nums, k);
        System.out.println("Length of the longest subarray: " + result);
    }
}
