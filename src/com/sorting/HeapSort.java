package com.sorting;

public class HeapSort {

    public static void main(String[] args) {

        int[] array =  {20, 35, -15, 7, 55, 1, -22};

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();

        heapSort(array, 0, array.length);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void heapSort(int[] input, int start, int end) {

        if (end-start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        heapSort(input, start, pivotIndex);
        heapSort(input, pivotIndex+1, end);
    }

    private static int partition(int[] input, int start, int end) {

        int i= start;
        int j = end;

        int pivot = input[i];

        while(i < j) {

            while(i < j && input[--j] > pivot);

            if (i < j) { // element found
                input[i] = input[j];
            }

            while (i<j && input[++i] < pivot);

            if (i<j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
}
