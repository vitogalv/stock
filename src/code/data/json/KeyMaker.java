package code.data.json;

/**
 * This class is used to get all of the appropriate keys based on the data Request for the json objects
 */
public class KeyMaker {

    private Request _request;

    /**
     * All of the data that a data point can hold. Not all api functions will return the same format of data
     */
    public enum Attribute {
        OPEN, HIGH, LOW, CLOSE, ADJUSTED_CLOSE, VOLUME, DIVIDEND_AMOUNT, SPLIT_COEFFICIENT
        , LATEST_TRADING_DAY, PREVIOUS_CLOSE, CHANGE, CHANGE_PERCENT, PRICE
    }

    /**
     * @param request the data request
     */
    public KeyMaker(Request request){
        _request = request;
    }

    /**
    * @return the json object key for the data series
    */
    public String getDataKey(){
        switch (_request.getFunction()){
            case "TIME_SERIES_INTRADAY":
                return "Time Series (" + _request.getInterval() + ")";
            case "TIME_SERIES_DAILY_ADJUSTED":
                return "Time Series (Daily)";
            case "TIME_SERIES_WEEKLY":
                return "Weekly Time Series";
            case "TIME_SERIES_WEEKLY_ADJUSTED":
                return "Weekly Adjusted Time Series";
            case "TIME_SERIES_MONTHLY":
                return "Monthly Time Series";
            case "TIME_SERIES_MONTHLY_ADJUSTED":
                return "Monthly Adjusted Time Series";
        }
    return "Global Quote";
    }

    /**
     * @param attribute is the attribute of any arbitrary data point
     * @return string representing the proper key to get the individual data items from the time series
     * ie: open, close, volume, etc.
     */
    public String getDataPointAttributeKey(Attribute attribute){
        switch (attribute){
            case OPEN:
                return getOpenKey();
            case HIGH:
                return getHighKey();
            case LOW:
                return getLowKey();
            case CLOSE:
                return getCloseKey();
            case VOLUME:
                return getVolumeKey();
            case ADJUSTED_CLOSE:
                return getAdjustedCloseKey();
            case DIVIDEND_AMOUNT:
                return getDividendAmountKey();
            case SPLIT_COEFFICIENT:
                return getSplitCoefficientKey();
            case LATEST_TRADING_DAY:
                return getLatestTradingDayKey();
            case PREVIOUS_CLOSE:
                return getPreviousCloseKey();
            case CHANGE:
                return getChangeKey();
            case CHANGE_PERCENT:
                return getChangePercentKey();
            case PRICE:
                return getPriceKey();
        }
        return null;
    }

    private String getOpenKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "02. open";
        }else{
            return "1. open";
        }
    }

    private String getHighKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "03. high";
        }else{
            return "2. high";
        }
    }

    private String getLowKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "04. low";
        }else{
            return "3. low";
        }
    }

    private String getCloseKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "05. close";
        }else{
            return "4. close";
        }
    }

    private String getVolumeKey() {
        String function = _request.getFunction();
        if(function.equals("GLOBAL_QUOTE")){
            return "06. volume";
        }else if(function.equals("TIME_SERIES_DAILY_ADJUSTED") || function.equals("TIME_SERIES_WEEKLY_ADJUSTED") || function.equals("TIME_SERIES_MONTHLY_ADJUSTED")){
            return "6. volume";
        }else{
            return "5. volume";
        }
    }

    private String getAdjustedCloseKey(){
        String function = _request.getFunction();
        if(function.equals("TIME_SERIES_DAILY_ADJUSTED") || function.equals("TIME_SERIES_WEEKLY_ADJUSTED") || function.equals("TIME_SERIES_MONTHLY_ADJUSTED")){
            return "5. adjusted close";
        }
        return null;
    }

    private String getDividendAmountKey(){
        String function = _request.getFunction();
        if(function.equals("TIME_SERIES_DAILY_ADJUSTED") || function.equals("TIME_SERIES_WEEKLY_ADJUSTED") || function.equals("TIME_SERIES_MONTHLY_ADJUSTED")){
            return "7. dividend amount";
        }
        return null;
    }

    private String getSplitCoefficientKey(){
        if(_request.getFunction().equals("TIME_SERIES_DAILY_ADJUSTED")){
            return "8. split coefficient";
        }
        return null;
    }

    public String getPriceKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "05. price";
        }
        return null;
    }

    private String getLatestTradingDayKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "07. latest trading day";
        }
        return null;
    }

    private String getPreviousCloseKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "08. previous close";
        }
        return null;
    }

    private String getChangeKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "09. change";
        }
        return null;
    }

    private String getChangePercentKey(){
        if(_request.getFunction().equals("GLOBAL_QUOTE")){
            return "10. change percent";
        }
        return null;
    }
}
