package oop.unixFileSearch.filter;

import oop.unixFileSearch.File;

public class FileSizeFilter extends FileFilter{

    private final int size;

    public FileSizeFilter(FilterOperator operator, int size) {
        super(operator);
        this.size = size;
    }

    @Override
    public boolean match(File file) {
        switch (operator) {
            case EQUAL -> {
                return file.getSize() == size;
            }
            case BIGGER_THAN -> {
                return file.getSize() >= size;
            }
            case SMALLER_THAN -> {
                return file.getSize() <= size;
            }
        }
        return false;
    }
}
