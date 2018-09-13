package code.data.json;

import code.data.json.stockdata.*;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;

public class ApiUtils {

    /**
     * @param request the request that builds the appropriate url for
     * @return linked list of all the datapoints
     */
    public static LinkedList<StockData> getStockData(Request request){
        URL api = request.getUrl();
        try {
            InputStreamReader reader = new InputStreamReader(api.openStream());
            JsonObject all = (JsonObject) Json.parse(reader);
            return parseWholeObject(all, request);
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param json the Json object that contains all the api data
     * @param request is the request object for this data
     * @return LinkedList of all the contained data
     */
    private static LinkedList<StockData> parseWholeObject(JsonObject json, Request request){
        LinkedList<StockData> retVal = new LinkedList<>();
        KeyMaker maker = new KeyMaker(request);
        JsonObject data = json.get(maker.getDataKey()).asObject();
        String function = request.getFunction();
        if(function.equals("GLOBAL_QUOTE")){
            GlobalStockQuote quote = new GlobalStockQuote(data, request);
            retVal.add(quote);
            return retVal;
        }
        for(JsonObject.Member member : data){
            if(function.contains("ADJUSTED")){
                if(function.contains("DAILY")){
                    StockDataPointDailyAdjusted dailyPoint = new StockDataPointDailyAdjusted(member, request);
                    retVal.add(dailyPoint);
                }else{
                    StockDataPointAdjusted adjustedPoint = new StockDataPointAdjusted(member, request);
                    retVal.add(adjustedPoint);
                }
            }else{
                StockDataPoint dataPoint = new StockDataPoint(member, request);
                retVal.add(dataPoint);
            }
        }
        return retVal;
    }


}
