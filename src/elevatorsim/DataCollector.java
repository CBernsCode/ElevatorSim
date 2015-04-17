package elevatorsim;

import java.util.LinkedList;

/**
 *
 * @author chris
 */
public class DataCollector {
    
    static LinkedList<Rider> list = new LinkedList<>();

    public static int totalTime(){
        int retVal =0;
        for(Rider rdr : list){
            if(rdr.getStopTime() > retVal)
            {
                retVal = rdr.getStopTime();
            }
        }
        return retVal;
    }
    
    public static int shortestTime(){
        int retVal = 9999999;
        for(Rider rdr : list){
            if(rdr.getTotalTime() < retVal)
            {
                retVal = rdr.getTotalTime();
            }
        }
        return retVal;
    }
    
    public static int longestTime(){
        int retVal = 0;
        for(Rider rdr : list){
            if(rdr.getTotalTime() > retVal)
            {
                retVal = rdr.getTotalTime();
            }
        }
        return retVal;
    }
    
    public static void addRiderToList(Rider rider)
    {
         list.add(rider);
    }
    
    public static int howManyFinished(){
        int retVal = 0;
        for(Rider rdr : list){
            retVal++;
        }
        return retVal;
    }
    
}
