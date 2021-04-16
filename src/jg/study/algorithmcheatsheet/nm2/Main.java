package jg.study.algorithmcheatsheet.nm2;

import java.util.Arrays;
import java.util.Scanner;


/*
 --> 4 2

 (N * (N - 1) .. / M!)

 1 2
 1 3
 1 4
 2 3
 2 4
 3 4
 */

public class Main {

    static int[] r;
    static int N;
    static int M;

    // 걍 재귀 N!
//    static void solve(int pos, int bef) {
//        if (pos == M) {
//            System.out.println(Arrays.toString(r));
//            return;
//        }
//
//        for (int i = bef; i <= N; i++) {
//            r[pos] = i;
//            solve(pos + 1, i + 1);
//        }
//    }

    // 선택의 관점에서로 2^N
    static void solve(int sel, int num) {

        if (sel == M) {
            System.out.println(Arrays.toString(r));
            return;
        }

        if (num > N) return;

        r[sel] = num;
        solve(sel + 1, num + 1);
        solve(sel, num + 1);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = new int[M];

        solve( 0, 0);

    }

}
