package com.arraysearch;

import java.util.Arrays;

public class FindPairsWithDiff {

    public static void main(String[] args) {

        //int[] array = {1, 7, 3, 2, 9, 5, 10, 4, 3};
        int[] array = {1,2, 2, 3, 3};
        findPairsWithDiff(array, 1);
        //findPairsWithDiff(array, 4);
        //findPairsWithDiff(array, 0);
       // findPairsWithDiff(array, -1);
        //findPairsWithDiff(array, 1);
    }

    /**
     * @param input the input array to search
     * @param diff the number which should be the difference between pairs of elements
     * @throws IllegalArgumentException if input array is null or empty
     */
    private static void findPairsWithDiff(int[] input, int diff) {

        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Input Array can not be null or empty");
        }

        Arrays.sort(input);  // sort the array

        int left = 0;
        int right = 1;
        diff = Math.abs(diff);
        int counter = 0;
        System.out.printf("\nPairs with diff as %s are: ", diff);

        while(right < input.length) {

            int currentDiff = input[right] - input[left];

            if (currentDiff == diff && (left != right)) {
                System.out.print("[" + input[right] + "," + input[left] + "] ");
                left++;
                right++;
                counter++;
            } else if (currentDiff > diff) {
                left++;
            } else {
                right++;
            }
        }
        if(counter == 0) {
            System.out.print("No pairs found");
        }
    }
}
