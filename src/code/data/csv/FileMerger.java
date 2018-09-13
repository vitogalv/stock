package code.data.csv;

import java.io.*;
import java.util.ArrayList;

public class FileMerger {

    /**
     * @return an ArrayList of filenames that correspond to the 11 csv files containing stock symbols and company names
     */
    private ArrayList<String> getFileNames(){
        ArrayList<String> retVal = new ArrayList<>();
        for(int i = 0; i <= 10; i++){
            retVal.add("C:\\Users\\Vito\\Desktop\\stock\\resources\\companies_by_sector_nasdaq\\companylist (" + i +").csv");

        }
        return retVal;
    }

    /**
     * this method will add all of the data in the files specified by the paths within {@param files} to the file
     * specified by {@param collective}
     * @param collective string representing the collective csv file
     * @param files list of filenames that correspond to the 11 csv files containing all of the data
     */
    private void addAll(String collective, ArrayList<String> files) throws IOException {
        FileOutputStream fos = new FileOutputStream(collective, true);
        FileInputStream fis = null;
        InputStreamReader reader = null;
        for(String name : files){
            fis = new FileInputStream(name);
            reader = new InputStreamReader(fis);
            addData(fos, reader);
            fis.close();
            reader.close();
        }
        fos.close();
    }

    /**
     * This method will take input from {@param input} and add it to {@param output}
     * @param output the output stream associated with the collective file
     * @param input the input stream reader associated with a file whose data is to be added to the collective file
     */
    private void addData(FileOutputStream output, InputStreamReader input)  throws IOException {
        int chara;
        while((chara = input.read()) != -1){
            output.write(chara);
        }
    }

    public void execute(){
        try {
            addAll("C:\\Users\\Vito\\Desktop\\stock\\resources\\companies_by_sector_nasdaq\\companylist.csv", getFileNames());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
