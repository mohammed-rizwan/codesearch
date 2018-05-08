package com.codesearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SearchService {


    /*

    Search gets the word from the InvertedIndex at O(1) and iterates thro the List of the Index
    and gets their respective lines in the FileData Map at again O(1) & O(1) time complexity.

    Average response time : 1 ms
     */

    public List<SearchResult> search(String word){
        List<SearchResult> sr= new ArrayList<>();
        Map<String,List<String>> fileData = FileDataManager.getFileData();
        Map<String,List<Index>> ivi=InvertedIndexManager.getInvertedIndex();
        String[] inputWords=word.split("$|#|\\-|\\+|\\.|\\,|\\;|\\(|\\)|@|%|\\'|\\/|\\\"|\\s|&|\\*|!|\\?");
        if (inputWords.length==1) {
            List<Index> ivIdx=ivi.get(inputWords[0]);
            if(ivIdx !=null) {
                for (Index ix : ivIdx) {
                    sr.add(new SearchResult(ix.getFileNameKey(), fileData.get(ix.getFileNameKey()).get(ix.getLineIndex())));
                }
            }
        } else {
            List<List<Index>> ivIdxs = new ArrayList<>();
            for(String iword:inputWords){
                List<Index> li=ivi.get(iword);
                if(li!=null) {
                    ivIdxs.add(li);
                }
            }
            if(ivIdxs.size()>0) {
                List<Index> smallest = new ArrayList<>(ivIdxs.get(0));
                int smallestLength = smallest.size();
                for (List<Index> indx : ivIdxs) {
                    if (indx.size() < smallestLength) {
                        smallest = indx;
                        smallestLength = indx.size();
                    }
                }

                List<Index> commonIndices = new ArrayList<>();
                for (Index in : smallest) {
                    boolean inALLList = true;
                    for (List<Index> indx : ivIdxs) {
                        if (!indx.contains(in)) {
                            inALLList = false;
                        }
                    }
                    if (inALLList) {
                        commonIndices.add(in);
                    }
                }
                for (Index ix : commonIndices) {
                    if(fileData.get(ix.getFileNameKey()).get(ix.getLineIndex()).contains(word)) {
                        sr.add(new SearchResult(ix.getFileNameKey(),fileData.get(ix.getFileNameKey()).get(ix.getLineIndex())));
                    }
                }
            }
        }
        return sr;
    }
}
