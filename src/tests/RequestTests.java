package tests;

import code.data.json.Request;
import code.data.json.url.Function;
import code.data.json.url.Interval;
import code.data.json.url.OutputSize;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RequestTests {

    @Test
    public void testGetUrlString00(){
        Request req = new Request(Function.TIME_SERIES_DAILY, "MSFT", Interval.Inter.FIVE);
        String url = req.getUrlString();
        assertEquals("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=MSFT&interval=5min&apikey=BR9J1B0YA4Z7QW6O", url);
    }

    @Test
    public void testGetUrlString01(){
        Request req = new Request(Function.TIME_SERIES_DAILY_ADJUSTED, "NTFX", Interval.Inter.FIFTEEN, OutputSize.full);
        String url  = req.getUrlString();
        assertEquals("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=NTFX&interval=15min&outputsize=full&apikey=BR9J1B0YA4Z7QW6O", url);
    }


}
