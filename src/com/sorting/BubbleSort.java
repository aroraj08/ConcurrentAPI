package com.sorting;

/**
 * In Bubble sort, largest element is bubbled to the right of the array in each iteration.
 * Performance degrades quickly as the number of elements to sort increase.
 * In place algorithm.  O(n raised to power 2) time complexity
 * This algo is not practically
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        bubbleSort(array, 0, array.length-1);

        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void bubbleSort(int[] array, int start, int end) {

        int j = end;
        while (start < end) {

            for(int i=0; i<j; i++) {

                if (array[i] > array[i+1]) {
                    // swap the values
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            start++;
            j--;
        }

    }
}
