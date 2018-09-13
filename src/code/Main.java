package code;

import code.data.database.DatabaseUtils;
import code.portfolio.Portfolio;
import code.portfolio.Transaction;

import java.sql.Timestamp;

public class Main {
    public static void main(String[] args){
        DatabaseUtils utils = new DatabaseUtils();
        Portfolio port = utils.getPortfolio();
        System.out.println("Balance before add :" + port.getCurrentStance());
        long time = 1536628392;
        Transaction trans = new Transaction("MSFT", new Timestamp(time), "buy", 13.67, 27);
        port.addTransaction(trans);
        System.out.println("Balance after add :" + port.getCurrentStance());
    }
}
