package primingtool.business;

import primingtool.model.Member;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class CSVHandler {

    private static File originalImportFile;
    private static String [] originalColumns;
    private static String fileName;
    private static String date;

    private static int amountOfSuccessfulRecords;
    private static int amountOfFailedRecords;

    private static HashMap <String, String> columnIndex = new HashMap<>();

    public static String successfulRecordFileNamePath;
    public static String failedRecordFileNamePath;

    /**
     *
     * @return
     */
    public static File getOriginalImportFile(){
        return CSVHandler.originalImportFile;
    }

    /**
     *
     * @return
     */
    public static String getOriginalImportFilePath() {
        return originalImportFile.getAbsolutePath();
    }

    /**
     *
     * @param file
     */
    public static void setOriginalImportFile(File file){
        CSVHandler.originalImportFile = file;
    }

    /**
     * Reads the first line of the .CSV
     */
    public static void setOriginalColumns(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(CSVHandler.originalImportFile));
            String firstLine = bufferedReader.readLine();
            CSVHandler.originalColumns = firstLine.split(",");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @return
     */
    public static String [] getOriginalColumns(){
        return originalColumns;
    }

    /**
     *
     * @return
     */
    public static String getFileName() {
        return fileName;
    }

    /**
     *
     * @param fileName
     */
    public static void setFileName(String fileName) {
        CSVHandler.fileName = fileName;
    }

    /**
     *
     */
    public static void setDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        CSVHandler.date = formatter.format(currentDate);

    }

    /**
     * Retrieves the current date that will be used when exporting the file
     * @return
     */
    public static String getDate(){
        return date;
    }

    /**
     * Retrieves a hasmap of key-values so that it's possible to follow the column order in the CSV File
     * @return
     */
    // TODO @pipe Not often the possessive is used in naming of things.
    public static HashMap<String, String> getColumnIndex() {
        return columnIndex;
    }

    /**
     * Adds the key-values to the hashmap for future reference when creating the Member Objects.
     * @param columnName
     * @param columnIndex
     */
    public static void addValueToColumn(String columnName, String columnIndex) {
        CSVHandler.columnIndex.put(columnName, columnIndex);

    }

    /**
     *
     * @param map
     * @param value
     * @return
     */
    private static String getKey(HashMap<String, String> map, String value){
        if(value != null){
            for (String key: map.keySet()) {
                if (value.equals(map.get(key))){
                    return key;
                }
            }
        }
        return null;
    }

    public static int getSuccessfulRecords() {
        return amountOfSuccessfulRecords;
    }

    /**
     *
     * @param amountOfRecords
     */
    public static void setSuccessfulRecords(int amountOfRecords) {
        CSVHandler.amountOfSuccessfulRecords = amountOfRecords;
    }

    /**
     *
     * @return
     */
    public static int getFailedRecords() {
        return amountOfFailedRecords;
    }

    /**
     *
     * @param failedRecords
     */
    public static void getFailedRecords(int failedRecords) {
        CSVHandler.amountOfFailedRecords = failedRecords;
    }

    /**
     *
     */
    public static void createFileDirectory(){
        String erroredFolder = "Errored Imports";
        File erroredDirectoy = new File(erroredFolder);
        if (!erroredDirectoy.isDirectory()) {
            erroredDirectoy.mkdir();
        }
        String successfullFolder = "Successful Imports";
        File successfulDirectory = new File(successfullFolder);
        if (!successfulDirectory.isDirectory()) {
            successfulDirectory.mkdir();
        }
    }

    /**
     *
     * @param date
     * @param fileName
     */
    public static void setOutputFilenames(String date, String fileName){
        CSVHandler.failedRecordFileNamePath = "Errored Imports/"+"Errored"+date+fileName+".csv";
        CSVHandler.successfulRecordFileNamePath = "Successful Imports/"+date+fileName+".csv";
    }

    /**
     *
     * @param filePath
     * @param memberList
     */
    public static void createFile (String filePath, List<Member> memberList){
        try{
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            for (int i = 0; i<memberList.size(); i++){
                printWriter.println(memberList.get(i).toString());
                printWriter.flush();
            }
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean hasValueFor(String columnName) {
        return !getColumnIndex().get(columnName).equals("-1");
    }

    public static int getIndexFor(String columnName) {
        return Integer.parseInt(CSVHandler.getColumnIndex().get(columnName));
    }

}
