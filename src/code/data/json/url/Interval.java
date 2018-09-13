package code.data.json.url;

/**
 * Class for accessing the interval values for alphavantage url construction
 */
public class Interval {

    /**
     * Intervals for alphavantage data points in minutes
     */
    public enum Inter{
        ONE,
        FIVE,
        FIFTEEN,
        THIRTY,
        SIXTY
    }

    /**
     * Method to get String for alphavantage url
     * @param interval the
     * @return a String that can be used in the alphavantage url to get stock data
     */
    public static String get(Inter interval){
        switch(interval){
            case ONE:
                return  "1min";
            case FIVE:
                return "5min";
            case FIFTEEN:
                return "15min";
            case THIRTY:
                return "30min";
            case SIXTY:
                return "60min";
        }
        return null;
    }
}
