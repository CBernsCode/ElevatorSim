package elevatorsim;

import java.util.LinkedList;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * I used some work that was done in the group project for guidance I proceded
 * to hack something togeth
 *
 * @author chris
 */
public class DataCollector {

    static LinkedList<Rider> list = new LinkedList<>();

    public static int totalTime() {
        int retVal = 0;
        for (Rider rdr : list) {
            if (rdr.getStopTime() > retVal) {
                retVal = rdr.getStopTime();
            }
        }
        return retVal;
    }

    public int shortestTime() {
        int retVal = 9999999;
        for (Rider rdr : list) {
            if (rdr.getTotalTime() < retVal) {
                retVal = rdr.getTotalTime();
            }
        }
        return retVal;
    }

    public int longestTime() {
        int retVal = 0;
        for (Rider rdr : list) {
            if (rdr.getTotalTime() > retVal) {
                retVal = rdr.getTotalTime();
            }
        }
        return retVal;
    }

    public static void addRiderToList(Rider rider) {
        list.add(rider);
    }

    public static int howManyFinished() {
        int retVal = 0;
        for (Rider rdr : list) {
            retVal++;
        }
        return retVal;
    }

    public static Rider getRiderByIndex(int a) {
        Rider retRdr = null;
        try {
            retRdr = list.get(a);
        } catch (Exception e) {

        }
        return retRdr;
    }

    public int getTotalTime() {
        int retVal = 0;
        for (Rider rdr : list) {
            retVal += rdr.getTotalTime();
        }
        return retVal;
    }

    public void writeOutputFile() throws IOException {

        Path p = Paths.get("./results.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("./output.txt");
        } catch (IOException ex) {
            Logger.getLogger(DataCollector.class.getName()).log(Level.SEVERE, null, ex);
        }

        String info = "";
        for (Rider rdr : list) {
            if (fileWriter != null) {
                try {
                    fileWriter.write(rdr.toString());
                    fileWriter.write('\n');
                } catch (IOException ex) {
                    Logger.getLogger(DataCollector.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        fileWriter.close();
    }
}
