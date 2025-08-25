import java.util.ArrayList;

class Graphs {

    static void dfs(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] visited) {
        // pre processing
        visited[node] = true;
        System.out.println("arrived at node " + node);

        for (int child : adjacencyList.get(node)) {
            if (!visited[child]) {
                dfs(child, adjacencyList, visited);
            }
        }

        // post processing
        System.out.println("visited node " + node);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(1).add(2);
        adjacencyList.get(1).add(4);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(2).add(4);
        adjacencyList.get(2).add(5);
        adjacencyList.get(3).add(2);
        adjacencyList.get(3).add(5);
        adjacencyList.get(4).add(1);
        adjacencyList.get(4).add(2);
        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(3);
        adjacencyList.get(6).add(7);
        adjacencyList.get(7).add(6);

        boolean[] visited = new boolean[8];
        for (int i = 0; i < 8; i++)
            visited[i] = false;

        for (int i = 1; i < 8; i++) {
            if (visited[i] == false) {
                dfs(i, adjacencyList, visited);
            }
        }
    }
}