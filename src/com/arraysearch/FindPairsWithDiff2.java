package com.arraysearch;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class FindPairsWithDiff2 {

    public static void main(String[] args) {

        //int[] array = {1, 7, 3, 2, 9, 5, 10, 4, 3};
        int[] array = {1, 2, 2, 3, 3};
        //findPairsWithDiff(array, 11);
        //findPairsWithDiff(array, 4);
        findPairsWithDiff(array, 0);
        //findPairsWithDiff(array, -1);
        //findPairsWithDiff(array, 1);
    }

    private static void findPairsWithDiff(int input[], int diff) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Input Array can not be null or empty");
        }
        System.out.println();
        System.out.print("Pairs with diff as " + diff + " are: ");
        Arrays.sort(input);  // sort the array

        int counter = 0;
        for (int i = 0; i< input.length-1; i++) {
            int numToSearch = input[i] + Math.abs(diff);
            int resultIndex = binarySearch(input, i+1, input.length-1, numToSearch);
            if (resultIndex != -1) {
                // combination found
                System.out.printf("[%s, %s] ", input[i], input[resultIndex]);
                counter++;
            }
        }
        if (counter == 0) {
            System.out.printf("No pairs found");
        }
    }

    private static int binarySearch(int[] input, int start, int end, int numToSearch) {

        while (start <= end) {
            int mid = (start + end)/2;
            if (input[mid] == numToSearch) {
                return mid;
            } else if (numToSearch < input[mid]) {
                end = mid-1;
            } else  {
                start = mid + 1;
            }
        }
        return -1;
    }
}
