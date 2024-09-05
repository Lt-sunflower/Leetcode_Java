package leetcode.problems.grind75;

import leetcode.models.GraphNode;
import leetcode.problems.Problem;
import leetcode.utils.GraphNodeUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q133CloneGraph implements Problem {

    /**
     * Given a reference of a node in a connected undirected graph.
     * Return a deep copy (clone) of the graph.
     **/

    private GraphNode node;

    public Q133CloneGraph(){
        this.node = GraphNodeUtils.createGraph(new int[][] {{2,4},{1,3},{2,4},{1,3}});
    }

    private GraphNode solve(){
        return clone(node);
    }

    private Map<Integer, GraphNode> map = new HashMap<>();
    private GraphNode clone(GraphNode current) {

        if (current == null) return null;

        if (map.containsKey(current.val)) return map.get(current.val);

        GraphNode clone = new GraphNode(current.val);

        map.put(clone.val, clone);

        for (GraphNode neighbour : current.neighbors){
            clone.neighbors.add(clone(neighbour));
        }

        return clone;
    }

    @Override
    public void printAnswer() {
        System.out.println("Inputs: " + Arrays.deepToString(GraphNodeUtils.reconstructGraph(node)));
        System.out.println("Answer: " + Arrays.deepToString(GraphNodeUtils.reconstructGraph(solve())));
    }
}
