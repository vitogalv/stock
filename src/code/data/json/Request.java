package code.data.json;

import code.data.json.url.DataType;
import code.data.json.url.Function;
import code.data.json.url.Interval;
import code.data.json.url.OutputSize;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class will be used as the entry point to the process of getting data from the api. It will handle
 * a lot of string formatting depending upon the request
 */
public class Request {
    private String _function, _symbol, _interval, _outPutSize, _dataType;

    /**
     * This api key for alphavantage.co
     */
    private static final String KEY = "BR9J1B0YA4Z7QW6O";

    /**
     * Contructor with all the required attributes of the url for the stock data api
     * @param function the time series. See {@link Function}
     * @param symbol the ticker of the stock
     * @param interval time interval between data points
     */
    public Request(Function function, String symbol, Interval.Inter interval){
        setFunction(function);
        setSymbol(symbol);
        setInterval(interval);
        setDataType(DataType.json);
    }

    /**
     * Constructor that allows the setting of the optional outputsize attribute
     * @param function
     * @param symbol
     * @param interval
     * @param outputSize
     */
    public Request(Function function, String symbol, Interval.Inter interval, OutputSize outputSize){
        setFunction(function);
        setSymbol(symbol);
        setInterval(interval);
        setOutputSize(outputSize);
        setDataType(DataType.json);
    }

    /**
     * Setter for function attribute
     * @param f desired function enum
     */
    private void setFunction(Function f){
        _function = f.toString();
    }

    /**
     * Setter for symbol/ticker attribute
     * @param symbol a non null string representing a stock  ticker, can be in any case
     */
    private void setSymbol(String symbol){
        _symbol = symbol.toUpperCase();
    }

    /**
     * Setter for outputsize attribute
     * @param size is enum representing outputsize
     */
    private void setOutputSize(OutputSize size){
        _outPutSize = size.toString();
    }

    /**
     * Setter for datatype  which will always be json for this application
     * @param type
     */
    private void setDataType(DataType type){
        _dataType = type.toString();
    }

    /**
     * Setter for interval attribute
     * @param interval
     */
    private void setInterval(Interval.Inter interval){
        _interval = Interval.get(interval);
        if(_interval == null){
            throw new NullPointerException();
        }
    }

    /**
     * @return return the full string to represent to function statement in the url
     */
    private String getFullFunction(){
        return "function=" + _function;
    }

    /**
     * @return string to represent the full symbol statement in the url
     */
    private String getFullSymbol(){
        return "symbol=" + _symbol;
    }

    /**
     * @return string to represent the full interval statement in the url
     */
    private String getFullInterval(){
        return "interval=" + _interval;
    }

    /**
     * @return string to represent the full apikey statement in the url
     */
    private String getFullKey(){
        return "apikey=" + KEY;
    }

    /**
     * @return string to represent the full outputsize statement in the url
     */
    private String getFullOutputSize(){
        return "outputsize=" + _outPutSize;
    }

    /**
     * @return string to represent the full datatype statement in the url
     */
    private String getFullDataType(){
        return "datatype=" + _dataType;
    }

    /**
     * @return a string representing the full url of the request
     */
    public String getUrlString(){
        String retVal = "https://www.alphavantage.co/query?";
        retVal += getFullFunction() + "&";
        retVal += getFullSymbol() + "&";
        retVal += getFullInterval() + "&";
        if(_outPutSize != null){
            retVal += getFullOutputSize() + "&";
        }
        retVal += getFullKey();
        return retVal;
    }

    /**
     * @return a URL object referencing alphavantage's api
     */
    public URL getUrl() {
        URL retVal = null;
        try {
            retVal = new URL(getUrlString());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        return retVal;
    }

    /**
     * @return the function of the request
     */
    public String getFunction(){
        return _function;
    }

    /**
     * @return The time interval of this request
     */
    public String getInterval(){
        return _interval;
    }

    public String getSymbol(){
        return _symbol;
    }

}
