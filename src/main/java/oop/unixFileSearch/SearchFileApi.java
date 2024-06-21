package oop.unixFileSearch;

import oop.unixFileSearch.filter.GroupFilter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SearchFileApi {

    private SearchFileApi() {}

    public static List<File> search(Directory root, GroupFilter filter) {
        List<File> result = new ArrayList<>();
        Queue<Directory> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Directory t = queue.poll();
            for (AbstractFile file: t.getFiles()) {
                if (file.isDirectory()) {
                    queue.add((Directory) file);
                    continue;
                }
                File realFile = (File)file;
                if (filter.match(realFile)) {
                    result.add(realFile);
                }
            }
        }
        return result;
    }
}
