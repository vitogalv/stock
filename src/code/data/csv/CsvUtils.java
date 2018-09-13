package code.data.csv;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class CsvUtils {

    /**
     * @return a list of the companies from the csv file
     */
    public static LinkedList<Company> getCompanyList(){
        LinkedList<Company> retVal = new LinkedList<>();
        try {
            for (String line : Files.readAllLines(Paths.get("C:\\Users\\Vito\\Desktop\\stock\\resources\\companies_by_sector_nasdaq\\companylist.csv"))) {
                Company company = new Company(line);
                retVal.add(company);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return retVal;
    }
}
