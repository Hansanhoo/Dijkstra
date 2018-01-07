package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Dijkstra {
	private static int counter = 0;
	
	public int getCounter(){
		return counter;
	}
	
    public static Set<Pos> calculateShortestPathFromSource(AdjGraph adjGraph, Pos source) {
    	counter = 0;
        Set<Pos> positions = new HashSet<>();
        Set<Pos> markedPositions = new HashSet<>();

        //Source added to positions with distance 0, so that the loop starts here
        source.setDistance(0);
        positions.add(source);

        while (positions.size() != 0) {
        	counter++;
            Pos currentPosition = getLowestDistancePosition(positions);
            positions.remove(currentPosition); //adjacentPositions will be added soon, if not marked yet

            //getting a entrySet() of the Map, to work with
            //each adjacentPosition (and its weight) separately per loop
            for (Pos adjacentPosition : adjGraph.getAdjacentPositions(currentPosition)) {
            	counter++;
                Integer edgeWeight = adjGraph.getWeight(currentPosition, adjacentPosition);

                if (!markedPositions.contains(adjacentPosition)) {
                    //minimum Distance is needed in next loop cycle for getLowestDistancePosition()
                    CalculateMinimumDistance(adjacentPosition, edgeWeight, currentPosition);
                    positions.add(adjacentPosition);
                }
            }
            markedPositions.add(currentPosition);
        }
        return markedPositions;
    }

    private static Pos getLowestDistancePosition(Set<Pos> positions) {
        Pos lowestDistancePosition = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Pos position: positions) {
        	counter++;
            int positionDistance = position.getDistance();
            if (positionDistance < lowestDistance) {
                lowestDistance = positionDistance;
                lowestDistancePosition = position;
            }
        }
        return lowestDistancePosition;
    }
    private static void CalculateMinimumDistance(Pos evaluationPosition,
                                                 Integer edgeWeight,Pos sourcePosition) {
        Integer sourceDistance = sourcePosition.getDistance();
        if (sourceDistance + edgeWeight < evaluationPosition.getDistance()) {
        	counter++;
            evaluationPosition.setDistance(sourceDistance + edgeWeight);

            LinkedList<Pos> shortestPath = new LinkedList<>(sourcePosition.getShortestPath());
            shortestPath.add(sourcePosition);
            evaluationPosition.setShortestPath(shortestPath);

        }
    }
}
