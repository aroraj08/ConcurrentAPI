package com.sorting;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {

        //int[] array = {20, 35, -15, 7, 55, 1, -22};

        int[] array = {1, 15, -22};

        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();

        mergeSort(array, 0, array.length);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    private static void mergeSort(int[] input, int start, int end) {

       if (end - start < 2) {
           return;
       }
        int mid = (start+end)/2;
       mergeSort(input, start, mid);
       mergeSort(input, mid, end);
       merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {

        if (input[mid-1] <= input[mid]) {
            return;
        }

        int[] temp = new int[end-start];
        int i = start;
        int j = mid;

        int index = 0;

        while(i < mid && j < end) {
            if (input[i] <= input[j]) {
                temp[index] = input[i];
                i++;
            } else {
                temp[index] = input[j];
                j++;
            }
            index++;
        }

        while(j < end) {
            temp[index++] = input[j];
            j++;
        }

        while(i < mid) {
            temp[index++] = input[i];
            i++;
        }
        // src, srcPos, dest, destPos, length
        System.arraycopy(input, i, input, start + index, mid - i);
         System.arraycopy(temp, 0, input, start, index);

    }
}
