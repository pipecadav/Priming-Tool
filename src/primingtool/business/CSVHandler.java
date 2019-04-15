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
    private static int successfulRecords;
    private static int erroredRecords;
    private static HashMap <String, Integer> columnsIndex = new HashMap<String, Integer>();
    public static String successfulFileNamePath;
    public static String failedFileNamePath;


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
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(CSVHandler.getOriginalImportFilePath()), System.getProperty("file.encoding")));
            String firstLine = bufferedReader.readLine();
            CSVHandler.originalColumns = firstLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)|;(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
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
    public static HashMap<String, Integer> getColumnsIndex() {
        return columnsIndex;
    }

    /**
     * Adds the key-values to the hashmap for future reference when creating the Member Objects.
     * @param fieldName
     * @param fieldIndex
     */
    public static void addValuestoConlumnIndex(String fieldName, Integer fieldIndex) {
        CSVHandler.columnsIndex.put(fieldName, fieldIndex);

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
        return successfulRecords;
    }

    /**
     *
     * @param successfulRecords
     */
    public static void setSuccessfulRecords(int successfulRecords) {
        CSVHandler.successfulRecords = successfulRecords;
    }

    /**
     *
     * @return
     */
    public static int getErroredRecords() {
        return erroredRecords;
    }

    /**
     *
     * @param erroredRecords
     */
    public static void setErroredRecords(int erroredRecords) {
        CSVHandler.erroredRecords = erroredRecords;
    }

    /**
     *
     */
    public static void createFileDirectory(){
        String erroredFolder = "Failed Imports";
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
        CSVHandler.failedFileNamePath = "Failed Imports/"+"Failed"+date+fileName+".csv";
        CSVHandler.successfulFileNamePath = "Successful Imports/"+date+fileName+".csv";
    }

    /**
     *
     * @param filePath
     * @param memberList
     */
    public static void createFile (String filePath, List<Member> memberList){
        try{
            Writer bufferedWriter = new OutputStreamWriter(
                            new FileOutputStream(filePath),
                    System.getProperty("file.encoding"));
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

}
