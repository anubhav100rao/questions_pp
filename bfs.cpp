#include <bits/stdc++.h>
using namespace std;


void bfs(int src, vector<vector<int>> &adjacency_list, vector<bool> &visited) {

    queue<int> q;
    q.push(src);
    visited[src] = true;

    while(!q.empty()) {
        int node = q.front(); q.pop();
        cout << "visiting node => " << node << "\n";
        for(int child: adjacency_list[node]) {
            if(!visited[child]) {
                visited[child] = true;
                q.push(child);
            }
        }
    }
}

signed main() {
   int nodes = 7, edges_count = 7;
    vector<vector<int>> adjacency_list = {
        {},
        {2, 4}, // node 1 - children
        {1, 3, 4, 5}, // node 2 - children
        {2, 5},
        {1, 2},
        {2, 3},
        {7},
        {6}
    };


    queue<int> q;
    vector<bool> visited(nodes + 1, false);

    for(int i = 1; i <= nodes; i++) {
        if(!visited[i]) {
            bfs(i, adjacency_list, visited);
        }
    }
 
    return 0;
}