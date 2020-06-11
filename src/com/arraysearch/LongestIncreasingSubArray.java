package com.arraysearch;

public class LongestIncreasingSubArray {

    public static void main(String[] args) {

        int[] array = {5, 6, 3, 5, 4, 7, 8, 9, 1, 2,3,1,4,5,6,1,7};

        int lastMinIndex = 0;
        int lastMaxIndex = 0;

        int newMinIndex = 0;
        int newMaxIndex = 0;

        boolean isFirstOccurence = true;
        for (int i=0; i< array.length-1; i++) {

            if (array[i] < array[i+1]) { // order is increasing

                newMaxIndex++;
            } else {
                if (!isFirstOccurence) {

                    // compare last and new min max indes
                    int lengthLastIndex = lastMaxIndex - lastMinIndex;
                    int lengthNewIndex = newMaxIndex - newMinIndex;
                    if (lengthNewIndex > lengthLastIndex) {
                        lastMinIndex = newMinIndex;
                        lastMaxIndex = newMaxIndex;
                    }
                } else {
                    lastMaxIndex= i;
                }
                    newMinIndex = i+1;
                    newMaxIndex = i+1;
                    isFirstOccurence = false;
            }
        }

        int lengthLastIndex = lastMaxIndex - lastMinIndex;
        int lengthNewIndex = newMaxIndex - newMinIndex;
        if (lengthNewIndex > lengthLastIndex) {
            System.out.println(newMinIndex + "," + newMaxIndex);
        } else {
            System.out.println(lastMinIndex + "," + lastMaxIndex);
        }
    }


}
