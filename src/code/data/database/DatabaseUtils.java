package code.data.database;

import code.data.csv.Company;
import code.portfolio.Portfolio;
import code.portfolio.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class will contain methods to interact with the database
 * The code in the file may be similar to the Oracle JDBC tutorial and MySql Tutorial
 */
public class DatabaseUtils {

    private String getConfigUrl(){
        return "jdbc:mysql://address=(host=localhost)(port=3306)(user=root)(password=*******)(useSSL=false)(emulateLocators= true)/stockmarket";
    }

    /**
     * bindDataSource has to be called before using this  method
     * @return connection associated with the stockmarket database
     */
    public Connection getConnection(){
        Connection retVal = null;
        try {
            retVal = DriverManager.getConnection(getConfigUrl());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return retVal;
    }

//    /**
//     * This method will store the csv values from companylist.csv in the companies table
//     */
//    public void CompanyListToDb() throws SQLException {
//        LinkedList<Company> companies = CsvUtils.getCompanyList();
//        Connection connect = getConnection();
//        Statement st = connect.createStatement();
//        for(Company c : companies){
//            st.execute(c.getSqlInsert());
//        }
//        st.close();
//        connect.close();
//    }

    /**
     * Convenience method to getArrayList of companies from companies table in database
     * @param query valid sql query that selects the entire row
     * @return an arraylist containing all of the company objects with the data from the resultset
     * @throws SQLException when SQLException is encountered
     */
    public ArrayList<Company> selectCompanies(String query)throws SQLException{
        ArrayList<Company> retVal = new ArrayList<>();
        Connection connect = getConnection();
        Statement st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet set = st.executeQuery(query);
        while(set.next()){
            String symbol = set.getString(1);
            String name = set.getString(2);
            String ipo = set.getString(3);
            String sector = set.getString(4);
            String industry = set.getString(5);
            String link = set.getString(6);
            Company comp  = new Company(symbol, name, ipo, sector, industry, link);
            retVal.add(comp);
        }
        st.close();
        connect.close();
        return retVal;
    }

    /**
     * This method should be used to get an up to date version of the portfolio
     * do not instantiate {@link Portfolio} directly
     * @return an up to date instance of the portfolio
     */
    public Portfolio getPortfolio(){
        LinkedList<Transaction> transactions = new LinkedList<>();
        Connection connect = getConnection();
        String query = "SELECT * FROM transactions";
        Statement st = null;
        ResultSet result = null;
        try {
            st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = st.executeQuery(query);
            while(result.next()){
                String symbol = result.getString(1);
                Timestamp time = result.getTimestamp(2);
                String type = result.getString(3);
                double value = result.getDouble(4);
                int quanity = result.getInt(5);
                Transaction trans = new Transaction(symbol, time, type, value, quanity);
                transactions.add(trans);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new Portfolio(transactions);
    }

    /**
     * This method will add the given transaction to the database
     * @param transaction the transaction who's data is going to the database
     * @return true if the operation was successful
     */
    public boolean addTransaction(Transaction transaction){
        String statement = "insert into transactions values(" + transaction.toString() + ")";
        Connection connect = getConnection();
        Statement st = null;
        try{
            st = connect.createStatement();
            st.execute(statement);
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }finally{
            if(st != null){
                try{
                    st.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(connect != null){
                try{
                    connect.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
