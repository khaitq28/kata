package oop.unixFileSearch.filter;

import oop.unixFileSearch.File;

import java.util.List;

public class GroupFilter {

    private List<FileFilter> fileFilters;

    public GroupFilter(List<FileFilter> fileFilters) {
        this.fileFilters = fileFilters;
    }

    public GroupFilter() {}

    public void addFilter(FileFilter filter) {
        fileFilters.add(filter);
    }
    public boolean match(File file) {
        for(FileFilter filter: fileFilters) {
            if (!filter.match(file)) return false;
        }
        return true;
    }
}
