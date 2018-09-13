package code.data.json.stockdata;

import code.data.json.KeyMaker;
import code.data.json.Request;
import com.eclipsesource.json.JsonObject;

public class StockDataPointDailyAdjusted extends StockDataPointAdjusted{

    /**
     * The split coefficient of this stock
     */
    private double _splitCoefficient;

    /**
     * @param json the json object member with all this points data
     * @param request the origianl request for data
     */
    public StockDataPointDailyAdjusted(JsonObject.Member json, Request request){
        super(json, request);
        KeyMaker maker = new KeyMaker(request);
        JsonObject innerData = json.getValue().asObject();
        _splitCoefficient =  Double.parseDouble(innerData.get(maker.getDataPointAttributeKey(KeyMaker.Attribute.SPLIT_COEFFICIENT)).asString());
    }

    /**
     * @return the split coefficient
     */
    public double getSplitCoefficient(){
        return _splitCoefficient;
    }

    @Override
    public String toString(){
        return "Split Coefficient= " + _splitCoefficient + "\n" + super.toString();
    }
}
