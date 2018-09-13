package tests;

import code.data.json.ApiUtils;
import code.data.json.Request;
import code.data.json.stockdata.StockData;
import code.data.json.url.Function;
import code.data.json.url.Interval;
import code.data.json.url.OutputSize;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class ApiUtilsTests {

    @Test
    public void testGetStockDataIntraDay(){
        Request request = new Request(Function.TIME_SERIES_INTRADAY, "MSFT", Interval.Inter.SIXTY, OutputSize.compact);
        LinkedList<StockData> data = ApiUtils.getStockData(request);
        for(StockData d : data){
            System.out.println(d.toString());
        }
    }

    @Test
    public void testGetStockDataAdjustedDaily(){
        Request request = new Request(Function.TIME_SERIES_DAILY_ADJUSTED, "MSFT", Interval.Inter.SIXTY, OutputSize.compact);
        LinkedList<StockData> data = ApiUtils.getStockData(request);
        for(StockData d : data){
            System.out.println(d.toString());
        }
    }

    @Test
    public void testGetStockDataGlobalQuote(){
        Request request = new Request(Function.GLOBAL_QUOTE, "TSLA", Interval.Inter.SIXTY);
        LinkedList<StockData> data = ApiUtils.getStockData(request);
        assertEquals(1, data.size());
        System.out.println(data.element().toString());
    }
}
