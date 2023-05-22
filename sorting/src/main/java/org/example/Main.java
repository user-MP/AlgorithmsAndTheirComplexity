package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Invalid range");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int[] createArrayWithRandomValues(int size, int min, int max){
        int arr[]=new int[size];
        for(int i=0;i<arr.length;i++){
            arr[i]=getRandomNumberInRange(min,max);
        }

        return arr;
    }

    public static void bubbleSort(int arr[]){

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
               if(arr[j]>arr[j+1]){
                   int temp=arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
               }


            }
        }
    }


    public static void insertionSort(int arr[]){

        int n = arr.length;
        for (int i = 1; i < n; i++) {
           int current = arr[i];

           int j = i-1;

           while ((j > -1) && (current < arr[j])) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }



    }


    public static void merge(int arr[], int l, int m, int r)
    {

        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];




        int i = 0, j = 0;


        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }


        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }



    public static void mergeSort(int arr[], int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;


            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

             Main.merge(arr, l, m, r);
        }
    }


    public static void main(String[] args) {
        long startTime=0, endTime=0;
        double executionTimeInSeconds=0;


        int numbers[]=createArrayWithRandomValues(52000,-3,150);


          // Bubble

//        System.out.println("Bubble before");
//        System.out.println(Arrays.toString(numbers));
//
//        startTime = System.nanoTime();
//
//        bubbleSort(numbers);
//
//        endTime = System.nanoTime();
//
//        executionTimeInSeconds =(double) (endTime - startTime)/ 1_000_000_000;
//        System.out.println("Bubble after");
//
//        System.out.println(Arrays.toString(numbers));
//
//        System.out.println("Time ="+executionTimeInSeconds+" seconds");


          // Insertion

//        System.out.println("Insertion before");
//        System.out.println(Arrays.toString(numbers));
//
//        startTime = System.nanoTime();
//
//        insertionSort(numbers);
//
//        endTime = System.nanoTime();
//
//        executionTimeInSeconds =(double) (endTime - startTime)/ 1_000_000_000;
//        System.out.println("Insertion after");
//
//        System.out.println(Arrays.toString(numbers));
//
//        System.out.println("Time ="+executionTimeInSeconds+" seconds");

//
//        System.out.println("Insertion after");
//



        // Merge
        System.out.println("Merge before");
        System.out.println(Arrays.toString(numbers));

        startTime = System.nanoTime();

        mergeSort(numbers, 0, numbers.length - 1);

        endTime = System.nanoTime();

        executionTimeInSeconds =(double) (endTime - startTime)/ 1_000_000_000;

        System.out.println("Merge after");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Time ="+executionTimeInSeconds+" seconds");
    }
}