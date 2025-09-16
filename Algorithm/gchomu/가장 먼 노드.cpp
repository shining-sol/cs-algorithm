#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
typedef pair<int, int> pii;

int solution(int n, vector<vector<int>> edge) {
    vector<int> dist(n+1, 987654321);
    vector<vector<int>> adj(n+1, vector<int>(0));
    dist[1]=0;
    int answer = 0;
    priority_queue<pii> pq;
    
    pq.push({1, 0});
    
    //인접 리스트 생성
    for(vector<int> ab : edge){
        adj[ab[0]].push_back(ab[1]);
        adj[ab[1]].push_back(ab[0]);
    }
    
    while(!pq.empty()){
        auto [node, curDist] = pq.top();
        pq.pop();
        
        if(dist[node] < curDist) continue;
        
        for(int i=0; i<adj[node].size(); ++i){
            if(curDist+1 < dist[adj[node][i]]){
                dist[adj[node][i]]=curDist+1;
                pq.push({adj[node][i], curDist+1});
            }
        }
    }
    int maxNum=0;
    for(int i=1; i<dist.size();++i){
        maxNum=max(maxNum, dist[i]);
    }
    for(int d : dist){
        if(d==maxNum) answer++;
    }
    
    return answer;
}
