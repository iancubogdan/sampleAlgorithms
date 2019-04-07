package algorithms.graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int noOfNodes;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int noOfNodes) {
        this.noOfNodes = noOfNodes;
        adjacencyList = new LinkedList[noOfNodes];
        for (int i = 0; i < noOfNodes; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int node, int adjacentNode) {
        adjacencyList[node].add(adjacentNode);
    }

    public void BFS(int node) {
        boolean visited[] = new boolean[noOfNodes];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);

        while (queue.size() != 0) {
            node = queue.poll();
            System.out.print(node + " ");

            for (Integer newNode : adjacencyList[node]) {
                if (!visited[newNode]) {
                    visited[newNode] = true;
                    queue.add(newNode);
                }
            }
        }
    }

    private void DFSUtil(int node, boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");

        for (Integer newNode : adjacencyList[node]) {
            if (!visited[newNode]) {
                DFSUtil(newNode, visited);
            }
        }
    }

    public void DFS(int node) {
        boolean visited[] = new boolean[noOfNodes];

        DFSUtil(node, visited);
    }


}
