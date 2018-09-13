package code.data.json.stockdata;

public class TimeStamp {

    /**
     * formatted string presenting time (yyyy-mm-dd hh:mm:ss)
     */
    private String _time;

    /**
     * @param time formatted time string
     */
    TimeStamp(String time){
        if(time == null){
            throw new NullPointerException();
        }else if(time.length() < 10){
            throw new IllegalArgumentException();
        }
        _time = time;
    }

    /**
     * @return year as an int
     */
    public int getYear(){
        return Integer.parseInt(_time.substring(0, 4));
    }

    /**
     * @return month as an int
     */
    public int getMonth(){
        return Integer.parseInt(_time.substring(5, 7));
    }

    /**
     * @return date of the month as an int
     */
    public int getDate(){
        return Integer.parseInt(_time.substring(8, 10));
    }

    /**
     * @return hour as an int
     */
    public int getHour(){
        int hour = 0, minute = 0, second = 0;
        if(_time.length() > 10){
            return Integer.parseInt(_time.substring(11, 13));
        }else{
            return 0;
        }
    }

    /**
     * @return minute as an int
     */
    public int getMinute(){
        int hour = 0, minute = 0, second = 0;
        if(_time.length() > 10){
            return Integer.parseInt(_time.substring(14, 16));
        }else{
            return 0;
        }
    }

    /**
     * @return second as an int
     */
    public int getSecond(){
        int hour = 0, minute = 0, second = 0;
        if(_time.length() > 10){
            return Integer.parseInt(_time.substring(17));
        }else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return _time;
    }

}
