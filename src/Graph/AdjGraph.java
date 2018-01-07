package Graph;

import java.util.List;


public interface AdjGraph {

    static final int MAXWEIGHT = 10;

    List<Pos> getAdjacentPositions(Pos p);
    Integer getWeight(Pos start, Pos end);
    Pos[] getPositions();
}
