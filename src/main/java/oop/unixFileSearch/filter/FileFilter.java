package oop.unixFileSearch.filter;


import oop.unixFileSearch.File;

public abstract class FileFilter {

    protected final FilterOperator operator;

    protected FileFilter(FilterOperator operator) {
        this.operator = operator;
    }
    public  abstract  boolean match(File file);

}
