package com.github.alg.cormen;

public class FindUnion {
    public static void main(String[] args) {
        long s, e;
        int a = 2, b = 3, c = 0;
        s = System.nanoTime();
        c = a+b;
        e = System.nanoTime();
        System.out.print(e-s);
    }
}
