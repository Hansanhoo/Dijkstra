package Graph;

import java.util.LinkedList;
import java.util.List;

public class Pos {

    private int matrixPos;
    private Node node;
    boolean isMatrix;

    private List<Pos> shortestPath;
    private Integer distance;

    public Pos() {
        shortestPath = new LinkedList<>();
        distance = Integer.MAX_VALUE;
        this.isMatrix = false;
    }

    public Pos(int matrixPos) {
        this();
        this.matrixPos = matrixPos;
        this.isMatrix = true;
    }
    public Pos (Node node) {
        this();
        this.node = node;

    }

    public int getMatrixPos() {
        return matrixPos;
    }

    public void setMatrixPos(int matrixPos) {
        this.matrixPos = matrixPos;
    }

    public Node getNode() {
        return node;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Pos> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Pos> shortestPath) {
        this.shortestPath = shortestPath;
    }

    @Override
    public String toString() {
        if (this.isMatrix) {
            return ""+this.matrixPos;
        }
        else return ""+getNode().getId();
    }



}
