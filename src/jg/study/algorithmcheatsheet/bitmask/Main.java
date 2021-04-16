package jg.study.algorithmcheatsheet.bitmask;

/*
& and
| or
~ not
^ xor
    둘중에 하나만 1일때 1
    00 -> 0
    01 -> 1
    10 -> 1
    11 -> 0

A << B (A를 왼쪽으로 B비트 만큼 민다)
A << B = A * 2^B (10진수 기준)
  예) 2^N  --> 1 << N
A >> B = A / 2^B (10진수 기준)
  예) (A + B) / 2 -->> (A + B) >> 1

비트 연산을 이용하여 부분집합을 표현가능

0이 포함되어 있는지 검사
 N & (1 << 0) > 0
3이 포함되어 있는지 검사
 N & (1 << 3) > 0

1을 추가하기
 N | (1 << 1)

2를 제거하기
 N & ~(1 << 2)

3을 토글하기
 N ^ (1 << 3)

전체집합 모두있음
(1 << N) - 1 --> [0 .. N-1]
공집합은 : 0

 */

import java.util.Arrays;

public class Main {

    static int N = 3;
    static int[] a = new int[N];

    static void solveBitmask() {
        int e = (1 << N) - 1;
        // 선택에 관한 수열을 만들수 있음.
        for (int i = 0; i <= e; i++) {
            // for (int j = 0; j < N; j++) {
            for (int j = N - 1; j >= 0; j--) {
                if ((i & (1 << j)) > 0)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.println();
        }
    }

    static void solve(int pos) {
        if (pos == N) {
            System.out.println(Arrays.toString(a));
            return;
        }
        for (int i = 0; i <= 1; i++) {
            a[pos] = i;
            solve(pos + 1);
        }
    }

    public static void main(String[] args) {
        solveBitmask();
        System.out.println("---");
        solve(0);
    }

}
