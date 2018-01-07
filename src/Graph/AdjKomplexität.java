package Graph;

import Std.StdRandom;

public class AdjKomplexität {
	 int nodeCount;
     int maxDegree;
     private Pos[] positions;
     
     Dijkstra di = new Dijkstra();
     public void testGeneratedList(){
    	    
    	 AdjGraph adjGraph = new AdjListGraph();
    	 Dijkstra.calculateShortestPathFromSource(adjGraph, adjGraph.getPositions()[0]);
    	 positions = adjGraph.getPositions();

    	 System.out.println("Shortest Path from: "+ positions[0] + " to: " + positions[5-1]);

      
         System.out.print(positions[4].getShortestPath());
         System.out.println();
    
     }
     public void testGeneratedMatrix(){
 	    
    	 AdjGraph adjGraph = new AdjMatrixGraph();
    	 Dijkstra.calculateShortestPathFromSource(adjGraph, adjGraph.getPositions()[0]);
    	 positions = adjGraph.getPositions();

    	 System.out.println("Shortest Path from: "+ positions[0] + " to: " + positions[5-1]);

      
         System.out.print(positions[4].getShortestPath());
         System.out.println();
    
     }
     public void testList(int n, int maxDegree){
    	 
    	 this.nodeCount = n;
    	 this.maxDegree = maxDegree;
    	 AdjGraph adjGraph = new AdjListGraph(nodeCount, maxDegree);

    	 Dijkstra.calculateShortestPathFromSource(adjGraph, adjGraph.getPositions()[0]);

    	 Pos[] positions = adjGraph.getPositions();

    	 System.out.println("n: " + n + " counter :" + di.getCounter());
     }
     public void testMatrix(int n, int maxDegree){
    	 
    	 this.nodeCount = n;
    	 this.maxDegree = maxDegree;
    	 AdjGraph adjGraph = new AdjMatrixGraph(nodeCount, maxDegree);

    	 Dijkstra.calculateShortestPathFromSource(adjGraph, adjGraph.getPositions()[0]);

    	 Pos[] positions = adjGraph.getPositions();

    	 System.out.println("n: " + n + " counter :"  + di.getCounter());
     }

    

     

   
}
