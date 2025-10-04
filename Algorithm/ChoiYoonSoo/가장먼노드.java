import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public int solution(int n, int[][] edge) {
        answer = 0;

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new int[n + 1];
        Arrays.fill(visited, -1);

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph[x].add(y);
            graph[y].add(x);
        }
        bfs(1);

        int m = 0;
        for (int i = 0; i < visited.length; i++) {
            m = Math.max(visited[i], m);
        }

        for (int i = 0; i < visited.length; i++) {
            if (m == visited[i]) answer++;
        }

        return answer;
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 0; i < graph[v].size(); i++) {
                if (visited[graph[v].get(i)] == -1) {
                    visited[graph[v].get(i)] = visited[v] + 1;
                    q.add(graph[v].get(i));
                }
            }

        }
    }
}