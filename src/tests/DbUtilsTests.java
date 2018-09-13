package tests;

import code.data.csv.Company;
import code.data.database.DatabaseUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;

public class DbUtilsTests {

    @Test
    public void testSelectValid(){
        DatabaseUtils utils = new DatabaseUtils();
        ArrayList<Company> comps = null;
        try {
            comps = utils.selectCompanies("select * from companies where industry like 'basic industries'");
        }catch(SQLException e){
            e.printStackTrace();
        }
        for(Company c : comps){
            System.out.println(c.toString());
        }
    }
}
