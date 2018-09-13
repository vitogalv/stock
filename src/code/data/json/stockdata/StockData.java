package code.data.json.stockdata;

import code.data.json.KeyMaker;
import code.data.json.Request;
import com.eclipsesource.json.JsonObject;

/**
 * This class represents a stock with it's most basic data
 */
public abstract class StockData {

    /**
     * The ticker or stock symbol
     */
    protected String _symbol;

    /**
     * The prices during the time period
     */
    protected double _open, _high, _low, _close;

    /**
     * The volume of the stock
     */
    protected int _volume;

    public StockData(){}

    /**
     * @param json json member containing all of the data
     * @param request
     */
    public StockData(JsonObject.Member json, Request request){
        _symbol = request.getSymbol();
        KeyMaker maker = new KeyMaker(request);
        JsonObject innerData = json.getValue().asObject();
        _open = Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.OPEN)).asString());
        _high = Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.HIGH)).asString());
        _low = Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.LOW)).asString());
        _close = Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.CLOSE)).asString());
        _volume = Integer.parseInt(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.VOLUME)).asString());
    }
    /**
     * @return a string representing the symbol of the stock
     */
    public String getSymbol(){
        return _symbol;
    }

    /**
     * @return the open price of the stock
     */
    public double getOpen(){
        return _open;
    }

    /**
     * @return the high price of the stock
     */
    public double getHigh(){
        return _high;
    }

    /**
     * @return the low price of the stock
     */
    public double getLow(){
        return _low;
    }

    /**
     * @return the close price of the stock
     */
    public double getClose(){
        return _close;
    }

    /**
     * @return the volume of the stock
     */
    public int getVolume(){
        return _volume;
    }

    @Override
    public String toString(){
        String retVal = "Symbol= " + _symbol + "\n"
                + "Open= " + _open + "\n"
                + "High= " + _high + "\n"
                + "Low= " + _low + "\n"
                + "Close= " + _close + "\n"
                + "Volume= " + _volume + "\n";
        return retVal;
    }
}
