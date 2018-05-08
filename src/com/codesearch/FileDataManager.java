package com.codesearch;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.*;

public class FileDataManager {



    private static Map<String,List<String>> fileData = new HashMap<>();

    public static Map<String,List<String>> getFileData(){
        return fileData;
    }

    private static boolean absorbFileData(File file) {
        List<String> lines ;

        if(fileData.get(file.getName())!=null){
            lines = fileData.get(file.getName());
        } else {
            lines = new ArrayList<>();
        }
        try {
            Scanner scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        }catch(Exception e) {
            return false;
        }
        fileData.put(file.getName(),lines);
        return true;
    }

    private static void absorbFolderData(File entry){
        if(entry.isFile() && Files.isReadable(entry.toPath())){
            absorbFileData(entry);
        } else if(entry.isDirectory()) {
            for(File file:entry.listFiles()){
                if(file.isDirectory()){
                    absorbFolderData(file);
                } else if (file.isFile() && Files.isReadable(entry.toPath())){
                    absorbFileData(file);
                }
            }
        }
    }

    /*

    This function absorbs all the readable files in the folder structure recursively
    and maintains a list of line in for each of the file.
    i.e., it maintains a Map where key is <Filename> and value is the List <Lines> in the file.

    This <Map> is then passed onto Index manager to populate the InvertedIndex for each of word in them.

    */

    public static void absorbFolderDataAndCreateIndex(File folder){
        absorbFolderData(folder);
        InvertedIndexManager.populateInvertedIndex(FileDataManager.getFileData());
    }



}
