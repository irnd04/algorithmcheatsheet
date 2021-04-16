package jg.study.algorithmcheatsheet.graph;

import java.util.*;

public class Main {

    static class Node {
        int to;

        public Node(int to) {
            this.to = to;
        }
    }

    static int N;
    static int M;
    static int S;
    static ArrayList<Node>[] adj;
    static boolean[] check;

    static void bfs() {
        LinkedList<Node> q = new LinkedList<>();
        q.offer(new Node(S));
        check[S] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.print(cur.to + " ");
            for (Node node : adj[cur.to]) {
                if (check[node.to]) continue;
                check[node.to] = true;
                q.offer(node);
            }
        }
        System.out.println();
    }

    static void dfs(Node cur) {
        System.out.print(cur.to + " ");
        for (Node node : adj[cur.to]) {
            if (check[node.to]) continue;
            check[node.to] = true;
            dfs(node);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        S = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<Node>();

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            adj[from].add(new Node(to));
            adj[to].add(new Node(from));
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i], Comparator.comparingInt(a -> a.to));
        }

        check = new boolean[N + 1];
        check[S] = true;
        dfs(new Node(S));
        System.out.println();
        Arrays.fill(check, false);
        bfs();
    }

}
