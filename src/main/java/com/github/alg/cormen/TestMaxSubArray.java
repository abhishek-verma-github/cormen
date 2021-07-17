package com.github.alg.cormen;

public class TestMaxSubArray {
    final static int negative_infinity = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int[] A = {-13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int[] result = findMaxSubArray(A,0,A.length-1);
        System.out.print("max subarray:-> from index: "+result[0]+", to index: "+result[1]+", SUM:"+result[2]);
    }

    static int[] maxCrossSubArray(int[] A, int low, int mid, int high){
        int left_sum = negative_infinity;
        int max_left = mid;
        int sum = 0;
        for(int i = mid; i >= low; i--){
            sum = sum + A[i];
            if(sum > left_sum){
                left_sum = sum;
                max_left = i;
            }
        }
        int right_sum = 0;
        int max_right = mid;
        sum = 0;
        for(int j = mid+1; j <= high; j++){
            sum = sum + A[j];
            if(sum > right_sum){
             right_sum = sum;
             max_right = j;
            }
        }
        //return tuple
        int[] result = {max_left, max_right, (left_sum+right_sum)};
        return result;
    }

    static int[] findMaxSubArray(int[] A, int low, int high){
        if(low == high){
            return new int[]{low, high, A[low]};
        }
        else{

            int mid = (int) Math.floor((low+high)/2);
            int[] left_result = findMaxSubArray(A,low,mid);
            int[] right_result = findMaxSubArray(A,mid+1,high);
            int[] cross_result = maxCrossSubArray(A,low,mid,high);

            if((left_result[2] >= right_result[2]) & (left_result[2] >= cross_result[2])) return left_result;
            if((right_result[2] >= left_result[2]) & (right_result[2] >= cross_result[2])) return right_result;
            else return cross_result;
        }
    }

}
