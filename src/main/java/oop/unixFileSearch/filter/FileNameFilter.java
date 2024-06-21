package oop.unixFileSearch.filter;

import oop.unixFileSearch.File;

public class FileNameFilter extends FileFilter{
    private FilterOperator operator;
    private String nameFilter;

    public FileNameFilter(FilterOperator operator, String nameFilter) {
        super(operator);
        this.nameFilter = nameFilter;
    }
    @Override
    public boolean match(File file) {
        switch (operator) {
            case EQUAL -> {
                return file.getName().equals(nameFilter);
            }
            case EQUAL_IGNORE_CASE -> {
                return file.getName().equalsIgnoreCase(nameFilter);
            }
        }
        return false;
    }
}
