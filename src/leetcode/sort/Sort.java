package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    public int[] bubbleSort(int[] array){
        // for each element, swap with next if larger. repeat n times

        for (int i=0; i<array.length-1; i++)
        {
            boolean swapped = false;
            for (int j=0; j< array.length-i-1; j++) // i is number of elements sorted
            {
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return array;
    }

    public int[] selectionSort(int[] array){
        // iterate n times, each time find the smallest/largest element and place element in position.

        for (int i=0; i<array.length; i++)
        {
            int minIndex = i;
            for (int j=i+1; j< array.length; j++) // i is number of elements sorted
            {
                if (array[j] < array[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public int[] insertionSort(int[] array){
        // for each element, place into correct position on left. left is sorted.

        for (int i=1; i<array.length; i++)
        {
            int j=i-1;
            int current = array[i];
            while (j>=0 && array[j]>current)
            {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
        return array;
    }

    public int[] mergeSort(int[] array){
        // break up to single elements and merge.

        if (array.length == 0) return array;
        return mergeSort(array, 0, array.length-1);
    }

    private int[] mergeSort(int[] array, int l, int r){

        if (l >= r) {
            return new int[]{array[l]};
        }

        int m = l+(r-l)/2;
        int[] left = mergeSort(array, l, m);
        int[] right = mergeSort(array, m+1, r);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {

        // check if size right
        int[] result = new int[left.length + right.length];

        int ptr1 = 0;
        int ptr2 = 0;
        int ptrResult = 0;
        while(ptr1 < left.length && ptr2 < right.length){
            if (left[ptr1] > right[ptr2]) {
                result[ptrResult] = right[ptr2];
                ptr2++;
            } else {
                result[ptrResult] = left[ptr1];
                ptr1++;
            }
            ptrResult++;
        }

        while(ptr1<left.length){
            result[ptrResult] = left[ptr1];
            ptr1++;
            ptrResult++;
        }

        while(ptr2<right.length){
            result[ptrResult] = right[ptr2];
            ptr2++;
            ptrResult++;

        }

        return result;
    }

    public int[] quickSort(int[] array){
        //

        return array;
    }

    public int[] heapSort(int[] array){
        //

        return array;
    }

    public int[] radixSort(int[] array){
        //

        return array;
    }


}
