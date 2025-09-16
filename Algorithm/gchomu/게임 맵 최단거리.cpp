#include <vector>
#include <queue>
#include <iostream>
using namespace std;

// 방향 벡터 설정: 상, 우, 하, 좌
int dx[] = {1, 0, -1, 0}, dy[] = {0, 1, 0, -1};
int n, m;
vector<vector<int>> memo;

bool isOutRange(int x, int y, const vector<vector<int>>& maps) {
    // 범위를 벗어나거나 벽인 경우 true 반환
    return (x < 0 || x >= n || y < 0 || y >= m || maps[x][y] == 0);
}

void bfs(int x, int y, const vector<vector<int>>& maps) {
    queue<pair<int, int>> q; // BFS를 위한 큐
    memo[x][y] = 1; // 시작 지점의 거리 설정
    q.push({x, y}); // 큐에 시작 지점 추가
    
    while (!q.empty()) {
        auto [currX, currY] = q.front();
        q.pop();
        
        // 4방향으로 이동
        for (int i = 0; i < 4; ++i) {
            int nextX = currX + dx[i];
            int nextY = currY + dy[i];
            
            // 범위를 벗어나지 않고, 아직 방문하지 않았을 때만 처리
            if (!isOutRange(nextX, nextY, maps) && memo[nextX][nextY] == 0) {
                memo[nextX][nextY] = memo[currX][currY] + 1; // 거리 갱신
                q.push({nextX, nextY}); // 큐에 다음 위치 추가
            }
        }
    }
}

int solution(vector<vector<int>> maps) {
    n = maps.size();
    m = maps[0].size();
    memo.assign(n, vector<int>(m, 0)); // 거리 배열 초기화
    
    bfs(0, 0, maps); // BFS 탐색 시작
    
    // 도착 지점에 도달할 수 없는 경우 -1 반환
    if (memo[n - 1][m - 1] == 0)
        return -1;
    
    // 도착 지점까지의 최단 거리 반환
    return memo[n - 1][m - 1];
}
