package tests;

import code.data.json.stockdata.StockDataPoint;
import code.data.json.stockdata.TimeStamp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class StockDataPointTests {

    @Test
    public void testConstruction00(){
        StockDataPoint dp = new StockDataPoint("KLM","1999-02-16", 17.2435, 24.88, 14.77, 19.70, 135569);
        TimeStamp time = dp.getTime();
        int year = time.getYear();
        int month = time.getMonth();
        int date = time.getDate();
        assertEquals(1999, year);
        assertEquals(02, month);
        assertEquals(16, date);
        assertEquals(17.2435, dp.getOpen(), 0.000001);
        assertEquals(24.88, dp.getHigh(), 0.0000001);
        assertEquals(14.77, dp.getLow(), 0.0000001);
        assertEquals(19.70, dp.getClose(), 0.0000001);
        assertEquals(135569, dp.getVolume());
    }

    @Test
    public void testConstruction01(){
        StockDataPoint dp = new StockDataPoint("CTS","2018-12-25 21:15:22", 92.30, 93.425, 89.97, 89.97, 14502);
        TimeStamp time = dp.getTime();
        int year = time.getYear();
        int month = time.getMonth();
        int date = time.getDate();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        assertEquals(2018, year);
        assertEquals(12, month);
        assertEquals(25, date);
        assertEquals(21, hour);
        assertEquals(15, minute);
        assertEquals(22, second);
        assertEquals(92.30, dp.getOpen(), 0.000001);
        assertEquals(93.425, dp.getHigh(), 0.000000001);
        assertEquals(89.97, dp.getLow(), 0.000000001);
        assertEquals(89.97, dp.getClose(), 0.000000001);
        assertEquals(14502, dp.getVolume());
    }
}
