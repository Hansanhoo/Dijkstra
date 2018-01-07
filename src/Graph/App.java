package Graph;


public class App {

    public static void main(String[] args) {
       /* int nodeCount = 10;
        int maxDegree = 4;
        //AdjGraph adjGraph = new AdjMatrixGraph(nodeCount, maxDegree);
        AdjGraph adjGraph = new AdjListGraph(nodeCount, maxDegree);

        System.out.println(adjGraph);

        Dijkstra.calculateShortestPathFromSource(adjGraph, adjGraph.getPositions()[0]);

        Pos[] positions = adjGraph.getPositions();

        System.out.println("Shortest Path from: "+ positions[0] + " to: " + positions[nodeCount-1]);

        for (Pos p : positions[nodeCount-1].getShortestPath()) {
            System.out.print(p + "\t");
        }*/
    	
    	AdjKomplexität AdjTest = new AdjKomplexität();
    	AdjTest.testGeneratedList();
    	AdjTest.testGeneratedMatrix();
    	AdjTest.testList(10, 8);
    	AdjTest.testList(100, 8);
    	AdjTest.testList(1000, 8);
    	AdjTest.testList(10000, 8);

    	
    	AdjTest.testMatrix(10, 8);
    	AdjTest.testMatrix(100, 8);
    	AdjTest.testMatrix(1000, 8);
    	AdjTest.testMatrix(10000, 8);


    }
}
