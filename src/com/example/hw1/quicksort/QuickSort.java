package com.example.hw1.quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    private int[] numbersToSort;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  // Create a Scanner object

        QuickSort qs = new QuickSort();
        showMessage("Enter numbers with spaces to be able to sort them below: ");
        qs.numbersToSort = receiveParseAndReturnArrayToQS(input);

        qs.quickSort(qs.numbersToSort);

        showMessage("AFTER applying Quick Sort algorithm...");
        System.out.println(qs);
    }

    //Receive the input from user's keyboard, parse and return and int[] to sort.

    private static int[] receiveParseAndReturnArrayToQS(Scanner input) {
        //String inserted by user.
        String stringOfNumbers = input.nextLine();
        //
        String[] numbersToParse = stringOfNumbers.split("\\s+");
        int[] myNumbersToSort = new int[numbersToParse.length];
        for (int i = 0; i < numbersToParse.length; i++) {
            myNumbersToSort[i] = Integer.parseInt(numbersToParse[i]);
        }

        return myNumbersToSort;
    }
    //Simple show message method.
    private static void showMessage(String msg) {
        System.out.println(msg);
    }

    public void quickSort(int[] arrayToQuickSort) {
        quickSort(arrayToQuickSort, 0, arrayToQuickSort.length - 1);
    }

    private void quickSort(int[] arrayToQuickSort, int low, int high) {
        if (low < high + 1) {
            int p = partition(arrayToQuickSort, low, high);
            quickSort(arrayToQuickSort, low, p - 1);
            quickSort(arrayToQuickSort, p + 1, high);
        }
    }
    //Swaps number positions.
    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    // Returns random pivot index between low and high inclusive.
    private int getPivot(int low, int high) {
        Random random = new Random();
        return random.nextInt((high - low) + 1) + low;
    }
    //moves all n < pivot to the left of pivot and all n > pivot
    // to the right of pivot, then returns pivot index.
    private int partition(int[] A, int low, int high) {
        swap(A, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (A[i] < A[low]) {
                swap(A, i, border++);
            }
        }
        swap(A, low, border - 1);
        return border - 1;
    }

    @Override
    public String toString() {
        return "Quick Sort result: " + Arrays.toString(numbersToSort);
    }
}

