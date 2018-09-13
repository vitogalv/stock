package code.data.json.stockdata;

import code.data.json.KeyMaker;
import code.data.json.Request;
import com.eclipsesource.json.JsonObject;

public class GlobalStockQuote extends StockData {

    private TimeStamp _latestTradingDay;

    private double _previousClose, _change, _changePercent;

    /**
     * @param json the json object containing all of the quote data
     * @param request the data request
     */
    public GlobalStockQuote(JsonObject json, Request request){
        KeyMaker maker = new KeyMaker(request);
        _symbol = request.getSymbol();
        _open = Double.parseDouble(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.OPEN)).asString());
        _high = Double.parseDouble(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.HIGH)).asString());
        _low = Double.parseDouble(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.LOW)).asString());
        _volume = Integer.parseInt(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.VOLUME)).asString());
        _previousClose = Double.parseDouble(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.PREVIOUS_CLOSE)).asString());
        _change = Double.parseDouble(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.CHANGE)).asString());
        String changePercent = json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.CHANGE_PERCENT)).asString();
        _changePercent = Double.parseDouble(changePercent.substring(0, changePercent.length()-1));
        _latestTradingDay = new TimeStamp(json.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.LATEST_TRADING_DAY)).asString());
    }

    public TimeStamp getLastTradingDay(){
        return _latestTradingDay;
    }

    public double getPreviousClose(){
        return _previousClose;
    }

    public double getChange(){
        return _change;
    }

    public double getChangePercent(){
        return _changePercent;
    }

    @Override
    public String toString(){
        String retVal = super.toString()
                + "Last Trading Day= " + _latestTradingDay.toString() + "\n"
                + "Previous Close= " + _previousClose + "\n"
                + "Change= " + _change + "\n"
                + "Change Percent= " + _changePercent + "\n";
        return retVal;
    }
}
