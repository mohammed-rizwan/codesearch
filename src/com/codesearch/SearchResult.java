package com.codesearch;


public class SearchResult {

    private String fileName;
    private String line;

    public SearchResult(String fileName, String line) {
        this.fileName = fileName;
        this.line = line;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString(){
        return " { \"fileName\": \""+this.fileName+"\", \"line\": \""+this.line+"\" }";
    }
}
