//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static long gcd(long x, long y) {
        return y == 0L ? x : gcd(y, x % y);
    }

    public static BigInteger gcd(BigInteger x, BigInteger y) {
        return y.compareTo(BigInteger.ZERO) == 0 ? x : gcd(y, x.mod(y));
    }

    public static String to_fraction(long x, long y) {
        long gcd = gcd(x, y);
        return x / gcd + "/" + y / gcd;
    }

    public static String to_fraction(BigInteger x, BigInteger y) {
        BigInteger gcd = gcd(x, y);
        BigInteger var10000 = x.divide(gcd);
        return var10000 + "/" + y.divide(gcd);
    }

    public static long[] series_sum(byte n) {
        long numerator = 0L;
        long denumerator = 1L;

        int i;
        for(i = 1; i <= n; ++i) {
            denumerator = (long)((double)denumerator * Math.pow((double)i, 4.0D));
        }

        for(i = 1; i <= n; ++i) {
            numerator = (long)((double)numerator + (double)denumerator / Math.pow((double)i, 4.0D));
        }

        return new long[]{numerator, denumerator};
    }

    public static BigInteger[] series_sum_bigint(byte n) {
        BigInteger numerator = BigInteger.valueOf(0L);
        BigInteger denumerator = BigInteger.valueOf(1L);

        int i;
        for(i = 1; i <= n; ++i) {
            denumerator = denumerator.multiply(BigInteger.valueOf((long)i).pow(4));
        }

        for(i = 1; i <= n; ++i) {
            numerator = numerator.add(denumerator.divide(BigInteger.valueOf((long)i).pow(4)));
        }

        return new BigInteger[]{numerator, denumerator};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many terms should there be?: ");
        byte n = in.nextByte();
        if (n > 5) {
            BigInteger[] arr = series_sum_bigint(n);
            System.out.printf("Sum of harmonic series with %d terms = %d/%d = %s", n, arr[0], arr[1], to_fraction(arr[0], arr[1]));
        } else {
            long[] arr = series_sum(n);
            System.out.printf("Sum of harmonic series with %d terms = %d/%d = %s", n, arr[0], arr[1], to_fraction(arr[0], arr[1]));
        }

    }
}
