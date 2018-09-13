package code.data.csv;

/**
 * This class servers as a container for all the attributes of a company that I care about from the csv file
 */
public class Company {

    /**
     * This ticker for the company
     */
    private String _symbol;

    /**
     * The name of the company
     */
    private String _name;

    /**
     * The year that the company when public
     */
    private String _ipoYear;

    /**
     * The sector that the company belongs to
     */
    private String _sector;

    /**
     * The industry that the company belongs to
     */
    private String _industry;

    /**
     * The url to the summary quote from nasdaq.com
     */
    private String _link;

    /**
     * @param csvLine a line from the csv file with one row of information
     */
    public Company(String csvLine){
        String[] info = toArray(csvLine);
        clean(info);
        setFields(info);
    }

    public Company(String symbol, String name, String ipo, String sector, String industry, String link){
        _symbol = symbol;
        _name = name;
        _ipoYear = ipo;
        _sector = sector;
        _industry = industry;
        _link= link;
    }

    /**
     * @param csvLine
     * @return an array with
     */
    private String[] toArray(String csvLine){
        String[] retVal = new String[6];
        String[] lineData = csvLine.split("\",\"");
        retVal[0] = lineData[0];
        retVal[1] = lineData[1];
        retVal[2] = lineData[5];
        retVal[3] = lineData[6];
        retVal[4] = lineData[7];
        retVal[5] = lineData[8];
        return retVal;
    }

    /**
     * This method will remove all of the quotes surrounding the values in {@param row}
     * @param row an array of values representing a row of values in a csv  file
     */
    private void removeQuotesCommas(String[] row){
        for(int i = 0; i < row.length; i++){
            row[i] = row[i].replaceAll("\"", "");
            row[i] = row[i].replaceAll(",", "");
        }
    }

    /**
     * This method will clean {@param values}
     * @param values the values from toArray()
     */
    private void clean(String[] values){
        removeQuotesCommas(values);
        if(values[2].equals("n/a")){
            values[2] = "0000";
        }
    }

    /**
     * This method will set the instance fields
     * @param values the final array of cleansed and validated values
     */
    private void setFields(String[] values){
        _symbol = values[0];
        _name = values[1];
        _ipoYear = values[2];
        _sector = values[3];
        _industry = values[4];
        _link = values[5];
    }

    public String getSymbol(){
        return _symbol;
    }

    public String getName(){
        return _name;
    }

    public String getIpoYear(){
        return _ipoYear;
    }

    public String getSector(){
        return _sector;
    }

    public String getIndustry(){
        return _industry;
    }

    public String getLink(){
        return _link;
    }

    @Override
    public String toString(){
        return "'" + _symbol + "'" + "," + "'" + _name + "'" + "," + "'" + _ipoYear + "'" + "," + "'" + _sector + "'" + "," + "'" + _industry + "'" + "," + "'" + _link + "'";
    }

    /**
     * @return the sql insert statement for the companies data
     */
    public String getSqlInsert(){
        return "INSERT INTO companies VALUES(" + toString() + ")";
    }

}
