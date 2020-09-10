package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * @brief This class is used to create the directed edge weighted graph and all its edges. The vertices are State objects,
 * one for each State in the United States, and the edges represent connected States with the weight being the relative home 
 * value to the user from the start State to end State.
 * Based on graph from Algorithms 4th edition textbook.
 */
public class graph {

	private final int numStates = 50; // The number of vertices
	private int numEdges = 0; // The number of edges
	private ArrayList<ArrayList<DirectedEdge>> list; // Adjacency List as 2D array list of Directed Edges
	private State userState; // Start State

	/*
	 * @brief Constructor to make the edge weighted directed graph.
	 * 
	 * @return A graph object.
	 */
	public graph(State start) throws IOException {
        list = new ArrayList<ArrayList<DirectedEdge>>();
		String line = "";
		String split = ",";
		ArrayList<Double> HPI = new ArrayList<>();
        ArrayList<Double> POL = new ArrayList<>();
		
        for (int i = 0; i < this.numStates; i++) {
            ArrayList<DirectedEdge> a = new ArrayList<DirectedEdge>();
        	list.add(a);
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("data.csv"))) {
		
			line = br.readLine();
        	while ((line = br.readLine()) != null) {
                String[] newLine = line.split(split);
                HPI.add(Double.parseDouble(newLine[3]));
                POL.add(Double.parseDouble(newLine[4]));
			}	 
			br.close();          
		}
		int count = 0;
		//Initiliaze State objects, used random values for hpi and pollution just to test function without requiring a clean dataset.
        userState = start;
		State AK = new State(63.70716, -152.404419,"AK",HPI.get(count), POL.get(count), 2019,0);
		count++;
		State AL = new State(32.806671,-86.791130,"AL",HPI.get(count), POL.get(count), 2019,1);
		count++;
		State AR = new State(34.969704, -92.373123,"AR",HPI.get(count), POL.get(count), 2019,2);
		count++;
		State AZ = new State(33.729759, -111.431221,"AZ",HPI.get(count), POL.get(count), 2019,3);
		count++;
		State CA = new State(36.7783, -119.4179,"CA",HPI.get(count), POL.get(count), 2019,4);
		count++;
		State CO = new State(39.550051, -105.78206,"CO",HPI.get(count), POL.get(count), 2019,5);
		count++;
		State CT = new State(41.603221, -73.087749,"CT",HPI.get(count), POL.get(count), 2019,6);
		count++;
		State DE = new State(38.910832, -75.52767,"DE", HPI.get(count), POL.get(count), 2019,7);
		count++;
		State FL = new State(27.664827, -81.515754,"FL",HPI.get(count), POL.get(count), 2019,8);
		count++;
        State GA = new State(32.157435, -82.907123,"GA",HPI.get(count), POL.get(count), 2019,9);
		count++;
		State HI = new State(19.898682, -155.665857,"HI",HPI.get(count),POL.get(count), 2019,10);
		count++;
		State IA = new State(41.878003, -93.097702,"IA",HPI.get(count), POL.get(count), 2019,11);
		count++;
		State ID = new State(44.068202, -114.742041,"ID",HPI.get(count),POL.get(count), 2019,12);
		count++;
		State IL = new State(40.633125, -89.398528,"IL",HPI.get(count), POL.get(count), 2019,13);
		count++;
		State IN = new State(40.551217, -85.602364,"IN",HPI.get(count), POL.get(count), 2019,14);
		count++;
		State KS = new State(39.011902, -98.484246,"KS",HPI.get(count), POL.get(count), 2019,15);
		count++;
		State KY = new State(37.839333, -84.270018,"KY",HPI.get(count), POL.get(count), 2019,16);
		count++;
		State LA = new State(31.244823, -92.145024,"LA",HPI.get(count), POL.get(count), 2019,17);
		count++;
		State MA = new State(42.407211, -71.382437,"MA",HPI.get(count), POL.get(count), 2019,18);
		count++;
		State MD = new State(39.045755, -76.641271,"MD",HPI.get(count), POL.get(count), 2019,19);
		count++;
		State ME = new State(45.253783, -69.445469,"ME",HPI.get(count), POL.get(count), 2019,20);
		count++;
		State MI = new State(44.314844, -85.602364,"MI",HPI.get(count), POL.get(count), 2019,21);
		count++;
		State MN = new State(46.729553, -94.6859,"MN",HPI.get(count), POL.get(count), 2019,22);
		count++;
		State MO = new State(37.964253, -91.831833,"MO",HPI.get(count), POL.get(count), 2019,23);
		count++;
        State MS = new State(32.354668, -89.398528,"MS",HPI.get(count), POL.get(count), 2019,24);
		count++;
		State MT = new State(46.879682, -110.362566,"MT",HPI.get(count),POL.get(count), 2019,25);
		count++;
		State NC = new State(35.759573, -79.0193,"NC",HPI.get(count), POL.get(count), 2019,26);
		count++;
		State ND = new State(47.551493, -101.002012,"ND",HPI.get(count),POL.get(count), 2019,27);
		count++;
		State NE = new State(41.492537, -99.901813,"NE",HPI.get(count), POL.get(count), 2019,28);
		count++;
		State NH = new State(43.193852, -71.572395,"NH",HPI.get(count), POL.get(count), 2019,29);
		count++;
		State NJ = new State(40.058324, -74.405661,"NJ",HPI.get(count), POL.get(count), 2019,30);
		count++;
		State NM = new State(34.97273, -105.032363,"NM",HPI.get(count), POL.get(count), 2019,31);
		count++;
        State NV = new State(38.80261, -116.419389,"NV",HPI.get(count), POL.get(count), 2019,32);
		count++;
		State NY = new State(43.299428, -74.217933,"NY",HPI.get(count), POL.get(count), 2019,33);
		count++;
		State OH = new State(40.417287, -82.907123,"OH",HPI.get(count), POL.get(count), 2019,34);
		count++;
		State OK = new State(35.007752, -97.092877,"OK",HPI.get(count), POL.get(count), 2019,35);
		count++;
		State OR = new State(43.804133, -120.554201,"OR",HPI.get(count),POL.get(count), 2019,36);
		count++;
		State PA = new State(41.203322, -77.194525,"PA",HPI.get(count), POL.get(count), 2019,37);
		count++;
		State RI = new State(41.580095, -71.477429,"RI",HPI.get(count), POL.get(count), 2019,38);
		count++;
		State SC = new State(33.836081, -81.163725,"SC",HPI.get(count), POL.get(count), 2019,39);
		count++;
		State SD = new State(43.969515, -99.901813,"SD",HPI.get(count), POL.get(count), 2019,40);
		count++;
		State TN = new State(35.517491, -86.580447,"TN",HPI.get(count), POL.get(count), 2019,41);
		count++;
        State TX = new State(31.968599, -99.901813,"TX",HPI.get(count), POL.get(count), 2019,42);
		count++;
        State UT = new State(39.32098, -111.093731,"UT",HPI.get(count), POL.get(count), 2019,43);
		count++;
		State VA = new State(37.431573, -78.656894,"VA",HPI.get(count), POL.get(count), 2019,44);
		count++;
        State VT = new State(44.558803, -72.577841,"VT",HPI.get(count), POL.get(count), 2019,45);
		count++;
		State WA = new State(47.751074, -120.740139,"WA",HPI.get(count),POL.get(count), 2019,46);
		count++;
		State WI = new State(43.78444, -88.787868,"WI",HPI.get(count), POL.get(count), 2019,47);
		count++;
		State WV = new State(38.597626, -80.4549,"WV",HPI.get(count), POL.get(count), 2019,48);
		count++;
		State WY = new State(43.075968, -107.29028,"WY",HPI.get(count), POL.get(count), 2019,49);

		edge(start, AK);
		edge(start, AL);
		edge(start, AR);
		edge(start, AZ);
		edge(start, CA);
		edge(start, CO);
		edge(start, CT);
		edge(start, DE);
		edge(start, FL);
		edge(start, GA);
		edge(start, HI);
		edge(start, IA);
		edge(start, ID);
		edge(start, IL);
		edge(start, IN);
		edge(start, KS);
		edge(start, KY);
		edge(start, LA);
		edge(start, MA);
		edge(start, MD);
		edge(start, ME);
		edge(start, MI);
		edge(start, MI);
		edge(start, MN);
		edge(start, MO);
		edge(start, MS);
		edge(start, MT);
		edge(start, NC);
		edge(start, ND);
		edge(start, NE);
		edge(start, NH);
		edge(start, NJ);
		edge(start, NM);
		edge(start, NV);
		edge(start, NY);
		edge(start, OH);
		edge(start, OK);
		edge(start, OR);
		edge(start, PA);
		edge(start, RI);
		edge(start, SC);
		edge(start, SD);
		edge(start, TN);
		edge(start, TX);
		edge(start, UT);
		edge(start, VA);
		edge(start, VT);
		edge(start, WA);
		edge(start, WV);
		edge(start, WI);
		edge(start, WY);
	}
	
	/*
	 * @brief Helper function to make an edge.
	 * @param prev A State object for the starting State.
	 * @param next A State object for the end target State.
	 */
	private void edge(State prev, State next) {
		DirectedEdge edge = new DirectedEdge(prev,next,next.homeValue(prev));
        this.addEdge(edge,prev.getID());
	}
	
	/*
	 * @brief Returns the number of States or vertices.
	 * @returns The integer number of States or vertices.
	 */
    public int numCities() {
        return this.numStates;
    }
    
	/*
	 * @brief Returns the number of connections or edges.
	 * @returns The integer number of connections or edges.
	 */
    public int numEdges() {
        return numEdges;
    }

	/*
	 * @brief Adds a directed edge to the graph.
	 * @param e A DirectedEdge object created in makeEdge.
	 * @param pos The pos of the State in the State Array, comes from the State ID.
	 */
    public void addEdge(DirectedEdge e, int pos) {
        list.get(pos).add(e);
        this.numEdges++;
    }

	/*
	 * @brief Gets the adjacency list as an array list at index v.
	 * @param v Integer index position of the ArrayList.
	 * @return The ArrayList of State objects at position v in the outer array list.
	 */
    public Iterable<DirectedEdge> list(int v) {
        return list.get(v);
    }
    
	/*
	 * @brief Gets the starting State object.
	 * @return A State object of the starting State.
	 */
    public State getStart() {
    	return this.userState;
    }
        
	/*
	 * @brief Gets a string representation of the graph object.
	 * @return A string representation of the graph object.
	 */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.numStates + " " + numEdges + "\n");
        for (int v = 0; v < this.numStates; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : list.get(v)) {
                s.append(e + "  ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}