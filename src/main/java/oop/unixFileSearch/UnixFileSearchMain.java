package oop.unixFileSearch;

import oop.unixFileSearch.filter.*;

import java.util.List;

public class UnixFileSearchMain {

    /*
        Design Unix File Search API to search file with different arguments as "extension", "name", "size" ...
The design should be maintainable to add new contraints.

     */

    public static void main(String[] args) {

        GroupFilter groupFilter = new GroupFilter();
        groupFilter.addFilter(new ExtensionFilter(FilterOperator.EQUAL, "txt"));
        groupFilter.addFilter(new FileNameFilter(FilterOperator.EQUAL_IGNORE_CASE, "abc"));
        groupFilter.addFilter(new FileSizeFilter(FilterOperator.EQUAL, 150));

        Directory directory = new Directory("root");

        List<File> result = SearchFileApi.search(directory, groupFilter);

    }
}
