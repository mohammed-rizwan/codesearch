package com.codesearch;

public class Index {
    private String fileNameKey;
    private Integer lineIndex;

    public Index(String fileNameKey, Integer lineIndex) {
        this.fileNameKey = fileNameKey;
        this.lineIndex = lineIndex;
    }

    public String getFileNameKey() {
        return fileNameKey;
    }

    public void setFileNameKey(String fileNameKey) {
        this.fileNameKey = fileNameKey;
    }

    public Integer getLineIndex() {
        return lineIndex;
    }

    public void setLineIndex(Integer lineIndex) {
        this.lineIndex = lineIndex;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null){
            return false;
        } else if (obj instanceof Index){
            Index cObj = (Index)obj;
            return this.fileNameKey.equals(cObj.fileNameKey) && this.lineIndex.equals(cObj.lineIndex);
        }
        return false;
    }
}
