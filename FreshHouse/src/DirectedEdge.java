package src;

/*
 * @brief The class to create a directed edge between two State objects with a weight. Based on DirectedEdge from textbook.
 */
public class DirectedEdge { 
	
    private final State prevState;	//Previous State object in a DirectedEdge
    private final State nextState;	//Next State object in a DirectedEdge
    private final double homeValue;		//Weight of the DirectedEdge

    /*
     * @brief The constructor to make the weighted directed edge.
     * @param prev The starting State object.
     * @param next The destination State object.
     * @param cost A double value for the cheapest cost meal in the destination State.
     * @return A DirectedEdge object.
     */
    public DirectedEdge(State prev, State next, double homeVal) {
        this.prevState= prev;
        this.nextState = next;
        this.homeValue = homeVal;
    }

    /*
     * @brief Gets the starting State in a DirectedEdge object.
     * @return A State object for the starting State in a DirectedEdge object.
     */
    public State prev() {
        return this.prevState;
    }
    
    /*
     * @brief Gets the ending State in a DirectedEdge object.
     * @return A State object for the ending State  in a DirectedEdge object.
     */
    public State next() {
        return this.nextState;
    }

    /*
     * @brief Gets edge weight of the DirectedEdge object.
     * @return A double value for the DirectedEdge object weight.
     */
    public double weight() {
        return this.homeValue;
    }

    /*
     * @brief Gets a String representation of the DirectedEdge object.
     * @return A String representation of the DirectedEdge object.
     */
    public String toString() {
        return this.prevState.state() + "----->" + this.nextState.state() + " " + this.homeValue;
    }
}