package March_20_Assignment;
import java.util.Arrays;
import java.util.Scanner;

public class Q3_Pair_Difference {
    public static int countPairsWithDifferenceK(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to make finding pairs easier
        int count = 0;
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            int diff = Math.abs(nums[right] - nums[left]);
            if (diff == k) {
                count++;
                left++;
                right++;
            } else if (diff < k) {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                right++;
            }
        }

        return count;
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
        int result = countPairsWithDifferenceK(nums, k);
        System.out.println("Count of pairs with difference " + k + ": " + result);
    }
}
