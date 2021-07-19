package com.github.alg.cormen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TestMergeSort {
    public static void main(String[] args) {

        Random rand = new Random();
        int N = 1000000;

        int[] A = new int[N];
        for(int x = 0; x < N; x++) A[x] = rand.nextInt();
        int[] B = Arrays.copyOf(A,N);

        long s,e;
        s = System.nanoTime();
        mergeSort(A,0,A.length - 1);
        e = System.nanoTime();

        System.out.print("[sorted] : ");
//        for(int x:A) System.out.print(x);
        System.out.println("\n[Time Taken]:"+(e-s) + "ns");


        long s1,e1;
        s1 = System.nanoTime();
        Arrays.parallelSort(B); // qsort()
        e1 = System.nanoTime();
        System.out.print("[Time taken]: factory sort - " + (e1-s1)+" ns");
    }

    static void merge(int[] A, int p, int q, int r){
        int n1 = q-p+1;
        int n2 = r-q;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0;i < n1; i++) L[i] = A[p+i];

        for(int j = 0;j < n2; j++) R[j] = A[q + 1 +j];

        int i = 0, j = 0, k = p;

        while( i < n1 & j < n2){
            if(L[i] <= R[j]) A[k++] = L[i++];
            else A[k++] = R[j++];
        }

        while (i < n1) A[k++] = L[i++];
        while (j < n2) A[k++] = R[j++];

    }

    static void mergeSort(int[] A, int p, int r){
        if(p < r) {
            int mid = (int) Math.floor((p + r) / 2);
            mergeSort(A,p,mid);
            mergeSort(A,mid+1,r);
            merge(A,p,mid,r);
        }
    }
}
