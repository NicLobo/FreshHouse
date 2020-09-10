package src;

import java.util.Scanner;
import src.State;

public class ReadState {
    
    private final int size = 51; // Number of states and Washington D.C.
    private State[] data = new State[size];
    
    public ReadState(Scanner in) {
        int i=0;
        in.nextLine(); // Skip first line with headers
        // Read data for line, construct a State object
        while (in.hasNextLine()) {
            String[] line = in.nextLine().split(",");
            double lat = Double.parseDouble(line[1]);
            double lng = Double.parseDouble(line[2]);
            double hpi = Double.parseDouble(line[3]);
            double p = Double.parseDouble(line[4]);
            int year = Integer.parseInt(line[5]);
            int id = Integer.parseInt(line[6]);
            data[i] = new State(lat, lng, line[0], hpi, p, year, id);
            i++;
        }
    }

    public State data(int id) {
        return data[id-1]; // ID starts at 1
    }

    public int size() {
        return size;
    }
}
