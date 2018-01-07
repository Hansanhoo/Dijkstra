package Graph;

import Std.StdRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdjListGraph implements AdjGraph {

    private Pos[] positions;

    public AdjListGraph(int nodeCount, int maxDegree) {
        if (nodeCount < 0) throw new RuntimeException("Number of vertices must be nonnegative");    
        positions = new Pos[nodeCount];
        for (int i=0;i<nodeCount;i++) {
            positions[i] = new Pos(new Node(i));
        }

        for (Pos position : positions) {

            //random number of Degrees between 1 and maxDegree
            for (int i=1; i <= (StdRandom.uniform(maxDegree-1)+1); i++) {

                //add random edge with random weight
                position.getNode().addAdjacent(positions[StdRandom.uniform(nodeCount)], StdRandom.uniform(MAXWEIGHT -1)+1);
            }
        }
    }
    public AdjListGraph(){
        positions = new Pos[5];
        for (int i=0;i<5;i++) {
            positions[i] = new Pos(new Node(i));
        }
        positions[0].getNode().addAdjacent(positions[1], 3);
        positions[1].getNode().addAdjacent(positions[3], 1);
        positions[2].getNode().addAdjacent(positions[4], 1);
        positions[3].getNode().addAdjacent(positions[2], 2);
        positions[4].getNode().addAdjacent(positions[2], 5);
  
    }
    @Override
    public Pos[] getPositions() {
        return positions;
    }


    @Override
    public List<Pos> getAdjacentPositions(Pos p) {
        List<Pos> adjacentPositions = new ArrayList<>();

        for (Map.Entry<Pos, Integer> adjacencyPair :
                p.getNode().getAdjacent().entrySet()) {
        	
            Pos currNode = adjacencyPair.getKey();
            adjacentPositions.add(currNode);
             }
        return adjacentPositions;
    }

    @Override
    public Integer getWeight(Pos start, Pos end) {

        int weight = start.getNode().getAdjacent().get(end);
        return weight;
    }

    @Override
    public String toString() {
        return "toString von ListGraph fehlt noch..!";
    }
}