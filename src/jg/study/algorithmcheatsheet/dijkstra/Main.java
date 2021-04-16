package jg.study.algorithmcheatsheet.dijkstra;


import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    int v;
    int cost;
    @Override
    public String toString() {
        return "Node [v=" + v + ", cost=" + cost + "]";
    }
    public Node(int v, int cost) {
        super();
        this.v = v;
        this.cost = cost;
    }

}

public class Main {

    static int N, M, X;
    static int[] dist;
    static Scanner sc = new Scanner(System.in);
    static LinkedList<Node>[] adj;
    static int[] trace;
    static int INF = Integer.MAX_VALUE;

    static void dijk(int s) {
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.cost - b.cost);
        for (int i = 1; i <= N; i++)
            dist[i] = INF;
        dist[s] = 0;
        trace[s] = -1;
        q.offer(new Node(s, 0));
        Node cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.cost > dist[cur.v]) continue;
            for (Node next : adj[cur.v]) {
                if (dist[next.v] > cur.cost + next.cost) {
                    dist[next.v] = cur.cost + next.cost;
                    trace[next.v] = cur.v;
                    q.offer(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();

        adj = new LinkedList[N + 1];
        dist = new int[N + 1];
        trace = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new LinkedList<Node>();
        }

        int from, to, cost;

        for (int i = 0; i < M; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            cost = sc.nextInt();
            adj[from].add(new Node(to, cost));
        }


        int start = 3;
        int end = N;

        dijk(start);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(end);

        while (true) {
            int f = trace[stack.peek()];
            if (f == -1) break;
            stack.push(f);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " --> ");
        }

        System.out.println();
        System.out.println(dist[end]);


        /*
4 8
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3

         */

    }
}