package jg.study.algorithmcheatsheet.permutation;

/*
순열
임의의 수열을 다른 순서로 섞는 연산
수열의 갯수는 N!
[1, 5, 6]인경우
156, 165, 516, 561, 615, 651

nm1 로도 처리가능.
 */

import java.util.Arrays;

public class Main {

    static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i <= 0) return false;
        int j = n - 1;

        while (a[j] <= a[i - 1]) j -= 1;
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = n - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    static boolean prevPermutation(int[] a) {
        int n = a.length;
        int i = n - 1;
        while (i > 0 && a[i - 1] <= a[i]) i--;
        if (i <= 0) return false;
        int j = n - 1;

        while (a[j] >= a[i - 1]) j -= 1;
        int temp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = temp;

        j = n - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 2, 1};
        System.out.println(Arrays.toString(a));
        while (prevPermutation(a)) {
            System.out.println(Arrays.toString(a));
        }

    }

}
