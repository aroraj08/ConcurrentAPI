package com.sorting;

public class MergeSort2 {

    public static void main(String[] args) {

        int[] array = {20, 35, -15, 7, 55, 1, -22};

        //int[] array = {1, 15, -22};

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();

        mergeSort(array, 0, array.length-1);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void mergeSort(int[] array, int start, int end) {

        if (start < end) {

            int mid = (start+end)/2;

            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {

        // create two arrays to hold this data

        int[] arr1 = new int[mid-start+1];
        int[] arr2 = new int[end-mid];
        // put data into these arrays

        for (int i=0; i< arr1.length; i++) {
                arr1[i] = array[start+i];
        }
        for (int j=0; j< arr2.length; j++) {
            arr2[j] = array[mid+1+j];
        }
        // compare these two sorted arrays and put data into input array

        int i = 0;
        int j = 0;

        int k = start;
        while (i<arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {
                array[k] = arr1[i];
                i++;
            } else  {
                array[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i<arr1.length) {
            // copy remaining elements of arr1
            array[k] = arr1[i];
            i++;
            k++;
        }

        while (j<arr2.length) {
            // copy remaining elements of arr1
            array[k] = arr2[j];
            j++;
            k++;
        }

    }
}
