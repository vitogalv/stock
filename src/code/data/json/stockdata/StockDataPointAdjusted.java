package code.data.json.stockdata;

import code.data.json.KeyMaker;
import code.data.json.Request;
import com.eclipsesource.json.JsonObject;

/**
 * This class represents a datapoint obtained from{
 *     TIME_SERIES_MONTHLY_ADJUSTED
 *     TIME_SERIES_WEEKLY_ADJUSTED
 * }
 */
public class StockDataPointAdjusted extends StockDataPoint {

    protected double _adjustedClose, _dividendAmount;

    /**
     * @param json the json object member with all this points data
     * @param request the origianl request for data
     */
    public StockDataPointAdjusted(JsonObject.Member json, Request request){
        super(json, request);
        KeyMaker maker = new KeyMaker(request);
        JsonObject innerData = json.getValue().asObject();
        _adjustedClose = Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.ADJUSTED_CLOSE)).asString());
        _dividendAmount = Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.DIVIDEND_AMOUNT)).asString());
    }

    public double getAdjustedClose(){
        return _adjustedClose;
    }

    public double getDividendAmount(){
        return _dividendAmount;
    }

    @Override
    public String toString(){
        String retVal = "Adjusted Close= " + _adjustedClose + "\n"
                + "Dividend Amount= " + _dividendAmount + "\n"
                + super.toString();
        return retVal;
    }
}
