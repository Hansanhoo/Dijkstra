package Graph;


import java.util.HashMap;
import java.util.Map;

public class Node {

    private int id;
    Map<Pos, Integer> adjacentNodes;


    public Node(int id) {

        adjacentNodes = new HashMap<>();
        this.id = id;
    }

    int getId() {
        return id;
    }


    public void addAdjacent(Pos destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public void setAdjacent(Map<Pos, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
    public Map<Pos, Integer> getAdjacent() {
        return adjacentNodes;
    }
}
