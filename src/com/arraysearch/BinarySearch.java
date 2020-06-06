package com.arraysearch;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array1 = {2, 3, 4, 6, 7, 8, 11};
        int[] array2 = {2, 3, 4, 6, 7, 8};
        int[] array3 = {1};
        int[] array4 = {1, 2};
        int[] array5 = {1, 2, 4, 5,6, 7,8, 9 ,10, 11, 15};

        System.out.println(binarySearchRecursive(array1, 2));
        System.out.println(binarySearchRecursive(array2, 3));
        System.out.println(binarySearchRecursive(array3, 1));
        System.out.println(binarySearchRecursive(array4, 1));
        System.out.println(binarySearchRecursive(array5, 17));

    }

    private static int binarySearchIterative(int[] input, int numToSearch) {

        if (input == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int startIndex = 0;
        int endIndex = input.length-1;

        while (startIndex <= endIndex) {

            int mid = (startIndex + endIndex)/2;
            if (numToSearch == input[mid]) {
                return mid;
            } else if (numToSearch < input[mid]) {
                endIndex = mid-1;
            } else {
                startIndex = mid+1;
            }
        }

        return -1;
    }

    private static int binarySearchRecursive(int[] input, int numToSearch) {

        if (input == null) {
            throw new IllegalArgumentException("Input array is null");
        }
        return binarySearchInternal(input, 0, input.length-1, numToSearch);
    }

    private static int binarySearchInternal(int[] input, int startIndex, int endIndex, int numToSearch) {

        if (startIndex > endIndex) {
            return -1;
        }

        int mid = (startIndex + endIndex)/2;
        if (numToSearch == input[mid]) {
            return mid;
        } else if (numToSearch < input[mid]) {
            return binarySearchInternal(input, startIndex, mid-1, numToSearch);
        } else {
            return binarySearchInternal(input, mid+1, endIndex, numToSearch);
        }
    }
}
