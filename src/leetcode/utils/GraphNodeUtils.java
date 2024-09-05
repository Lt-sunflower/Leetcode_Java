package leetcode.utils;

import leetcode.models.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class GraphNodeUtils {

    public static GraphNode createGraph(int[][] graph){
        // Step 1: Create nodes for each index
        List<GraphNode> nodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            nodes.add(new GraphNode(i + 1));  // Create nodes with values 1-based index
        }

        // Step 2: Assign neighbors to each node
        for (int i = 0; i < graph.length; i++) {
            GraphNode currentNode = nodes.get(i);
            for (int neighborIndex : graph[i]) {
                // Adjust for 1-based index in the graph input to 0-based index for nodes list
                currentNode.neighbors.add(nodes.get(neighborIndex - 1));
            }
        }

        // Step 3: Return the first node or any node as the starting point
        return nodes.getFirst();
    }

    public static int[][] reconstructGraph(GraphNode startNode) {
        // Step 1: Determine the number of nodes in the graph
        List<GraphNode> nodes = getAllNodes(startNode);
        int n = nodes.size();

        // Step 2: Initialize the adjacency list array
        int[][] adjacencyList = new int[n][];

        // Create a map from node values to their indices
        java.util.Map<Integer, Integer> nodeIndexMap = new java.util.HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeIndexMap.put(nodes.get(i).val, i);
        }

        // Step 3: Fill the adjacency list array
        for (int i = 0; i < n; i++) {
            GraphNode node = nodes.get(i);
            List<Integer> neighbors = new ArrayList<>();
            for (GraphNode neighbor : node.neighbors) {
                neighbors.add(neighbor.val);
            }
            adjacencyList[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
        }

        return adjacencyList;
    }

    private static List<GraphNode> getAllNodes(GraphNode startNode) {
        // Use a BFS or DFS to traverse the graph and collect all nodes
        List<GraphNode> nodes = new ArrayList<>();
        java.util.Set<GraphNode> visited = new java.util.HashSet<>();
        java.util.Queue<GraphNode> queue = new java.util.LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            GraphNode current = queue.poll();
            nodes.add(current);
            for (GraphNode neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return nodes;
    }
}
