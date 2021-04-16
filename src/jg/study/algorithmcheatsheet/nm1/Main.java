package jg.study.algorithmcheatsheet.nm1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /*
     --> 4 2
     [1, 2]
    [1, 3]
    [1, 4]
    [2, 1]
    [2, 3]
    [2, 4]
    [3, 1]
    [3, 2]
    [3, 4]
    [4, 1]
    [4, 2]
    [4, 3]



     */

    static int N;
    static int M;
    static int[] r;
    static boolean[] check;

    static void solve(int pos) {
        if (pos == M) {
            System.out.println(Arrays.toString(r));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (check[i]) continue;
            check[i] = true;
            r[pos] = i;
            solve(pos + 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = new int[M];
        check = new boolean[N + 1];
        solve(0);
    }


}
