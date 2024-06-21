package oop.unixFileSearch.filter;

import oop.unixFileSearch.File;

public class ExtensionFilter extends FileFilter{

    private final String extension;

    public ExtensionFilter(FilterOperator operator, String extension) {
        super(operator);
        this.extension = extension;
    }

    @Override
    public boolean match(File file) {
        switch (operator) {
            case EQUAL -> {
                return this.extension.equalsIgnoreCase(file.getExtension());
            }
            case DIFFERENT -> {
                return !this.extension.equalsIgnoreCase(file.getExtension());
            }
        }
        return false;
    }
}
