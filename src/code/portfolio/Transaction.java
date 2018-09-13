package code.portfolio;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * This class represents the buy or the sale of a single stock in whatever quantity
 */
public class Transaction {

    /**
     * The ticker/symbol of the stock being traded
     */
    private String _symbol;

    /**
     * This time that this transaction occured
     */
    private Timestamp _time;

    /**
     * The type of transaction this is, whether it is a purchase or a sale
     */
    private TransType _type;

    /**
     * The value of the  stock during the time of this transaction
     */
    private double _value;

    /**
     * The quantity of shares that were either bought or sold
     */
    private int _quantity;

    public enum TransType{
        BUY, SELL
    }

    public Transaction(String symbol, Timestamp time, String type, double value, int quantity){
        setSymbol(symbol);
        setTime(time);
        setType(type);
        setValue(value);
        setQuantity(quantity);
    }

    private void setSymbol(String symbol){
        if(symbol == null){
            throw new NullPointerException();
        }
        _symbol = symbol;
    }

    private void setTime(Timestamp time){
        if(time == null){
            throw new NullPointerException();
        }
        _time = time;
    }

    private void setType(String type){
        if(type == null){
            throw new NullPointerException();
        }
        if(type.equalsIgnoreCase("buy")){
            _type = TransType.BUY;
        }else if(type.equalsIgnoreCase("sell")){
            _type = TransType.SELL;
        }else{
            throw new IllegalArgumentException();
        }
    }

    private void setValue(double value){
        _value = value;
    }

    private void setQuantity(int quant){
        _quantity = quant;
    }

    public String getSymbol(){
        return _symbol;
    }

    public Timestamp getTime(){
        return _time;
    }

    public TransType getType(){
        return  _type;
    }

    /**
     * @return the Transaction type as a string
     */
    public String getTransType(){
        if(_type == TransType.BUY){
            return "buy";
        }else{
            return "sell";
        }
    }

    public double getValue(){
        return _value;
    }

    public int getQuantity(){
        return _quantity;
    }

    @Override
    public String toString(){
        return "'" + _symbol + "','" + _time.toString() + "','" +
                getTransType() + "','" + _value + "','" + _quantity + "'";
    }

}
