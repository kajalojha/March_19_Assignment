package March_20_Assignment; // Package declaration

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MyHashSet {
    private final int capacity; // Capacity of the hash set
    private final List<List<Integer>> buckets; // List of buckets for chaining

    // Constructor to initialize the hash set with a given capacity
    public MyHashSet(int capacity) {
        this.capacity = capacity;
        buckets = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    // Hash function to calculate the index for a given key
    private int hash(int key) {
        return key % capacity;
    }

    // Method to add a value to the hash set
    public void add(int value) {
        int index = hash(value);
        if (!contains(value))
            buckets.get(index).add(value);
    }

    // Method to check if a value exists in the hash set
    public boolean contains(int value) {
        int index = hash(value);
        List<Integer> bucket = buckets.get(index);
        for (int num : bucket) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    // Method to remove a value from the hash set
    public int remove(int value) {
        int index = hash(value);
        List<Integer> bucket = buckets.get(index);
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) == value) {
                bucket.remove(i);
                return value;
            }
        }
        return -1;
    }
}

public class Q1_Hash_set {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the capacity of HashSet: ");
        int capacity = scanner.nextInt();
        MyHashSet hashSet = new MyHashSet(capacity); // Create an instance of MyHashSet

        System.out.print("Enter the number of queries: ");
        int numQueries = scanner.nextInt(); // Number of queries
        System.out.println("Enter queries (1 for add, 2 for contains, 3 for remove):");

        // Process each query
        for (int i = 0; i < numQueries; i++) {
            int queryType = scanner.nextInt(); // Query type
            int value = scanner.nextInt(); // Value associated with the query

            // Perform operations based on query type
            if (queryType == 1) {
                hashSet.add(value);
            } else if (queryType == 2) {
                System.out.println(hashSet.contains(value));
            } else if (queryType == 3) {
                System.out.println(hashSet.remove(value));
            } else {
                System.out.println("Invalid query type.");
            }
        }
    }
}
