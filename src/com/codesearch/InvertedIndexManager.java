package com.codesearch;

import java.util.*;


public class InvertedIndexManager {

    private static Map<String, List<Index>> invertedIndex = new HashMap<>();


    public static Map<String, List<Index>> getInvertedIndex() {
        return invertedIndex;
    }


    /*

    This functions forms the basic Inverted Index for all the words in the files list.

    Input: Map <Filename, List <lines>>

    Inverted Index is a map with Key: "word" and value: List<Index>,
    where Index struct holds - the filename and arraylist index of the line which has the word.

    */

    public static boolean populateInvertedIndex(Map<String,List<String>> fileData){


        for(Map.Entry<String,List<String>> entry:fileData.entrySet()){

            String filename = entry.getKey();
            List<String> lines= entry.getValue();
            for(int i=0;i<lines.size();i++){

                String[] words = lines.get(i).trim().split("$|#|\\-|\\+|\\.|\\,|\\;|\\(|\\)|@|%|\\'|\\/|\\\"|\\s|&|\\*|!|\\?");
                for (String word:words){
                    if(!word.trim().isEmpty()) {
                        List<Index> indices;
                        boolean newIx = false;
                        if (invertedIndex.get(word) != null) {
                            indices = invertedIndex.get(word);
                        } else {
                            indices = new ArrayList<>();
                            newIx = true;
                        }
                        indices.add(new Index(filename, i));
                        if (newIx) {
                            invertedIndex.put(word, indices);
                        }
                    }

                }
            }
        }
        return true;
    }
}
