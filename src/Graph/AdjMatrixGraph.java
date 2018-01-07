package Graph;

import Std.StdRandom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AdjMatrixGraph implements AdjGraph {

    private static final String NEWLINE = System.getProperty("line.separator");
    
    private int[][] matrix;
    private Pos[] matrixPos;
    private int nodeCount;    

    
    // random graph with nodeCount vertices and E edges
    public AdjMatrixGraph(int nodeCount, int maxDegree) {    
        if (nodeCount < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        if (maxDegree > nodeCount) throw new RuntimeException("MaxDegree must be smaller than nodeCount");

        this.matrix = new int[nodeCount][nodeCount];
        this.nodeCount = nodeCount;

        matrixPos = new Pos[nodeCount];

        for (int i=0;i<nodeCount;i++) {      
            matrixPos[i] = new Pos(i);

            for (int v=1; v <= (StdRandom.uniform(maxDegree-1)+1); v++) {

                int dist = StdRandom.uniform(MAXWEIGHT -1)+1; //avoid 0
                int w = StdRandom.uniform(nodeCount);
                
                addEdge(v, w, dist);
            }
        }
    }
    public AdjMatrixGraph(){

           this.matrix = new int[5][5];
           this.nodeCount = 5;

           matrixPos = new Pos[nodeCount];

           for (int i=0;i<nodeCount;i++) {      
               matrixPos[i] = new Pos(i);     
   
           }
           addEdge(0, 1, 3);
           addEdge(1, 3, 1);
           addEdge(2, 4, 1);
           addEdge(3, 2, 2);
           addEdge(4, 2, 5);
    }

    // add undirected edge v-w
    private void addEdge(int v, int w, int dist) {
        if (v == w) return; //no self adjacence
        matrix[v][w] = dist;
        matrix[w][v] = dist;
    }

    // does the graph contain the edge v-w?
    public boolean contains(int v, int w) {
        return (matrix[v][w] > 0);
    }


    @Override
    public Pos[] getPositions() {
        return matrixPos;
    }

    @Override
    public List<Pos> getAdjacentPositions(Pos source){

        List<Pos> adjacentNodes = new ArrayList<>();

        for (int w : getAdjacents(source.getMatrixPos())) {
        	if (w > 0) adjacentNodes.add(matrixPos[w]);
        }
        return adjacentNodes;
    }

    @Override
    public Integer getWeight(Pos start, Pos end) {
    	return matrix[start.getMatrixPos()][end.getMatrixPos()];
    }

    // return list of adjacents of v
    public Iterable<Integer> getAdjacents(int v) {
        return new AdjIterator(v);
    }

    // support iteration over graph nodes
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < nodeCount) {
                if (matrix[v][w] > 0) return true;
                w++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }

        public void remove()  {
            throw new UnsupportedOperationException();
        }
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        try{
            int rows = matrix.length;
            int columns = matrix[0].length;

            //header row
            String str = "";
            for(int j=0;j<columns;j++){
            	if(j == 0){
            		  str += "\t";
            	}
                str += j + "\t";
            }
            s.append("    " + str + NEWLINE);

            //header row sep. line
            str = "";
            for(int j=0;j<columns;j++){
            	if(j == 0){
          		  str += "\t";
          	}
                str += "-" + "\t";
            }
            s.append("    " + str + NEWLINE);

            //content plus column header
            str = "0 |\t";
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    str += matrix[i][j] + "\t";
                }

                s.append(str + NEWLINE);
                str = i+1 + " |\t";
            }

        }catch(Exception e){System.out.println("Matrix is empty!!");}

        return s.toString();
    }




}
