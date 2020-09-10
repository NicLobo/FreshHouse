package src;

import java.util.ArrayList;

/*
 * @brief The bestState class to find the optimal place to move from a start State. Based on Dijkstra's from Algorithms, 4th edition textbook.
 */
public class bestState {

    private double[] bestState;			//Array of shortest distance lengths   
    private DirectedEdge[] lastEdges;       //Array of final edges to a point stored as DirectedEdges
    private boolean[] pending;          	//If vertex is waiting to be relaxed
    private ArrayList<State> v;    	//ArrayList of vertices
    
	/*
	 * @brief The bestState constructor to make the bestState object and set all the required variables.
	 * @param g The graph object to traverse.
	 * @param start The start vertex as a State object.
	 * @return A bestState object.
	 */
    public bestState(graph g, State start) {
        bestState = new double[g.numCities()];
        lastEdges = new DirectedEdge[g.numCities()];
        pending = new boolean[g.numCities()];
        for (int v = 0; v < g.numCities(); v++) {
            bestState[v] = Double.POSITIVE_INFINITY; 
        }
        bestState[start.getID()] = 0.0;

        v = new ArrayList<State>();
        v.add(start);
        pending[start.getID()] = true;
        while (v.size() != 0) {
            State i = v.remove(0);
            pending[i.getID()] = false;
            relax(g, i);
        }
    }
    
	/*
	 * @brief Used to relax the edges in Dijkstra's algorithm.
	 * @param g The graph object to traverse.
	 * @param s The start vertex as a State object.
	 */
    private void relax(graph g, State s) {
        for (DirectedEdge e : g.list(s.getID())) {
            State next = e.next();
            if (bestState[next.getID()] > bestState[s.getID()] + e.weight()) {
                bestState[next.getID()] = bestState[s.getID()] + e.weight();
                lastEdges[next.getID()] = e;
                if (!pending[next.getID()]) {
                    v.add(next);
                    pending[next.getID()] = true;
                }
            }
        }
    }

    /*
     * @brief Finds the shortest path which is the cheapest meal path from the start to end State objects in the graph object.
     * @param end The end State object.
     * @return An ArrayList of State objects for the cheapest path.
     */
    public ArrayList<DirectedEdge> getShortestPath(State end) {
        ArrayList<DirectedEdge> path = new ArrayList<DirectedEdge>();
        ArrayList<DirectedEdge> finalPath = new ArrayList<DirectedEdge>();

        for (DirectedEdge e = lastEdges[end.getID()]; e != null; e = lastEdges[e.prev().getID()]) {
            path.add(e);
        }
        for (int i = 0; i < path.size(); i++) {
        	finalPath.add(path.get(path.size()-1-i));
        }
        return finalPath;
    }
}