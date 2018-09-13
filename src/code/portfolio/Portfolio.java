package code.portfolio;

import code.data.database.DatabaseUtils;
import code.gui.Drawable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.util.LinkedList;

/**
 * Class to represents a collection of the users transactions and methods to analyze this collection
 */
public class Portfolio implements Drawable {

    private static final double INITIAL_INVESTMENT = 1000.0;

    private LinkedList<Transaction> _transactions;

    /**
     * @param transactions a linkedlist of all transactions
     */
    public Portfolio(LinkedList<Transaction> transactions){
        if(transactions == null){
            throw new NullPointerException();
        }
        _transactions = transactions;
    }

    /**
     * @return the number in dollars of how negative or positive
     */
    public double getCurrentStance(){
        Double retVal = INITIAL_INVESTMENT;
        for(Transaction t : _transactions){
            double totalVal = (t.getValue() * t.getQuantity());
            if(t.getType() == Transaction.TransType.BUY){
                retVal -= totalVal;
            }else{
                retVal += totalVal;
            }
        }
        return retVal;
    }

    public void addTransaction(Transaction transaction){
        DatabaseUtils utils = new DatabaseUtils();
        utils.addTransaction(transaction);
        _transactions.add(transaction);
    }

    @Override
    public Node draw() {
        VBox contentOrganizer = new VBox();
        ScrollPane retVal = new ScrollPane(contentOrganizer);

        return null;
    }
}
