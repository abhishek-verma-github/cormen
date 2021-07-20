package com.github.alg.cormen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ThreeSum {
    public static void main(String[] args) {
        int SUM = 9;
        int[] A = {1,2,3,4,2,8,7,1,6};

        int[] pair = new int[3];

        ol:for(int i = 0; i < A.length; i++){
            HashSet<Integer> ht = new HashSet<>();
            for(int j = i+1; j < A.length; j++){
                int sm = A[i] + A[j];
                if(ht.contains((SUM-sm))){
                    pair[0] = SUM-sm;
                    pair[1] = A[i];
                    pair[2] = A[j];
                    break ol;
                }
                else{
                    ht.add((SUM-sm));
                }
            }
        }

        System.out.println(pair[0]+", "+pair[1]+", "+pair[2]);

    }



}
