#include <bits/stdc++.h>
using namespace std;

void dfs(int node, vector<vector<int>> &adjacency_list, vector<bool> &visited) {
    visited[node] = true;
    cout << node << " ";

    for(int child: adjacency_list[node]) {
        if(visited[child] == false) {
            dfs(child, adjacency_list, visited);
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

    // DFS, BFS
    vector<bool> visited(nodes + 1, false);

    int connected_components = 0;

    for(int i = 1; i <= nodes; i++) {
        if(visited[i] == false) {
            dfs(i, adjacency_list, visited);    
            connected_components++;
        }
    }

    cout << "\n";

    cout << "number of connected components = " << connected_components << "\n";
    
 
    return 0;
}