package src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import src.State;

public class WriteCSV {
    
    public static void writeState(State[] a, String filepath) {
        File file = new File(filepath);
        try {
            FileWriter writer = new FileWriter(file); // create FileWriter

            // Add header to CSV
            writer.append("State");
            writer.append(",");
            writer.append("Latitude");
            writer.append(",");
            writer.append("Longitude");
            writer.append(",");
            writer.append("Housing Price Index");
            writer.append(",");
            writer.append("Mean NO2 Pollution (ppb)");
            writer.append(",");
            writer.append("Year");
            writer.append(",");
            writer.append("ID");
            writer.append("\n");

            // Add data to CSV
            for (int i=0; i<a.length; i++) {
                writer.append(a[i].state());
                writer.append(",");
                writer.append(Double.toString(a[i].lat()));
                writer.append(",");
                writer.append(Double.toString(a[i].lng()));
                writer.append(",");
                writer.append(Double.toString(a[i].hpi()));
                writer.append(",");
                writer.append(Double.toString(a[i].pollution()));
                writer.append(",");
                writer.append(Integer.toString(a[i].year()));
                writer.append(",");
                writer.append(Integer.toString(a[i].getID()));
                writer.append("\n");
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
