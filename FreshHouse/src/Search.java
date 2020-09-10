package src;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @brief This class creates a search object for a state
 * @details After the object is created their is method to preform a binary search to search for values of a specifc year
 */
public class Search {

    //The Name of The State to be searched
    private String State;
    //An array of list of years to be searched
    private ArrayList<Integer> Years;
    //An ArrayList to store house pricing index levels of that state for every year
    private ArrayList<Float> HPI;
    //An ArrayList to store air pollution levels of that state for every year
    private ArrayList<Float> APL;

    /**
     * @brief Constructor to create a search object for state.
     * @param input The input dataset to be read. This string is a filepath or title.
     * @param state The state for the values that need to be found, inputted as a String.
     * @throws IOException if the file does not exist or cannot be read.
     */
    public Search(String input, String state) throws IOException {
        //Assign the input state to the State variable
        State = state;
        //BufferedReader and FileReader created for dataset reading
        BufferedReader file = new BufferedReader(new FileReader(input));
        //Set up row to store each line of input
        String row = "";
        //Counter used to skip the first line of dataset
        int skip = 1;
        //Reads file while it is not empty (The row is not empty)
		while ((row = file.readLine()) != null) {
            //Split the row input by the comma of the csv
            String[] col = row.split(",");
            //After first line is skipped will run
            if (skip == 0) {
                //If the state is equal to the state in the dataset assign values
                if (State.equals(col[0])) {
                    //Converts the values into a respective variable type
                    Integer year = Integer.parseInt(col[5]);
                    Float hpi = Float.parseFloat(col[3]);
                    Float apl = Float.parseFloat(col[4]);
                    //Adds the values as their new type to each of the ArrayLists
                    Years.add(year);
                    HPI.add(hpi);
                    APL.add(apl);
                }
            }
            //Skips first line but then decreases skip counter
            else {
                skip--;
            }
        }
        //Closes file
        file.close();
    }

    /**
     * @brief Prints the HPI and APL values of a specifc year of the object.
     * @param year The year that the user wants the data for inputted as an Integer.
     */
    public void BinarySearch(Integer year) {
        //Low index of the array to be searched
        int low = 0;
        //High index of the array to be searched
        int high = Years.size() - 1;
        //Runs while the low and high index are not the same
        while (low <= high) {
            //Find the middle index to be searced
            int mid = low + (high - low) / 2;
            //Compares the desired search year to the year at the middle index of the ArrayList
            //If it is lower readjust the middle index
            if (year < Years.get(mid)) {
                high = mid - 1;
            }
            //If it is higher readjust the lower index
            else if (year > Years.get(mid)) {
                low = mid + 1;
            }
            //If the year is equal then keep the middle index the same
            else {
                break
            }
        }
        //Prints the state and the values by accessing the ArrayLists at the middle index.
        System.out.println(State + ", " + HPI.get(mid) + ", " + APL.get(mid) + ", " + Years.get(mid));
    }
}
