import java.io.*;
import java.util.*;

class Solution {
    static int n,m,answer;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;

    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        bfs(0,0, maps);

        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }

        return answer;
    }

    static void bfs(int x, int y, int[][] maps) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == n-1 && p.y == m-1){
                answer = Math.min(answer, p.count);
            }

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(maps[nx][ny] == 0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new Point(nx, ny, p.count + 1));
            }

        }

    }

    static class Point{
        int x;
        int y;
        int count;

        Point(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}