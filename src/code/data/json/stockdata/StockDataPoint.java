package code.data.json.stockdata;


import code.data.json.Request;
import com.eclipsesource.json.JsonObject;

/**
 * This class represents a single data point taken for the alphavantage stock
 * data api.
 * This object is to be used for datapoints from{
 *     TIME_SERIES_MONTHLY
 *     TIME_SERIES_DAILY
 *     TIME_SERIES_INTRADAY
 *     TIME_SERIES_WEEKLY
 * }
 */
public class StockDataPoint extends StockData {

    /**
     * The time stamp of the data point
     */
    private TimeStamp _time;

    /**
     * Constructor to set all values can be null values
     * @param time string in the format of "yyyy-mm-dd hh:mm:ss" or if intraday time is not
     *             applicable then just "yyyy-mm-dd"
     * @param open the open price of the stock at this time
     * @param high the high price of the stock during the period
     * @param low the low price of the stock during the period
     * @param close the close price of the stock at the end of the period
     * @param volume the volume of the stock during this period
     */
    public StockDataPoint(String symbol, String time, double open, double high, double low, double close, int volume){
        _symbol = symbol;
        _time = new TimeStamp(time);
        _open = open;
        _close = close;
        _high = high;
        _low = low;
        _volume = volume;
    }

    /**
     * @param json the object memeber that contains this stocks data
     * @param request the original data request
     */
    public StockDataPoint(JsonObject.Member json, Request request){
        super(json, request);
        _time = new TimeStamp(json.getName());
    }

    /**
     * @return Calendar of this  datapoint
     */
    public TimeStamp getTime(){
        return _time;
    }

    @Override
    public String toString(){
        String retVal = "Time= " + _time.toString() + "\n" + super.toString();
        return retVal;
    }
}
