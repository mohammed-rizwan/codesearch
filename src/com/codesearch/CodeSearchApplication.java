package com.codesearch;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CodeSearchApplication {

    private static SearchService searchService = new SearchService();
    public static void main(String[] args) {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        FileDataManager.absorbFolderDataAndCreateIndex(new File(s+"/dump/"));
        Scanner scanIn= new Scanner(System.in);
        System.out.println("Enter word to search (Type EXIT to quit) : ");
        String word = scanIn.nextLine();
        do {

            long startTimeInMs = new Date().getTime();
            List<SearchResult> result = searchService.search(word);
            System.out.println("Total time in ms : " + (new Date().getTime() - startTimeInMs));
            System.out.println("Total number of lines with word : " + result.size());
            System.out.println(result);
            System.out.println("Enter word to search (Type EXIT to quit) : ");
            word = scanIn.nextLine();
        }while (!word.toUpperCase().equals("EXIT"));

    }
}
